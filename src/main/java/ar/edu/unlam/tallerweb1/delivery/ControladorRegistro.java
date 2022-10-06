package ar.edu.unlam.tallerweb1.delivery;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.config.AppConfig;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistro;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;


@Controller
public class ControladorRegistro{
	private ServicioRegistro servicioRegistro;
	private AppConfig cfg;

	@Autowired
	public ControladorRegistro(ServicioRegistro servicioRegistro) {
		this.servicioRegistro = servicioRegistro;
		
	}
	
	@RequestMapping(path = "/registro", method = RequestMethod.GET)
	public ModelAndView irARegistro() {
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("upload_folder",cfg.getUploadDir());
		modelo.put("datosRegistro", new DatosRegistro());
		modelo.put("reg_ok", "");
		modelo.put("register", true);
		return new ModelAndView("registro", modelo);
	}
	
	@RequestMapping(path="/validar-usuario")
	public ModelAndView validarUsuario(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		//validamos que no exista el nombre de usuario
				Usuario usuario = servicioRegistro.existeUsuario(datosRegistro.getUsername());
				if(usuario == null) {
					model.put("user_ok", true);
				}else {
					model.put("user_ok", false);
				}
				
				return new ModelAndView("registro", model);
				
				
	}
	
	@RequestMapping(path="/validar-email")
	public ModelAndView validarEmail(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		//validamos que no exista el email
				Usuario usuario = servicioRegistro.existeEmail(datosRegistro.getEmail());
				if(usuario == null) {
					model.put("email_ok", true);
				}else {
					model.put("email_ok", false);
				}
				
				return new ModelAndView("registro", model);
				
				
	}
	
	@RequestMapping(path = "/validar-registro", method = RequestMethod.POST)
	public ModelAndView validarRegistro(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request ) {
		
		ModelMap model = new ModelMap();
		
		this.servicioRegistro.registrarUsuario(datosRegistro);
		
		//pasamos datos del usuario registrado para mostrar por pantalla
		model.put("nombre", datosRegistro.getNombre());
		model.put("apellido", datosRegistro.getApellido());
		//informamos que se guardo correctamente
		model.put("reg_ok", "ok");
		
		return new ModelAndView("registro", model);
		
		
	}
	

}
