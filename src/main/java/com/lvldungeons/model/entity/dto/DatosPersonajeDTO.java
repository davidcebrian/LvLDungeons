package com.lvldungeons.model.entity.dto;

public class DatosPersonajeDTO {
	private Boolean listo;
	private String token;
	
	public DatosPersonajeDTO() {
		super();
	}
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
