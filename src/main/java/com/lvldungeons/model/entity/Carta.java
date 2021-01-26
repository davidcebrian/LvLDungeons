package com.lvldungeons.model.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lvldungeons.model.enumerados.TipoCarta;

@Entity
public class Carta implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCarta;
	
	private String nombre;
	private String efecto;
	private int daño;
	private TipoCarta tipoCarta;
	private Blob diseño;
	
	@ManyToOne
	@JoinColumn(name = "idBaraja", nullable = true)
	private Baraja baraja;
	
	@ManyToOne
	@JoinColumn(name = "idPersonaje", nullable = true)
	private Personaje personaje;
	
	public Carta(){
		super();
	}

	public Carta(String nombre, String efecto, int daño, TipoCarta tipoCarta, Blob diseño) {
		super();
		this.nombre = nombre;
		this.efecto = efecto;
		this.daño = daño;
		this.tipoCarta = tipoCarta;
		this.diseño = diseño;
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

	public TipoCarta getTipoCarta() {
		return tipoCarta;
	}

	public void setTipoCarta(TipoCarta tipoCarta) {
		this.tipoCarta = tipoCarta;
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
