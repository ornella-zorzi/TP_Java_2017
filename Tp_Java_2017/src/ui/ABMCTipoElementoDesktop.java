package ui;

import java.awt.EventQueue;

import entity.Categoria;
import entity.Elemento;
import entity.Persona;
import entity.TipoElemento;
import controlers.CtrlABMCPersona;
import controlers.CtrlABMCTipoElemento;
import util.ApplicationException;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	
	
	private JButton btnBuscar;
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JTextField txtCantMaxReserva;
	private JTextField txtDiasAnticipacion;
	private JTextField txtTiempoLimite;
	private JTextField txtNombre_TE;
	private JComboBox cboElemento;
	private JTextField txtId;
	private JFrame frame;
	private JPanel contentPane;

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
		
		JLabel lblId = new JLabel("ID ");
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		JLabel lblElemento = new JLabel("Elemento ");
		
		cboElemento = new JComboBox();
		
		JLabel lblTipoElemento = new JLabel("Tipo Elemento ");
		
		JLabel lblTiempoLimite = new JLabel("Tiempo Limite ");
		
		txtNombre_TE = new JTextField();
		txtNombre_TE.setColumns(10);
		
		txtTiempoLimite = new JTextField();
		txtTiempoLimite.setColumns(10);
		
		JLabel lblDias = new JLabel("Dias Anticipacion");
		
		txtDiasAnticipacion = new JTextField();
		txtDiasAnticipacion.setColumns(10);
		
		txtCantMaxReserva = new JTextField();
		txtCantMaxReserva.setColumns(10);
		
		JLabel lblCantreservamax = new JLabel("Cant_reserva_max");
		
	
		btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarClick();
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarClick();
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClick();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTipoElemento)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblId)
							.addComponent(lblElemento))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblDias)
							.addComponent(lblTiempoLimite)
							.addComponent(lblCantreservamax)))
					.addGap(77)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cboElemento, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtId))
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
							.addComponent(btnBuscar)
							.addGap(29))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCantMaxReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNombre_TE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTiempoLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDiasAnticipacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(151, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAgregar)
					.addGap(39)
					.addComponent(btnModificar)
					.addGap(43)
					.addComponent(btnBorrar)
					.addContainerGap(127, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblElemento)
						.addComponent(cboElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoElemento)
						.addComponent(txtNombre_TE, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTiempoLimite)
						.addComponent(txtTiempoLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDias)
						.addComponent(txtDiasAnticipacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtCantMaxReserva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantreservamax))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnModificar)
						.addComponent(btnBorrar))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		cargarListas();
	}
	private void cargarListas() {
		try {
			this.cboElemento.setModel(new DefaultComboBoxModel(ctrl.getElemento().toArray()));
			this.cboElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
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
			this.txtId.setText(String.valueOf(te.getId_TE()));
			notificar("Tipo de elemento  creado con exito ");
			mapearDeForm();
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}
	
	protected void borrarClick(){
		try{
			TipoElemento te  = mapearDeForm();
			ctrl.delete(te); 
		    notificar(" Tipo Elemento eliminado con exito");
		    this.limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	protected void modificarClick(){
		try{
			TipoElemento te  = mapearDeForm();
			mapearAForm(te);
			ctrl.update(te);
			notificar("Tipo Elemento modificado con exito");
			this.limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void mapearAForm(TipoElemento te){
		this.cboElemento.setSelectedItem(te.getElemento());
		this.txtNombre_TE.setText(te.getNombre_TE());
		this.txtTiempoLimite.setText(String.valueOf(te.getTiempo_limite()));
		this.txtDiasAnticipacion.setText(String.valueOf(te.getDias_anticipacion()));
		this.txtCantMaxReserva.setText(String.valueOf(te.getCant_reserva_max()));
	}
	
	private TipoElemento mapearDeForm(){
		TipoElemento te=new TipoElemento();
		if(!this.txtId.getText().isEmpty()){
			te.setId_TE(Integer.parseInt(this.txtId.getText()));
		}
		if (cboElemento.getSelectedIndex() != -1){
			te.setElemento((Elemento)this.cboElemento.getSelectedItem());
		}
		te.setNombre_TE(this.txtNombre_TE.getText());
		te.setTiempo_limite(Integer.parseInt(this.txtTiempoLimite.getText()));
		te.setDias_anticipacion(Integer.parseInt(this.txtDiasAnticipacion.getText()));
		te.setCant_reserva_max(Integer.parseInt(this.txtCantMaxReserva.getText()));
	
		return te;
	}
	
	public void showPersona(TipoElemento te){
		this.mapearAForm(te);
	}
	private void limpiarCampos(){
		
		
		this.txtNombre_TE.setText("");
		this.txtTiempoLimite.setText("");
		this.txtDiasAnticipacion.setText("");
		this.txtCantMaxReserva.setText("");
		
	}
	public void notificar(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}
	}

