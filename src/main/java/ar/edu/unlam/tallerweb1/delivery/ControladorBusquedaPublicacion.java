package ar.edu.unlam.tallerweb1.delivery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacion;

@Controller	
public class ControladorBusquedaPublicacion {
	
	private ServicioPublicacion servicioPublicacion;
	
	@Autowired
	public ControladorBusquedaPublicacion(ServicioPublicacion servicioPublicacion) {
		this.servicioPublicacion = servicioPublicacion;
	}
		
	
	@RequestMapping("/buscarPublicacion")
		public ModelAndView busquedaPublicacionesGet() {
			ModelMap model = new ModelMap();
			model.put("buscarPublicacion", new DatosPublicacion());
			 return new ModelAndView("buscarPublicacion", model);
			
		}
		
		@RequestMapping(path= "/buscarPublicacion", method = RequestMethod.POST)
		public ModelAndView busquedaPublicacionesPost(@ModelAttribute ("buscarPublicacion") DatosPublicacion datosPublicacion, HttpServletRequest request) {
			ModelMap model = new ModelMap();
			
			List<Publicacion> publicacion= servicioPublicacion.buscarPor(datosPublicacion.getTitulo());
			
			model.put("publicaciones", publicacion);
			 return new ModelAndView("buscarPublicacion", model);
			
		}
		
	}

