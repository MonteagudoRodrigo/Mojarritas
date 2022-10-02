package ar.edu.unlam.tallerweb1.delivery;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ar.edu.unlam.tallerweb1.domain.usuarios.Usuario;

public class DatosPublicacion {
	private Usuario usuario;
	private String lugar;
	private String titulo;
	private Date fecha;
	private String descripcion;
	private Integer cantParticipantes;
	private Integer cupo;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(String fecha,String hora) {
		Calendar calendario = Calendar.getInstance();
		calendario.set(
				//Se utiliza 'split' para obtener el día, el mes, el mes, la hora y los
				//minutos por separado y así poder trabajar con Date
				Integer.getInteger(fecha.split("-")[0]),
				Integer.getInteger(fecha.split("-")[1]),
				Integer.getInteger(fecha.split("-")[2]),
				Integer.getInteger(hora.split(":")[0]),
				Integer.getInteger(fecha.split(":")[1])
				);
		
		this.fecha = calendario.getTime();
		
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
