package com.lvldungeons.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.lvldungeons.model.entity.base.AbstractEntity;
import com.lvldungeons.model.enumerate.TipoBaraja;

@SuppressWarnings("serial")
@Entity
public class Baraja extends AbstractEntity {
	
	@ElementCollection
	private List<Carta> cartas;
	
	@Enumerated(EnumType.STRING)
	private TipoBaraja tipobaraja;
	

	private Personaje personaje;
	
	
	/*
	 * Constructores
	 */
	public Baraja() {
		super();
		cartas = new ArrayList<Carta>();
	}
	
	public Baraja(TipoBaraja tipo) {
		super();
		cartas = new ArrayList<Carta>();
		this.tipobaraja = tipo;
	}

	/*
	 * Getters y setters
	 */
	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

	public TipoBaraja getTipo() {
		return tipobaraja;
	}

	public void setTipo(TipoBaraja tipo) {
		this.tipobaraja = tipo;
	}	
	
}
