package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class ControladorBusquedaEventos {

	@RequestMapping("/busquedaEventos")
	public ModelAndView busquedaEventos() {
		ModelMap model = new ModelMap();
		model.put("buscadorEventos", new DatosEventos());
		return new ModelAndView ("busquedaEventos", model);
		
	}
	
	
}
