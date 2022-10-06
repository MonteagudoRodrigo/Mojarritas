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
	private ModelMap modelo;
	
	@Autowired
	public ControladorRegistro(ServicioRegistro servicioRegistro) {
		this.servicioRegistro = servicioRegistro;
		this.modelo = new ModelMap();
		
	}
	
	@RequestMapping(path = "/registro", method = RequestMethod.GET)
	public ModelAndView irARegistro() {
		
		
		
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
		
		System.out.println(datosRegistro.toString());
		//validamos que no exista el nombre de usuario
				long res = servicioRegistro.existeUsuario(datosRegistro.getUsername());
				System.out.println(res);
				if(res > 0) {
					modelo.put("user_v_state", "no");
					
					modelo.put("user_v_icon", "x");
					
				}else {
					modelo.put("user_v_state", "ok");
					modelo.put("user_v_icon", "check");
				}
				
				return new ModelAndView("registro", modelo);
				
				
	}
	
	@RequestMapping(path="/validar-email")
	public ModelAndView validarEmail(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request) {
		
		
		//validamos que no exista el email
				long res = servicioRegistro.existeEmail(datosRegistro.getEmail());
				if(res> 0) {
					modelo.put("email_v_state", "no");
					modelo.put("email_v_icon", "x");
					
				}else {
					modelo.put("email_v_state", "ok");
					modelo.put("email_v_icon", "check");
				}
				
				return new ModelAndView("registro", modelo);
				
				
	}
	
	@RequestMapping(path = "/validar-registro", method = RequestMethod.POST)
	public ModelAndView validarRegistro(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request ) {
		
		
		
		this.servicioRegistro.registrarUsuario(datosRegistro);
		
		//pasamos datos del usuario registrado para mostrar por pantalla
		modelo.put("nombre", datosRegistro.getNombre());
		modelo.put("apellido", datosRegistro.getApellido());
		//informamos que se guardo correctamente
		modelo.put("reg_ok", "ok");
		
		return new ModelAndView("registro", modelo);
		
		
	}
	

}
