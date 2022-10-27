package ar.edu.unlam.tallerweb1.domain.usuarios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.domain.amigos.Amigo;

@Service("ServicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	private RepositorioUsuario repositorioUsuario;

	@Autowired
	public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}
	
	@Override
	public void agregarAmigo(Usuario usuario, Usuario amigo_usr) {
		Amigo amigo = new Amigo();
		amigo.setUsuario(usuario);
		amigo.setAmigo(amigo_usr);
		
		this.repositorioUsuario.agregarAmigo(amigo);
	}
	
	
	
	
}
