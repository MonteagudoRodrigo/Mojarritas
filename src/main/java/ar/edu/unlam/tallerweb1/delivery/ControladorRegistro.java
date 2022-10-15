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
		
		modelo.put("user_v_state", DatosRegistro.state.UNVERIFY);
		modelo.put("email_v_state", "");
		
		//config inicial de errores
		modelo.put("error_state", "hidden");
		
		return new ModelAndView("registro", modelo);
	}
	
	@RequestMapping(path="/validar-usuario" , method = RequestMethod.POST)
	public ModelAndView validarUsuario(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		//validamos que no exista el nombre de usuario
				
				if(servicioRegistro.existeUsuario(datosRegistro.getUsername()) > 0) 
					datosRegistro.setUserVerify(DatosRegistro.state.VERIFY_NO);
				else 
					datosRegistro.setUserVerify(DatosRegistro.state.VERIFY_OK);
					
				
				modelo.put("user_v_state", datosRegistro.getUserVerify());
				modelo.put("email_v_state", datosRegistro.getEmailVerify());
				modelo.put("error_state", "hidden");
				
				return new ModelAndView("registro", modelo);
				
				
	}
	
	@RequestMapping(path="/validar-email" , method = RequestMethod.POST)
	public ModelAndView validarEmail(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		//validamos que no exista el email
				
				if(servicioRegistro.existeEmail(datosRegistro.getEmail()) > 0) 
					datosRegistro.setEmailVerify(DatosRegistro.state.VERIFY_NO);
				else 
					datosRegistro.setEmailVerify(DatosRegistro.state.VERIFY_OK);
						
					
				modelo.put("email_v_state", datosRegistro.getEmailVerify());
				modelo.put("user_v_state", datosRegistro.getUserVerify());
				modelo.put("error_state", "hidden");
				
				return new ModelAndView("registro", modelo);
				
	}
	
	@RequestMapping(path = "/validar-registro", method = RequestMethod.POST)
	public ModelAndView validarRegistro(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request ) {
		
		ModelMap model = new ModelMap();
		
		this.servicioRegistro.registrarUsuario(datosRegistro);
		
		//pasamos datos del usuario registrado para mostrar por pantalla
		model.put("nombre", datosRegistro.getNombre());
		model.put("apellido", datosRegistro.getApellido());
		//informamos que se guardo correctamente
		model.put("register", "hidden");
		model.put("reg_ok", "ok");
		
		return new ModelAndView("registro", model);
		
		
	}
	

}
