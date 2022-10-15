package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.sql.SQLException;

import org.springframework.web.util.NestedServletException;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.hibernate.exception.GenericJDBCException;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	Usuario buscarUsuario(String email, String password);
	Long guardar(Usuario usuario)throws ConstraintViolationException ;
    Usuario buscar(String email);
	void modificar(Usuario usuario);
	Long registrarUsuario(Usuario usuario)throws ConstraintViolationException;
}
