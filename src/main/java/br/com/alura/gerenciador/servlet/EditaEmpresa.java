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
 * Servlet implementation class EditaEmpresa
 */
@WebServlet("/editaEmpresa")
public class EditaEmpresa extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		DateTimeFormatter formatter = Util.getDateTimeFormatter();
		String nomeEmpresa = request.getParameter("nome");
		String id = request.getParameter("id");
		
		LocalDate dataAbertura = null;
		try {
			dataAbertura = LocalDate.parse(request.getParameter("dataAbertura"), formatter);		
		} catch (DateTimeParseException ex) {
			throw new ServletException(ex);
		}
		
		System.out.println("Alterando empresa (" + nomeEmpresa + ")");
		
		Integer empresaId = Integer.parseInt(id);
		Empresa empresa = Banco.findById(empresaId);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		response.sendRedirect("listaEmpresas");
	}

}
