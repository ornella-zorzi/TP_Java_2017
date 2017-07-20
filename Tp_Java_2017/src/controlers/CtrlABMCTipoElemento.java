package controlers;
import java.util.ArrayList;
import entity.*;


public class CtrlABMCTipoElemento {
	
private ArrayList<TipoElemento> tipo_elem ;
	
	
	public CtrlABMCTipoElemento(){
		
		tipo_elem= new ArrayList<TipoElemento>();
		
	  
	}
	public void add(TipoElemento  te) {
		this.tipo_elem.add(te);
	}
	
	public void delete(TipoElemento  te){
		this.tipo_elem.remove(te);
	}
	
	public void update(TipoElemento  te){
		this.delete(te);
		this.add(te);
	}
	
	
	public TipoElemento getByNombreNombreTipo(TipoElemento te){
		
		for (int i=0; i < this.tipo_elem.size(); i++){
			if(tipo_elem.get(i).getNombre_El().equalsIgnoreCase(te.getNombre_El())
				&& tipo_elem.get(i).getNombre_TE().equalsIgnoreCase(te.getNombre_TE())) {
				return tipo_elem.get(i);		
			}
		}
		return null; 
		
	}
	
	public ArrayList<TipoElemento> getAll(){
		return this.tipo_elem;
	}
}
