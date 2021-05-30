package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutorizacaoFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String uri = request.getRequestURI();
		String className = uri.substring(uri.indexOf("/", uri.lastIndexOf("/")) + 1);
		
		System.out.println(className);

		List<String> loginActions = new ArrayList<>();
		loginActions.add("formLogin");
		loginActions.add("login");
//		loginActions.add("empresas");
		boolean requiresAutentication = !loginActions.contains(className);
		HttpSession session = request.getSession();
		boolean userIsLogged = session.getAttribute("usuarioLogado") != null;

		if (requiresAutentication && !userIsLogged) {
			response.sendRedirect("formLogin");
			return;
		}

		chain.doFilter(request, response);
	}

}
