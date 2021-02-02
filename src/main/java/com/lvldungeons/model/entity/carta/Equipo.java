package com.lvldungeons.model.entity.carta;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.model.enumerate.TipoEquipo;

@SuppressWarnings("serial")
@Entity
public class Equipo extends Carta {
	private TipoEquipo tipoEquipo;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "personaje_id")
	private Personaje personaje;

	public Equipo() {
		super();	
	}

	public TipoEquipo getTipoEquipo() {
		return tipoEquipo;
	}

	public void setTipoEquipo(TipoEquipo tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	
}
