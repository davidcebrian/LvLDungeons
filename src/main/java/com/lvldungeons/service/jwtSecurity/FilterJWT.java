package com.lvldungeons.service.jwtSecurity;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterJWT implements Filter {

	/**
	 * Realiza el filtrado de todas las peticiones, si el id no existe va a tomar el valor -1 y no dejara pasar la peticion.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long idUser = AuthJWT.getIdUserDesdeRequest((HttpServletRequest) request);
		
		if (idUser != -1) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendError(403, "No Auth");
		}
	}
}
