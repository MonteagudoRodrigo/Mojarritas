package ar.edu.unlam.tallerweb1.delivery;

import org.hibernate.type.DateType;
import org.springframework.web.multipart.MultipartFile;

public class DatosRegistro {
	private String email;
    private String password;
    private String nombre;
    private String apellido;
    private String username;
    private int sexo;
    private DateType nacimiento;
    private MultipartFile imagen;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MultipartFile getImagen() {
		return imagen;
	}
	public void setImagen(MultipartFile imagen) {
		this.imagen = imagen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public DateType getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(DateType nacimiento) {
		this.nacimiento = nacimiento;
	}
    
    
}
