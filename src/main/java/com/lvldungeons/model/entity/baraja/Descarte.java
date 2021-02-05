package com.lvldungeons.model.entity.baraja;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.lvldungeons.model.entity.Partida;

@SuppressWarnings("serial")
@Entity
public class Descarte extends Baraja {
	/*
	 * La baraja de descarte tiene una coleccion de cartas que crece infinitamente donde se guardan las cartas ya usada.
	 */
	
	private final Integer CARTAS_INICIAL = super.getMIN_CARTAS();

	private Integer cantidad;
	
	@OneToOne(mappedBy = "descarte")
	private Partida partida;
	
	/*
	 * Constructores
	 */
	public Descarte(Integer cantidad) {
		super();
		this.cantidad = cantidad;
	}

	public Descarte() {
		super();
	}

	/*
	 * Getters y Setters
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCARTAS_INICIAL() {
		return CARTAS_INICIAL;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
}
