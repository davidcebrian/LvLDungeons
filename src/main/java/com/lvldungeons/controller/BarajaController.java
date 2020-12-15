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

import com.lvldungeons.model.entity.Baraja;


@RestController
@RequestMapping(path = "baraja")
public class BarajaController {

	@Autowired 
	private BarajaService barajaService; 
	

	@GetMapping("{id}")
	public ResponseEntity<?> getbarajas(@PathVariable long Id) {
		ResponseEntity response;
		if (barajaService.existsById(Id)) {
			response = ResponseEntity.status(HttpStatus.OK).body(barajaService.findById(Id));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("No se ha encontrado el usuario");
		}
		return response;
	}
	
	@PostMapping("")
	public ResponseEntity<?> addbaraja(@RequestBody Baraja baraja) {
		ResponseEntity response;

		if (!barajaService.existsById(baraja.getIdUsuario())) {
			response = ResponseEntity.status(HttpStatus.OK).body(barajaService.save(baraja));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el usuario");
		}
		return response;
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updatebaraja(@PathVariable long id, @RequestBody Baraja baraja) {
		ResponseEntity response;

		if (barajaService.existsById(id)) {
			response = ResponseEntity.status(HttpStatus.OK).body(barajaService.save(baraja));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el usuario");
		}
		return response;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletebaraja(@PathVariable long id) {
		ResponseEntity response;

		if (barajaService.existsById(id)) {
			response = ResponseEntity.status(HttpStatus.OK).body(barajaService.delete(baraja));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("No existe el usuario");
		}
		return response;
	}
}
