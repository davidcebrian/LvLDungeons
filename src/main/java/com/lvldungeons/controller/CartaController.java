package com.lvldungeons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvldungeons.model.entity.carta.Carta;
import com.lvldungeons.service.CartaService;


@RestController
@RequestMapping(path = "carta")
public class CartaController {
	
	@Autowired
	private CartaService cService;
	
	@GetMapping("/all")
	public ResponseEntity getAll() {
		List<Carta> cartas = cService.getEntities();
		return ResponseEntity.status(HttpStatus.OK).body(cartas);
	}
	
	@PostMapping()
	public ResponseEntity saveCard(@RequestBody Carta carta) {
		ResponseEntity<?> response;
		if(carta == null) {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO HAS INTRODUCIDO CARTA");
		}else {
			cService.saveEntity(carta);
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(carta);
		}
		return response;
	}
	
	@PostMapping("/group")
	public ResponseEntity saveCards(@RequestBody List<Carta> cartas) {
		ResponseEntity<?> response;
		if(cartas.isEmpty()) {
			response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO HAS INTRODUCIDO CARTAS");
		}else {
			cService.saveEntities(cartas);
			response = ResponseEntity.status(HttpStatus.ACCEPTED).body(cartas);
		}
		return response;
	}
}