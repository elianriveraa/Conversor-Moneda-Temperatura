package GUIs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ConversorTemperatura extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorTemperatura frame = new ConversorTemperatura();
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
	public ConversorTemperatura() {
		setBounds(100, 100, 450, 300);

	}

}
