package com.lvldungeons.model.entity.baraja;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.lvldungeons.model.entity.Partida;

@SuppressWarnings("serial")
@Entity
public class MonstruoFinal  extends Baraja {

	private final Integer MAX_CARTAS = 10;
	
	@OneToOne(mappedBy = "monstruoFinal")
	private Partida partida;

	public MonstruoFinal() {
		super();
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Integer getMAX_CARTAS() {
		return MAX_CARTAS;
	}
	
}
