package ar.edu.unlam.tallerweb1.domain.publicaciones;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

@Entity
public class Publicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne (optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Usuario usuario;
	
	private Long lugarId;
	private String titulo;
	private String fecha;
	private String descripcion;
	private Integer cantParticipantes;
	private Integer cupo;
	
	public Long getId() {
		return id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLugarId() {
		return lugarId;
	}
	public void setLugarId(Long lugarId) {
		this.lugarId = lugarId;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCantParticipantes() {
		return cantParticipantes;
	}
	public void setCantParticipantes(Integer cantParticipantes) {
		this.cantParticipantes = cantParticipantes;
	}
	public Integer getCupo() {
		return cupo;
	}
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}
	
}
