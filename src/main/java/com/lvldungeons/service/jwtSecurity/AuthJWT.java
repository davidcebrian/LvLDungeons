package com.lvldungeons.service.jwtSecurity;

import java.security.Key;

import javax.servlet.http.HttpServletRequest;

import com.lvldungeons.model.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class AuthJWT {

	private static Key key;
	
	/*
	 * Creo el token jwt a partir del ID del usuario.
	 */
	public static String generarJWTDesdeId(User u) {
		String jws = Jwts.builder().setSubject(""+u.getIdUsuario())
				.signWith(SignatureAlgorithm.HS512, getGeneratedKey()).compact();
		
		return jws;
	}
	
	/*
	 * Descubro el id desde un jwt.
	 * 
	 * 
	 * Si devuelve -1, no existe el usuario
	 */
	public static int getIdUserDesdeJWT(String jwt) {
		int id;
		try {
			id = Integer.parseInt(Jwts.parser().setSigningKey(getGeneratedKey()).parseClaimsJws(jwt).getBody().getSubject());
		} catch (Exception ex) {
			ex.printStackTrace();
			id = -1;
		}
		return id;
	}

	/*
	 * Descubro el id desde un request. 
	 * 
	 * Si devuelve -1, no existe el usuario
	 */
	public static int getIdUserDesdeRequest(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		int id;
		
		if (authHeader != null && authHeader.length() > 8) {
			id = getIdUserDesdeJWT(authHeader.substring(7));
		} else {
			id = -1;
		}
		
		return id;
	}
	
	
	/*
	 * Genera una clave nueva cada vez iniciamos el servidor.
	 * 
	 */
	private static Key getGeneratedKey () {
		if (key == null) {
			key = MacProvider.generateKey();
		}
		return key;
	}

}
