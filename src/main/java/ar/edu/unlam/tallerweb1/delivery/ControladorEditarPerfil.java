package ar.edu.unlam.tallerweb1.delivery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorEditarPerfil {

	@RequestMapping(path = "/editar-perfil", method = RequestMethod.POST)
	public ModelAndView editarPerfilPost(@ModelAttribute ("datosPerfil") DatosPerfil datosPerfil, HttpServletRequest request) {
		ModelMap model= new ModelMap();
		model.put("datosPerfil", new DatosPerfil());
		return new ModelAndView("actualizado", model);
	}
	
	@RequestMapping(path = "/editar-perfil", method = RequestMethod.GET)
	public ModelAndView editarPerfilGet() {
		ModelMap model = new ModelMap();
		model.put("datosPerfil", new DatosPerfil());
		return new ModelAndView ("editarPerfil", model);
	}
	
	
}
