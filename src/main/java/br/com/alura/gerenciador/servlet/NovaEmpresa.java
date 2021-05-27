package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateTimeFormatter formatter = Util.getDateTimeFormatter();
		String nomeEmpresa = request.getParameter("nome");
		LocalDate dataAbertura = null;
		try {
			dataAbertura = LocalDate.parse(request.getParameter("dataAbertura"), formatter);		
		} catch (DateTimeParseException ex) {
			throw new ServletException(ex);
		}
				
		System.out.println("Cadastrando nova empresa (" + nomeEmpresa + ")");
		
		Empresa empresa = new Empresa(nomeEmpresa, dataAbertura);
		
		Banco.adiciona(empresa);
		
		request.setAttribute("nomeEmpresa", nomeEmpresa);
		response.sendRedirect("listaEmpresas");
		
	}

}
