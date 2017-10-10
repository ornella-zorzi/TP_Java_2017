package ui;
import data.DataReserva;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.*;
import entity.*;
import util.*;


import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JFrame;
import javax.swing.JComboBox;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class ABMCReservaDesktop extends JInternalFrame {
	
	private CtrlABMCReserva ctrl=new CtrlABMCReserva();
	private Reserva currentRes=new Reserva();
	

	private JTextField txtIdReserva;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtDetalle;
	private JTextField txtEstado;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JComboBox cboElemento;
	private JComboBox cboTipoElemento;
	private JFrame frame;
	private JTextField txtIdPer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCReservaDesktop frame = new ABMCReservaDesktop();
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
	public ABMCReservaDesktop() {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 350);
		
		JLabel lblIdReserva = new JLabel("Id Reserva");
		
		txtIdReserva = new JTextField();
		txtIdReserva.setEditable(false);
		txtIdReserva.setColumns(10);
		
		JLabel lblTipoElemento = new JLabel("Tipo Elemento");
		
		cboTipoElemento = new JComboBox();
		
		JLabel lblElemento = new JLabel("Elemento ");
		
		cboElemento = new JComboBox();
		
		
		
		JLabel lblFecha = new JLabel("Fecha");
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		
		JLabel lblHora = new JLabel("Hora");
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		
		JLabel lblDetalle = new JLabel("Detalle");
		
		txtDetalle = new JTextField();
		txtDetalle.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		/*btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarClick();
			}
		});*/
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarClick();
			}
		});
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarClick();
			}
		});
		
		JLabel lblIdPersona = new JLabel("ID Persona");
		
		txtIdPer = new JTextField();
		txtIdPer.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(btnAgregar)
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(btnEliminar)
					.addGap(49)
					.addComponent(btnModificar)
					.addGap(69))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHora)
						.addComponent(lblDetalle)
						.addComponent(lblIdReserva)
						.addComponent(lblTipoElemento)
						.addComponent(lblElemento)
						.addComponent(lblFecha)
						.addComponent(lblEstado)
						.addComponent(lblIdPersona))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtIdPer)
						.addComponent(txtEstado)
						.addComponent(txtDetalle)
						.addComponent(txtHora)
						.addComponent(txtFecha)
						.addComponent(cboElemento, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cboTipoElemento, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtIdReserva, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
					.addGap(39)
					.addComponent(btnBuscar)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdReserva)
						.addComponent(txtIdReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTipoElemento)
							.addGap(18)
							.addComponent(lblElemento))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(cboTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBuscar))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cboElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFecha)
						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblHora)
							.addGap(17)
							.addComponent(lblDetalle)
							.addGap(18)
							.addComponent(lblEstado))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtDetalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdPersona)
						.addComponent(txtIdPer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModificar)
						.addComponent(btnEliminar)
						.addComponent(btnAgregar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		cargarListas(); 
	}
	/*
	protected void buscarClick() {
	 private void buscarClick() {

		 try {
			 btnAceptar.setEnabled(true);
			 int validar=this.ctrl.validarBotonBuscar(cboTipos.getSelectedIndex(), txtFecha.getText(), txtHora.getText());
			 if (validar==1)
			 	{
			 		JOptionPane.showMessageDialog(this, "Seleccione un Tipo de Elemento");  
			 		this.cboElementos.setEnabled(true);
			 		 }
			 else if(validar==2)
			 	 {
			 		JOptionPane.showMessageDialog(this, "Verifique hora y fecha");  
			 		this.cboElementos.setEnabled(true);
			 	 }
			 else if(validar==3)
			 {
				 Tipo_Elemento te=new Tipo_Elemento();
				 if (cboTipos.getSelectedIndex() != -1){
					 te=(Tipo_Elemento)cboTipos.getSelectedItem();
					 java.sql.Date fecha = convertirFecha(this.txtFecha.getText());
					 java.sql.Time hora = convertirHora(this.txtHora.getText());
 						 
					 this.cboElementos.setModel(new DefaultComboBoxModel<Object>(this.ctrl.getElemDisponibles(fecha, hora, ctrl.getElementos(te)).toArray()));
					 this.cboElementos.setSelectedIndex(-1);
					 this.cboElementos.setEnabled(true);
	
		 }}}

		 catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error recuperando Elementos","Error",JOptionPane.ERROR_MESSAGE);
	 		
		}
		 }*/
		/*try {
			this.mapearAForm(ctrl.getByNombre(this.mapearDeForm()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}*/
	/*protected void buscarClick() {
		try {
			this.mapearAForm(ctrl.getByTipoElemento(this.mapearDeForm()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}*/
	protected void agregarClick() {
		java.sql.Date fecha=this.mapearDeFormFecha();
		java.sql.Time hora=this.mapearDeFormHora();
		Reserva r= this.mapearDeForm();
		try{
			ctrl.add(r,fecha,hora);
			//this.txtIdReserva.setText(String.valueOf(r.getId_res()));
			notificar("Reserva creada con exito ");
			//mapearDeForm();		
			this.limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		this.txtIdReserva.setText(String.valueOf(r.getId_res()));
	}

	
	protected void borrarClick(){
		try{
			Reserva re = mapearDeForm();	
			ctrl.delete(re); //lo envio a la capa logica reserva para que haga el delete
		    notificar("Reserva eliminada con exito");
		    this.limpiarCampos();
			ctrl.delete(this.mapearDeForm());
			this.limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	protected void modificarClick(){
		try{
			Reserva re = mapearDeForm();
			mapearAForm(re);
			ctrl.update(re);
			notificar("Reserva modificada con exito");
			this.limpiarCampos();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	private void mapearAForm(Reserva re){
		this.txtIdReserva.setText(String.valueOf(re.getId_res()));
		this.cboTipoElemento.setSelectedItem(re.getElemento().getTipoElemento());
		this.cboElemento.setSelectedItem(re.getElemento());
		this.txtFecha.setText(String.valueOf(re.getFecha()));
		this.txtHora.setText(String.valueOf(re.getHora()));
		this.txtDetalle.setText(String.valueOf(re.getDetalle()));
		this.txtEstado.setText(String.valueOf(re.getEstado()));
		this.txtIdPer.setText(String.valueOf(re.getPersona().getId_per()));

	}
	
	private Reserva mapearDeForm(){
		Reserva re= new Reserva();
		if(!this.txtIdReserva.getText().isEmpty()){
			re.setId_res(Integer.parseInt(this.txtIdReserva.getText()));
		}
		if (cboTipoElemento.getSelectedIndex()!= -1){
			
			re.setTipoelemento((TipoElemento)this.cboTipoElemento.getSelectedItem());
		}
		if (cboElemento.getSelectedIndex()!= -1){
			re.setElemento((Elemento)this.cboElemento.getSelectedItem());
		}
		
		
		re.setDetalle(this.txtDetalle.getText());
		re.setEstado(this.txtEstado.getText());
		re.getPersona().setId_per(Integer.parseInt(this.txtIdPer.getText()));
		return (re);
	}
	public java.sql.Date mapearDeFormFecha(){
		java.sql.Date fecha = Date.valueOf(this.txtFecha.getText());
		return (fecha);
	}
	public java.sql.Time mapearDeFormHora(){
		java.sql.Time hora = Time.valueOf(this.txtHora.getText());
		return (hora);
	}
	public void showElemento(Reserva re){
		this.mapearAForm(re);
	}
	
	private void limpiarCampos(){
		this.txtFecha.setText("");
		this.txtHora.setText("");
		this.txtDetalle.setText("");
		this.txtEstado.setText("");
		//this.txtPersona.setText("");
		
	}
	public void notificar(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}
	private void cargarListas() {
		try {
		this.cboElemento.setModel(new DefaultComboBoxModel(ctrl.getElemento().toArray()));
		this.cboElemento.setSelectedIndex(-1);
		this.cboTipoElemento.setModel(new DefaultComboBoxModel(ctrl.getTipoElemento().toArray()));
		this.cboTipoElemento.setSelectedIndex(-1);
		
		//	this.cboTipoElemento.setModel(new DefaultComboBoxModel(ctrl.getElemento().toArray());
		//	this.cboTipoElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	
	}
	public void showReserva(Reserva r){
		this.mapearAForm(r);
	}
}
