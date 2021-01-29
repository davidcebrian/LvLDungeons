package com.lvldungeons.model.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.lvldungeons.model.entity.base.AbstractEntity;
import com.lvldungeons.model.enumerados.TipoBaraja;

@SuppressWarnings("serial")
public class Partida extends AbstractEntity{
	
	private String token;
	
	private List<Personaje> personajes;
	
	private Map<TipoBaraja, Baraja> barajas;

	public Partida(Personaje personaje) {
		super();
		this.token = UUID.randomUUID().toString().substring(0, 6);
		this.personajes = new ArrayList<Personaje>() {{
			add(personaje);
		}};
	
		this.barajas = new HashMap<TipoBaraja, Baraja>() {{
			put(TipoBaraja.PUERTA, new Baraja());
			put(TipoBaraja.RECOMPENSA, new Baraja());
			put(TipoBaraja.MONSTRUOS_EPICOS, new Baraja());
			put(TipoBaraja.DESCARTE, new Baraja());
		}};
	}

	public String getToken() {
		return token;
	}

	public List<Personaje> getPersonajes() {
		return personajes;
	}
	
	public void addPersonajes(Personaje personaje) {
		this.personajes.add(personaje);
	}

	public Map<TipoBaraja, Baraja> getBarajas() {
		return barajas;
	}

	public void removePersonaje(Personaje personaje) {
		this.personajes.remove(personaje);
	}
}
