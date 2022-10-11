package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.delivery.DatosRegistro;


public interface ServicioRegistro {
	void registrarUsuario(DatosRegistro datos);
	long existeEmail(String email);
	long existeUsuario(String username);
}
