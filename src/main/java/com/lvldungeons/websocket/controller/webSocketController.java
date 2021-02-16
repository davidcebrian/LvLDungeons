package com.lvldungeons.websocket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.lvldungeons.model.entity.dto.PartidaDTO;
import com.lvldungeons.service.GenerateDTOService;
import com.lvldungeons.service.PartidaService;
import com.lvldungeons.service.PersonajeService;


@Controller
public class webSocketController {
	
	
	@Autowired
	private PersonajeService personajeService;
	
	@Autowired
	private PartidaService partidaService;
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	List<String> topics;
	@CrossOrigin(origins = "*")
	@MessageMapping("/prueba")
	//@SendTo("/topic/mensaje")
	public void joinPartida(HttpServletRequest request, PartidaDTO unirse) throws Exception {
	  Thread.sleep(500);
	  PartidaDTO postPartida = GenerateDTOService.generatePartidaDTO(partidaService.getPartidaByToken(unirse.getToken()));
	  messagingTemplate.convertAndSend("/topic/partida/" /*+ unirse.getToken()*/, postPartida);
	  
//	  switch(string.getEdad()) {
//	  case 1:
//		  messagingTemplate.convertAndSend("/topic/partida/", string);
//		  break;
//	  case 2:
//		  messagingTemplate.convertAndSend("/topic/partida/2", string);
//		  break;
//	  }
	  //return string;
	}
	
}

