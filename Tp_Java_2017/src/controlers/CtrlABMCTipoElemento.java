package controlers;
import java.util.ArrayList;

import data.DataTipoElemento;
import data.DataElemento;
import entity.Persona;
import entity.TipoElemento;
import entity.Elemento;


public class CtrlABMCTipoElemento {
	private DataElemento dataEl;
	private DataTipoElemento dataTipoEl;	
	private ArrayList<TipoElemento> tipoEl ;

	public CtrlABMCTipoElemento(){
		
		dataTipoEl = new DataTipoElemento();
		dataEl = new DataElemento();
		tipoEl = new ArrayList<TipoElemento>();		
	}

	public void add(TipoElemento te)throws Exception{
		dataTipoEl.add(te);
	}

	public void delete(TipoElemento te)throws Exception{
		dataTipoEl.delete(te);
	}
	
	public void update(TipoElemento te)throws Exception{
		dataTipoEl.update(te);
	}
	public ArrayList<TipoElemento> getAll() throws Exception {
		//return this.pers;
		return dataTipoEl.getAll();
		
	}
	public ArrayList<Elemento> getElemento() throws Exception{
		return dataEl.getAll();
		
	}
	public TipoElemento getByNombre(TipoElemento te)throws Exception {
		//return this.pers.get(this.pers.indexOf(p));
		return dataTipoEl.getByNombre(te);
	}
	
	public TipoElemento getByNombre(String nombre_TE) throws Exception {
		TipoElemento te= new TipoElemento();
		te.setNombre_TE(nombre_TE);
		return getByNombre (te);
	}

	
}
	

