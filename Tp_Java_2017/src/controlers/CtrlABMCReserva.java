package controlers;
import entity.*;
import data.*;

import java.util.ArrayList;

public class CtrlABMCReserva {
	private DataPersona dataPer;
	private DataReserva dataRes;
	private DataTipoElemento dataTiEl;
	private DataElemento dataEL;
	private ArrayList<Reserva> res;
	
	public CtrlABMCReserva(){
		dataRes = new DataReserva();
		dataPer = new DataPersona();
		dataTiEl = new DataTipoElemento();
		dataEL= new DataElemento();
	}


}
