package ar.edu.unlam.tallerweb1.delivery;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.domain.Security.*;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ControladorLogin {

	private ServicioLogin servicioLogin;
	private ServicioSecurity servicioSecurity;
	
	private String userToken;

	@Autowired
	public ControladorLogin(ServicioLogin servicioLogin){
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

		Usuario usuarioBuscado = servicioLogin.consultarUsuario(datosLogin.getEmail(), datosLogin.getPassword());
		
		if (usuarioBuscado != null) {
			
			servicioSecurity = new ServicioSecurity();
			
			this.userToken = servicioSecurity.generarToken(usuarioBuscado);
			
			usuarioBuscado.setToken(this.userToken);
			
			servicioLogin.actualizarUsuario(usuarioBuscado);
			
			return new ModelAndView("redirect:/home");
			
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("login", model);
	}
	
	

	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView irAHome() throws Exception {
		
		
		if( this.userToken == null || !servicioSecurity.ValidaToken(this.userToken)) {
			return new ModelAndView("redirect:/login");
		}
	
		return new ModelAndView("home");
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/login");
	}
	
	
}
