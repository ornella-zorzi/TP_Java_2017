package ui;
import java.util.ArrayList;
import java.util.Scanner;

import entity.*;
import controlers.CtrlABMCTipoElemento;

public class ABMTipoElementoConsole{
	private Scanner s;
	private CtrlABMCTipoElemento ctrl;
	public ABMTipoElementoConsole(){
		s=new Scanner(System.in);
		ctrl= new CtrlABMCTipoElemento();
		
	}
	
	public void start(){
		String rta="";
		boolean continua=true;
		do {
			System.out.println("\n\n ###############\n");
			System.out.println("¿Qué acción desea realizar? (Ingrese la letra indicada)");
			System.out.println("A - Alta");
			System.out.println("B - Baja");
			System.out.println("M - Modificación");
			System.out.println("C - Consulta");
			System.out.println("S - Salir");
			rta=s.nextLine();
			switch (rta.toLowerCase()) {
			case "a":
				this.alta();
				break;
			case "b":
				this.baja();
				break;
			case "m":
				this.modificacion();
				break;
			case "c":
				this.consulta();
				break;
			case "s":
				continua=false;
			}
		} while (continua);
		
		s.close();
	}
	private void alta(){
		System.out.println("\n\nNuevo elemento");
		System.out.println("#############");
		TipoElemento te = new TipoElemento();
		
		System.out.println("Ingrese Nombre del elemento:");
		te.setNombre_El(s.nextLine());
		System.out.println("Ingrese Nombre del tipo de elemento");
		te.setNombre_TE(s.nextLine());
		System.out.println("Ingrese Cantidad maxima de reserva ");
		te.setCant_reserva_max(s.nextInt());
		System.out.println("Ingrese tiempo limite de reserva ");
		te.setTiempo_limite(s.nextInt());
		System.out.println("Ingrese dias de anticipacion de reserva ");
		te.setDias_anticipacion(s.nextInt());
		
		ctrl.add(te);
	}
	private void baja(){
		System.out.println("\n\nEliminar Elemento ");
		System.out.println("#############");
		TipoElemento te =new TipoElemento();
		System.out.println("Ingrese el nombre del  Tipo de elemento:");
		te.setNombre_TE(s.nextLine());
		System.out.println("Ingrese el nombre del Elemento  ");
		te.setNombre_El(s.nextLine());
		ctrl.delete(te);

	}
	private void modificacion(){
		TipoElemento te =new TipoElemento();
		System.out.println("\n\nModificar elemento");
		System.out.println("#############");
		System.out.println("Ingrese nombre de elemento:");
		te.setNombre_El(s.nextLine());
		System.out.println("Ingrese el nombre del tipo de elemento ");
		te.setNombre_TE(s.nextLine());
		this.mostrar(ctrl.getByNombreNombreTipo(te));
		
		System.out.println("\nIngrese Nuevo Nombre de Elemento");
		te.setNombre_El(s.nextLine());
		System.out.println("Ingrese Nuevo tipo de elemento ");
		te.setNombre_TE(s.nextLine());
		System.out.println("Ingrese Nueva cantidad de reserva maxima ");
		te.setCant_reserva_max(s.nextInt());
		System.out.println("Ingrese Nuevo tiempo limite ");
		te.setTiempo_limite(s.nextInt());
		System.out.println("Ingrese Nuevos dias de anticipacion ");
		te.setDias_anticipacion(s.nextInt());
		ctrl.update(te);
	}
	private void consulta(){
		TipoElemento te =new TipoElemento();
		System.out.println("\n\nConsultar elementos ");
		System.out.println("#############");
		System.out.println("Ingrese Opción:");
		System.out.println("1 - Listar todos");
		System.out.println("2 - Buscar por Nombre y Tipo de elemento ");
		String rta=s.nextLine();
		switch (rta) {
		case "1":
			this.mostrar(ctrl.getAll());
			break;
		case "2":
			System.out.println("Ingrese Nombre de elemento:");
			te.setNombre_El(s.nextLine());
            System.out.println("Ingrese Tipo de elemento:");
            te.setNombre_TE(s.nextLine());
			this.mostrar(ctrl.getByNombreNombreTipo(te));
			
			break;

		default:
			break;
		}
		
	}
	
	public void mostrar(ArrayList<TipoElemento> tipo_elementos){
		for(TipoElemento te : tipo_elementos){
			mostrar(te);
		}
	}
	
	public void mostrar(TipoElemento te){
	
		System.out.println(te.getNombre_El() + " - " + te.getNombre_TE() + " - " + te.getCant_reserva_max() +
				" - " + te.getTiempo_limite() + " - " + te.getDias_anticipacion() + " - " );
			
	}

}
