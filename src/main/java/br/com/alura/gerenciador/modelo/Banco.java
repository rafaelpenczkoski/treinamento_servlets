package br.com.alura.gerenciador.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas;
	private static List<Usuario> listaUsuarios;
	private static Integer sequenceEmpresa = 1;

	static {
		listaEmpresas = new ArrayList<>();
		listaUsuarios = new ArrayList<>();
		adicionaEmpresa(new Empresa("Luxoft", LocalDate.now()));
		adicionaEmpresa(new Empresa("Google", LocalDate.now()));
		adicionaEmpresa(new Empresa("Alura", LocalDate.now()));

		adicionaUsuario(new Usuario("rafael", "123"));
	}

	public static void adicionaEmpresa(Empresa empresa) {
		if (empresa != null && empresa.getId() == null) {
			empresa.setId(Banco.sequenceEmpresa++);
		}
		Banco.listaEmpresas.add(empresa);
	}

	public static void adicionaUsuario(Usuario usuario) {
		Banco.listaUsuarios.add(usuario);
	}

	public static boolean removeEmpresa(Integer empresaId) {
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

	public static Empresa findEmpresaById(Integer empresaId) {
		for (Empresa empresa : Banco.listaEmpresas) {
			if (empresa.getId().equals(empresaId)) {
				return empresa;
			}
		}
		return null;
	}

	public static Usuario getUsuarioByLoginSenha(String login, String senha) {
		for (Usuario usuario : Banco.listaUsuarios) {
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}

	public static List<Empresa> getEmpresas() {
		return Banco.listaEmpresas;
	}
}
