package com.lvldungeons.model.entity.carta;

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
@Inheritance(strategy = InheritanceType.JOINED) // Crea entidades distintas por cada tabla, relacionadas con el padre.
public class Carta extends AbstractEntity {

	private String nombre;			
	private String diseño;			// Imagen de la carta
	private String descripcion;		
	private Integer valor;			// Valor puede tomar varias funciones, como stamina, daño, vida, etc...
	
	@Enumerated(EnumType.STRING)
	private TipoCarta tipo;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "personaje_id")
	private Personaje personaje;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "baraja_id")
	private Baraja baraja;	

	
	/*
	 * Constructores
	 */
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

	/*
	 * Getters y Setters
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDiseño() {
		return diseño;
	}

	public void setDiseño(String diseño) {
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
