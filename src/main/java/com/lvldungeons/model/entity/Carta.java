package com.lvldungeons.model.entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lvldungeons.model.entity.base.AbstractEntity;
import com.lvldungeons.model.enumerate.TipoCarta;

@SuppressWarnings("serial")
@Entity
public class Carta extends AbstractEntity {
	
	private String nombre;
	private String efecto;
	private int daño;	
	private Blob diseño;
	
	@Enumerated(EnumType.STRING)
	private TipoCarta tipoCarta;
	
	private Baraja baraja;

	private Personaje personaje;
	
	/*
	 * Constructores
	 */
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
	
	/*
	 * Getters y Setters
	 */
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
}
