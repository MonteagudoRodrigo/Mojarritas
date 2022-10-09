package ar.edu.unlam.tallerweb1.delivery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.domain.usuarios.ServicioLogin;
import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Controller
public class ControladorPublicacion {

	private ServicioPublicacion servicioPublicacion;
	
	@Autowired
	public ControladorPublicacion(ServicioPublicacion servicioPublicacion) {
		this.servicioPublicacion = servicioPublicacion;
	}
	
	@RequestMapping("/publicacion")
	public ModelAndView irAPublicacion(@RequestParam("id")Long id){
		ModelMap modelo = new ModelMap();
		
		Publicacion publicacion = servicioPublicacion.consultarPublicacion(id);
		
		modelo.put("publicacion", publicacion.getTitulo());
		modelo.put("descripcion", publicacion.getDescripcion());
		modelo.put("fecha", publicacion.getFecha());
		modelo.put("cupo", publicacion.getCupo());
		modelo.put("cantParticipantes", publicacion.getCantParticipantes());
		modelo.put("nombreUsuario", publicacion.getUsuario().getNombre());
		modelo.put("apellidoUsuario", publicacion.getUsuario().getApellido());
		modelo.put("userName", publicacion.getUsuario().getUsername());
		
		return new ModelAndView("publicacion", modelo);
	}
	
	@RequestMapping("/nuevaPublicacion")
	public ModelAndView nuevaPublicacion() {
		ModelMap modelo = new ModelMap();
		modelo.put("datosPublicacion", new DatosPublicacion());
		return new ModelAndView("nuevaPublicacion", modelo);
	}
	
	@RequestMapping(path = "/validar-publicacion", method = RequestMethod.POST)
	public ModelAndView validarPublicacion(@ModelAttribute("datosPublicacion") DatosPublicacion datosPublicacion, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		Publicacion publicacion = new Publicacion();
		
		String errores = (datosPublicacion.getTitulo())==""?"<br>TÍTULO":"";
		errores = errores.concat((datosPublicacion.getDescripcion())==""?"<br>DESCRIPCIÓN":""); 
		errores = errores.concat((datosPublicacion.getFecha())==""?"<br>FECHA":"");
		errores = errores.concat((datosPublicacion.getLugar())==""?"<br>LUGAR":"");
		errores = errores.concat((datosPublicacion.getCupo())==null?"<br>CUPO":"");
		
		if(errores!="") {
			ModelMap modelo = new ModelMap();
			modelo.put("error", errores.concat(" incompleto/s."));
			return new ModelAndView("nuevaPublicacion",modelo);
		}
		
		
		publicacion.setTitulo(datosPublicacion.getTitulo());
		publicacion.setDescripcion(datosPublicacion.getDescripcion());
		publicacion.setUsuario((Usuario) session.getAttribute("usuario"));
		publicacion.setLugarId((long) 1);
		//TODO: Por el momento, hasta desarrollar los lugares, indico el lugar con ID = 1
		publicacion.setCupo(datosPublicacion.getCupo());
		publicacion.setCantParticipantes(1);
		publicacion.setFecha(datosPublicacion.getFecha());
		
		servicioPublicacion.crearPublicacion(publicacion);
		
		return new ModelAndView("redirect:/home");
	}
	
}
