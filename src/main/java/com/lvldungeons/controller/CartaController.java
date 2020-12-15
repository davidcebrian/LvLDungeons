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
import com.lvldungeons.service.CartaService;


@RestController
@RequestMapping(path = "carta")
public class CartaController {

	@Autowired 
	private CartaService cartaService; 
	
	@GetMapping("{id}")
	public ResponseEntity<?> getCartas(@PathVariable Long id) {
		ResponseEntity<?> response;
		response = ResponseEntity.status(HttpStatus.OK).body(cartaService.getEntityById(id));

		return response;
	}
	
	@PostMapping("")
	public ResponseEntity<?> addCarta(@RequestBody Carta carta) {
		ResponseEntity<?> response;
		response = ResponseEntity.status(HttpStatus.OK).body(cartaService.saveEntity(carta));

		return response;
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateCarta(@PathVariable Long id, @RequestBody Carta carta) {
		ResponseEntity<?> response;
		response = ResponseEntity.status(HttpStatus.OK).body(cartaService.updateEntity(id, carta));

		return response;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCarta(@PathVariable Long id) {
		ResponseEntity<?> response;
		cartaService.deleteEntity(id);
		response = ResponseEntity.status(HttpStatus.OK).body("Se ha eliminado la entidad: " + id.toString());

		return response;
	}
}