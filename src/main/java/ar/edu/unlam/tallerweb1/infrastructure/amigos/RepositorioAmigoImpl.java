package ar.edu.unlam.tallerweb1.infrastructure.amigos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.amigos.Amigo;
import ar.edu.unlam.tallerweb1.domain.amigos.RepositorioAmigo;
import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;

@Repository("RepositorioAmigo")
public class RepositorioAmigoImpl implements RepositorioAmigo {

	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioAmigoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardarSolicitud(Amigo amigo) {
		this.sessionFactory.getCurrentSession().save(amigo);
		
	}

	@Override
	public List<Amigo> listarAmigos(long idUser) {
		return (List<Amigo>) this.sessionFactory.getCurrentSession()
				.createCriteria(Amigo.class)
				.createAlias("usuario", "user")
				.add(Restrictions.and(Restrictions.eq("user.id", idUser), Restrictions.eq("confirmado", true)))
				.list();
		
	}

	@Override
	public List<Amigo> listarSolicitudes(long idUser) {
		return (List<Amigo>) this.sessionFactory.getCurrentSession()
				.createCriteria(Amigo.class)
				.createAlias("amigo", "user")
				.add(Restrictions.and(Restrictions.eq("user.id", idUser), Restrictions.eq("confirmado", false)))
				.list();
	}

	
}
