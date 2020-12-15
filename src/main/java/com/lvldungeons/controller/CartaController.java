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

import com.lvldungeons.model.entity.Carta;

@RestController
@RequestMapping(path = "carta")
public class CartaController {

	
	@Autowired 
	private CartaService cartaService; 
	

	@GetMapping("{id}")
	public ResponseEntity<?> getcartas(@PathVariable long Id) {
		ResponseEntity response;
		if (cartaService.existsById(Id)) {
			response = ResponseEntity.status(HttpStatus.OK).body(cartaService.findById(Id));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("No se ha encontrado el usuario");
		}
		return response;
	}
	
	@PostMapping("")
	public ResponseEntity<?> addcarta(@RequestBody Carta carta) {
		ResponseEntity response;

		if (!cartaService.existsById(carta.getIdUsuario())) {
			response = ResponseEntity.status(HttpStatus.OK).body(cartaService.save(carta));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el usuario");
		}
		return response;
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updatecarta(@PathVariable long id, @RequestBody Carta carta) {
		ResponseEntity response;

		if (cartaService.existsById(id)) {
			response = ResponseEntity.status(HttpStatus.OK).body(cartaService.save(carta));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el usuario");
		}
		return response;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletecarta(@PathVariable long id) {
		ResponseEntity response;

		if (cartaService.existsById(id)) {
			response = ResponseEntity.status(HttpStatus.OK).body(cartaService.delete(carta));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("No existe el usuario");
		}
		return response;
	}
}
