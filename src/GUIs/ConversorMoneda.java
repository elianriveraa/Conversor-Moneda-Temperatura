package GUIs;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;

public class ConversorMoneda extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorMoneda frame = new ConversorMoneda();
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
	public ConversorMoneda() {
		setFrameIcon(new ImageIcon(ConversorMoneda.class.getResource("/iconos64/flujo-de-dinero64.png")));
		setTitle("Conversor de Moneda");
		setBounds(100, 100, 450, 300);

	}

}
