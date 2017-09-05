package ui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import controlers.CtrlABMCTipoElemento;
import entity.Categoria;
import entity.Persona;
import entity.TipoElemento;
import entity.Elemento;


public class ABMCTipoElementoDesktop extends JInternalFrame {
	
	private CtrlABMCTipoElemento  ctrl = new CtrlABMCTipoElemento();
	
	private JPanel contentPane;
	private JTextField txtIdTipoElemento;
	private JTextField txtTipoElemento;
	private JTextField txtTiempoLimite;
	private JTextField txtDiasAnticipacion;
	private JComboBox comboBox;
	private JButton btnAgregar;
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
			
		JLabel lblIdTipoElemento = new JLabel("Id Tipo Elemento");
		JLabel lblElemento = new JLabel("Elemento");
		JLabel lblTipoElemento = new JLabel("Tipo Elemento");
		JLabel lblTiempoLimite = new JLabel("Tiempo Limite");
		JLabel lblDiasAnticipacion = new JLabel("Dias Anticipacion");
		
		txtIdTipoElemento = new JTextField();
		txtIdTipoElemento.setEditable(false);
		txtIdTipoElemento.setColumns(10);
		 
		JComboBox comboBox = new JComboBox();
		
		txtTipoElemento = new JTextField();
		txtTipoElemento.setColumns(10);

		txtTiempoLimite = new JTextField();
		txtTiempoLimite.setColumns(10);
		
		JTextField txtDiasAnticipacion = new JTextField();
		txtDiasAnticipacion.setColumns(10); 
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				agregarClick();
			}
		});
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarClick();
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarClick();
			}
		});
		

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblIdTipoElemento)
								.addGap(58)
								.addComponent(txtIdTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblTiempoLimite)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtTiempoLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblDiasAnticipacion)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtDiasAnticipacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblTipoElemento)
									.addComponent(lblElemento))
								.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtTipoElemento))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAgregar)
							.addGap(43)
							.addComponent(btnEliminar)
							.addGap(45)
							.addComponent(btnModificar)))
					.addContainerGap(121, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdTipoElemento)
						.addComponent(txtIdTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblElemento)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTipoElemento)
						.addComponent(txtTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTiempoLimite)
						.addComponent(txtTiempoLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDiasAnticipacion)
						.addComponent(txtDiasAnticipacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnEliminar)
						.addComponent(btnModificar))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		cargarListas();
	}
	 private void cargarListas (){
		 try {
			 this.comboBox.setModel(new DefaultComboBoxModel(ctrl.getElemento().toArray()));
			  this.comboBox.setSelectedIndex(-1);
		 }catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
	 }
	protected void agregarClick() {
		TipoElemento te = this.mapearDeForm();
		try {
			ctrl.add(te);
			notificar ("Tipo de Elemento creado con exito ");
			mapearDeForm();
			limpiarCampos();
			
		} catch(Exception e ){
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	
		this.txtIdTipoElemento.setText(String.valueOf(te.getId_TE()));
		
	}

	protected void borrarClick(){
		try{ 
			TipoElemento te = mapearDeForm();
			ctrl.delete(te);
			notificar("Tipo de elemento eliminada con exito ");
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
			notificar("Tipo de Elemento  modificado con exito");
			this.limpiarCampos();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void mapearAForm (TipoElemento te){
		this.txtIdTipoElemento.setText(String.valueOf(te.getId_TE()));
		this.comboBox.setSelectedItem(te.getElemento());
		this.txtTipoElemento.setText(te.getNombre_TE());
		this.txtTiempoLimite.setText(String.valueOf(te.getTiempo_limite()));
		this.txtDiasAnticipacion.setText(String.valueOf(te.getDias_anticipacion()));		
	}

	private TipoElemento mapearDeForm(){
		TipoElemento te = new TipoElemento();
		if(!this.txtIdTipoElemento.getText().isEmpty()){  
		  te.setId_TE(Integer.parseInt(this.txtIdTipoElemento.getText()));
		}
		if (comboBox.getSelectedIndex() != -1){
			te.setElemento((Elemento)this.comboBox.getSelectedItem());
		}
		te.setNombre_TE(this.txtTipoElemento.getText());
	    te.setTiempo_limite(Integer.parseInt(this.txtTiempoLimite.getText()));
	    te.setDias_anticipacion(Integer.parseInt(this.txtDiasAnticipacion.getText()));
        return te;
	 }

	
	public void showTipoElemento(TipoElemento te){
		this.mapearAForm(te);
	}
	private void limpiarCampos(){
		this.txtTipoElemento.setText("");
		this.txtTiempoLimite.setText("");
		this.txtDiasAnticipacion.setText("");
	}
	public void notificar(String mensaje) {
		JOptionPane.showMessageDialog(this.frame, mensaje);
	}

}
