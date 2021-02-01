package com.lvldungeons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.model.entity.dto.DatosPersonajeDTO;
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
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarPartida(HttpServletRequest request, @PathVariable Long id, @RequestBody DatosPersonajeDTO datos){
		ResponseEntity<?> response;
		Personaje personaje;
		
		personaje = this.personajeService.getPersonajeFromRequest(request, id);
		
		if (personaje != null) {
			if (!token.equals("") && listo.equals("")) {
				response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
					GenerateDTOService.generatePartidaDTO(personajeService.unirsePartida(personaje, token))
					);	
		
			} else if (!listo.equals("")) {
				if (listo.equals("true") || listo.equals("false")) {
					Boolean listoBool = Boolean.parseBoolean(listo);
						response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
								GenerateDTOService.generatePersonajeDTO(personajeService.setEstadoPersonaje(personaje, listoBool))
								);
				} else {
					response = ResponseEntity.status(HttpStatus.ACCEPTED).body(errorService.generarError(4));
				}
			} else {
				response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
						GenerateDTOService.generatePartidaDTO(personajeService.iniciarPartida(personaje))
						);
			}
		} else {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(errorService.generarError(4));
		}
		return response;
	}
	

	@PostMapping("/{id}")
	public ResponseEntity<?> obtenerPartida(HttpServletRequest request, @PathVariable Long id, @RequestParam String token){
		ResponseEntity<?> response;
		Personaje personaje;
		
		personaje = this.personajeService.getPersonajeFromRequest(request, id);
		
		if (personaje != null) {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
					GenerateDTOService.generatePartidaDTO(personajeService.obtenerPartida(personaje, token))
			);
		} else {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(errorService.generarError(6));
		}
		return response;
	}
	
	@GetMapping("{id}/start/")
	public ResponseEntity<?> empezarPartida(HttpServletRequest request, @PathVariable Long id, @RequestParam String token){
		ResponseEntity<?> response;
		Personaje personaje;
	
		personaje = this.personajeService.getPersonajeFromRequest(request, id);
		
		if (personaje != null) {	
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
				personajeService.empezarPartida(token)
			);
		} else {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(errorService.generarError(6));
		}
		
		return response;
	}
}