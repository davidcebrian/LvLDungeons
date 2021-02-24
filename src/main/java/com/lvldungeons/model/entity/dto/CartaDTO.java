package com.lvldungeons.model.entity.dto;

import com.lvldungeons.model.enumerate.TipoCarta;
import com.lvldungeons.model.enumerate.TipoEquipo;

public class CartaDTO {
	/*
	 * DTO que recibe una carta y la transforma en un Equipo o en una Carta, dependiendo del tipoEquipo.
	 */
	
	private String nombre;
	private String diseño;
	private String descripcion;
	private Integer valor;
	private TipoCarta tipo;
	
	private TipoEquipo tipoEquipo; // Solo existira si es de tipo Equipo.

	
	/*
	 * Constructor
	 */
	public CartaDTO() {
		super();
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

	public TipoEquipo getTipoEquipo() {
		return tipoEquipo;
	}

	public void setTipoEquipo(TipoEquipo tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}
	
}