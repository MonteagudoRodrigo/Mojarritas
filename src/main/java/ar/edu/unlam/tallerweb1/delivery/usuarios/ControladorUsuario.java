package ar.edu.unlam.tallerweb1.delivery.usuarios;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/usuario/buscar")
	public ModelAndView listarAmigos(@RequestParam String nombre, HttpSession session) {
		Usuario userAuthorized = (Usuario) session.getAttribute("user-session");
		
		if(userAuthorized != null) {
		
			ModelMap model = new ModelMap();
			
			List<Usuario> usuarios = this.servicioUsuario.listarTodos(nombre);
			
			model.put("usuarios", usuarios);
			model.put("user", userAuthorized);
			model.put("res", false);
			
			return new ModelAndView("/buscar-usuarios", model);
		}
		
		return new ModelAndView("redirect:/login");
	}
	

}
