package ar.edu.unlam.tallerweb1.domain.amigos;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;


@Entity
public class Amigo {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne 
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	@ManyToOne 
	@JoinColumn(name = "amigo_id")
	private Usuario amigo;
	
	
	private boolean confirmado;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuarioFrom() {
		return usuario;
	}

	public void setUsuarioFrom(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioTo() {
		return amigo;
	}

	public void setUsuarioTo(Usuario amigo) {
		this.amigo = amigo;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	
	public boolean getConfirmado() {
		return this.confirmado;
	}


	
	
	
}
