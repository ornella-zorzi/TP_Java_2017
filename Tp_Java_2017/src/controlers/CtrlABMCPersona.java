package controlers;
import java.util.ArrayList;
import entity.Persona;
import data.DataPersona;

public class CtrlABMCPersona {
	private DataPersona dataPer;
	
private ArrayList<Persona> pers;
	
	
	public CtrlABMCPersona(){
		dataPer = new DataPersona();
		pers= new ArrayList<Persona>();
			  
	}

	public void add(Persona p) throws Exception {
		//this.pers.add(p);
		dataPer.add(p);
	}
	
	public void delete(Persona p) throws Exception{
		this.pers.remove(p);
	}
	
	public void update(Persona p)throws Exception {
		this.delete(p);
		this.add(p);
	}
	
	public Persona getByDni(Persona p)throws Exception {
		//return this.pers.get(this.pers.indexOf(p));
		return this.dataPer.getByDni(p);
	}
	
	public Persona getByDni(String dni) throws Exception {
		Persona p=new Persona();
		p.setDni(dni);
		return getByDni(p);
	}
	
	public Persona getByNombreApellido(Persona p){
		
		for (int i=0; i < this.pers.size(); i++){
			if(pers.get(i).getNombre().equalsIgnoreCase(p.getNombre())
				&& pers.get(i).getApellido().equalsIgnoreCase(p.getApellido())) {
				return pers.get(i);		
			}
		}
		return null; 
		
	}
	
	public ArrayList<Persona> getAll() throws Exception {
		//return this.pers;
		return dataPer.getAll();
	}
}
