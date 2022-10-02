package ar.edu.unlam.tallerweb1.domain.publicaciones;

public interface RepositorioPublicacion {
		Publicacion buscarPublicacion(Long id);
		Publicacion buscar(Long id);
		void guardar(Publicacion publicacion);
		void modificar(Publicacion publicacion);
		void crearPublicacion(Publicacion publicacion);
}
