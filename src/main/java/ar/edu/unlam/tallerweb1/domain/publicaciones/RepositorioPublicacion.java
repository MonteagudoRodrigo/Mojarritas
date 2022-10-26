package ar.edu.unlam.tallerweb1.domain.publicaciones;

import java.util.List;



public interface RepositorioPublicacion {
		Publicacion buscarPublicacion(Long id);
		Publicacion buscar(Long id);
		void guardar(Publicacion publicacion);
		void modificar(Publicacion publicacion);
		void crearPublicacion(Publicacion publicacion);
		List<Publicacion> searchForAll(String value);
		List<Publicacion> globalList();
		List<Publicacion> ListPubicacionUser(Long id);
}
