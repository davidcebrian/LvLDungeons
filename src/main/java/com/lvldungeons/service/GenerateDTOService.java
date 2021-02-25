package com.lvldungeons.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.Partida;
import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.model.entity.User;
import com.lvldungeons.model.entity.carta.Carta;
import com.lvldungeons.model.entity.carta.Equipo;
import com.lvldungeons.model.entity.dto.CartaDTO;
import com.lvldungeons.model.entity.dto.PartidaDTO;
import com.lvldungeons.model.entity.dto.PersonajeDTO;
import com.lvldungeons.model.entity.dto.UserDTO;

@Service
public class GenerateDTOService {

	/*
	 * Generar UserDTO desde un User
	 */
	public  UserDTO generateUserDTO(User postUser) {
		
		Personaje pj = postUser.getPersonaje();
		PersonajeDTO pjDTO = generatePersonajeDTO(pj);
		
		UserDTO userDTO = new UserDTO(postUser.getEmail(), postUser.getUsername(), pjDTO);
		
		userDTO.setNombre((postUser.getNombre()!=null) ? postUser.getNombre() : null);
		userDTO.setEdad((postUser.getEdad()!=0) ? postUser.getEdad() : null);

		return userDTO;
	}
	
	/*
	 * Generar PartidaDTO desde una Partida
	 */
	public  PartidaDTO generatePartidaDTO(Partida postPartida) {
		
		List<Personaje> personajes = postPartida.getPersonajes();
		
		List<PersonajeDTO> personajesDTO = new ArrayList<>(); 
		
//		PersonajeDTO pjDTO;
//		Personaje pj;
		
		personajes.stream().forEach(personaje -> {
			personajesDTO.add(generatePersonajeDTO(personaje));
		});
		
//		for (int i=0; i<personajes.size(); i++) {
//			pj = personajes.get(i);
//			pjDTO = generatePersonajeDTO(pj);
//			personajesDTO.add(pjDTO);
//		}	
		PartidaDTO partidaDTO = new PartidaDTO(postPartida.getToken(), postPartida.getIniciada(), postPartida.getOwner(), personajesDTO);
		
		return partidaDTO;
	}
	
	/*
	 * Generar PersonajeDTO desde un Personaje
	 */
	public  PersonajeDTO generatePersonajeDTO(Personaje pj) {
		PersonajeDTO personajeDTO = new PersonajeDTO();
		personajeDTO.setDaño(pj.getDaño());
		personajeDTO.setEmpezarPartida(pj.getEmpezarPartida());
		personajeDTO.setEnergia(pj.getEnergia());
		personajeDTO.setEquipo(pj.getEquipo());
		personajeDTO.setId(pj.getId());
		personajeDTO.setMano(pj.getMano());
		personajeDTO.setUsername(pj.getUsuario().getUsername());
		personajeDTO.setVida(pj.getVida());
		personajeDTO.setVivo(pj.getVivo());
		
		return personajeDTO;
	}
	
	
	/*
	 * Generar CartaDTO desde una carta
	 */
	public  Carta generateCartaDTO(CartaDTO cartaDTO) {
		if(cartaDTO.getTipoEquipo() != null) {
			Equipo equipo = new Equipo(cartaDTO);
			return equipo;
		}else {
			Carta carta = new Carta(cartaDTO);
			return carta;
		}
	}
}
