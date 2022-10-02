package ar.edu.unlam.tallerweb1.domain.publicaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioPublicacion")
@Transactional
public class ServicioPublicacionImpl implements ServicioPublicacion{

	private RepositorioPublicacion servicioPublicacionDao;
	
	@Autowired
	public ServicioPublicacionImpl(RepositorioPublicacion servicioPublicacionDao) {
		this.servicioPublicacionDao = servicioPublicacionDao;
	}

	@Override
	public Publicacion consultarPublicacion(Long id) {
		return servicioPublicacionDao.buscarPublicacion(id);
	}

}
