package com.lvldungeons.model.entity.baraja;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.lvldungeons.model.entity.Partida;


@SuppressWarnings("serial")
@Entity
public class Puerta extends Baraja {
	/*
	 * La baraja de puerta se abrira obligatoriamente cada turno. Puede contener hechizos, monstruos y maldiciones.
	 */
	
	@OneToOne(mappedBy = "puerta")
	private Partida partida;

	/*
	 * Constructor
	 */
	public Puerta() {
		super();
	}

	public Puerta(Partida partida) {
		super();
		this.partida = partida;
	}

	/*
	 * Getters y Setters
	 */
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	
}
