package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.domain.publicaciones.Publicacion;
import ar.edu.unlam.tallerweb1.domain.publicaciones.ServicioPublicacion;

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
		
		return new ModelAndView("publicacion", modelo);
	}
}
