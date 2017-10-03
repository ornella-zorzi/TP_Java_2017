package ui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

import controlers.CtrlABMCTipoElemento;
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

public class ListadoTipoElementos extends JInternalFrame {
	
	private ArrayList<TipoElemento> tels;
	CtrlABMCTipoElemento ctrl= new CtrlABMCTipoElemento();
	
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ListadoTipoElementos() {
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Listado TipoElementos");
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
			this.tels=ctrl.getAll();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		initDataBindings();
	}
	protected void btnEditarClick() {
		int indexTipoElemento=table.convertRowIndexToModel(table.getSelectedRow());
		
		ABMCTipoElementoDesktop ted= new ABMCTipoElementoDesktop();
		ted.showTipoElemento(this.tels.get(indexTipoElemento));
		
		this.getDesktopPane().add(ted);
		ted.setVisible(true);
		
	}
	protected void initDataBindings() {
		JTableBinding<TipoElemento, List<TipoElemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, tels, table);
		//
		BeanProperty<TipoElemento, String> TipoElementoBeanProperty = BeanProperty.create("nombre_TE");
		jTableBinding.addColumnBinding(TipoElementoBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<TipoElemento, Integer> TipoElementoBeanProperty_1 = BeanProperty.create("cant_reserva_max");
		jTableBinding.addColumnBinding(TipoElementoBeanProperty_1).setColumnName("cant reserva max").setEditable(false);
		//
		BeanProperty<TipoElemento, Integer> TipoElementoBeanProperty_2 = BeanProperty.create("tiempo_limite");
		jTableBinding.addColumnBinding(TipoElementoBeanProperty_2).setColumnName("tiempo limite").setEditable(false);
		//
		BeanProperty<TipoElemento, Integer> TipoElementoBeanProperty_3 = BeanProperty.create("dias_anticipacion");
		jTableBinding.addColumnBinding(TipoElementoBeanProperty_3).setColumnName("dias anticipacion").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}