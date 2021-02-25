package com.lvldungeons.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.Partida;
import com.lvldungeons.model.entity.carta.Carta;
import com.lvldungeons.model.enumerate.TipoCarta;
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
	
	public Partida cargarBarajas(String token) {
		Partida partida = getPartidaByToken(token);
		List<Carta> todas = cartaService.getEntities();
		List<Carta> puerta = new ArrayList<>();
		List<Carta> tesoro = new ArrayList<>();
		List<Carta> monstruoFinal = new ArrayList<>();
		todas.stream().forEach(c -> {
			if(c.getTipo().equals(TipoCarta.HECHIZOS) || c.getTipo().equals(TipoCarta.MONSTRUO) || c.getTipo().equals(TipoCarta.MALDICION) ) {
				puerta.add(c);
			}else if(c.getTipo().equals(TipoCarta.EQUIPO)) {
				tesoro.add(c);
			}else {
				monstruoFinal.add(c);
			}
		});
		partida.setPuerta(puerta);
		partida.setTesoro(tesoro);
		partida.setMonstruoFinal(monstruoFinal);
		partidaRepo.save(partida);
		return partida;
	}
	
	public Partida repartir(String token) {
		Partida partida = getPartidaByToken(token);
		Random random = new Random();
		partida.getPersonajes().stream().forEach(personaje -> {
			List<Carta> mano = new ArrayList<>();
			for(int i = 0; i<4; i++) {
				mano.add(partida.getPuerta().get(random.nextInt(partida.getPuerta().size())));
				mano.add(partida.getTesoro().get(random.nextInt(partida.getTesoro().size())));
			}
			personaje.setMano(mano);
		});
		partidaRepo.save(partida);
		return partida;
	}
	
	
}
