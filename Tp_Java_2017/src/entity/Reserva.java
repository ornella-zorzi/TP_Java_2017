package entity;
import java.util.Date;


public class Reserva {
	private Date hora;
	private Date fecha; 
	private String estado;
	private String detalle;
	private Persona persona;
	private TipoElemento tipoelemento;
	
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public TipoElemento getTipoelemento() {
		return tipoelemento;
	}
	public void setTipoelemento(TipoElemento tipoelemento) {
		this.tipoelemento = tipoelemento;
	}
	
	
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	
	

}
