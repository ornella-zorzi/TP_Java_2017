package controlers;
import java.util.ArrayList;

import entity.Elemento;
import data.DataElemento;
import entity.TipoElemento;
import data.DataTipoElemento;


public class CtrlABMCElemento { 

	private DataElemento dataElem;
	private DataTipoElemento dataTipoEl;
	private ArrayList<Elemento> elems;

	public CtrlABMCElemento(){
	dataElem = new DataElemento();
	dataTipoEl = new DataTipoElemento();
	elems= new ArrayList<Elemento>();
	}

	public void add(Elemento e) throws Exception {
	//this.pers.add(p);
	dataElem.add(e);
	}

	public void delete(Elemento e) throws Exception{
	//this.pers.remove(p);
	dataElem.delete(e);
	}

	public void update(Elemento e)throws Exception {
	//this.delete(p);
	//this.add(p);
	dataElem.update(e);
	}

	public Elemento getByNombre(Elemento el)throws Exception {
	//return this.pers.get(this.pers.indexOf(p));
	return dataElem.getByNombre(el);
	}
	public Elemento getByNombre(String nombre_el) throws Exception{
		Elemento el = new Elemento();
		el.setNombre_El(nombre_el);
		return getByNombre(el);
	}

   public ArrayList<Elemento> getAll() throws Exception {
	//return this.pers;
	return dataElem.getAll();
	}
   
	public ArrayList<TipoElemento> getTipoElemento() throws Exception {
		//return this.pers;
		return dataTipoEl.getAll();
		
	}
	

}