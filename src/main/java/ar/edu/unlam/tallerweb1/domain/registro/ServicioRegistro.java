package ar.edu.unlam.tallerweb1.domain.registro;

import ar.edu.unlam.tallerweb1.delivery.registro.DatosRegistro;


public interface ServicioRegistro {
	void registrarUsuario(DatosRegistro datos);
	long existeEmail(String email);
	long existeUsuario(String username);
}
