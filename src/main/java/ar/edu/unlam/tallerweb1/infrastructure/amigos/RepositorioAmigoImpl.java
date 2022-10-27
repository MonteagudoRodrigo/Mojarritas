package ar.edu.unlam.tallerweb1.infrastructure.amigos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.domain.amigos.Amigo;
import ar.edu.unlam.tallerweb1.domain.amigos.RepositorioAmigo;

@Repository("RepositorioAmigo")
public class RepositorioAmigoImpl implements RepositorioAmigo {

	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioAmigoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean guardarSolicitud(Amigo amigo) {
		return (boolean) this.sessionFactory.getCurrentSession().save(amigo);
		
	}

	@Override
	public List<Amigo> listarAmigos(long idUser) {
		return (List<Amigo>) this.sessionFactory.getCurrentSession()
				.createCriteria(Amigo.class)
				.createAlias("usuario", "user")
				.add(Restrictions.and(Restrictions.eq("user.id", idUser), Restrictions.eq("confirmado", 1)));
		
	}

	@Override
	public List<Amigo> listarSolicitudes(long idUser) {
		return (List<Amigo>) this.sessionFactory.getCurrentSession()
				.createCriteria(Amigo.class)
				.createAlias("amigo", "user")
				.add(Restrictions.and(Restrictions.eq("user.id", idUser), Restrictions.eq("confirmado", 0)));
	}
}
