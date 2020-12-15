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
import com.lvldungeons.service.BarajaService;

@RestController
@RequestMapping(path = "baraja")
public class BarajaController {

	@Autowired 
	private BarajaService barajaService; 
	
	@GetMapping("{id}")
	public ResponseEntity<?> getBarajas(@PathVariable Long id) {
		ResponseEntity<?> response;
		response = ResponseEntity.status(HttpStatus.OK).body(barajaService.getEntityById(id));
		
		return response;
	}
	
	@PostMapping("")
	public ResponseEntity<?> addBaraja(@RequestBody Baraja baraja) {
		ResponseEntity<?> response;
		response = ResponseEntity.status(HttpStatus.OK).body(barajaService.saveEntity(baraja));
		
		return response;
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateBaraja(@PathVariable Long id, @RequestBody Baraja baraja) {
		ResponseEntity<?> response;
		response = ResponseEntity.status(HttpStatus.OK).body(barajaService.updateEntity(id, baraja));

		return response;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteBaraja(@PathVariable Long id) {
		ResponseEntity<?> response;
		barajaService.deleteEntity(id);
		response = ResponseEntity.status(HttpStatus.OK).body("Se ha eliminado la entidad: " + id.toString());

		return response;
	}
}