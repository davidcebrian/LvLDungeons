package com.lvldungeons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvldungeons.service.CartaService;


@RestController
@RequestMapping(path = "carta")
public class CartaController {
	
	@Autowired
	private CartaService cService;
	
	@GetMapping("/all")
	public ResponseEntity getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(cService.getEntities());
	}
}