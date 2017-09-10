package ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlABMCElemento;
import entity.Elemento;
import entity.Persona;
import entity.TipoElemento;

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
public class ABMCElementoDesktop extends JInternalFrame {
	
	private CtrlABMCElemento ctrl=new CtrlABMCElemento();
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtId;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JFrame frame;
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
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblNombre = new JLabel("Nombre");
		
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
					.addGap(78)
					.addComponent(btnAgregar)
					.addGap(47)
					.addComponent(btnBorrar)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(btnModificar)
					.addGap(40))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblId)
						.addComponent(lblNombre))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
							.addComponent(btnBuscar)
							.addGap(59))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(235, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnBorrar)
						.addComponent(btnModificar))
					.addGap(44))
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
	}
	
	private Elemento mapearDeForm(){
		Elemento el=new Elemento();
		if(!this.txtId.getText().isEmpty()){
			el.setId_El(Integer.parseInt(this.txtId.getText()));
		}
		el.setNombre_El(this.txtNombre.getText());
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
