package ar.edu.unlam.tallerweb1.delivery;


import org.springframework.web.multipart.MultipartFile;

public class DatosRegistro {
	private String email;
    private String password;
    private String nombre;
    private String apellido;
    private String username;
    private String sexo;
    private String nacimiento;
    private MultipartFile imagen;
    private state userVerify = state.UNVERIFY;
    private state emailVerify = state.UNVERIFY;
  
    public enum state{
    	UNVERIFY,
    	VERIFY_OK,
    	VERIFY_NO
    }
    
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}
	public state getUserVerify() {
		return userVerify;
	}
	public void setUserVerify(state userVerify) {
		this.userVerify = userVerify;
	}
	public state getEmailVerify() {
		return emailVerify;
	}
	public void setEmailVerify(state emailVerify) {
		this.emailVerify = emailVerify;
	}

    
    
}
