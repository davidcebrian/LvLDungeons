package com.lvldungeons.service.Error;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class ManejoErrores {

	private ObjectMapper mapper;
	private JsonNode errorJSON;
	
	private ManejoErrores() {
		super();
		mapper = new ObjectMapper();
		reiniciarError();
	}
	
	
	public JsonNode generarError(Integer error) {
		reiniciarError();
		
		((ObjectNode) errorJSON).put("error", error);

		if (error == 1) {
			((ObjectNode) errorJSON).put("mensaje", "Se ha realizado una peticion incorrecta");				

		} else if (error == 2) {
			((ObjectNode) errorJSON).put("mensaje", "Ya existe el nickname o email");				

		} else if (error == 3) {
			((ObjectNode) errorJSON).put("mensaje", "No se ha podido realizar el login");				
			
		} else {
			((ObjectNode) errorJSON).put("mensaje", "Error Indeterminado, Contacte con un administrador");				
			
		}
		
		return errorJSON;
	}
	
	private void reiniciarError() {
		try {
			errorJSON = mapper.readTree(new String ("{}"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
