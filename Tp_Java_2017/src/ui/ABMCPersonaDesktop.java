package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlers.CtrlABMCPersona;
import entity.Categoria;
import entity.Persona;
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
import util.ApplicationException;

public class ABMCPersonaDesktop extends JInternalFrame {
	
	private CtrlABMCPersona ctrl=new CtrlABMCPersona();
	
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JCheckBox chckbxHabilitado;
	private JComboBox comboBox;
	private JButton btnAgregar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCPersonaDesktop frame = new ABMCPersonaDesktop();
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
	public ABMCPersonaDesktop() {
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 392, 410);
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblDni = new JLabel("DNI");
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellido = new JLabel("Apellido");
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblCategoria = new JLabel("Categoria");
		
		chckbxHabilitado = new JCheckBox("Habilitado");
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		comboBox = new JComboBox();
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
			}
		});
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
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
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addComponent(btnAgregar)
							.addGap(27)
							.addComponent(btnEliminar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblId)
										.addComponent(lblDni)
										.addComponent(lblNombre)
										.addComponent(lblApellido)
										.addComponent(lblEmail)
										.addComponent(lblCategoria)
										.addComponent(lblUsuario)
										.addComponent(lblContrasea))
									.addGap(34)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(txtApellido, Alignment.LEADING)
											.addComponent(txtEmail, Alignment.LEADING)
											.addComponent(txtNombre, Alignment.LEADING)
											.addComponent(txtDni, Alignment.LEADING)
											.addComponent(txtId, Alignment.LEADING))))
								.addComponent(chckbxHabilitado))))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBuscar)
						.addComponent(btnModificar))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblId)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDni)
								.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(8)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblApellido)
								.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCategoria)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxHabilitado)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsuario)
								.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblContrasea)
								.addComponent(txtContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(btnBuscar)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnEliminar)
						.addComponent(btnModificar))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		cargarListas();
	}
	private void cargarListas() {
		try {
			this.comboBox.setModel(new DefaultComboBoxModel(ctrl.getCategoria().toArray()));
			this.comboBox.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	protected void buscarClick() {
		try {
			this.mapearAForm(ctrl.getByDni(this.mapearDeForm()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}
	
	protected void agregarClick() {
		Persona p = this.mapearDeForm();
		try{
			ctrl.add(p);
			this.txtId.setText(String.valueOf(p.getId_per()));
			notificar("Persona creada con exito ");
			mapearDeForm();
			limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		//this.txtId.setText(String.valueOf(p.getId_per()));
	}
	
	protected void borrarClick(){
		try{
			Persona p = mapearDeForm();
			ctrl.delete(p); //lo envio a la capa logica el persona para que haga el delete
		    notificar("Persona eliminada con exito");
		    this.limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	protected void modificarClick(){
		try{
			Persona p = mapearDeForm();
			mapearAForm(p);
			ctrl.update(p);
			notificar("Persona modificado con exito");
			this.limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void mapearAForm(Persona p){
		this.txtDni.setText(p.getDni());
		this.txtNombre.setText(p.getNombre());
		this.txtApellido.setText(p.getApellido());
		this.chckbxHabilitado.setSelected(p.isHabilitado());
		this.txtId.setText(String.valueOf(p.getId_per()));
		this.txtUsuario.setText(p.getUsuario());
		this.txtContraseña.setText(p.getContraseña());
		this.txtEmail.setText(p.getEmail());
		this.comboBox.setSelectedItem(p.getCategoria());
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
