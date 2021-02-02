package com.lvldungeons.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.Partida;
import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.model.entity.User;
import com.lvldungeons.model.entity.dto.PartidaDTO;
import com.lvldungeons.model.entity.dto.PersonajeDTO;
import com.lvldungeons.model.entity.dto.UserDTO;

@Service
public class GenerateDTOService {

	public static UserDTO generateUserDTO(User postUser) {
		
		Personaje pj = postUser.getPersonaje();
		PersonajeDTO pjDTO = generatePersonajeDTO(pj);
		
		UserDTO userDTO = new UserDTO(postUser.getEmail(), postUser.getUsername(), pjDTO);
		
		userDTO.setNombre((postUser.getNombre()!=null) ? postUser.getNombre() : null);
		userDTO.setEdad((postUser.getEdad()!=0) ? postUser.getEdad() : null);

		return userDTO;
	}
	public static PartidaDTO generatePartidaDTO(Partida postPartida) {
		
		List<Personaje> personajes = postPartida.getPersonajes();
		
		List<PersonajeDTO> personajesDTO = new ArrayList<PersonajeDTO>(); 
		
		PersonajeDTO pjDTO;
		Personaje pj;
		
		for (int i=0; i<personajes.size(); i++) {
			pj = personajes.get(i);
			pjDTO = generatePersonajeDTO(pj);
			personajesDTO.add(pjDTO);
		}
		
		
		PartidaDTO partidaDTO = new PartidaDTO(postPartida.getToken(), postPartida.getIniciada(), personajes.get(0).getId(), personajesDTO);
		
		return partidaDTO;
	}
	
	public static PersonajeDTO generatePersonajeDTO(Personaje pj) {
		PersonajeDTO personajeDTO = new PersonajeDTO(pj.getId(), pj.getVida(), pj.getDaño(), pj.getEnergia(), pj.getVivo(), pj.getEmpezarPartida());

		return personajeDTO;
	}
}
