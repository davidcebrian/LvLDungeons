package com.lvldungeons.model.entity.baraja;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.lvldungeons.model.entity.Partida;


@SuppressWarnings("serial")
@Entity
public class Puerta extends Baraja {

	@OneToOne(mappedBy = "puerda")
	private Partida partida;

	public Puerta() {
		super();
	}

	public Puerta(Partida partida) {
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
