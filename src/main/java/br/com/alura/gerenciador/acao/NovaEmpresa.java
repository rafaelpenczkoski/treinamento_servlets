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

public class NovaEmpresa implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		return "redirect:listaEmpresas";
	}
}
