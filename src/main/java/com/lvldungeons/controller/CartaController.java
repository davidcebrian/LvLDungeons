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
	public ResponseEntity<?> getCartas(@PathVariable long Id) {
		ResponseEntity<?> response;
		if (cartaService.getEntityById(Id) != null) {
			response = ResponseEntity.status(HttpStatus.OK).body(cartaService.getEntityById(Id));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("No se ha encontrado el usuario");
		}
		return response;
	}
	
	@PostMapping("")
	public ResponseEntity<?> addCarta(@RequestBody Carta carta) {
		ResponseEntity<?> response;

		if (cartaService.getEntityById(carta.getIdCarta()) == null) {
			response = ResponseEntity.status(HttpStatus.OK).body(cartaService.saveEntity(carta));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el usuario");
		}
		return response;
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateCarta(@PathVariable long id, @RequestBody Carta carta) {
		ResponseEntity<?> response;

		if (cartaService.getEntityById(id) == null) {
			response = ResponseEntity.status(HttpStatus.OK).body(cartaService.updateEntity(id, carta));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el usuario");
		}
		return response;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCarta(@PathVariable Long id) {
		ResponseEntity<?> response;

		if (cartaService.getEntityById(id) != null) {
			cartaService.deleteEntity(id);
			response = ResponseEntity.status(HttpStatus.OK).body("Se ha eliminado la entidad: " + id.toString());
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("No existe el usuario");
		}
		return response;
	}
}