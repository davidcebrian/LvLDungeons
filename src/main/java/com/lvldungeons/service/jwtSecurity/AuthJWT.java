package com.lvldungeons.service.jwtSecurity;

import java.security.Key;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lvldungeons.model.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Service
public class AuthJWT {

	private static Key key;
	
	/*
	 * Creo el token jwt a partir del ID del usuario.
	 */
	public static String generarJWTDesdeId(User u) throws Exception{
		String jws = Jwts.builder().setSubject(""+Long.toString(u.getId()))
				.signWith(SignatureAlgorithm.HS512, getGeneratedKey()).compact();
		
		return jws;
	}
	
	/*
	 * Descubro el id desde un jwt.
	 * 
	 * 
	 * Si devuelve -1, no existe el usuario
	 */
	public static long getIdUserDesdeJWT(String jwt) {
		long id;
		try {
			id = Long.parseLong(Jwts.parser().setSigningKey(getGeneratedKey()).parseClaimsJws(jwt).getBody().getSubject());
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
	public static long getIdUserDesdeRequest(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		long id;
		if (authHeader != null && authHeader.length() > 8) {
			id = getIdUserDesdeJWT(authHeader.split(" ")[1]);
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
