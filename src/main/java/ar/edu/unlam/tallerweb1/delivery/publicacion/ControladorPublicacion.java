package ar.edu.unlam.tallerweb1.delivery.publicacion;

import java.util.List;

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
		
		if(publicacion==null) {
			modelo.put("msg", "No se ha encontrado la publicación buscada. Por favor, vuelva al inicio.");
			return new ModelAndView("error",modelo);
		}
		
		modelo.put("publicacion", publicacion);
		
		
		return new ModelAndView("publicacion", modelo);
	}
	
	
	@RequestMapping("/publicacion/create")
	public ModelAndView nuevaPublicacion() {
		ModelMap modelo = new ModelMap();
		modelo.put("datosPublicacion", new Publicacion());
		return new ModelAndView("crearPublicacion", modelo);
	}
	
	
	@RequestMapping(path = "/publicacion/validar-publicacion", method = RequestMethod.POST)
	public ModelAndView validarPublicacion(@ModelAttribute("datosPublicacion") Publicacion datosPublicacion, HttpServletRequest request, HttpSession session) {
		
		
		Publicacion publicacion = new Publicacion();
		
		
		
		publicacion.setTitulo(datosPublicacion.getTitulo());
		publicacion.setDescripcion(datosPublicacion.getDescripcion());
		publicacion.setUsuario((Usuario) session.getAttribute("user-session"));
		publicacion.setLugarId((long) 1);
		publicacion.setCupo(datosPublicacion.getCupo());
		publicacion.setCantParticipantes(0);
		publicacion.setFecha(datosPublicacion.getFecha());
		
		servicioPublicacion.crearPublicacion(publicacion);
		
		return new ModelAndView("redirect:/publicacion/admin");
	}
	


	
	@RequestMapping(path= "/search", method = RequestMethod.GET)
	public ModelAndView l(@RequestParam String value, HttpSession session) {
		
Usuario userAuthorized = (Usuario) session.getAttribute("user-session");
		
		if(userAuthorized != null) {
			
			ModelMap model = new ModelMap();
			
			List<Publicacion> publicaciones = servicioPublicacion.searchForAll(value);
			
			model.put("publicaciones", publicaciones);
			model.put("user", userAuthorized);
		
		return new ModelAndView("/home", model);
		}
		
		return new ModelAndView("redirect:/login");
		
		
	}
	
	@RequestMapping("/home")
	public ModelAndView goToHome(HttpSession session){
		
		Usuario userAuthorized = (Usuario) session.getAttribute("user-session");
		
		if(userAuthorized != null) {
			
			//Listamos publicaciones
			List<Publicacion> publicaiones = servicioPublicacion.globalList();
			
			ModelMap model = new ModelMap();
			model.put("publicaciones", publicaiones);
			model.put("user", userAuthorized);
			return new ModelAndView("home", model);
		}
		
		return new ModelAndView("redirect:/login");
		
		
	}
	
	@RequestMapping("/publicacion/admin")
	public ModelAndView administrarPublicaciones(HttpSession session){
		
		Usuario userAuthorized = (Usuario) session.getAttribute("user-session");
		
		if(userAuthorized != null) {
			
			//Listamos publicaciones
			List<Publicacion> publicaiones = servicioPublicacion.ListPubicacionUser(userAuthorized.getId());
			
			ModelMap model = new ModelMap();
			model.put("publicaciones", publicaiones);
			model.put("user", userAuthorized);
			return new ModelAndView("mis-publicaciones", model);
		}
		
		return new ModelAndView("redirect:/login");
		
		
	}
	
	
	
	
}
