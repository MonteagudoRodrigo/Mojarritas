package ar.edu.unlam.tallerweb1.infrastructure;

import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacionImpl;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public class PublicacionTest extends SpringTest{
	
	@Test
	@Transactional @Rollback
	public void queSeCreeUnaPublicacion() {
		Usuario usuario = new Usuario();
		usuario.setEmail("soyunmaildeprueba@test");
		usuario.setNombre("prueba");
		usuario.setApellido("prueba");
		Publicacion publicacion = new Publicacion();
		publicacion.setTitulo("Título de prueba");
		publicacion.setUsuario(usuario);
		
		RepositorioPublicacionImpl repositorio = new RepositorioPublicacionImpl(this.session().getSessionFactory());
		session().save(publicacion);
		
		//assertTrue(repositorio.buscarPor(usuario).contains(publicacion));
	}
}
