package ar.edu.unlam.tallerweb1.domain.amigos;

import java.util.List;

public interface RepositorioAmigo {
	
	void guardarSolicitud(Amigo amigo);
	List<Amigo> listarAmigos(long idUser);
	List<Amigo> listarSolicitudes(long idUser);
	
	

}
