/*package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

import controlers.CtrlABMCElemento;
import controlers.CtrlABMCReserva;
import controlers.CtrlABMCTipoElemento;
import entity.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMCReservaDesktop extends JInternalFrame {
	private CtrlABMCReserva ctrl=new CtrlABMCReserva();
	
	private JTextField txtID;
	private JButton btnBuscar;
	private JTextField txtDni;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtDetalle;
	private JTextField txtEstado;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JComboBox cboTipoElemento;
	private JComboBox cboElemento;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
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
/*	public ABMCReservaDesktop() {
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 499, 375);
		
		JLabel lblId = new JLabel("ID");
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		
	
		
		cboTipoElemento = new JComboBox();
		
		cboElemento = new JComboBox();
		
		JLabel lblTipo_elemento = new JLabel("Tipo Elemento");
		
		JLabel lblElemento = new JLabel("Elemento");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		
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
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			//	buscarClick();
			}
		});
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarClick();
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarClick();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(lblId))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTipo_elemento))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblElemento))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDni))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFecha))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblHora))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDetalle))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEstado)))
					.addGap(105)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(215, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtDetalle, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(215, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(cboElemento, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(cboTipoElemento, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtID, Alignment.TRAILING))
								.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
								.addComponent(btnBuscar)
								.addGap(25)))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAgregar)
					.addGap(62)
					.addComponent(btnModificar)
					.addGap(76)
					.addComponent(btnBorrar)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblId)
							.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBuscar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cboTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipo_elemento))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(cboElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblElemento))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDni))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFecha))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHora)
						.addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDetalle)
						.addComponent(txtDetalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEstado)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnModificar)
						.addComponent(btnBorrar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		cargarListas();

	}
	private void cargarListas() {
		try {
			this.cboElemento.setModel(new DefaultComboBoxModel(ctrl.getElemento().toArray()));
			this.cboElemento.setSelectedIndex(-1);
		//	this.cboTipoElemento.setModel(new DefaultComboBoxModel(ctrl.getElemento().toArray());
		//	this.cboTipoElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	/*protected void buscarClick() {
		try {
			this.mapearAForm(ctrl.getByDni(this.mapearDeForm()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}
	*/
/*	protected void agregarClick() {
		Reserva r = this.mapearDeForm();
		try{
			ctrl.add(r);
			this.txtID.setText(String.valueOf(r.getId_res()));
			notificar("Reserva creada con exito ");
			mapearDeForm();
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		//this.txtId.setText(String.valueOf(p.getId_per()));
	}
	
	protected void borrarClick(){
		try{
			Reserva r = mapearDeForm();
			ctrl.delete(r); //lo envio a la capa logica el persona para que haga el delete
		    notificar("Reserva eliminada con exito");
		    this.limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	protected void modificarClick(){
		try{
			Reserva r = mapearDeForm();
			mapearAForm(r);
			ctrl.update(r);
			notificar("Reserva modificado con exito");
			this.limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void mapearAForm(Reserva r){
		this.txtID.setText(String.valueOf(r.getId_res()));
		this.cboElemento.setSelectedItem(r.getElemento());
		this.txtFecha.setd(r.getFecha());
		this.txtHora.set(r.getHora());
		
	}
	
	private Persona mapearDeForm(){
		Persona p=new Persona();
		if(!this.txtId.getText().isEmpty()){
			p.setId_per(Integer.parseInt(this.txtId.getText()));
		}
		p.setDni(this.txtDni.getText());
		p.setNombre(this.txtNombre.getText());
		p.setApellido(this.txtApellido.getText());
		p.setEmail(this.txtEmail.getText());
		p.setUsuario(this.txtUsuario.getText());
		p.setContraseña(this.txtContraseña.getText());
		p.setHabilitado(this.chckbxHabilitado.isSelected());
		if (comboBox.getSelectedIndex() != -1){
			p.setCategoria((Categoria)this.comboBox.getSelectedItem());
		}
		return p;
	}
	
	public void showPersona(Persona p){
		this.mapearAForm(p);
	}
	private void limpiarCampos(){
		
		this.txtDni.setText("");
		this.txtNombre.setText("");
		this.txtApellido.setText("");
		this.txtEmail.setText("");
		//this.comboBox.setEditor(anEditor);
		this.txtUsuario.setText("");
		this.txtContraseña.setText("");
		
	}
	public void notificar(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}
}
*/