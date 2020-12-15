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
import com.lvldungeons.service.UserService;


@RestController
@RequestMapping(path = "user")
public class UserController {

	@Autowired 
	private UserService userService; 
	
	@GetMapping("{id}")
	public ResponseEntity<?> getUsers(@PathVariable Long id) {
		ResponseEntity<?> response;
		response = ResponseEntity.status(HttpStatus.OK).body(userService.getEntityById(id));
		
		return response;
	}
	
	@PostMapping("")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		ResponseEntity<?> response;
		response = ResponseEntity.status(HttpStatus.OK).body(userService.saveEntity(user));

		return response;
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
		ResponseEntity<?> response;
		response = ResponseEntity.status(HttpStatus.OK).body(userService.updateEntity(id, user));
		
		return response;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		ResponseEntity<?> response;
		userService.deleteEntity(id);
		response = ResponseEntity.status(HttpStatus.OK).body("Se ha eliminado la entidad: " + id.toString());
		
		return response;
	}
}
