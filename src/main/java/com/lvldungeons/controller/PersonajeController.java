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

import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.service.PersonajeService;

@RestController
@RequestMapping(path = "personaje")
public class PersonajeController {

	@Autowired 
	private PersonajeService personajeService; 
	
	@GetMapping("{id}")
	public ResponseEntity<?> getPersonajes(@PathVariable Long id) {
		ResponseEntity<?> response;
		response = ResponseEntity.status(HttpStatus.OK).body(personajeService.getEntityById(id));
		
		return response;
	}
	
	@PostMapping("")
	public ResponseEntity<?> addPersonaje(@RequestBody Personaje personaje) {
		ResponseEntity<?> response;
		response = ResponseEntity.status(HttpStatus.OK).body(personajeService.saveEntity(personaje));
		
		return response;
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updatePersonaje(@PathVariable Long id, @RequestBody Personaje personaje) {
		ResponseEntity<?> response;
		response = ResponseEntity.status(HttpStatus.OK).body(personajeService.updateEntity(id, personaje));
		
		return response;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletePersonaje(@PathVariable Long id) {
		ResponseEntity<?> response;
		
		personajeService.deleteEntity(id);
		response = ResponseEntity.status(HttpStatus.OK).body("Se ha eliminado la entidad: " + id.toString());
		
		return response;
	}
}