package com.lvldungeons.model.entity.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.lvldungeons.model.entity.Personaje;

public class PartidaDTO {
	/*
	 * Enviar informacion filtrada de la partida desde el backend
	 */
	
	private String token;
	private List<PersonajeDTO> personajes;
	private Boolean iniciada;
	private Long idOwner;
	
	/*
	 * Constructores
	 */
	public PartidaDTO(String token, Boolean iniciada, Long idOwner, List<PersonajeDTO> personajes) {
		super();
		this.token = token;
		this.personajes = personajes;
		this.iniciada = iniciada;
		this.idOwner = idOwner;
	}

	public PartidaDTO() {
		super();
	}

	/*
	 * Getters y Setters
	 */
	public Boolean getIniciada() {
		return iniciada;
	}
	
	public void setIniciada(Boolean iniciada) {
		this.iniciada = iniciada;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	public Long getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(Long idOwner) {
		this.idOwner = idOwner;
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
