package ar.edu.unlam.tallerweb1.domain.usuarios;

import ar.edu.unlam.tallerweb1.delivery.DatosRegistro;


public interface ServicioRegistro {
	void registrarUsuario(DatosRegistro datos);
	Usuario existeEmail(String email);
	Usuario existeUsuario(String username);
}
