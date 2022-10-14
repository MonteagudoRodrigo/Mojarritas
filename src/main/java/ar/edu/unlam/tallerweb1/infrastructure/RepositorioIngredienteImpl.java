package ar.edu.unlam.tallerweb1.infrastructure;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.ingrediente.RepositorioIngrediente;

@Repository("repositorioIngrediente")
public class RepositorioIngredienteImpl implements RepositorioIngrediente {

	private SessionFactory sessionFactory;
	
}
