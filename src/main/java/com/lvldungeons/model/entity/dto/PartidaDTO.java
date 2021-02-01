package com.lvldungeons.model.entity.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.lvldungeons.model.entity.Personaje;

public class PartidaDTO {
	private String token;
	private List<PersonajeDTO> personajes;
	private Boolean iniciada;
	
	public PartidaDTO(String token, Boolean iniciada, List<PersonajeDTO> personajes) {
		super();
		this.token = token;
		this.personajes = personajes;
		this.iniciada = iniciada;
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

	public Boolean getIniciada() {
		return iniciada;
	}
	
	public void setIniciada(Boolean iniciada) {
		this.iniciada = iniciada;
	}

	public List<PersonajeDTO> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<PersonajeDTO> personajes) {
		this.personajes = personajes;
	}
	
	public void addPersonajesDTO(PersonajeDTO personaje) {
		this.personajes.add(personaje);
	}

}
