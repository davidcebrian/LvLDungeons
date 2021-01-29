package com.lvldungeons.model.entity.dto;

public class DatosAutenticacionUsuario {
	private String usuario;
	private String password;

	/**
	 * Constructor
	 */
	public DatosAutenticacionUsuario(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}


	public String getPassword() {
		return password;
	}

}
