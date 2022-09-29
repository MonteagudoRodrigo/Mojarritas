package ar.edu.unlam.tallerweb1.delivery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistro;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Controller
public class ControladorRegistro {
	private ServicioRegistro servicioRegistro;

	@Autowired
	public ControladorRegistro(ServicioRegistro servicioRegistro) {
		this.servicioRegistro = servicioRegistro;
	}
	
	@RequestMapping(path = "/registro", method = RequestMethod.GET)
	public ModelAndView irARegistro() {
		ModelMap modelo = new ModelMap();
		modelo.put("datosRegistro", new DatosRegistro());
		return new ModelAndView("registro", modelo);
	}
	
	@RequestMapping(path = "/validar-registro", method = RequestMethod.POST)
	public ModelAndView validarRegistro(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		this.servicioRegistro.registrarUsuario(datosRegistro.getEmail(), datosRegistro.getPassword(),datosRegistro.getNombre(),datosRegistro.getApellido(),datosRegistro.getUsername());
		
		return new ModelAndView("registro", model);
		
	}
}
