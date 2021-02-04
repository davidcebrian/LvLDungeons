package com.lvldungeons.model.entity.baraja;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.lvldungeons.model.entity.Partida;


@SuppressWarnings("serial")
@Entity
public class Tesoro extends Baraja {

	@OneToOne(mappedBy = "puerda")
	private Partida partida;

	public Tesoro() {
		super();
	}

	public Tesoro(Partida partida) {
		super();
		this.partida = partida;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	

}
