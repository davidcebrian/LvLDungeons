package com.lvldungeons.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.lvldungeons.model.entity.dto.PartidaDTO;
import com.lvldungeons.service.GenerateDTOService;
import com.lvldungeons.service.PartidaService;


@Controller
public class webSocketController {
	
	@Autowired
	private PartidaService partidaService;
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@Autowired
	private GenerateDTOService generateDto;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@MessageMapping("room/prueba/{room}")
	public void joinPartida(@DestinationVariable String room, PartidaDTO unirse) throws Exception {
	  Thread.sleep(500);
	  PartidaDTO postPartida = generateDto.generatePartidaDTO(partidaService.getPartidaByToken(unirse.getToken()));
	  messagingTemplate.convertAndSend("/topic/partida/" + room, postPartida);
	}
	
}

