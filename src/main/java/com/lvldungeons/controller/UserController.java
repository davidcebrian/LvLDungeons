package com.lvldungeons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvldungeons.entity.User;
import com.lvldungeons.repository.UserRepository;


@RestController
@RequestMapping(path = "test")
public class UserController {

	@Autowired 
	private UserRepository UserRepo; 
	
	@GetMapping("/user")
	public ResponseEntity<?> getUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(UserRepo.findAll());
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> addCard(@RequestBody User user) {
		UserRepo.save(user);
		return ResponseEntity.status(HttpStatus.OK).body("Se ha insertado correctamente.");
	}
}
