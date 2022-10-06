package ar.edu.unlam.tallerweb1.delivery;

public class AccountVerify {
	private String usuario;
	private String mail;
	
	public enum result{
		CHECK_OK,
		CHECK_NO
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	

}
