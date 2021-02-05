package com.lvldungeons.model.entity.dto;

public class PersonajeDTO {
	/*
	 * Enviar informacion filtrada de Personaje desde el Backend
	 */
	
	private Integer vida;
	private Integer daño;
	private Integer energia;
	private Boolean vivo;
	private Long id;
	private Boolean empezarPartida;
	
	/*
	 * Constructores
	 */
	public PersonajeDTO(Long id, Integer vida, Integer daño, Integer energia, Boolean vivo, Boolean empezarPartida) {
		super();
		this.id = id;
		this.vida = vida;
		this.daño = daño;
		this.energia = energia;
		this.vivo = vivo;
		this.empezarPartida = empezarPartida;
	}

	/*
	 * Getters y Setters
	 */
	public PersonajeDTO() {
		super();
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
