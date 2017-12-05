package ui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

import controlers.CtrlABMCReserva;
import entity.Reserva;
import entity.Elemento;
import entity.Persona;
import entity.TipoElemento;

import java.awt.Color;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;

public class ListadoReserva extends JInternalFrame {
	
	private ArrayList<Reserva> res;
	CtrlABMCReserva ctrl= new CtrlABMCReserva();
	
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ListadoReserva() {
		setIconifiable(true);
		setTitle("Listado Reserva");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 507, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEditarClick();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(368, Short.MAX_VALUE)
					.addComponent(btnEditar)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(groupLayout);
		
		try{
			this.res=ctrl.getAll();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		initDataBindings();
	}
	protected void btnEditarClick() {
		int indexReserva=table.convertRowIndexToModel(table.getSelectedRow());
		
		ABMCReservaDesktop rd= new ABMCReservaDesktop();
		rd.showReserva(this.res.get(indexReserva));
		
		this.getDesktopPane().add(rd);
		rd.setVisible(true);
		
		
	}
	protected void initDataBindings() {
		JTableBinding<Reserva, List<Reserva>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, res, table);
		//
		BeanProperty<Reserva, String> reservaBeanProperty = BeanProperty.create("tipoelemento.nombre_TE");
		jTableBinding.addColumnBinding(reservaBeanProperty).setColumnName("nombre te").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_1 = BeanProperty.create("elemento.nombre_El");
		jTableBinding.addColumnBinding(reservaBeanProperty_1).setColumnName("nombre el").setEditable(false);
		//
		BeanProperty<Reserva, Date> reservaBeanProperty_2 = BeanProperty.create("fecha");
		jTableBinding.addColumnBinding(reservaBeanProperty_2).setColumnName("fecha").setEditable(false);
		//
		BeanProperty<Reserva, Time> reservaBeanProperty_3 = BeanProperty.create("hora");
		jTableBinding.addColumnBinding(reservaBeanProperty_3).setColumnName("hora").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_4 = BeanProperty.create("detalle");
		jTableBinding.addColumnBinding(reservaBeanProperty_4).setColumnName("detalle").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_5 = BeanProperty.create("estado");
		jTableBinding.addColumnBinding(reservaBeanProperty_5).setColumnName("estado").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_6 = BeanProperty.create("persona.apellido");
		jTableBinding.addColumnBinding(reservaBeanProperty_6).setColumnName("Apellido");
		//
		BeanProperty<Reserva, String> reservaBeanProperty_7 = BeanProperty.create("persona.nombre");
		jTableBinding.addColumnBinding(reservaBeanProperty_7).setColumnName("Nombre");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}