package com.lvldungeons.model.entity.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lvldungeons.model.entity.carta.Carta;
import com.lvldungeons.model.entity.carta.Equipo;

@JsonInclude(Include.NON_NULL)
public class PersonajeDTO {
	/*
	 * Enviar informacion filtrada de Personaje desde el Backend
	 */
	
	private String username;
	private Integer vida;
	private Integer daño;
	private Integer energia;
	private Boolean vivo;
	private Long id;
	private Boolean empezarPartida;
	
	private List<Carta> mano;
	
    private List<Equipo> equipo;
	
	/*
	 * Constructores
	 */
//	public PersonajeDTO(String username, Long id, Integer vida, Integer daño, Integer energia, Boolean vivo, Boolean empezarPartida) {
//		super();
//		this.username = username;
//		this.id = id;
//		this.vida = vida;
//		this.daño = daño;
//		this.energia = energia;
//		this.vivo = vivo;
//		this.empezarPartida = empezarPartida;
//	}
//    public PersonajeDTO() {
//    	super();
//    }

	/*
	 * Getters y Setters
	 */
	
	
	public String getUsername() {
		return username;
	}

	public List<Carta> getMano() {
		return mano;
	}

	public void setMano(List<Carta> mano) {
		this.mano = mano;
	}

	public List<Equipo> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getEmpezarPartida() {
		return empezarPartida;
	}
	
	public void setEmpezarPartida(Boolean empezarPartida) {
		this.empezarPartida = empezarPartida;
	}	

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public Integer getDaño() {
		return daño;
	}

	public void setDaño(Integer daño) {
		this.daño = daño;
	}

	public Integer getEnergia() {
		return energia;
	}

	public void setEnergia(Integer energia) {
		this.energia = energia;
	}

	public Boolean getVivo() {
		return vivo;
	}

	public void setVivo(Boolean vivo) {
		this.vivo = vivo;
	}

}
