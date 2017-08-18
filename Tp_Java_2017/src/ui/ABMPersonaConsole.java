package ui;
import java.util.ArrayList;
import java.util.Scanner;
import controlers.CtrlABMCPersona;
import entity.Persona;

public class ABMPersonaConsole {
	private Scanner s;
	private CtrlABMCPersona ctrl;
	public ABMPersonaConsole(){
		s=new Scanner(System.in);
		ctrl= new CtrlABMCPersona();
		
		
	}
	public void start(){
		String rta="";
		boolean continua=true;
		do {
			System.out.println("\n\n ###############\n");
			System.out.println("�Qu� acci�n desea realizar? (Ingrese la letra indicada)");
			System.out.println("A - Alta");
			System.out.println("B - Baja");
			System.out.println("M - Modificaci�n");
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
		System.out.println("\n\nNueva persona");
		System.out.println("#############");
		Persona p=new Persona();
		System.out.println("Ingrese DNI:");
		p.setDni(s.nextLine());
		System.out.println("Ingrese Nombre");
		p.setNombre(s.nextLine());
		System.out.println("Ingrese Apellido");
		p.setApellido(s.nextLine());
		System.out.println("Ingrese Email");
		p.setEmail(s.nextLine());
		System.out.println("Ingrese Usuario");
		p.setUsuario(s.nextLine());
		System.out.println("Ingrese Contrase�a");
		p.setContrase�a(s.nextLine());
		System.out.println("�Est� habilitado? (S/N)");
		String h=s.nextLine();
		if(h.equalsIgnoreCase("S")){
			p.setHabilitado(true);
		}else if (h.equalsIgnoreCase("N")) {
			p.setHabilitado(false);
		}
		try{
				ctrl.add(p);
		} catch (Exception e ){
			e.printStackTrace();
		}
	//	ctrl.add(p);
	}
	private void baja(){
		System.out.println("\n\nEliminar persona");
		System.out.println("#############");
		Persona p=new Persona();
		System.out.println("Ingrese DNI:");
		p.setDni(s.nextLine());
		try{
			ctrl.delete(p);
		} catch (Exception e ){
			e.printStackTrace();
		}
	//	ctrl.delete(p);

	}
	
	private void modificacion(){
		Persona p=new Persona();
		System.out.println("\n\nModificar persona");
		System.out.println("#############");
		System.out.println("Ingrese DNI:");
		p.setDni(s.nextLine());
		try{ this.mostrar(ctrl.getByDni(p));
		}catch(Exception e){
			e.printStackTrace();
		}
		//this.mostrar(ctrl.getByDni(p));
		
		System.out.println("\nIngrese Nuevo Nombre");
		p.setNombre(s.nextLine());
		System.out.println("Ingrese Nuevo Apellido");
		p.setApellido(s.nextLine());
		System.out.println("Ingrese Nuevo Email ");
		p.setEmail(s.nextLine());
		System.out.println("Ingrese Nuevo Usuario");
		p.setUsuario(s.nextLine());
		System.out.println("Ingrese Nueva Contrase�a ");
		p.setContrase�a(s.nextLine());
		System.out.println("�Est� habilitado? (S/N)");
		String h=s.nextLine();
		if(h.equalsIgnoreCase("S")){
			p.setHabilitado(true);
		}else if (h.equalsIgnoreCase("N")) {
			p.setHabilitado(false);
		}
		try { 
			 ctrl.update(p);
		} catch (Exception e ){
			e.printStackTrace();
		}
		///ctrl.update(p);
	}
	
	private void consulta(){
		Persona p=new Persona();
		System.out.println("\n\nConsultar personas");
		System.out.println("#############");
		System.out.println("Ingrese Opci�n:");
		System.out.println("1 - Listar todos");
		System.out.println("2 - Buscar por DNI");
		System.out.println("3 - Buscar por Nombre y Apellido");
		String rta=s.nextLine();
		switch (rta) {
		case "1":
			try {
				this.mostrar(ctrl.getAll());
			} catch (Exception e1){
				e1.printStackTrace();
			}
		//	this.mostrar(ctrl.getAll());
			break;
		case "2":
			System.out.println("Ingrese DNI:");
			p.setDni(s.nextLine());
			try { 
				this.mostrar(ctrl.getByDni(p));
			} catch (Exception e ){
				e.printStackTrace();
			}
		//	this.mostrar(ctrl.getByDni(p));
			
			break;
		case "3":
			System.out.println("Ingrese Nombre:");
			p.setNombre(s.nextLine());
			System.out.println("Ingrese Apellido:");
			p.setApellido(s.nextLine());
			this.mostrar(ctrl.getByNombreApellido(p));
			break;

		default:
			break;
		}
		
	}
	
	public void mostrar(ArrayList<Persona>personas){
		for(Persona p: personas){
			mostrar(p);
		}
	}
	
	public void mostrar(Persona p){
		String h="";
		if(p.isHabilitado()){
			h="Habilitado";
		}else{
			h="Deshabilitado";
		}
		System.out.println(p.getDni()+" - "+p.getApellido()+", "+
						 p.getNombre()+" : "+ p.getEmail() + " , "+ p.getUsuario() + " , "+  h);
	}

}
