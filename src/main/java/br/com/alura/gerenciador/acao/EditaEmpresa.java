package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import br.com.alura.gerenciador.servlet.Util;

public class EditaEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		Empresa empresa = Banco.findEmpresaById(empresaId);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		return "redirect:listaEmpresas";
	}
}
