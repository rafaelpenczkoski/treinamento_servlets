package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

public class ControllerFilter implements Filter {
	
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

		className = "br.com.alura.gerenciador.acao." + className.substring(0, 1).toUpperCase() + className.substring(1);

		try {
			Class<?> clazz = Class.forName(className);
			Constructor<?> constructor = clazz.getConstructor();
			Acao action = (Acao) constructor.newInstance();
			String actionResult = action.executa(request, response);

			String[] destination = actionResult.split(":");

			if (destination[0].equals("forward")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("../WEB-INF/view/" + destination[1]);
				requestDispatcher.forward(request, response);
			} else if (destination[0].equals("redirect")) {
				response.sendRedirect(destination[1]);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
