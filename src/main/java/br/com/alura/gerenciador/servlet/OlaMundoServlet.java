package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ola")
public class OlaMundoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter writer = res.getWriter();
		
		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("	<head>");
		writer.println("		<meta charset=\"ISO-8859-1\">");
		writer.println("		<title>Olá mundo!</title>");
		writer.println("	</head>");
		writer.println("	<body>");
		writer.println("		<h2>Olá mundo!</h2>");
		writer.println("		<p>Parabéns, você escreveu seu primeiro servlet!</p>");
		writer.println("	</body>");
		writer.println("</html>");
	} 
	
}
