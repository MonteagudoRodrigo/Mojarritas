package ar.edu.unlam.tallerweb1.infrastructure;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.ingrediente.Ingrediente;
import ar.edu.unlam.tallerweb1.domain.menu.Menu;
import ar.edu.unlam.tallerweb1.domain.menu.RepositorioMenu;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Repository("repositorioMenu")
public class RepositorioMenuImpl implements RepositorioMenu {
	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioMenuImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardar(Menu menu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long buscar(String nombre) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long buscar(Usuario usuario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long buscar(Ingrediente ingrediente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modificar(Menu menu) {
		// TODO Auto-generated method stub
		
	}
    
    

}
