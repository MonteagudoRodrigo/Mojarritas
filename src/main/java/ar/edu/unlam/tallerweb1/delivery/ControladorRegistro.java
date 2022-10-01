package ar.edu.unlam.tallerweb1.delivery;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioRegistro;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;
import ar.edu.unlam.tallerweb1.utils.Archivos;

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
	
	@RequestMapping(path="/validar-usuario")
	public ModelAndView validarUsuario(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		//validamos que no se repita el email
				Usuario usuario = servicioRegistro.existeUsuario(datosRegistro.getUsername());
				if(usuario == null) {
					model.put("user_ok", "El nombre de usuario está disponible");
				}else {
					model.put("user_found", "El nombre de usuario ya está en uso");
				}
				
				return new ModelAndView("registro", model);
				
				
	}
	
	@RequestMapping(path = "/validar-registro", method = RequestMethod.POST)
	public ModelAndView validarRegistro(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request ) {
		
		ModelMap model = new ModelMap();
		
		//validamos que no se repita el email
		Usuario usuario = servicioRegistro.existeEmail(datosRegistro.getEmail());
		
		if(usuario != null) {
			model.put("error", "Ya existe un perfil registrado con ese email");
			return new ModelAndView("registro", model);
		}
		
		usuario = servicioRegistro.existeUsuario(datosRegistro.getUsername());
		
		if(usuario != null) {
			model.put("error", "El nombre se usuario no se encuentra disponible, verifiquelo antes de enviar");
			return new ModelAndView("registro", model);
		}
		
		return registrarUsuario(datosRegistro);
		
		
	}
	
	private ModelAndView registrarUsuario(DatosRegistro datosRegistro) {
		
		ModelMap model = new ModelMap();
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre(datosRegistro.getNombre());
		usuario.setApellido(datosRegistro.getApellido());
		usuario.setUsername(datosRegistro.getUsername());
		usuario.setEmail(datosRegistro.getEmail());
		usuario.setPassword(datosRegistro.getPassword());
		
		MultipartFile multipart = datosRegistro.getImagen();
		
		
		
		//validamos la subida de archivo
		if(!multipart.isEmpty()) {
			Path directorioImagen = Paths.get("D:\\FACULTAD\\TALLER WEB\\PROYECTOS\\Mojarritas\\src\\main\\webapp\\profiles");
	        String ruta = directorioImagen.toFile().getAbsolutePath();
			
	     
			System.out.println(ruta);
			
			
			String nombreImagen = Archivos.guardarArchivo(multipart, ruta);
			
			usuario.setImagen(nombreImagen);
		}else {
			usuario.setImagen("default.png");
		}
		
		
		
		this.servicioRegistro.registrarUsuario(usuario);
		
		model.put("msg", "Tu registro se realizó con éxito");
		
		return new ModelAndView("registro", model);
		
	}
}
