package ar.edu.unlam.tallerweb1.domain.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletRequestAttributes;

import ar.edu.unlam.tallerweb1.domain.usuarios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("servicioLogin")
@Transactional
public class ServicioLoginImpl implements ServicioLogin {

	private RepositorioUsuario repositorioUsuario;

	@Autowired
	public ServicioLoginImpl(RepositorioUsuario repositorioUsuario){
		this.repositorioUsuario = repositorioUsuario;
	}

	@Override
	public boolean Auth(String email, String password) {
		
		Usuario user = repositorioUsuario.buscarUsuario(email, password);
		
		if( user != null ) {
			//se agrega el usuario a la session
			this.setToSession(user);
			
			return true;
		}
		
		
		return false;
	}
	
	private void setToSession(Usuario user) {
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		
		HttpSession session = attr.getRequest().getSession(true);
	
		session.setAttribute("user-session", user);
	}
	
	
}
