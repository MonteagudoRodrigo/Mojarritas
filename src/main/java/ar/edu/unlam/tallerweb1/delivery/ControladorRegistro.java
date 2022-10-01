package ar.edu.unlam.tallerweb1.delivery;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(path = "/validar-registro", method = RequestMethod.POST)
	public ModelAndView validarRegistro(@ModelAttribute("datosRegistro") DatosRegistro datosRegistro, HttpServletRequest request, 
										@RequestParam("archivoImagen") MultipartFile multipart ) {
		
		ModelMap model = new ModelMap();
		
		Usuario usuario = new Usuario();
		usuario.setNombre(datosRegistro.getNombre());
		usuario.setApellido(datosRegistro.getApellido());
		usuario.setUsername(datosRegistro.getUsername());
		usuario.setEmail(datosRegistro.getEmail());
		

		
		//validamos la subida de archivo
		if(!multipart.isEmpty()) {
			Path directorioImagen = Paths.get("//src//main//webapp/profiles");
	        String ruta = directorioImagen.toFile().getAbsolutePath();
			
	     
			System.out.println(ruta);
			
			
			String nombreImagen = Archivos.guardarArchivo(multipart, ruta);
			
			usuario.setImagen(nombreImagen);
		}else {
			usuario.setImagen("default.png");
		}
		
		
		
		this.servicioRegistro.registrarUsuario(usuario);
		
		return new ModelAndView("registro", model);
		
	}
}
