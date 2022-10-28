package ar.edu.unlam.tallerweb1.delivery.amigos;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@ResponseBody
	@RequestMapping("/amigos/solicitud")
	public boolean enviarSolicitud(@RequestParam long idUserTo, long idUserFrom ) {
		
		 
		//seteamos el id al usuario que será amigo
		Usuario user_to = new Usuario();
		user_to.setId(idUserTo);
		
		Usuario user_from = new Usuario();
		user_from.setId(idUserFrom);
		
		this.servicioAmigo.enviarSolicitud(user_from, user_to);
		
		return true;
		
	}
	
	@RequestMapping("/amigos")
	public ModelAndView listarAmigos(HttpSession session) {
		Usuario userAuthorized = (Usuario) session.getAttribute("user-session");
		
		if(userAuthorized != null) {
		
			ModelMap model = new ModelMap();
			
			List<Amigo> amigos = this.servicioAmigo.listarAmigos(userAuthorized);
			
			model.put("amigos", amigos);
			model.put("user", userAuthorized);
			
			return new ModelAndView("/mis-amigos", model);
		}
		
		return new ModelAndView("redirect:/login");
	}
	
	


}
