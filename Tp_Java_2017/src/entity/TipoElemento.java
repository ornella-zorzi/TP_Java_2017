package entity;

public class TipoElemento  extends Elemento{
	
	private int id_TE;
	private String nombre_TE;
	private int  cant_reserva_max;
	private int tiempo_limite;
	private int dias_anticipacion;
	private Elemento elemento;
	

	public Elemento getElemento() {
		return elemento;
	}
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}
	public int getId_TE() {
		return id_TE;
	}
	public void setId_TE(int id_TE) {
		this.id_TE = id_TE;
	}
	public String getNombre_TE() {
		return nombre_TE;
	}
	public void setNombre_TE(String nombre_TE) {
		this.nombre_TE = nombre_TE;
	}
	public int getCant_reserva_max() {
		return cant_reserva_max;
	}
	public void setCant_reserva_max(int cant_reserva_max) {
		this.cant_reserva_max = cant_reserva_max;
	}
	public int getTiempo_limite() {
		return tiempo_limite;
	}
	public void setTiempo_limite(int tiempo_limite) {
		this.tiempo_limite = tiempo_limite;
	}
	public int getDias_anticipacion() {
		return dias_anticipacion;
	}
	public void setDias_anticipacion(int dias_anticipacion) {
		this.dias_anticipacion = dias_anticipacion;
	}
	public TipoElemento(int id_El, String nombre_El, int id_TE,
			String nombre_TE, int cant_reserva_max, int tiempo_limite,
			int dias_anticipacion) {
		super(id_El, nombre_El);
		this.id_TE = id_TE;
		this.nombre_TE = nombre_TE;
		this.cant_reserva_max = cant_reserva_max;
		this.tiempo_limite = tiempo_limite;
		this.dias_anticipacion = dias_anticipacion;
	}
	
	public TipoElemento (){
		super();
	}
	
	


	
}