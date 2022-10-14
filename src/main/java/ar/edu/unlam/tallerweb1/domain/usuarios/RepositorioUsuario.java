package ar.edu.unlam.tallerweb1.domain.usuarios;



// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	Usuario buscarUsuario(String email, String password);
	
	void guardar(Usuario usuario);
    long buscar(String email);
	void modificar(Usuario usuario);
	void registrarUsuario(Usuario usuario);
	long buscarUsuario(String username);
	
	
}
