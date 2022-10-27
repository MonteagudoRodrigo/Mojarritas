package ar.edu.unlam.tallerweb1.domain.usuarios;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Amigo {
	
	@EmbeddedId
	AmigosClave id;
	
	
	@ManyToOne 
	@MapsId ("userId")
	@JoinColumn( name= "usuario_id")
	private Usuario usuario;
	
	
	@ManyToOne 
	@MapsId ("friendsId")
	@JoinColumn( name= "amigo_id")
	private Usuario amigo;
	
	
	private boolean confirmado;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getAmigo() {
		return amigo;
	}

	public void setAmigo(Usuario amigo) {
		this.amigo = amigo;
	}


	
	
	
}
