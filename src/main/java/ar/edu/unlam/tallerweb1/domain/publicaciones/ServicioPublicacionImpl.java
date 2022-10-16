package ar.edu.unlam.tallerweb1.domain.publicaciones;

import java.util.List;

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

	@Override
	public void crearPublicacion(Publicacion publicacion) {
		this.servicioPublicacionDao.crearPublicacion(publicacion);
	}
	
	@Override
	public List<Publicacion> buscarPor(String titulo) {
		return this.servicioPublicacionDao.buscarPor(titulo);

	}
}
