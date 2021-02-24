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

import com.lvldungeons.model.entity.Partida;
import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.model.entity.dto.DatosPersonajeDTO;
import com.lvldungeons.model.entity.dto.PartidaDTO;
import com.lvldungeons.service.GenerateDTOService;
import com.lvldungeons.service.PersonajeService;
import com.lvldungeons.service.Error.Errores;

@RestController
@RequestMapping(path = "personaje")
public class PersonajeController {

	@Autowired 
	private PersonajeService personajeService; 
	@Autowired
	private GenerateDTOService generateDto;
	
	

	/*
	 * Interactuamos con una partida desde un personaje.
	 * Este metodo puede realizar varias funciones entre las que se encuentran:
	 *  
	 *  - Crear una partida. (Si no se pasa RequestBody o los datos son nulos)
	 *  - Unirse a una partida. (Se necesita el token de la partida en el RequestBody)
	 *  - Cambiar el estado del personaje a listo en una partida. (Se necesita el estado y el token de partida en el RequestBody)
	 *  
	 *
	 */
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarPartida(HttpServletRequest request, @PathVariable Long id, @RequestBody DatosPersonajeDTO datos){
		ResponseEntity<?> response;
		Personaje personaje;
		
		personaje = this.personajeService.getPersonajeFromRequest(request, id);
		
		// Si existe el personaje
		if (personaje != null) {
			
			// Si el RequestBody trae el token, pero no trae el estado "Listo"
			if (datos.getToken() != null && datos.getListo() == null) {
				//Ese personaje se une a la partida si esta existe, si no lanza error.
				Partida unirse = personajeService.unirsePartida(personaje, datos.getToken());
				if(unirse != null) {					
					PartidaDTO partidaRes = generateDto.generatePartidaDTO(unirse);
					response = ResponseEntity.status(HttpStatus.ACCEPTED).body(partidaRes);				
				}else {
					response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_PARTIDA_NOTFOUND);
				}
					
			//Si trae el campo Listo en el requestBody
			} else if (datos.getListo() != null) {
				
					// Cambio el estado del Personaje
					response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
							generateDto.generatePartidaDTO(personajeService.setEstadoPersonaje(personaje, datos.getListo()).getPartida())
							);
					
			// Si no trae datos en el estado crea una nueva partida.
			} else {
				response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
						generateDto.generatePartidaDTO(personajeService.iniciarPartida(personaje))
						);
			}	
		} else {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(Errores.ERROR_CREAR_PARTIDA);
		}
		
		return response;
	}
	
	@PutMapping("/{id}/exit")
	public ResponseEntity<?> exitPartida(HttpServletRequest request, @PathVariable Long id){
		ResponseEntity<?> response;
		Personaje personaje;
		
		personaje = this.personajeService.getPersonajeFromRequest(request, id);
		
		// Si existe el personaje
		if (personaje != null) {
			
				//Ese personaje se sale de la partida
				response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
						generateDto.generatePartidaDTO(personajeService.salirPartida(personaje))
					);	
		}else {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(Errores.ERROR_SALIR_PARTIDA);
		}
		return response;
	}
	

	/*
	 * GET de la partida de un personaje, necesitas el id del usuario y el token de la partida.
	 * 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPartida(HttpServletRequest request, @PathVariable Long id, @RequestParam String token){
		ResponseEntity<?> response;
		Personaje personaje;
		
		personaje = this.personajeService.getPersonajeFromRequest(request, id);
		
		if (personaje != null) {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
					generateDto.generatePartidaDTO(personajeService.obtenerPartida(personaje, token))
			);
		} else {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(Errores.ERROR_OBTENER_PARTIDA);
		}
		return response;
	}
	
	/*
	 * Para empezar una partida se necesita tambien el id del personaje que debe ser el dueño de la partida y el token de esta.
	 * 
	 * Lo que hace el metodo es inciar la partida junto con sus barajas y sus cartas, etc..
	 * 
	 */
	@PostMapping("{id}/start/")
	public ResponseEntity<?> empezarPartida(HttpServletRequest request, @PathVariable Long id, @RequestParam String token){
		ResponseEntity<?> response;
		Personaje personaje;
	
		personaje = this.personajeService.getPersonajeFromRequest(request, id);
		
		if (personaje != null) {	
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(
				personajeService.empezarPartida(token)
			);
		} else {
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(Errores.ERROR_INICIAR_PARTIDA);
		}
		
		return response;
	}
}