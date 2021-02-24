package com.lvldungeons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.Partida;
import com.lvldungeons.model.entity.carta.Carta;
import com.lvldungeons.model.repository.PartidaRepository;

@Service
public class PartidaService {

	@Autowired
	private PartidaRepository partidaRepo;
	
	@Autowired
	private CartaService cartaService;
	
	public Partida getPartidaByToken(String token) {
		return partidaRepo.findByToken(token);
	}

	public Partida savePartida(Partida partida) {
		return partidaRepo.save(partida);
	}

	public void removePartida(Partida partida) {
		partidaRepo.delete(partida);
	}
	
	public void cargarBarajas(List<Carta> cartas) {
		
	}
	
	
}
