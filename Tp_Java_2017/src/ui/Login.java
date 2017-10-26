package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controlers.*;
import entity.*;
import util.*;
import data.*;
import ui.MainWindow;


public class Login extends JInternalFrame {
	private JTextField txtUsuario;
	private JButton btnIngresar;
	private JTextField txtPassword;
//	private CtrlLogin  ctrl = new CtrlLogin();
	private CtrlABMCPersona ctrl = new CtrlABMCPersona();
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		
		JLabel lblPassword = new JLabel("password:");
		
		txtUsuario =  new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ingresarClick();
				
			}

			
		});
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsuario)
								.addComponent(lblPassword))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(92)
									.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(82)
									.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(131)
							.addComponent(lblLogin)))
					.addContainerGap(170, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(293, Short.MAX_VALUE)
					.addComponent(btnIngresar)
					.addGap(68))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogin)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addComponent(btnIngresar)
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(130, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
 
	protected void ingresarClick() {
		//Persona u = mapearUsuario();
		try{
			Persona u = mapearUsuario();
			if(u!= null){
				ctrl.getValidacionUsario(u);
				notificar("usted se ha logueado correctamente");
			
			}
			else{
				notificar("usuario o contraseña incorrecta");
			}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
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