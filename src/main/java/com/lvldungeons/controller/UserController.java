package com.lvldungeons.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.lvldungeons.model.entity.User;


@RestController
@RequestMapping(path = "user")
public class UserController {

	@Autowired 
	private UserService userService; 
	
	@GetMapping("{id}")
	public ResponseEntity<?> getUsers(@PathVariable long Id) {
		ResponseEntity response;
		if (userService.existsById(Id)) {
			response = ResponseEntity.status(HttpStatus.OK).body(userService.findById(Id));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("No se ha encontrado el usuario");
		}
		return response;
	}
	
	@PostMapping("")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		ResponseEntity response;

		if (!userService.existsById(user.getIdUsuario())) {
			response = ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el usuario");
		}
		return response;
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody User user) {
		ResponseEntity response;

		if (userService.existsById(id)) {
			response = ResponseEntity.status(HttpStatus.OK).body(userService.save(user));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el usuario");
		}
		return response;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id) {
		ResponseEntity response;

		if (userService.existsById(id)) {
			response = ResponseEntity.status(HttpStatus.OK).body(userService.delete(user));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("No existe el usuario");
		}
		return response;
	}
}
