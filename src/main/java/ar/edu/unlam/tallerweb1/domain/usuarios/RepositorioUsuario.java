package ar.edu.unlam.tallerweb1.domain.usuarios;


import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.hibernate.exception.GenericJDBCException;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	Usuario buscarUsuario(String email, String password);
	Usuario buscarUsuario(String userName);
	void guardar(Usuario usuario);
    long buscar(String email);
	void modificar(Usuario usuario);
	void registrarUsuario(Usuario usuario);
	long buscarUsuario(String username);
	
}
