package ar.edu.unlam.tallerweb1.domain.amigos;

import java.util.List;

public interface RepositorioAmigo {
	
	boolean guardarSolicitud(Amigo amigo);
	List<Amigo> listarAmigos(long idUser);
	List<Amigo> listarSolicitudes(long idUser);
	

}
