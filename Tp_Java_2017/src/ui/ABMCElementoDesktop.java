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
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class ABMCElementoDesktop extends JInternalFrame {
	private AutoBinding<Elemento, TipoElemento, JComboBox, Object> cbo;
	
	private CtrlABMCElemento ctrl=new CtrlABMCElemento();
	private Elemento currentEle=new Elemento();
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtId;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnBuscar;
	private JFrame frame;
	private JLabel lblTipoElemento;
	private JComboBox cboTipoElemento;
	private JButton btnModificar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCElementoDesktop frame = new ABMCElementoDesktop();
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
	public ABMCElementoDesktop() {
		setIconifiable(true);
		setTitle("ABMCElemento");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblNombre = new JLabel("Nombre");
		lblTipoElemento = new JLabel("Tipo Elemento");
		cboTipoElemento = new JComboBox();
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
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
							.addGap(78)
							.addComponent(btnAgregar)
							.addGap(47)
							.addComponent(btnBorrar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTipoElemento)
								.addComponent(lblId)
								.addComponent(lblNombre))
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtId, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(txtNombre)
								.addComponent(cboTipoElemento, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBuscar)
						.addComponent(btnModificar))
					.addGap(38))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblId)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipoElemento)
								.addComponent(cboTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(37))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addComponent(btnBuscar)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnBorrar)
						.addComponent(btnModificar))
					.addGap(44))
		);
		getContentPane().setLayout(groupLayout);
		
		cargarListas(); 

	}


	private void cargarListas() {
		try { 
			this.cboTipoElemento.setModel(new DefaultComboBoxModel(ctrl.getTipoElemento().toArray()));
			this.cboTipoElemento.setSelectedIndex(-1);
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
		Elemento el = this.mapearDeForm();
		try{
			
			ctrl.add(el);
			this.txtId.setText(String.valueOf(el.getId_El()));
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
			Elemento el = mapearDeForm();	
			ctrl.delete(el); //lo envio a la capa logica elemento para que haga el delete
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
			Elemento el = mapearDeForm();
			mapearAForm(el);
			ctrl.update(el);
			notificar("Elemento modificado con exito");
			this.limpiarCampos();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	
	private void mapearAForm(Elemento el){
		this.txtId.setText(String.valueOf(el.getId_El()));
		this.txtNombre.setText(el.getNombre_El());
		this.cboTipoElemento.setSelectedItem(el.getTipoElemento());    
	}
	
	private Elemento mapearDeForm(){
		Elemento el=new Elemento();
		if(!this.txtId.getText().isEmpty()){
			el.setId_El(Integer.parseInt(this.txtId.getText()));
		}	
		el.setNombre_El(this.txtNombre.getText());
		if (cboTipoElemento.getSelectedIndex()!= -1){
			el.setTipoElemento((TipoElemento)this.cboTipoElemento.getSelectedItem());
		}
		return el;

	}
	
	public void showElemento(Elemento el){
		this.mapearAForm(el);
	}
	
	private void limpiarCampos(){
		this.txtNombre.setText("");
		
	}
	public void notificar(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}
}
