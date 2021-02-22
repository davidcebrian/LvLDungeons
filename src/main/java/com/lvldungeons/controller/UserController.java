package com.lvldungeons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.lvldungeons.model.entity.User;
import com.lvldungeons.model.entity.dto.UserDTO;
import com.lvldungeons.service.GenerateDTOService;
import com.lvldungeons.service.UserService;
import com.lvldungeons.service.Error.Errores;



@RestController
@RequestMapping(path = "user")
public class UserController {

	@Autowired 
	private UserService userService; 
	@Autowired
	private GenerateDTOService generateDto;
	

	/**
	 * Puede devolver un JSON con un error y un mensaje si el login no es correcto.
	 * 
	 * @param username String
	 * @param password String
	 * @return Token de sesion.
	 */
	@GetMapping("")
	public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password){
		ResponseEntity<?> response;
		
		if (username.equals("") || password.equals("")) {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.PETICION_INCORRECTA);
		
		} else {
			JsonNode jwt = userService.autenticaUsuario(username, password);
			if (jwt == null) {			
				response = ResponseEntity.status(HttpStatus.ACCEPTED).body(Errores.USUARIO_PASS_INCORRECTA);	
			} else {
				response = ResponseEntity.status(HttpStatus.ACCEPTED).body(jwt);	
			}
		}
		return response;
	}
	
	/**
	 * Devuelve el usuario recien creado, o un codigo de error y un mensaje.
	 * 
	 * @param user User
	 * @return User.
	 */
	@PostMapping("")
	public ResponseEntity<?> register(@RequestBody User user) {
		ResponseEntity<?> response;
		
		if (user.getUsername().isBlank() || user.getPassword().isBlank() || user.getEmail().isBlank()) {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.PETICION_INCORRECTA);			
		} else {			
			User postUser = userService.saveEntity(user);
			if (postUser == null) {
				response = ResponseEntity.status(HttpStatus.ACCEPTED).body(Errores.EXISTE_NICK_EMAIL);
			} 
			else {
				response = ResponseEntity.status(HttpStatus.ACCEPTED).body(generateDto.generateUserDTO(postUser));	
			}
		}

		return response;
	}
	
	/**
	 * Te devuelve un usuario que use un parametro Authorization correcto en la peticion
	 * 
	 * @param user User
	 * @return User.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserWithToken(HttpServletRequest request, @PathVariable long id) {
		ResponseEntity<?> response = null;
		User user = userService.datosAutenticado(request, id);

		if(request != null && user != null) {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(generateDto.generateUserDTO(user));
		}else {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.PETICION_INCORRECTA);
		}
		return response;
	}
	
	
	/**
	 * 
	 * Una vez logado el usuario le permite modificar sus datos
	 * 
	 * @param user User
	 * @return User
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(HttpServletRequest request, @PathVariable long id, @RequestBody UserDTO userDTO){
		ResponseEntity<?> response = null;
		User user = userService.datosAutenticado(request, id);
		userService.updateUser(user, userDTO);
		
		if(user != null) {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(generateDto.generateUserDTO(user));
		}else {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(Errores.EXISTE_NICK_EMAIL);
		}
		
		return response;
	} 
	
	/**
	 * Una vez logado el usuario le permite borrar su propia cuenta
	 * 
	 * @param User
	 * 
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delelteUser(HttpServletRequest request, @PathVariable long id){
		ResponseEntity<?> response = null;
		User user = userService.datosAutenticado(request, id);
		
		if(user != null) {
			userService.deleteUser(user);
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(generateDto.generateUserDTO(user));
		}else {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(Errores.INDETERMINADO); 
		}
		return response;
	}
	
	
}
