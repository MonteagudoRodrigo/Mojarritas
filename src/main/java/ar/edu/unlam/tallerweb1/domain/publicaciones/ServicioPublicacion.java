package ar.edu.unlam.tallerweb1.domain.publicaciones;

public interface ServicioPublicacion {
		Publicacion consultarPublicacion(Long id);
		void crearPublicacion(Publicacion publicacion);
}
