package com.lvldungeons.model.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.lvldungeons.model.entity.base.AbstractEntity;
import com.lvldungeons.model.enumerate.TipoBaraja;

@SuppressWarnings("serial")
@Entity
public class Partida extends AbstractEntity {
	
	@Column(nullable = false, unique = true)
	private String token;
	
    @OneToMany(mappedBy = "partida", cascade=CascadeType.ALL)
	private List<Personaje> personajes;
	
    //@ElementCollection
	//private Map<TipoBaraja, Baraja> barajas;

    public Partida() {
    	super();
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
	/*
		this.barajas = new HashMap<TipoBaraja, Baraja>() {{
			put(TipoBaraja.PUERTA, new Baraja());
			put(TipoBaraja.RECOMPENSA, new Baraja());
			put(TipoBaraja.MONSTRUOS_EPICOS, new Baraja());
			put(TipoBaraja.DESCARTE, new Baraja());
		}};
	*/
	}

	public String getToken() {
		return token;
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
}
