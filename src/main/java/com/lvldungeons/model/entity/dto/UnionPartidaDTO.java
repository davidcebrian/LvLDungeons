package com.lvldungeons.model.entity.dto;

public class UnionPartidaDTO {
	
	private String token;
	private long idPersonaje;
	
	
	public UnionPartidaDTO(String token, long idPersonaje) {
		super();
		this.token = token;
		this.idPersonaje = idPersonaje;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getIdPersonaje() {
		return idPersonaje;
	}
	public void setIdPersonaje(long idPersonaje) {
		this.idPersonaje = idPersonaje;
	}
	
	
}
