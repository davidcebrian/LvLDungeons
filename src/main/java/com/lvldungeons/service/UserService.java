package com.lvldungeons.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lvldungeons.model.entity.User;
import com.lvldungeons.model.entity.dto.UserDTO;
import com.lvldungeons.model.repository.UserRepository;
import com.lvldungeons.service.jwtSecurity.AuthJWT;

@Service
public class UserService {

	// Repositorios
	@Autowired
	private UserRepository userRepo;

	// Servicios

	private ObjectMapper mapper = new ObjectMapper();

	// Autenticacion de usuario, devolviendo jwt creado a partir de un usuario.
	public JsonNode autenticaUsuario(String username, String password) {
		JsonNode jwt = null;
		try {
			jwt = mapper.readTree(new String("{}"));
			User usuarioAutenticado = userRepo.findByUsernameAndPassword(username, password);
			((ObjectNode) jwt).put("jwt", AuthJWT.generarJWTDesdeId(usuarioAutenticado));
			((ObjectNode) jwt).put("id", usuarioAutenticado.getId());
		} catch (Exception e) {
			return null;
		}
		return jwt;
	}

	// Crear un nuevo user
	public User saveEntity(User sent) {
		if (userRepo.findByEmail(sent.getEmail()) != null) {
			sent = null;
		} else if (userRepo.findByUsername(sent.getUsername()) != null) {
			sent = null;
		} else {
			userRepo.save(sent);
		}
		return sent;
	}

	// Devuelve los datos del usuario autenticado
	public User datosAutenticado(HttpServletRequest request, long id) {
		long idRequest = AuthJWT.getIdUserDesdeRequest(request);
		User user;

		if (idRequest == id) {
			user = userRepo.findById(id).get();
		} else {
			user = null;
		}
		return user;
	}

	
	//Actualiza los datos de un usuario
	public User updateUser(User user, UserDTO userDTO) {
		
		if(userDTO.getEmail() != user.getEmail() && userRepo.findByEmail(userDTO.getEmail()) != null) {
			user = null;
		}else if(userDTO.getUsername() != user.getUsername() && userRepo.findByEmail(userDTO.getEmail()) != null) {
			user = null;
		}else {
			user.setNombre(userDTO.getNombre());
			user.setEdad(userDTO.getEdad());
			user.setEmail(userDTO.getEmail());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			userRepo.save(user);
		}	
		return user;
	}

	
	//Elimina al usuario
	public void deleteUser(User user) {
		userRepo.delete(user);		
	}
	
}
