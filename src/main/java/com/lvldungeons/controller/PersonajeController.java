package com.lvldungeons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lvldungeons.model.entity.Partida;
import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.service.GenerateDTOService;
import com.lvldungeons.service.PersonajeService;
import com.lvldungeons.service.Error.ManejoErrores;

@RestController
@RequestMapping(path = "personaje")
public class PersonajeController {

	@Autowired 
	private PersonajeService personajeService; 
	
	@Autowired 
	private ManejoErrores errorService;
	
	@PostMapping("/{id}")
	public ResponseEntity<?> empezarPartida(HttpServletRequest request, @PathVariable Long id){
		ResponseEntity<?> response;
		Personaje personaje;
		Partida partida;
		
		personaje = this.personajeService.getPersonajeFromToken(request, id);
		
		if (personaje != null) {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
					GenerateDTOService.generatePartidaDTO(personajeService.iniciarPartida(personaje))
			);
		} else {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(errorService.generarError(4));
		}
		return response;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> unirsePartida(HttpServletRequest request, @PathVariable Long id, @RequestParam String token){
		ResponseEntity<?> response;
		Personaje personaje;
		Partida partida;
		
		personaje = this.personajeService.getPersonajeFromToken(request, id);

		if (personaje != null) {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
					GenerateDTOService.generatePartidaDTO(personajeService.unirsePartida(personaje, token))
			);
		} else {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(errorService.generarError(5));
		}
		
		return response;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> obtenerPartida(HttpServletRequest request, @PathVariable Long id, @RequestParam String token){
		ResponseEntity<?> response;
		Personaje personaje;
		Partida partida;
		
		personaje = this.personajeService.getPersonajeFromToken(request, id);
		
		if (personaje != null) {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
					GenerateDTOService.generatePartidaDTO(personajeService.obtenerPartida(personaje, token))
			);
		} else {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(errorService.generarError(6));
		}
		return response;
	}
}