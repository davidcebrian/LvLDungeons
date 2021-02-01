package com.lvldungeons.model.entity.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.lvldungeons.model.entity.Personaje;

public class PartidaDTO {
	private String token;
	private List<PersonajeDTO> personajes;
	
	public PartidaDTO(String token, List<PersonajeDTO> personajes) {
		super();
		this.token = token;
		this.personajes = personajes;
	}

	public PartidaDTO() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<PersonajeDTO> getPersonajesDTO() {
		return personajes;
	}

	public void setPersonajesDTO(List<PersonajeDTO> personajes) {
		this.personajes = personajes;
	}
	
	public void addPersonajesDTO(PersonajeDTO personaje) {
		this.personajes.add(personaje);
	}
}
