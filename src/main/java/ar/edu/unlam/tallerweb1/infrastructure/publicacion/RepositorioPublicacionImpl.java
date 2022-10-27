package ar.edu.unlam.tallerweb1.infrastructure.publicacion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.RepositorioPublicacion;

@Repository("repositorioPublicacion")
public class RepositorioPublicacionImpl implements RepositorioPublicacion{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioPublicacionImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Publicacion buscarPublicacion(Long id) {
		//TODO De momento, se busca por Id, pero la idea es devolver un array por fecha
		final Session session = sessionFactory.getCurrentSession();
		return (Publicacion) session.createCriteria(Publicacion.class)
				.add(Restrictions.eq("id",id))
				.uniqueResult();
	}

	@Override
	public void guardar(Publicacion publicacion) {
		sessionFactory.getCurrentSession().save(publicacion);
	}

	@Override
	public void modificar(Publicacion publicacion) {
		sessionFactory.getCurrentSession().update(publicacion);
	}

	@Override
	public void crearPublicacion(Publicacion publicacion) {
		this.guardar(publicacion);
	}

	@Override
	public Publicacion buscar(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Publicacion) session.createCriteria(Publicacion.class)
				.add(Restrictions.eq("id",id))
				.uniqueResult();
	}

	@Override
	public List<Publicacion> searchForAll(String value) {
		return (List <Publicacion>)this.sessionFactory.getCurrentSession()
			.createCriteria(Publicacion.class)
			.createAlias("usuario", "user")
			.add(Restrictions.or(Restrictions.like("descripcion", "%"+value+"%"),Restrictions.like("titulo", "%"+value+"%")
					,Restrictions.like("user.nombre", "%"+value+"%")))
			.list();

	}
	
	@Override
	public List<Publicacion> globalList() {
		return (List <Publicacion>) this.sessionFactory.getCurrentSession()
			.createCriteria(Publicacion.class)
			.addOrder(Order.desc("id"))
			.list();

	}
	
	@Override
	public List<Publicacion> ListPubicacionUser(Long id) {
		return (List <Publicacion>) this.sessionFactory.getCurrentSession()
				.createCriteria(Publicacion.class)
				.createAlias("usuario", "user")
				.add(Restrictions.eq("user.id", id))
				.addOrder(Order.desc("id"))
				.list();
	}

}
