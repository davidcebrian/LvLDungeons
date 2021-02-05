package com.lvldungeons.model.entity.baraja;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.lvldungeons.model.entity.Partida;


@SuppressWarnings("serial")
@Entity
public class Tesoro extends Baraja {
	/*
	 * La baraja de tesoro solo tiene cartas de tipo Equipo, Se abrirá solo despues de haber derrotado a un monstruo
	 */
	
	@OneToOne(mappedBy = "tesoro")
	private Partida partida;

	/*
	 * Constructor
	 */
	public Tesoro() {
		super();
	}

	public Tesoro(Partida partida) {
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
