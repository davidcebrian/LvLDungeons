package com.lvldungeons.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.Partida;
import com.lvldungeons.model.entity.Personaje;
import com.lvldungeons.model.entity.User;
import com.lvldungeons.model.repository.PersonajeRepository;

@Service
public class PersonajeService {

	// Repositorios
	@Autowired
	private PersonajeRepository persoRepo;

	// Servicios

	@Autowired 
	private UserService userService;
	@Autowired
	private PartidaService partidaService;

	//Obten un personaje
	public Personaje getPersonajeFromRequest(HttpServletRequest request, long id) {
		User user = userService.datosAutenticado(request, id);
		
		return (user != null) ? user.getPersonaje() : null;
	}
	
	// Iniciar una partida
	public Partida iniciarPartida(Personaje personaje) {
		Partida partida;
		if (personaje.getPartida() != null) {
			partidaService.removePartida(personaje.getPartida());
		}
		
		partida = personaje.iniciarPartida();
		
		persoRepo.save(personaje);
		
		return partida;
	}
	
	// Unirse a una partida
	public Partida unirsePartida(Personaje personaje, String token) {
		
		Partida partida = partidaService.getPartidaByToken(token);
		partida.addPersonaje(personaje);
		personaje.unirsePartida(partida);
		
		partidaService.savePartida(partida);
		persoRepo.save(personaje);
		
		return partidaService.getPartidaByToken(token);
	}

	// Get una partida
	public Partida obtenerPartida(Personaje personaje, String token) {
		
		Partida partida = partidaService.getPartidaByToken(token);
		
		return (partida != null) ? partida : null;
	}

	
	// Empezar la partida cuando todos los jugadores esten listos
	public Boolean empezarPartida(String token) {
		Partida partida = partidaService.getPartidaByToken(token);
		boolean empezar = true;
		
		partida.getPersonajes().stream().allMatch(pj -> pj.getEmpezarPartida());
		
		// Aqui debemos hacer algo cuando empieza la partida, pero por ahora
		// Solo devolvera un boolean.
		
		return empezar;
	}

	//Cambiar estado del personaje.
	public Personaje setEstadoPersonaje(Personaje personaje, Boolean listo) {
		
		if (personaje.getPartida() != null && !personaje.getPartida().getIniciada()) {
			personaje.setEmpezarPartida(listo);			
		}
		
		return persoRepo.save(personaje);
	}

}
