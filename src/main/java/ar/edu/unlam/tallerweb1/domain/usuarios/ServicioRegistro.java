package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public interface ServicioRegistro {
	void registrarUsuario(String email, String password, String nombre, String apellido, String username);
}
