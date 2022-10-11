package ar.edu.unlam.tallerweb1.delivery;

	import org.springframework.ui.ModelMap;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;

	
public class ControladorBusquedaPublicacion {

		@RequestMapping("/busquedaPublicaciones")
		public ModelAndView busquedaEventos() {
			ModelMap model = new ModelMap();
			model.put("buscadorPublicaciones", new DatosPublicacion());
			return new ModelAndView ("buscadorPublicaciones", model);
			
		}
		
		
		
	}
