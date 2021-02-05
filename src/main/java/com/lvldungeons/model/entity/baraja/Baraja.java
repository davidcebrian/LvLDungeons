package com.lvldungeons.model.entity.baraja;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lvldungeons.model.entity.base.AbstractEntity;
import com.lvldungeons.model.entity.carta.Carta;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Baraja extends AbstractEntity {
	/*
	 * Clase padre de los distintos tipos de baraja:
	 * 
	 * - Descarte
	 * - MonstruoFinal
	 * - Puerta
	 * - Tesoro
	 */
	
	private final Integer MIN_CARTAS = 0;	
	private String nombre;
	private String descripcion;
	
    @OneToMany(mappedBy = "baraja", cascade=CascadeType.ALL)
    @JsonIgnore
	private List<Carta> cartas = new ArrayList<Carta> ();
	
    
    /*
     * Constructores
     */
	public Baraja() {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getMIN_CARTAS() {
		return MIN_CARTAS;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public void addCartas(Carta carta) {
		this.cartas.add(carta);
	}
	
}
