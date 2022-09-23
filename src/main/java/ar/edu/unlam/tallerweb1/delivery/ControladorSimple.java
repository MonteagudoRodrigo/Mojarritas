package ar.edu.unlam.tallerweb1.delivery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorSimple {
	
	@RequestMapping(path = "/nuevaPagina" , method = RequestMethod.GET)
ModelAndView irPagina() {
	return new ModelAndView("pagina");
};
	
	
	
}
