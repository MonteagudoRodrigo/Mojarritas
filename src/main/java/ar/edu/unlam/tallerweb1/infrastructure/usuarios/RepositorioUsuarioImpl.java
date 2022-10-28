package ar.edu.unlam.tallerweb1.infrastructure.usuarios;

import ar.edu.unlam.tallerweb1.domain.usuarios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("repositorioUsuario")
public class RepositorioUsuarioImpl implements RepositorioUsuario {

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioUsuarioImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Usuario buscarUsuario(String email, String password) {

		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("pass", password))
				.uniqueResult();
	}

	@Override
	public void guardar(Usuario usuario) {
		Serializable res = sessionFactory.getCurrentSession().save(usuario);
		System.out.println(res.toString());
	}

	@Override
	public long buscar(String email) {
		final Session session = sessionFactory.getCurrentSession();
		return (long) session.createCriteria(Usuario.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.eq("email", email))
				.uniqueResult();			
	}

	@Override
	public void modificar(Usuario usuario) {
		sessionFactory.getCurrentSession().update(usuario);
	}

	@Override
	public void registrarUsuario(Usuario usuario) {
		this.guardar(usuario);
	}
	
	@Override
	public long buscarUsuario(String username) {
		return (long) sessionFactory.getCurrentSession().createCriteria(Usuario.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.eq("username", username))
				.uniqueResult();
	}


	

	@Override
	public List<Usuario> listarTodos(String nombre) {
		return (List <Usuario>)this.sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.or(Restrictions.like("nombre", "%"+nombre+"%"),Restrictions.like("apellido", "%"+nombre+"%")
						,Restrictions.like("username", "%"+nombre+"%")))
				.list();
	}
		
}
