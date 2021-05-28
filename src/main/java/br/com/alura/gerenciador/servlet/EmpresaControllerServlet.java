package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/")
public class EmpresaControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		String className = uri.substring(uri.indexOf("/", 1) + 1);

		className = "br.com.alura.gerenciador.acao." + className.substring(0, 1).toUpperCase() + className.substring(1);

		try {
			Class<?> clazz = Class.forName(className);
			Constructor<?> constructor = clazz.getConstructor();
			Acao acao = (Acao) constructor.newInstance();
			String destination = acao.executa(request, response);

			String[] path = destination.split(":");

			if (path[0].equals("forward")) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + path[1]);
				requestDispatcher.forward(request, response);
			} else if (path[0].equals("redirect")) {
				response.sendRedirect(path[1]);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
