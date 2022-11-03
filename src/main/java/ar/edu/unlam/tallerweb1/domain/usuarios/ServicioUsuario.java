package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.util.List;

import ar.edu.unlam.tallerweb1.domain.amigos.Amigo;

public interface ServicioUsuario {

	List<Usuario> listarTodos(Long id, String nombre);
}
