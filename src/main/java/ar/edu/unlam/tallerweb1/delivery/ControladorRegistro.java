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



@Controller
public class ControladorRegistro{
	private ServicioRegistro servicioRegistro;
	
	@Autowired
	public ControladorRegistro(ServicioRegistro servicioRegistro) {
		this.servicioRegistro = servicioRegistro;
		
		
	}
	
	@RequestMapping(path = "/registro", method = RequestMethod.GET)
	public ModelAndView irARegistro() {
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("upload_folder",AppConfig.getUploadDir());
		modelo.put("datosRegistro", new DatosRegistro());
		
		//pasamos las configuraciones de verificacion inicial
		//para usuario y email
		modelo.put("verify_u_attr", "hidden");
		modelo.put("verify_e_attr", "hidden");
		//config inicial de errores
		modelo.put("error_state", "hidden");
		
		return new ModelAndView("registro", modelo);
	}
	
	@RequestMapping(path="/validar-usuario")
	public ModelAndView validarUsuario(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		System.out.println(datosRegistro.toString());
		//validamos que no exista el nombre de usuario
				long res = servicioRegistro.existeUsuario(datosRegistro.getUsername());
				System.out.println(res);
				if(res > 0) {
					model.put("user_v_state", "no");
					
					model.put("user_v_icon", "x");
					
				}else {
					model.put("user_v_state", "ok");
					model.put("user_v_icon", "check");
				}
				
				return new ModelAndView("registro", model);
				
				
	}
	
	@RequestMapping(path="/validar-email")
	public ModelAndView validarEmail(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		//validamos que no exista el email
				long res = servicioRegistro.existeEmail(datosRegistro.getEmail());
				if(res> 0) {
					model.put("email_v_state", "no");
					model.put("email_v_icon", "x");
					
				}else {
					model.put("email_v_state", "ok");
					model.put("email_v_icon", "check");
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
