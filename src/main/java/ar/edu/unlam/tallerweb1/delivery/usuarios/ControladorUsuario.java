package ar.edu.unlam.tallerweb1.delivery.usuarios;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unlam.tallerweb1.domain.amigos.Amigo;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Controller
public class ControladorUsuario {

	private ServicioUsuario servicioUsuario;
	
	@Autowired
	public ControladorUsuario(ServicioUsuario servicioUsuario) {
		this.servicioUsuario = servicioUsuario;
	}
	

}
