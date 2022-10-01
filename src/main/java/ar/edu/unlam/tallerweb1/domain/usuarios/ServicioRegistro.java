package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public interface ServicioRegistro {
	void registrarUsuario(Usuario usuario);
	Usuario existeEmail(String email);
	Usuario existeUsuario(String username);
}
