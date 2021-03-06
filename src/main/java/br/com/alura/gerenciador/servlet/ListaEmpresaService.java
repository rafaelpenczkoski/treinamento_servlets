package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/api/empresas")
public class ListaEmpresaService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Empresa> empresas = Banco.getEmpresas();

		String accept = request.getHeader("Accept");

		if (accept.endsWith("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			String xml = xstream.toXML(empresas);
			response.setContentType("application/xml");
			response.getWriter().println(xml);
		} else if (accept.endsWith("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			response.setContentType("application/json");
			response.getWriter().println(json);
		} else {
			response.setContentType("application/json");
			response.getWriter().println("{\"message\": \"no content\"}");
		}
	}
}
