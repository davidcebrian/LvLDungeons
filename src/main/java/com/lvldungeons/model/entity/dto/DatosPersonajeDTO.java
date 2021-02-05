package com.lvldungeons.model.entity.dto;

public class DatosPersonajeDTO {
	/*
	 * DTO donde se reciben los datos referentes a un personaje y su partida, 
	 * por el momento solo se recibe si ese usuario esta listo o no, y el token de la propia partida.
	 */
	
	private Boolean listo;
	private String token;
	
	/*
	 * Constructor
	 */
	public DatosPersonajeDTO() {
		super();
	}
	/*
	 * Getter y Setters
	 */
	public Boolean getListo() {
		return listo;
	}
	public void setListo(Boolean listo) {
		this.listo = listo;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
