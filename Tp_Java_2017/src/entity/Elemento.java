package entity;

public class Elemento {
	private int id_El;
	private String nombre_El;
	
	
	public int getId_El() {
		return id_El;
	}
	public void setId_El(int id_El) {
		this.id_El = id_El;
	}
	public String getNombre_El() {
		return nombre_El;
	}
	public void setNombre_El(String nombre_El) {
		this.nombre_El = nombre_El;
	}
	

	public Elemento ( int id_El , String nombre_El){
		this.setId_El(id_El);
		this.setNombre_El(nombre_El);
		
	}
	public Elemento (){
		
	}
}
