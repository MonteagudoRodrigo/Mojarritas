package ar.edu.unlam.tallerweb1.domain.publicaciones;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public interface RepositorioPublicacion {
		Publicacion buscarPublicacion(Long id);
		Publicacion buscar(Long id);
		List<Publicacion> buscarPor(Usuario usuario);
		void guardar(Publicacion publicacion);
		void modificar(Publicacion publicacion);
		void crearPublicacion(Publicacion publicacion);
		List<Publicacion> buscarPor(String titulo);
}
