package ar.edu.unlam.tallerweb1.domain.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioRegistro")
@Transactional
public class ServicioRegistroImpl implements ServicioRegistro{

	private RepositorioUsuario servicioRegistroDao;
	
	@Autowired
	public ServicioRegistroImpl(RepositorioUsuario servicioRegistroDao){
		this.servicioRegistroDao = servicioRegistroDao;
	}
	
	@Override
	public void registrarUsuario(Usuario usuario) {
		this.servicioRegistroDao.guardar(usuario);
	}
}