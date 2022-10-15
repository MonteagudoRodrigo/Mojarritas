package ar.edu.unlam.tallerweb1.domain.usuarios;



// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioLogin {

	Usuario consultarUsuario(String email, String password);
	
	void actualizarUsuario(Usuario user);
<<<<<<< HEAD
=======

	Usuario consultarUsuario(String userName);
>>>>>>> 073418752eb3057b6c4987f70b5060847270b19f
}
