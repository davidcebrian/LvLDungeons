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
import com.lvldungeons.model.entity.base.AbstractEntity;

@SuppressWarnings("serial")
@Entity
public class Partida extends AbstractEntity {
	
	@Column(nullable = false, unique = true)
	private String token;
	private boolean iniciada;
	private Long idOwner;
	
    @OneToMany(mappedBy = "partida", cascade=CascadeType.ALL)
	private List<Personaje> personajes;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "descarte_id", referencedColumnName = "id")
	private Descarte descarte;
    //private Monstruo monstruo;
    //private Puerta puerta;
    //private Tesoro tesoro
    //private MonstruoFinal monstruoFinal;
        
    public Partida() {
    	super();
    	this.iniciada = false;
		this.token = UUID.randomUUID().toString().substring(0, 6);
		/*this.barajas = new HashMap<TipoBaraja, Baraja>() {{
			put(TipoBaraja.PUERTA, new Baraja());
			put(TipoBaraja.RECOMPENSA, new Baraja());
			put(TipoBaraja.MONSTRUOS_EPICOS, new Baraja());
			put(TipoBaraja.DESCARTE, new Baraja());
		}};
		*/
    }
    
	public Partida(Personaje personaje) {
		super();
		this.token = UUID.randomUUID().toString().substring(0, 6);
		this.personajes = new ArrayList<Personaje>() {{
			add(personaje);
		}};
		this.idOwner = personaje.getId();
	/*
		this.barajas = new HashMap<TipoBaraja, Baraja>() {{
			put(TipoBaraja.PUERTA, new Baraja());
			put(TipoBaraja.RECOMPENSA, new Baraja());
			put(TipoBaraja.MONSTRUOS_EPICOS, new Baraja());
			put(TipoBaraja.DESCARTE, new Baraja());
		}};
	*/
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
/*
	public Map<TipoBaraja, Baraja> getBarajas() {
		return barajas;
	}
*/
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
