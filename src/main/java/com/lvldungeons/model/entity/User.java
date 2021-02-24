package com.lvldungeons.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lvldungeons.model.entity.base.AbstractEntity;


@SuppressWarnings("serial")
@Entity
public class User extends AbstractEntity {
	/*
	 * Entidad que controla tus datos personales y el inicio de sesion. 
	 */
	
	private String nombre;
	private Integer edad;

	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "personaje_id", referencedColumnName = "id", nullable = false)
	private Personaje personaje;
	
	/*
	 * Constructores
	 */
	public User() {
		super();
		this.personaje = new Personaje(this);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String nick) {
		this.username = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Personaje getPersonaje() {
		return personaje;
	}	
	
}
