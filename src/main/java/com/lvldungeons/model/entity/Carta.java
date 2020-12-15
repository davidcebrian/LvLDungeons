package com.lvldungeons.model.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lvldungeons.model.enumerados.tipoCarta;

@Entity
public class Carta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCarta;
	
	private String nombre;
	private String efecto;
	private int daño;
	private tipoCarta tipocarta;
	private Blob diseño;
	
	@ManyToOne
	@JoinColumn(name = "idBaraja", nullable = false)
	private Baraja baraja;
	
	@ManyToOne
	@JoinColumn(name = "idPersonaje", nullable = false)
	private Personaje personaje;
	
	public Carta(){
		super();
		this.baraja = new Baraja();
		this.personaje = new Personaje();
	}

	public Carta(String nombre, String efecto, int daño, tipoCarta tipocarta, Blob diseño) {
		super();
		this.nombre = nombre;
		this.efecto = efecto;
		this.daño = daño;
		this.tipocarta = tipocarta;
		this.diseño = diseño;
		this.baraja = new Baraja();
		this.personaje = new Personaje();
	}
	
	public Baraja getBaraja() {
		return baraja;
	}

	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEfecto() {
		return efecto;
	}

	public void setEfecto(String efecto) {
		this.efecto = efecto;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public tipoCarta getTipocarta() {
		return tipocarta;
	}

	public void setTipocarta(tipoCarta tipocarta) {
		this.tipocarta = tipocarta;
	}

	public Blob getDiseño() {
		return diseño;
	}

	public void setDiseño(Blob diseño) {
		this.diseño = diseño;
	}

	public long getIdCarta() {
		return idCarta;
	}
	
	
	
}
