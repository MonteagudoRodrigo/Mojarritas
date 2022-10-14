package ar.edu.unlam.tallerweb1.infrastructure;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
	public RepositorioMenuImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardar(Menu menu) {
		Serializable res = sessionFactory.getCurrentSession().save(menu);
		System.out.println(res.toString());

	}

	@Override
	public long buscar(String nombre) {
		final Session session = sessionFactory.getCurrentSession();
		return (long) session.createCriteria(Menu.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.eq("nombre", nombre))
				.uniqueResult();
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
		sessionFactory.getCurrentSession().update(menu);

	}

}
