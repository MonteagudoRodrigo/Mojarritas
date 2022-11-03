package ar.edu.unlam.tallerweb1.domain.amigos;

import java.io.Serializable;
import java.util.List;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public interface ServicioAmigo {

	Serializable enviarSolicitud(Usuario userFrom, Usuario userTo);
	boolean aceptarSolicitud(Amigo amigo);
	List<Amigo> listarAmigos(Usuario ofUser);
	List<Amigo> listarSolicitudes(Usuario ofUser);
	boolean cancelarSolicitud(long id);
	

	
}
