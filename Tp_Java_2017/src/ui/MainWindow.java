package ui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;

public class MainWindow {

	private JFrame frame;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		JMenuItem mntmAbmcpersona = new JMenuItem("ABMCPersona");
		mntmAbmcpersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuABMCPersonaClick();
			}
		});
		mnPersona.add(mntmAbmcpersona);
		
		JMenu mnElemento = new JMenu("Elemento");
		menuBar.add(mnElemento);
		
		JMenuItem mntmAbmcelemento = new JMenuItem("ABMCElemento");
		mntmAbmcelemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuABMCElementoClick();
			}
		});
		mnElemento.add(mntmAbmcelemento);
		
		JMenuItem mntmAbmctipoelemento = new JMenuItem("ABMCTipoElemento");
		mntmAbmctipoelemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuABMCTipoElementoClick();
			}
		});
		mnElemento.add(mntmAbmctipoelemento);
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
	protected void mnuABMCTipoElementoClick() {
		ABMCTipoElementoDesktop ted= new ABMCTipoElementoDesktop();
		desktopPane.add(ted);
		ted.setVisible(true);
	}
}  