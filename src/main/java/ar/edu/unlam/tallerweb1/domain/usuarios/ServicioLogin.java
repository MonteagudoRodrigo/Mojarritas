package ar.edu.unlam.tallerweb1.domain.usuarios;


public interface ServicioLogin {

	boolean Auth(String email, String password);
	
}
