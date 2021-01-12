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

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		int idUser = AuthJWT.getIdUserDesdeRequest((HttpServletRequest) request);
		
		if (idUser != -1) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendError(403, "No Auth");
		}
	}

}
