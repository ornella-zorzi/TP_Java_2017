package controlers;
import java.util.ArrayList;

import data.DataTipoElemento;
import data.DataElemento;
import entity.Categoria;
import entity.Persona;
import entity.TipoElemento;
import entity.Elemento;

public class CtrlABMCTipoElemento {
	private DataElemento dataEl;
	private DataTipoElemento dataTipoEl;	
	private ArrayList<TipoElemento> tipoEl ;

	public CtrlABMCTipoElemento(){
		dataEl = new DataElemento();
		dataTipoEl = new DataTipoElemento();
		tipoEl = new ArrayList<TipoElemento>();		
	}
	
	public void add(TipoElemento tiel)throws Exception{
		dataTipoEl.add(tiel);
	}
	
	public void delete(TipoElemento tiel)throws Exception{
		dataTipoEl.delete(tiel);
	}
	
	public void update(TipoElemento tiel)throws Exception{
		dataTipoEl.update(tiel);
	}
	public ArrayList<TipoElemento> getAll() throws Exception {
		//return this.pers;
		return dataTipoEl.getAll();
		
	}
	public ArrayList<Elemento> getElemento() throws Exception{
		return dataEl.getAll();
		
	}
}
	

	
	/*public TipoElemento getByNombreNombreTipo(TipoElemento te){
		
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
	}*/
