package com.lvldungeons.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.lvldungeons.model.entity.base.AbstractEntity;
import com.lvldungeons.model.entity.carta.Carta;

@SuppressWarnings("serial")
@Entity
public class Partida extends AbstractEntity {
	/*
	 * Entidad central del juego, desde donde se controla toda la partida.
	 */
	
	
	@Column(nullable = false, unique = true)
	private String token;  // Token identificador de la partida desde fuera del backend.
	
	private boolean iniciada;
	private Long idOwner;  // ID del dueño de la partida.
	
	/*
	 * Persoajes que juegan esta partida.
	 */
    @OneToMany(mappedBy = "partida", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Personaje> personajes;
	
    /*
     * Todas las barajas necesarias
     */
  
    @ElementCollection()
	private List<Carta> descarte;
    
    @ElementCollection()
    private List<Carta> monstruoFinal;
    
    @ElementCollection()
    private List<Carta> puerta;
    
    @ElementCollection()
    private List<Carta> tesoro;
    
    public Partida() {
    	super();
    	this.iniciada = false;
		this.token = UUID.randomUUID().toString().substring(0, 6);

    }
    
	public Partida(Personaje personaje) {
		super();
		this.token = UUID.randomUUID().toString().substring(0, 6);
		personaje.setEmpezarPartida(false);
		this.personajes = new ArrayList<Personaje>() {{
			add(personaje);
		}};
		this.idOwner = personaje.getId();
	}

	public Boolean getIniciada() {
		return iniciada;
	}
	
	public void setIniciada(Boolean iniciada) {
		this.iniciada = iniciada;
	}

	public String getToken() {
		return token;
	}	
	
	public Long getOwner() {
		return this.idOwner;
	}

	public void setOwner(Long idOwner) {
		this.idOwner = idOwner;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}
	
	public void addPersonaje(Personaje personaje) {
		personaje.setEmpezarPartida(false);
		this.personajes.add(personaje);
	}

	public void removePersonaje(Personaje personaje) {
		personaje.setPartida(null);
		this.personajes.remove(personaje);
	}

	public List<Carta> getDescarte() {
		return descarte;
	}

	public void setDescarte(List<Carta> descarte) {
		this.descarte = descarte;
	}

	public List<Carta> getMonstruoFinal() {
		return monstruoFinal;
	}

	public void setMonstruoFinal(List<Carta> monstruoFinal) {
		this.monstruoFinal = monstruoFinal;
	}

	public List<Carta> getPuerta() {
		return puerta;
	}

	public void setPuerta(List<Carta> puerta) {
		this.puerta = puerta;
	}

	public List<Carta> getTesoro() {
		return tesoro;
	}

	public void setTesoro(List<Carta> tesoro) {
		this.tesoro = tesoro;
	}


}
