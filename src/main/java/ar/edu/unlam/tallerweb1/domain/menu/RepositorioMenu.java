package ar.edu.unlam.tallerweb1.domain.menu;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public interface RepositorioMenu {
	void guardar(Menu menu);
    long buscar(String email);
	void modificar(Usuario usuario);
}
