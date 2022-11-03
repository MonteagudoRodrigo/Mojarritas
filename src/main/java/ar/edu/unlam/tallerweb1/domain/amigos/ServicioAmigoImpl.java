package ar.edu.unlam.tallerweb1.domain.amigos;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Service("ServicioAmigo")
@Transactional
public class ServicioAmigoImpl implements ServicioAmigo {
	
	private RepositorioAmigo repositorioAmigo;
	
	@Autowired
	public ServicioAmigoImpl(RepositorioAmigo repositorioAmigo) {
		this.repositorioAmigo = repositorioAmigo;
	}

	@Override
	public Serializable enviarSolicitud(Usuario userFrom, Usuario userTo) {
		Amigo amigo = new Amigo();
		
		amigo.setUsuarioFrom(userFrom);
		amigo.setUsuarioTo(userTo);
		amigo.setConfirmado(false);
		
		return this.repositorioAmigo.guardarSolicitud(amigo);
	}

	@Override
	public boolean aceptarSolicitud(Amigo amigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Amigo> listarAmigos(Usuario ofUser) {
		return this.repositorioAmigo.listarAmigos(ofUser.getId());
	}

	@Override
	public List<Amigo> listarSolicitudes(Usuario ofUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelarSolicitud(long id) {
		Amigo amigo = new Amigo();
		amigo.setId(id);
		this.repositorioAmigo.eliminarSolicitud(amigo);
		return true;
	}

	

	
	
	

}
