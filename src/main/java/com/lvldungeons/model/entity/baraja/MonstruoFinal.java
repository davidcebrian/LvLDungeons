package com.lvldungeons.model.entity.baraja;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.lvldungeons.model.entity.Partida;

@SuppressWarnings("serial")
@Entity
public class MonstruoFinal  extends Baraja {
	/*
	 * La baraja de Monstruo final te permite ganar el juego, si consigues derrotar al monstruo
	 * - Para coger una carta de esta baraja se debe tener el maximo de vida posible del personaje.
	 * - Solo tiene cartas de Monstruo Final.
	 * 
	 */
	
	private final Integer MAX_CARTAS = 10;

	@OneToOne(mappedBy = "monstruoFinal")
	private Partida partida;
	
	/*
	 * Constructores
	 */
	public MonstruoFinal() {
		super();
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

	public Integer getMAX_CARTAS() {
		return MAX_CARTAS;
	}
	
}
