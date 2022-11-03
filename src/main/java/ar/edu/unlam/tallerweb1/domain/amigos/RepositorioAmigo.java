package ar.edu.unlam.tallerweb1.domain.amigos;

import java.io.Serializable;
import java.util.List;

public interface RepositorioAmigo {
	
	Serializable guardarSolicitud(Amigo amigo);
	List<Amigo> listarAmigos(long idUser);
	List<Amigo> listarSolicitudes(long idUser);
	void eliminarSolicitud(Amigo amigo);
	
	

}
