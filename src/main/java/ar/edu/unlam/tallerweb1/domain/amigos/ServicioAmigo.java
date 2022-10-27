package ar.edu.unlam.tallerweb1.domain.amigos;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public interface ServicioAmigo {

	boolean enviarSolicitud(Usuario userFrom, Usuario userTo);
	boolean aceptarSolicitud(Amigo amigo);
	List<Amigo> listarAmigos(Usuario ofUser);
	List<Amigo> listarSolicitudes(Usuario ofUser);

	
}
