package br.com.alura.gerenciador.servlet;

import java.time.format.DateTimeFormatter;

public class Util {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static DateTimeFormatter getDateTimeFormatter() {
		return Util.FORMATTER;
	}
	
}
