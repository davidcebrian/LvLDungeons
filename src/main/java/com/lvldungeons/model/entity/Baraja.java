package com.lvldungeons.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lvldungeons.model.enumerados.TipoBaraja;

@Entity
public class Baraja implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBaraja;
	
	@OneToMany(mappedBy = "baraja")
	private List<Carta> cartas;
	
	@Enumerated(EnumType.STRING)
	private TipoBaraja tipobaraja;
	
	@OneToOne
	@JoinColumn(name = "idPersonaje")
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

	public long getIdBaraja() {
		return idBaraja;
	}
	
	
}
