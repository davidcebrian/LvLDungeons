package com.lvldungeons.service.Error;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class ManejoErrores {

	private ObjectMapper mapper;
	private JsonNode errorJSON;
	
	/*
	 * Constructor.
	 */
	private ManejoErrores() {
		super();
		mapper = new ObjectMapper();
		reiniciarError();
	}
	
	/**
	 * 
	 * Recibe un codigo de error, y devuelve un JSON con el codigo enviado y un mensaje predefinido.
	 * 
	 * @param Integer error 
	 * @return JSON
	 */
	public JsonNode generarError(Integer error) {
		reiniciarError();
		
		((ObjectNode) errorJSON).put("error", error);

		if (error == 1) {
			((ObjectNode) errorJSON).put("mensaje", "Se ha realizado una peticion incorrecta");				

		} else if (error == 2) {
			((ObjectNode) errorJSON).put("mensaje", "Ya existe el nickname o email");				

		} else if (error == 3) {
			((ObjectNode) errorJSON).put("mensaje", "Usuario o contraseña incorrecta");				
		
		} else if (error == 4) {
			((ObjectNode) errorJSON).put("mensaje", "No se ha podido iniciar la partida");				
		
		} else if (error == 5) {
			((ObjectNode) errorJSON).put("mensaje", "No se puede unir a la partida");				
		
		} else if (error == 6) {
			((ObjectNode) errorJSON).put("mensaje", "No se ha podido acceder a la partida");				
		
		} else {
			((ObjectNode) errorJSON).put("mensaje", "Error Indeterminado, Contacte con un administrador");				
			
		}
		
		return errorJSON;
	}
	
	
	/**
	 * Reinicia el JSON de error.
	 */
	private void reiniciarError() {
		try {
			errorJSON = mapper.readTree(new String ("{}"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
