package com.lvldungeons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.model.repo.PersonajeRepository;

@Service
public class PersonajeService {

	// Repositorios
	@Autowired
	private PersonajeRepository persoRepo;

	// Servicios
	@Autowired
	private UpdateService updateService;

	// Get de todos los personajes
	public List<Personaje> getEntity() {
		return (List<Personaje>) persoRepo.findAll();
	}

	// Get de un user por id
	public Personaje getEntityById(Long id) {
		Personaje p = persoRepo.findById(id).get();
		return p;
	}

	// Crear un nuevo user
	public Personaje saveEntity(Personaje sent) {
		return persoRepo.save(sent);
	}

	// Actualziar un user
	public Personaje updateEntity(Long id, Personaje sent) {
		Personaje us = persoRepo.findById(id).get();

		if (us != null) {
			updateService.updatePersonaje(us, sent);
			persoRepo.save(us);
		}
		return us;
	}

	// Borrar un user
	public void deleteEntity(Long id) {
		persoRepo.deleteById(id);
	}
}
