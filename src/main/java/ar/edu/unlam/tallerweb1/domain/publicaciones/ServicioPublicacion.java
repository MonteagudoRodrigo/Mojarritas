package ar.edu.unlam.tallerweb1.domain.publicaciones;

import java.util.List;

public interface ServicioPublicacion {
		Publicacion consultarPublicacion(Long id);
		void crearPublicacion(Publicacion publicacion);
		List<Publicacion> buscarPor(String titulo);
}
