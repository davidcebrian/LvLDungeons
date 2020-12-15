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

@RestController
@RequestMapping(path = "personaje")
public class PersonajeController {

	@Autowired 
	private PersonajeService personajeService; 

	@GetMapping("{id}")
	public ResponseEntity<?> getpersonajes(@PathVariable long Id) {
		ResponseEntity response;
		if (personajeService.existsById(Id)) {
			response = ResponseEntity.status(HttpStatus.OK).body(personajeService.findById(Id));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("No se ha encontrado el usuario");
		}
		return response;
	}
	
	@PostMapping("")
	public ResponseEntity<?> addpersonaje(@RequestBody Personaje personaje) {
		ResponseEntity response;

		if (!personajeService.existsById(personaje.getIdUsuario())) {
			response = ResponseEntity.status(HttpStatus.OK).body(personajeService.save(personaje));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el usuario");
		}
		return response;
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updatepersonaje(@PathVariable long id, @RequestBody Personaje personaje) {
		ResponseEntity response;

		if (personajeService.existsById(id)) {
			response = ResponseEntity.status(HttpStatus.OK).body(personajeService.save(personaje));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe el usuario");
		}
		return response;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletepersonaje(@PathVariable long id) {
		ResponseEntity response;

		if (personajeService.existsById(id)) {
			response = ResponseEntity.status(HttpStatus.OK).body(personajeService.delete(personaje));
		} else {
			response = ResponseEntity.status(HttpStatus.CONFLICT).body("No existe el usuario");
		}
		return response;
	}
}
