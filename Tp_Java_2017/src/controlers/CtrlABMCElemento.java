package controlers;
import java.util.ArrayList;

import entity.Elemento;
import data.DataElemento;


public class CtrlABMCElemento {
	private DataElemento dataElem;
	
private ArrayList<Elemento> elems;
public CtrlABMCElemento(){
	dataElem = new DataElemento();
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

public Elemento getByNombre(Elemento ele)throws Exception {
	//return this.pers.get(this.pers.indexOf(p));
	return dataElem.getByNombre(ele);
}

public ArrayList<Elemento> getAll() throws Exception {
	//return this.pers;
	return dataElem.getAll();
}
}