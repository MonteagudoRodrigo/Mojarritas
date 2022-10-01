package ar.edu.unlam.tallerweb1.infrastructure;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class ConexionBaseDeDatosTest extends SpringTest{
	
    @Test
    @Transactional @Rollback
    public void pruebaConexion(){
        assertThat(session().isConnected()).isTrue();
    }

    @Test
    @Transactional @Rollback
    public void crearUsuario(){
    	String emailOriginal = "test@test";
    	String passwordOriginal = "1234";
    	String usuarioOriginal = "pepe";
    	String nombreOriginal = "carlos";
    	String apellidoOriginal = "menem";
    	
        Usuario usuario = new Usuario();
        usuario.setEmail(emailOriginal);
        usuario.setPassword(passwordOriginal);
        usuario.setNombre(nombreOriginal);
        usuario.setApellido(apellidoOriginal);
        usuario.setUsername(usuarioOriginal);
        session().save(usuario);
        assertThat(usuario.getId()).isNotNull();
    }
    
    @Test
    @Transactional @Rollback
    public void modificarUsuario(){
    	String emailOriginal = "test@test";
    	String passwordOriginal = "1234";
    	String usuarioOriginal = "pepe";
    	String nombreOriginal = "carlos";
    	String apellidoOriginal = "menem";
    	
    	
    	
    	
        Usuario usuario = new Usuario();
        usuario.setEmail(emailOriginal);
        usuario.setPassword(passwordOriginal);
        usuario.setNombre(nombreOriginal);
        usuario.setApellido(apellidoOriginal);
        usuario.setUsername(usuarioOriginal);
              
        session().save(usuario).toString();
        
        String emailModificado = "anda@anda";
    	String claveModificada = "5678";
    	String usuarioModificado = "jose";
    	String nombreModificado = "chupete";
    	String apellidoModificado = "De la Rua";
      
       
    	RepositorioUsuarioImpl nuevoRepo = new RepositorioUsuarioImpl(this.session().getSessionFactory());
       
       Usuario usuario2 = new Usuario(); 
       usuario2 = nuevoRepo.buscar(usuario.getEmail());
       
       usuario.setNombre("pascual");
       nuevoRepo.modificar(usuario2);
       
       
      
       
        
        
        assertThat(usuario.getId()).isNotNull();
    }
    
    
    
    
}
