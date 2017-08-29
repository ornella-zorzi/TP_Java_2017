package ui;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ABMCTipoElementoDesktop extends JInternalFrame {
	private JTextField txtIdTipoElemento;
	private JTextField txtNombreTipoElemento;
	private JTextField txtTiempoLimite;
	private JTextField txtDiasAnticipacion;

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
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);	
		setBounds(100, 100, 450, 326);
		
		JLabel lblId_TipoElemento = new JLabel("IdTipoElemento");	
		txtIdTipoElemento = new JTextField();
		txtIdTipoElemento.setEditable(false);
		txtIdTipoElemento.setColumns(10);
		
		JLabel lblElemento = new JLabel("Elemento");	
		JComboBox cboElemento = new JComboBox();
		
		JLabel lblNombreTipoElemento = new JLabel("Nombre Tipo Elemento");
		txtNombreTipoElemento = new JTextField();
		txtNombreTipoElemento.setColumns(10);
		
		JLabel lblTiempoLimite = new JLabel("Tiempo Limite");
		txtTiempoLimite = new JTextField();
		txtTiempoLimite.setColumns(10);
		
		JLabel lblDiasAnticipacion = new JLabel("Dias Anticipacion");
		txtDiasAnticipacion = new JTextField();
		txtDiasAnticipacion.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarClick();
			}
		});
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNombreTipoElemento)
							.addGap(26)
							.addComponent(txtNombreTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
							.addComponent(btnBuscar)
							.addGap(27))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAgregar)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblId_TipoElemento)
										.addComponent(lblElemento)
										.addComponent(lblTiempoLimite)
										.addComponent(lblDiasAnticipacion))
									.addGap(31)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtDiasAnticipacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTiempoLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(cboElemento, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(txtIdTipoElemento))
										.addComponent(btnEliminar))))
							.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
							.addComponent(btnModificar)
							.addGap(95))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId_TipoElemento)
						.addComponent(txtIdTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblElemento)
						.addComponent(cboElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreTipoElemento)
						.addComponent(txtNombreTipoElemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTiempoLimite)
						.addComponent(txtTiempoLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiasAnticipacion)
						.addComponent(txtDiasAnticipacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnEliminar)
						.addComponent(btnModificar))
					.addGap(31))
		);
		getContentPane().setLayout(groupLayout);
		cargarListas();

	}
	private void cargarListas(){
	/*	try{ this.cboElemento.setModel(new DefaultComboBoxModel(ctrl.getCategoria().toArray()));
				this.cboCategoria.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}*/
	}
	protected void buscarClick() {
		/* try {
			this.mapearAForm(ctrl.getByDni(this.mapearDeForm()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		*/
	}
	protected void agregarClick(){
		
	}
	protected void borrarClick(){
		
	}
	protected void modificarClick(){
		
	}
}
