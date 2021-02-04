package com.lvldungeons.model.entity.carta;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.model.entity.baraja.Baraja;
import com.lvldungeons.model.entity.base.AbstractEntity;
import com.lvldungeons.model.entity.dto.CartaDTO;
import com.lvldungeons.model.enumerate.TipoCarta;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Carta extends AbstractEntity {
	
	private String nombre;
	private Blob diseño;
	private String descripcion;
	private Integer valor;
	
	@Enumerated(EnumType.STRING)
	private TipoCarta tipo;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "personaje_id")
	private Personaje personaje;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "baraja_id")
	private Baraja baraja;	

	public Carta() {
		super();
	}
	
	public Carta(CartaDTO cartaDto) {
		super();
		this.setNombre(cartaDto.getNombre());
		this.setDescripcion(cartaDto.getDescripcion());
		this.setValor(cartaDto.getValor());
		this.setDiseño(cartaDto.getDiseño());
		this.setTipo(cartaDto.getTipo());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Blob getDiseño() {
		return diseño;
	}

	public void setDiseño(Blob diseño) {
		this.diseño = diseño;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public TipoCarta getTipo() {
		return tipo;
	}

	public void setTipo(TipoCarta tipo) {
		this.tipo = tipo;
	}

	public Baraja getBaraja() {
		return baraja;
	}

	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	
	
}