package ar.edu.unlam.tallerweb1.domain.publicaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioPublicacion")
@Transactional
public class ServicioPublicacionImpl implements ServicioPublicacion{

	private RepositorioPublicacion repositorioPublicacion;
	
	@Autowired
	public ServicioPublicacionImpl(RepositorioPublicacion repositorioPublicacion) {
		this.repositorioPublicacion = repositorioPublicacion;
	}

	@Override
	public Publicacion consultarPublicacion(Long id) {
		return repositorioPublicacion.buscarPublicacion(id);
	}

	@Override
	public void crearPublicacion(Publicacion publicacion) {
		this.repositorioPublicacion.crearPublicacion(publicacion);
	}
	
	@Override
	public List<Publicacion> searchForAll(String value) {
		return this.repositorioPublicacion.searchForAll(value);

	}
	
	@Override
	public List<Publicacion> globalList() {
		return this.repositorioPublicacion.globalList();

	}
	
	@Override
	public List<Publicacion> ListPubicacionUser(Long id) {
		return this.repositorioPublicacion.ListPubicacionUser(id);

	}
}
