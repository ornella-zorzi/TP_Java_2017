package ui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

import controlers.CtrlABMCElemento;
import entity.Elemento;
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

public class ListadoElementos extends JInternalFrame {
	
	private ArrayList<Elemento> elems;
	CtrlABMCElemento ctrl= new CtrlABMCElemento();
	
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ListadoElementos() {
		setIconifiable(true);
		setTitle("Listado Elementos");
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
			this.elems=ctrl.getAll();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		initDataBindings();
	}
	protected void btnEditarClick() {
		int indexElemento=table.convertRowIndexToModel(table.getSelectedRow());
		
		ABMCElementoDesktop ed= new ABMCElementoDesktop();
		ed.showElemento(this.elems.get(indexElemento));
		
		this.getDesktopPane().add(ed);
		ed.setVisible(true);
		
	}
	protected void initDataBindings() {
		JTableBinding<Elemento, List<Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, elems, table);
		//
		BeanProperty<Elemento, String> elementoBeanProperty = BeanProperty.create("nombre_el");
		jTableBinding.addColumnBinding(elementoBeanProperty).setColumnName("nombre").setEditable(false);
		//
	
		BeanProperty<Elemento, String> elementoBeanProperty_1 = BeanProperty.create("tipo_elemento.nombre_te");
		jTableBinding.addColumnBinding(elementoBeanProperty_1).setColumnName("TipoElemento").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}