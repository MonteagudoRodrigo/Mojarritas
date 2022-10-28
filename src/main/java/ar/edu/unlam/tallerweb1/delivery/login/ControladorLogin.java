package ar.edu.unlam.tallerweb1.delivery.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.login.ServicioLogin;

import javax.servlet.http.HttpServletRequest;






@Controller
public class ControladorLogin {

	private ServicioLogin servicioLogin;
	

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
	}
	

	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();

		modelo.put("datosLogin", new DatosLogin());

		return new ModelAndView("login", modelo);
	}
	

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("datosLogin") DatosLogin datosLogin, HttpServletRequest request) throws Exception {
		
		ModelMap model = new ModelMap();

		if (servicioLogin.Auth(datosLogin.getEmail(), datosLogin.getPassword())) 
			return new ModelAndView("redirect:/home");
		model.put("error", "Usuario o clave incorrecta");
		
		return new ModelAndView("login", model);
	}
	
	
	
	
}
