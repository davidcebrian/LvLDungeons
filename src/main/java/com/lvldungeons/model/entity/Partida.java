package com.lvldungeons.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.lvldungeons.model.entity.baraja.Descarte;
import com.lvldungeons.model.entity.baraja.MonstruoFinal;
import com.lvldungeons.model.entity.baraja.Puerta;
import com.lvldungeons.model.entity.baraja.Tesoro;
import com.lvldungeons.model.entity.base.AbstractEntity;

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
    @OneToMany(mappedBy = "partida", cascade=CascadeType.ALL)
	private List<Personaje> personajes;
	
    /*
     * Todas las barajas necesarias
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "descarte_id", referencedColumnName = "id")
	private Descarte descarte;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monstruo_final_id", referencedColumnName = "id")
    private MonstruoFinal monstruoFinal;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "puerta_id", referencedColumnName = "id")
    private Puerta puerta;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tesoro_id", referencedColumnName = "id")
    private Tesoro tesoro;
    
    public Partida() {
    	super();
    	this.iniciada = false;
		this.token = UUID.randomUUID().toString().substring(0, 6);

    }
    
	public Partida(Personaje personaje) {
		super();
		this.token = UUID.randomUUID().toString().substring(0, 6);
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
		idOwner = this.idOwner;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}
	
	public void addPersonaje(Personaje personaje) {
		this.personajes.add(personaje);
	}

	public void removePersonaje(Personaje personaje) {
		this.personajes.remove(personaje);
	}

	public Descarte getDescarte() {
		return descarte;
	}

	public void setDescarte(Descarte descarte) {
		this.descarte = descarte;
	}

}
