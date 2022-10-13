package ar.edu.unlam.tallerweb1.domain.menu;

import ar.edu.unlam.tallerweb1.domain.ingrediente.Ingrediente;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public interface RepositorioMenu {
	void guardar(Menu menu);
    long buscar(String nombre);
    long buscar(Usuario usuario);
    long buscar(Ingrediente ingrediente);
	void modificar(Menu menu);
}
