package ar.edu.unlam.tallerweb1.delivery.amigos;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.amigos.Amigo;
import ar.edu.unlam.tallerweb1.domain.amigos.ServicioAmigo;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Controller
public class ControladorAmigo {
	
	private ServicioAmigo servicioAmigo;
	
	@Autowired
	public ControladorAmigo(ServicioAmigo servicioAmigo) {
		this.servicioAmigo = servicioAmigo;
	}
	
	@RequestMapping("/amigos/solicitud")
	public void enviarSolicitud(@RequestParam long idUserTo, HttpSession session) {
		 
		//seteamos el id al usuario que será amigo
		Usuario user_to = new Usuario();
		user_to.setId(idUserTo);
		
		boolean response = this.servicioAmigo.enviarSolicitud((Usuario) session.getAttribute("user-session"), user_to);
		
	}
	
	@RequestMapping("/amigos")
	public ModelAndView listarAmigos(HttpSession session) {
		ModelMap model = new ModelMap();
		
		List<Amigo> amigos = this.servicioAmigo.listarAmigos((Usuario) session.getAttribute("user-session"));
		
		model.put("amigos", amigos);
		
		return new ModelAndView("/mis-amigos", model);
	}

}
