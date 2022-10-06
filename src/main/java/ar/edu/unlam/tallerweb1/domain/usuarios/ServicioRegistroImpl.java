package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		try {
			usuario.setNacimiento(new SimpleDateFormat("yyyy-mm-dd").parse(datos.getNacimiento()));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		usuario.setPassword(datos.getPassword());
		
		usuario.setImagen(Archivos.guardarArchivo(datos.getImagen(),  AppConfig.getUploadDir()));
		
		this.servicioRegistroDao.registrarUsuario(usuario);
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