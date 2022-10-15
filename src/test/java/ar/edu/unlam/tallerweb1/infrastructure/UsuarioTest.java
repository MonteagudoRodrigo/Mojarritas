package ar.edu.unlam.tallerweb1.infrastructure;
import org.hibernate.SessionFactory;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public class UsuarioTest extends SpringTest {

	@Test
	@Transactional @Rollback
	public void pruebaConexion(){
	    assertThat(session().isConnected()).isTrue();
	}
	
@Test
@Transactional @Rollback
public void queSepuedaGuardarUnUsuario() {
	
	Usuario usuario1 = new Usuario();
	
	String email = "prueba@prueba";
	
	usuario1.setEmail(email);
	
	session().save(usuario1);
	

	
	RepositorioUsuarioImpl nuevoRepo= new RepositorioUsuarioImpl(this.session().getSessionFactory());
	assertTrue(nuevoRepo.buscar(email).getEmail().equals(email));
	
}


}
