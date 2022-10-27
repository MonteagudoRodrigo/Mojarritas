package ar.edu.unlam.tallerweb1.delivery;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unlam.tallerweb1.domain.usuarios.Amigo;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Controller
public class ControladorUsuario {

	private ServicioUsuario servicioUsuario;
	
	@Autowired
	public ControladorUsuario(ServicioUsuario servicioUsuario) {
		this.servicioUsuario = servicioUsuario;
	}
	
	@RequestMapping("/amigos/enviar-solicitud")
	public void agregarAmigo(@RequestParam long id, HttpSession session) {
		//obtenemos usuario logueado
		 
		//seteamos el id al usuario que será amigo
		Usuario user_friend = new Usuario();
		user_friend.setId(id);
		
		this.servicioUsuario.agregarAmigo((Usuario) session.getAttribute("user-session"), user_friend);
		
	}
}
