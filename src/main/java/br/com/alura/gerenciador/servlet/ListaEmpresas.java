package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresas
 */
@WebServlet("/listaEmpresas")
public class ListaEmpresas extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> lista = Banco.getEmpresas();
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresas.jsp");
		request.setAttribute("listaEmpresas", lista);
		requestDispatcher.forward(request, response);
	}

}
