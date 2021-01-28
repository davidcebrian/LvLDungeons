package com.lvldungeons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.Baraja;
import com.lvldungeons.model.entity.User;
import com.lvldungeons.model.repo.BarajaRepository;

@Service
public class BarajaService {

	// Repositorios
	@Autowired
	private BarajaRepository barajaRepo;

	// Servicios
	@Autowired
	private UpdateService updateService;

	// Get de todas las barajas
	public List<Baraja> getEntity() {
		return (List<Baraja>) barajaRepo.findAll();
	}

	// Get de una baraja por id
	public Baraja getEntityById(Long id) {
		return barajaRepo.findById(id).get();
	}

	// Crear una nueva Baraja
	public Baraja saveEntity(Baraja sent) {
		return barajaRepo.save(sent);
	}

	// Actualizar una Baraja
	public Baraja updateEntity(Long id, Baraja sent) {
		Baraja us = barajaRepo.findById(id).get();

		if (us != null) {
			updateService.updateBaraja(us, sent);
			barajaRepo.save(us);
		}
		return us;
	}

	// Borrar un user
	public void deleteEntity(Long id) {
		barajaRepo.deleteById(id);
	}
}
