package ar.edu.unlam.tallerweb1.delivery.home;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.home.ServicioHome;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Controller
public class ControladorHome {
	
	private ServicioHome servicioHome;
	private ServicioPublicacion servicioPublicacion;
	
	@Autowired
	public ControladorHome(ServicioHome servicioHome, ServicioPublicacion servicioPublicacion) {
		this.servicioHome = servicioHome;
		this.servicioPublicacion = servicioPublicacion;
	}
	
	
	

	

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/home");
	}
	


}
