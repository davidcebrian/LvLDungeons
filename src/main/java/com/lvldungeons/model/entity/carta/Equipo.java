package com.lvldungeons.model.entity.carta;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.model.entity.dto.CartaDTO;
import com.lvldungeons.model.enumerate.TipoEquipo;

@SuppressWarnings("serial")
@Entity
public class Equipo extends Carta {
	@Enumerated(EnumType.STRING)
	private TipoEquipo tipoEquipo;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "personaje_id")
	private Personaje personaje;

	public Equipo() {
		super();	
	}
	
	public Equipo(CartaDTO cartaDto) {
		super();	
		this.setNombre(cartaDto.getNombre());
		this.setDescripcion(cartaDto.getDescripcion());
		this.setValor(cartaDto.getValor());
		this.setDiseño(cartaDto.getDiseño());
		this.setTipo(cartaDto.getTipo());
		this.setTipoEquipo(cartaDto.getTipoEquipo());
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
