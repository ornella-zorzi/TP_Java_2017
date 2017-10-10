package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.GroupLayout;
//import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;

public class MainWindow {

	private JFrame frmGestionDeReservas;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmGestionDeReservas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDeReservas = new JFrame();
		frmGestionDeReservas.setTitle("Gestion de Reservas");
		frmGestionDeReservas.setBounds(100, 100, 450, 300);
		frmGestionDeReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		desktopPane = new JDesktopPane();
		frmGestionDeReservas.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frmGestionDeReservas.setJMenuBar(menuBar);
		
		JMenu mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		JMenuItem mntmAbmcpersona = new JMenuItem("ABMCPersona");
		mntmAbmcpersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuABMCPersonaClick();
			}
		});
		mnPersona.add(mntmAbmcpersona);
		
		JMenuItem mntmListadopersonas = new JMenuItem("ListadoPersonas");
		mntmListadopersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuListadoPersonaClick();
			}
		});
		mnPersona.add(mntmListadopersonas);
		
		JMenu mnElemento = new JMenu("Elemento");
		menuBar.add(mnElemento);
		
		JMenuItem mntmAbmcelemento = new JMenuItem("ABMCElemento");
		mntmAbmcelemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuABMCElementoClick();
			}
		});
		mnElemento.add(mntmAbmcelemento);
		
		JMenuItem mntmListadoElementos = new JMenuItem("Listado Elementos");
		mntmListadoElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuListadoElementoClick();
			}
		});
		mnElemento.add(mntmListadoElementos);
		
		JMenu mnTipoElemento = new JMenu("Tipo Elemento");
		menuBar.add(mnTipoElemento);
		
		JMenuItem mntmAbmctipoelemento= new JMenuItem("ABMCTipoElemento");
		mntmAbmctipoelemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuABMCTipoElementoClick();
			}
		});
		mnTipoElemento.add(mntmAbmctipoelemento);
		
		JMenuItem mntmListadoTipoElementos = new JMenuItem("Listado Tipo Elementos");
		mntmListadoTipoElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuListadoTipoElementoClick();
			}
		});
		mnTipoElemento.add(mntmListadoTipoElementos);
		
		JMenu mnReserva = new JMenu("Reserva");
		menuBar.add(mnReserva);
		
		JMenuItem mntmAbmcReserva = new JMenuItem("ABMCReserva");
		mntmAbmcReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuABMCReservaClick();
			}
		});
		mnReserva.add(mntmAbmcReserva);
	}
	protected void mnuABMCPersonaClick() {
		ABMCPersonaDesktop pd= new ABMCPersonaDesktop();
		desktopPane.add(pd);
		pd.setVisible(true);
	}
	protected void mnuABMCElementoClick() {
		ABMCElementoDesktop ed= new ABMCElementoDesktop();
		desktopPane.add(ed);
		ed.setVisible(true);
	}
	protected void mnuListadoPersonaClick() {
		ListadoPersonas lp= new ListadoPersonas();
		desktopPane.add(lp);
		lp.setVisible(true);
	}
	protected void mnuListadoTipoElementoClick() {
		ListadoTipoElementos lte= new ListadoTipoElementos();
		desktopPane.add(lte);
		lte.setVisible(true);
	}
	protected void mnuListadoElementoClick() {
		ListadoElementos le= new ListadoElementos();
		desktopPane.add(le);
		le.setVisible(true);
	}
	protected void mnuABMCTipoElementoClick() {
		ABMCTipoElementoDesktop ted= new ABMCTipoElementoDesktop();
		desktopPane.add(ted);
		ted.setVisible(true);
	}
	protected void mnuABMCReservaClick() {
		ABMCReservaDesktop rd= new ABMCReservaDesktop();
		desktopPane.add(rd);
		rd.setVisible(true);
	}
}  