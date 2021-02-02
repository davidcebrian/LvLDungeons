package com.lvldungeons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.carta.Carta;
import com.lvldungeons.model.repository.CartaRepository;

@Service
public class CartaService {

	// Repositorios
	@Autowired
	private CartaRepository cartaRepo;


	// Get de todas las barajas
	public List<Carta> getEntities() {
		return (List<Carta>) cartaRepo.findAll();
	}

	// Get de una baraja por id
	public Carta getEntityById(Long id) {
		return cartaRepo.findById(id).get();
	}

	// Crear una nueva Carta
	public Carta saveEntity(Carta sent) {
		return cartaRepo.save(sent);
	}

	// Actualizar una Carta
	public Carta updateEntity(Long id, Carta sent) {
		Carta us = cartaRepo.findById(id).get();

		if (us != null) {
			//updateService.updateCarta(us, sent);
			cartaRepo.save(us);
		}
		return us;
	}

	// Borrar un user
	public void deleteEntity(Long id) {
		cartaRepo.deleteById(id);
	}
}
