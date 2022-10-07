package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unlam.tallerweb1.config.AppConfig;
import ar.edu.unlam.tallerweb1.delivery.DatosRegistro;
import ar.edu.unlam.tallerweb1.utils.Archivos;

@Service("servicioRegistro")
@Transactional
public class ServicioRegistroImpl implements ServicioRegistro{

	private RepositorioUsuario servicioRegistroDao;
	
	
	@Autowired
	public ServicioRegistroImpl(RepositorioUsuario servicioRegistroDao){
		this.servicioRegistroDao = servicioRegistroDao;
		
	}
	
	@Override
	public void registrarUsuario(DatosRegistro datos) {
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre(datos.getNombre());
		usuario.setApellido(datos.getApellido());
		usuario.setUsername(datos.getUsername());
		usuario.setEmail(datos.getEmail());
		usuario.setSexo(Integer.parseInt(datos.getSexo()));
		usuario.setNacimiento(this.formatearFecha(datos.getNacimiento()));
		usuario.setPassword(datos.getPassword());
		usuario.setImagen(Archivos.guardarArchivo(datos.getImagen(),  AppConfig.getUploadDir()));
		
		this.servicioRegistroDao.registrarUsuario(usuario);
	}
	
	
	private java.sql.Date formatearFecha(String fecha) {

	  	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date parsed = null;
        
        try {
			parsed = format.parse(fecha);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return new java.sql.Date(parsed.getTime());
	}
	
	@Override
	public long existeEmail(String email) {
		return servicioRegistroDao.buscar(email);
	}
	
	@Override
	public long existeUsuario(String username) {
		return servicioRegistroDao.buscarUsuario(username);
	}
	
	
}