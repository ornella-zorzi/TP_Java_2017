package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class ABMCElementoDesktop extends JInternalFrame {

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
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("New label");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);

	}

}
