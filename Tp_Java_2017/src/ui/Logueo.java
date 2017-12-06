package ui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controlers.CtrlABMCPersona;
import entity.Persona;

public class Logueo {
	static Persona u=new Persona();
	CtrlABMCPersona ctrl=new CtrlABMCPersona();
	private JFrame frame;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logueo window = new Logueo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Logueo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ingresarClick();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

			
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsuario)
						.addComponent(lblContrasea))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtPassword)
						.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
					.addContainerGap(133, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(280, Short.MAX_VALUE)
					.addComponent(btnIngresar)
					.addGap(65))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblContrasea)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(btnIngresar)
					.addGap(47))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	public void ingresarClick() throws Exception {
		u = mapearUsuario();
		try{
			if(u!= null){
				ctrl.getValidacionUsario(u);
				
				notificar("usted se ha logueado correctamente");
				MainWindow mw=new MainWindow();
				frame.setVisible(false);
				mw.frmGestionDeReservas.setVisible(true);
			}
			else{
				notificar("usuario o contraseña incorrecta");
			}
			
			
		} catch (Exception e) {
		} 
	}
	
/*	esta dos veces porque estaba mirando como queda mejor 
protected void ingresarClick() {
		Persona p = this.mapearUsuario();
		try {
				//Persona u = mapearUsuario();
		     if (u!=null){
			notificar("ingreso");
			
		}
		else {
			notificar("no ingreso ");
		}
		}
		 catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
		
	
	}  */ 
	public Persona mapearUsuario() throws Exception{
		String usu= this.txtUsuario.getText();
		String cont = this.txtPassword.getText();
		Persona usu2 = new Persona();
		usu2.setUsuario(usu);
		usu2.setContraseña(cont);
		Persona u = new Persona();
		u= ctrl.getValidacionUsario(usu2);
		return u ; 

	}
	
	
	
	public void notificar(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}
}
