package com.lvldungeons.model.entity.dto;

public class PersonajeDTO {
	private Integer vida;
	private Integer daño;
	private Integer energia;
	private Boolean vivo;
	
	public PersonajeDTO(Integer vida, Integer daño, Integer energia, Boolean vivo) {
		super();
		this.vida = vida;
		this.daño = daño;
		this.energia = energia;
		this.vivo = vivo;
	}

	public PersonajeDTO() {
		super();
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
