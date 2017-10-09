package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ListadoReserva extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoReserva frame = new ListadoReserva();
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
	public ListadoReserva() {
		setBounds(100, 100, 450, 300);

	}

}
