package ui;
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

import javax.swing.JFrame;
import javax.swing.JComboBox;

public class ABMCTipoElementoDesktop extends JInternalFrame {
	private CtrlABMCTipoElemento ctrl=new CtrlABMCTipoElemento();
	
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombreTe;
	private JTextField txtCantReservaMax;
	private JTextField txtTiempoLimite;
	private JTextField txtDiasAnticipacion;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCTipoElementoDesktop frame = new ABMCTipoElementoDesktop();
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
	public ABMCTipoElementoDesktop() {
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblId = new JLabel("ID");
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		
		JLabel lblTipoelemento = new JLabel("TipoElemento");
		
		txtNombreTe = new JTextField();
		txtNombreTe.setColumns(10);
		
		JLabel lblCantReservaMax = new JLabel("Cant reserva max");
		
		txtCantReservaMax = new JTextField();
		txtCantReservaMax.setColumns(10);
		
		JLabel lblTiempoLimite = new JLabel("Tiempo Limite");
		
		txtTiempoLimite = new JTextField();
		txtTiempoLimite.setColumns(10);
		
		JLabel lblDiasAnticipacion = new JLabel("Dias anticipacion");
		
		txtDiasAnticipacion = new JTextField();
		txtDiasAnticipacion.setColumns(10);
		
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
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClick();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDiasAnticipacion)
									.addGap(18)
									.addComponent(txtDiasAnticipacion))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCantReservaMax)
										.addComponent(lblTiempoLimite)
										.addComponent(lblTipoelemento)
										.addComponent(lblId))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtTiempoLimite)
										.addComponent(txtCantReservaMax)
										.addComponent(txtNombreTe, Alignment.TRAILING)
										.addComponent(txtID, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
							.addGap(71)
							.addComponent(btnBuscar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(btnAgregar)
							.addGap(57)
							.addComponent(btnModificar)
							.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
							.addComponent(btnEliminar)))
					.addGap(31))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoelemento)
						.addComponent(txtNombreTe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantReservaMax)
						.addComponent(txtCantReservaMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTiempoLimite)
						.addComponent(txtTiempoLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiasAnticipacion)
						.addComponent(txtDiasAnticipacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnModificar)
						.addComponent(btnEliminar))
					.addGap(39))
		);
		getContentPane().setLayout(groupLayout);

	}
	
	protected void buscarClick() {
		try {
			this.mapearAForm(ctrl.getByNombre(this.mapearDeForm()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}
	
	protected void agregarClick() {
		TipoElemento te = this.mapearDeForm();
		try{
			
			ctrl.add(te);
			this.txtID.setText(String.valueOf(te.getId_TE()));
			notificar("Elemento creada con exito ");
			mapearDeForm();		
			this.limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		//this.txtId.setText(String.valueOf(el.getId_El()));
	}

	
	protected void borrarClick(){
		try{
			TipoElemento te = mapearDeForm();	
			ctrl.delete(te); //lo envio a la capa logica elemento para que haga el delete
		    notificar("Elemento eliminada con exito");
		    this.limpiarCampos();
			ctrl.delete(this.mapearDeForm());
			this.limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	protected void modificarClick(){
		try{
			TipoElemento te = mapearDeForm();
			mapearAForm(te);
			ctrl.update(te);
			notificar("Elemento modificado con exito");
			this.limpiarCampos();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	
	private void mapearAForm(TipoElemento te){
		this.txtID.setText(String.valueOf(te.getId_TE()));
		this.txtNombreTe.setText(te.getNombre_TE());
		this.txtCantReservaMax.setText(String.valueOf(te.getCant_reserva_max()));    
		this.txtTiempoLimite.setText(String.valueOf(te.getTiempo_limite()));
		this.txtDiasAnticipacion.setText(String.valueOf(te.getDias_anticipacion()));
	}
	
	private TipoElemento mapearDeForm(){
		TipoElemento te=new TipoElemento();
		if(!this.txtID.getText().isEmpty()){
			te.setId_TE(Integer.parseInt(this.txtID.getText()));
		}	
		te.setNombre_TE(this.txtNombreTe.getText());
		te.setCant_reserva_max(Integer.parseInt(this.txtCantReservaMax.getText()));
		te.setTiempo_limite(Integer.parseInt(this.txtTiempoLimite.getText()));
		te.setDias_anticipacion(Integer.parseInt(this.txtTiempoLimite.getText()));
		
		return te;

	}
	
	public void showTipoElemento(TipoElemento te){
		this.mapearAForm(te);
	}
	
	private void limpiarCampos(){
		this.txtNombreTe.setText("");
		this.txtCantReservaMax.setText("");
		this.txtTiempoLimite.setText("");
		this.txtDiasAnticipacion.setText("");
	}
	public void notificar(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}
}
