package ar.edu.unlam.tallerweb1.domain.usuarios;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.NestedServletException;

@Service("servicioRegistro")
@Transactional
public class ServicioRegistroImpl implements ServicioRegistro {

	private RepositorioUsuario servicioRegistroDao;
	
	@Autowired
	public ServicioRegistroImpl(RepositorioUsuario servicioRegistroDao){
		this.servicioRegistroDao = servicioRegistroDao;
	}
	
	@Override
	public Long registrarUsuario(Usuario usuario){
		try {
			return (Long) this.servicioRegistroDao.registrarUsuario(usuario);
		}catch(ConstraintViolationException e) {
			System.out.println(e.getMessage());
			return (long) -1;
		}
		
	}
}