package com.lvldungeons.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	private String nombre;
	private String email;
	private String nick;
	private String pass;
	private LocalDate fechaCreacion;
	private int edad;
	
	@OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL)
	private Personaje personaje;
	
	public User() {
		super();
		this.personaje = new Personaje();
	}
	
	public User(String nombre, String email, String nick, String pass, int edad, Personaje personaje) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.nick = nick;
		this.pass = pass;
		this.fechaCreacion = LocalDate.now();
		this.edad = edad;
		this.personaje = personaje;
	}

	public long getIdUsuario() {
		return idUsuario;
	}


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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
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
