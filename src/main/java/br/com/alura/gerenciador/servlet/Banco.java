package br.com.alura.gerenciador.servlet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> listaEmpresas;
	private static Integer chaveSequencial = 1;

	static {
		listaEmpresas = new ArrayList<>();
		adiciona(new Empresa("Luxoft", LocalDate.now()));
		adiciona(new Empresa("Google", LocalDate.now()));
		adiciona(new Empresa("Alura", LocalDate.now()));
	}
	
	public static void adiciona(Empresa empresa) {
		if (empresa != null && empresa.getId() == null) {
			empresa.setId(Banco.chaveSequencial++);
		}
		Banco.listaEmpresas.add(empresa);
	}
	
	public static boolean remove(Integer empresaId) {
		Iterator<Empresa> it = Banco.listaEmpresas.iterator();
		
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (empresa.getId().equals(empresaId)) {
				it.remove();
				return true;
			}
		}
		return false;
	}
	
	public static Empresa findById(Integer empresaId) {
		for (Empresa empresa: Banco.listaEmpresas) {
			if (empresa.getId().equals(empresaId)) {
				return empresa;
			}
		}
		return null;
	}
	
	public static List<Empresa> getEmpresas() {
		return Banco.listaEmpresas;
	}
}
