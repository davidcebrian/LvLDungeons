package com.lvldungeons.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.carta.Carta;
import com.lvldungeons.model.entity.carta.Equipo;
import com.lvldungeons.model.entity.dto.CartaDTO;
import com.lvldungeons.model.enumerate.TipoCarta;
import com.lvldungeons.model.repository.CartaRepository;
import com.lvldungeons.model.repository.EquipoRepository;

@Service
public class CartaService {

	// Repositorios
	@Autowired
	private CartaRepository cartaRepo;
	@Autowired
	private EquipoRepository equipoRepo;
	@Autowired
	private GenerateDTOService generateDto;


	
	// Get de todas las barajas
	public List<Carta> getEntities() {
		return (List<Carta>) cartaRepo.findAll();
	}

	// Get de una carta por id
	public Carta getEntityById(Long id) {
		return cartaRepo.findById(id).get();
	}

	// Crear una nueva Carta
	public Carta saveEntity(Carta sent) {
		return cartaRepo.save(sent);
	}
	
	//Crear varias cartas
	public List<Carta> saveEntities(List<CartaDTO> sent){
		List<Carta> cartas = new ArrayList<Carta>();
		List<Equipo> equipos = new ArrayList<Equipo>();
		sent.stream().forEach((c) -> {
			if(c.getTipo() != TipoCarta.EQUIPO) {
				cartas.add(generateDto.generateCartaDTO(c));
			}else {
				equipos.add((Equipo) generateDto.generateCartaDTO(c));
			}
		});
		cartaRepo.saveAll(cartas);
		equipoRepo.saveAll(equipos);
		cartas.addAll(equipos);
		return cartas;
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

	// Borrar una carta
	public void deleteEntity(Long id) {
		cartaRepo.deleteById(id);
	}
}
