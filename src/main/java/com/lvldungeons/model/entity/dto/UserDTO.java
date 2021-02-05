package com.lvldungeons.model.entity.dto;

public class UserDTO {
	/*
	 * Enviar informacion filtrada del usuario desde el backend
	 */
	
	
	private String nombre;
	private Integer edad;
	private String email;
	private String username;
	
	private PersonajeDTO personaje;

	/*
	 * Constructores
	 */
	public UserDTO(String nombre, Integer edad, String email, String username, PersonajeDTO personaje) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.username = username;
		this.personaje = personaje;
	}
	
	public UserDTO(String email, String username, PersonajeDTO personaje) {
		super();
		this.email = email;
		this.username = username;
		this.personaje = personaje;
	}

	public UserDTO() {
		super();
	}

	/*
	 * Getters y Setters
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public PersonajeDTO getPersonaje() {
		return personaje;
	}

	public void setPersonaje(PersonajeDTO personaje) {
		this.personaje = personaje;
	}
}
