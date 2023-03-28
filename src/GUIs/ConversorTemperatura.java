package GUIs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConversorTemperatura extends JFrame {

	private JPanel contentPane;
	private JTextField textCelsius;
	private JTextField textFahrenheit;
	private JTextField textKelvin;
	private JTextField textRankine;
	private MenuPrincipal ventanamenu;
	private double valorCelsius, celsius, fahrenheit, kelvin, rankine, resultado;

	

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
	
	void designGUI() {
		setTitle("Conversor de Temperatura");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConversorTemperatura.class.getResource("/iconos64/temperature.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegresar = new JButton("");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegresarMenu();
			}
		});
		btnRegresar.setIcon(new ImageIcon(ConversorTemperatura.class.getResource("/iconos64/regresar(32).png")));
		btnRegresar.setBounds(10, 10, 32, 32);
		contentPane.add(btnRegresar);
		
		JLabel lblNewLabel = new JLabel("Conversión de Temperatura");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 52, 302, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Celsius");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(30, 99, 57, 17);
		contentPane.add(lblNewLabel_1);
		
		textCelsius = new JTextField();
		
		
		textCelsius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				num(textCelsius);
				valorCelsius = Double.parseDouble(textCelsius.getText());
				//operacionCelsius(valorCelsius);
				operacionFahrenheit(valorCelsius);
				textFahrenheit.setText(String.valueOf(operacionFahrenheit(valorCelsius)));
				//textFahrenheit.setText(textCelsius.getText());
				textKelvin.setText(textCelsius.getText());
				textRankine.setText(textCelsius.getText());
				
			}
		});
		textCelsius.setFont(new Font("Arial", Font.BOLD, 14));
		textCelsius.setBounds(27, 117, 210, 32);
		contentPane.add(textCelsius);
		textCelsius.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fahrenheit");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(30, 159, 88, 17);
		contentPane.add(lblNewLabel_1_1);
		
		textFahrenheit = new JTextField();
		textFahrenheit.setFont(new Font("Arial", Font.BOLD, 14));
		textFahrenheit.setColumns(10);
		textFahrenheit.setBounds(27, 177, 210, 32);
		contentPane.add(textFahrenheit);
		
		JLabel lblNewLabel_1_2 = new JLabel("Kelvin");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(30, 219, 57, 17);
		contentPane.add(lblNewLabel_1_2);
		
		textKelvin = new JTextField();
		textKelvin.setFont(new Font("Arial", Font.BOLD, 14));
		textKelvin.setColumns(10);
		textKelvin.setBounds(27, 237, 210, 32);
		contentPane.add(textKelvin);
		
		textRankine = new JTextField();
		textRankine.setFont(new Font("Arial", Font.BOLD, 14));
		textRankine.setColumns(10);
		textRankine.setBounds(27, 297, 210, 32);
		contentPane.add(textRankine);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Rankine");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(30, 279, 63, 17);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("* La conversión de temperatura calcula la");
		lblNewLabel_2.setBounds(30, 339, 240, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("temperatura del cero absoluto o superior.");
		lblNewLabel_2_1.setBounds(30, 352, 240, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Cero absoluto");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(30, 375, 120, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Celsius: -273.15 °C");
		lblNewLabel_2_1_1.setBounds(30, 398, 120, 13);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Fahrenheit: -459.67 °F");
		lblNewLabel_2_1_1_1.setBounds(30, 413, 143, 13);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Kelvin: 0 K");
		lblNewLabel_2_1_1_2.setBounds(30, 430, 120, 13);
		contentPane.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_1_1_3 = new JLabel("Rankine: 0 °R");
		lblNewLabel_2_1_1_3.setBounds(30, 446, 120, 13);
		contentPane.add(lblNewLabel_2_1_1_3);
		
		JButton btnNewButton = new JButton("°C");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(237, 117, 57, 32);
		contentPane.add(btnNewButton);
		
		JButton btnf = new JButton("°F");
		btnf.setFont(new Font("Arial", Font.PLAIN, 12));
		btnf.setBounds(237, 177, 57, 32);
		contentPane.add(btnf);
		
		JButton btnK = new JButton("K");
		btnK.setFont(new Font("Arial", Font.PLAIN, 12));
		btnK.setBounds(237, 237, 57, 32);
		contentPane.add(btnK);
		
		JButton btnr = new JButton("°R");
		btnr.setFont(new Font("Arial", Font.PLAIN, 12));
		btnr.setBounds(237, 297, 57, 32);
		contentPane.add(btnr);
		
		JLabel lblNewLabel_4 = new JLabel("Conversión de Celsius a Fahrenheit");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(331, 124, 210, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("= [°C] x 9/5 + 32");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_4_1.setBounds(372, 147, 143, 13);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("[°F]");
		lblNewLabel_4_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_1_1.setBounds(341, 147, 32, 13);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Conversión de Celsius a Kelvin");
		lblNewLabel_4_2.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_4_2.setBounds(331, 184, 210, 13);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("[K]");
		lblNewLabel_4_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_1_1_1.setBounds(341, 207, 32, 13);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("= [°C] + 273.15");
		lblNewLabel_4_1_2.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_4_1_2.setBounds(372, 207, 143, 13);
		contentPane.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Conversión de Celsius a Rankine");
		lblNewLabel_4_3.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_4_3.setBounds(331, 244, 210, 13);
		contentPane.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("[°R]");
		lblNewLabel_4_1_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_1_1_2.setBounds(341, 267, 32, 13);
		contentPane.add(lblNewLabel_4_1_1_2);
		
		JLabel lblNewLabel_4_1_3 = new JLabel("= [°C] x 9/5 + 491.67");
		lblNewLabel_4_1_3.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_4_1_3.setBounds(382, 267, 169, 13);
		contentPane.add(lblNewLabel_4_1_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("Conversión de Fahrenheit a Celsius");
		lblNewLabel_4_4.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_4_4.setBounds(331, 304, 210, 13);
		contentPane.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_1_1_3 = new JLabel("[°C]");
		lblNewLabel_4_1_1_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_1_1_3.setBounds(341, 327, 32, 13);
		contentPane.add(lblNewLabel_4_1_1_3);
		
		JLabel lblNewLabel_4_1_4 = new JLabel("= ([°F] - 32) x");
		lblNewLabel_4_1_4.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_4_1_4.setBounds(376, 327, 97, 13);
		contentPane.add(lblNewLabel_4_1_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("Conversión de Celsius a Fahrenheit");
		lblNewLabel_4_5.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_4_5.setBounds(331, 364, 210, 13);
		contentPane.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_1_1_4 = new JLabel("[K]");
		lblNewLabel_4_1_1_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_1_1_4.setBounds(341, 387, 32, 13);
		contentPane.add(lblNewLabel_4_1_1_4);
		
		JLabel lblNewLabel_4_1_5 = new JLabel("= ([°C] + 459.67) x");
		lblNewLabel_4_1_5.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_4_1_5.setBounds(372, 387, 143, 13);
		contentPane.add(lblNewLabel_4_1_5);
		
		JLabel lblNewLabel_4_6 = new JLabel("Conversión de Celsius a Fahrenheit");
		lblNewLabel_4_6.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_4_6.setBounds(331, 423, 210, 13);
		contentPane.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_1_1_5 = new JLabel("[°R]");
		lblNewLabel_4_1_1_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_1_1_5.setBounds(341, 446, 32, 13);
		contentPane.add(lblNewLabel_4_1_1_5);
		
		JLabel lblNewLabel_4_1_6 = new JLabel("= [°F] + 459.67");
		lblNewLabel_4_1_6.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_4_1_6.setBounds(372, 446, 143, 13);
		contentPane.add(lblNewLabel_4_1_6);
		
		JLabel lblNewLabel_4_1_4_1 = new JLabel("──");
		lblNewLabel_4_1_4_1.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_4_1_4_1.setBounds(483, 327, 32, 13);
		contentPane.add(lblNewLabel_4_1_4_1);
		
		JLabel lblNewLabel_4_1_4_1_1 = new JLabel("5");
		lblNewLabel_4_1_4_1_1.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_4_1_4_1_1.setBounds(489, 318, 26, 17);
		contentPane.add(lblNewLabel_4_1_4_1_1);
		
		JLabel lblNewLabel_4_1_4_1_2 = new JLabel("9");
		lblNewLabel_4_1_4_1_2.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_4_1_4_1_2.setBounds(489, 337, 26, 17);
		contentPane.add(lblNewLabel_4_1_4_1_2);
		
		JLabel lblNewLabel_4_1_4_1_3 = new JLabel("──");
		lblNewLabel_4_1_4_1_3.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_4_1_4_1_3.setBounds(509, 386, 32, 13);
		contentPane.add(lblNewLabel_4_1_4_1_3);
		
		JLabel lblNewLabel_4_1_4_1_1_1 = new JLabel("5");
		lblNewLabel_4_1_4_1_1_1.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_4_1_4_1_1_1.setBounds(515, 377, 26, 17);
		contentPane.add(lblNewLabel_4_1_4_1_1_1);
		
		JLabel lblNewLabel_4_1_4_1_2_1 = new JLabel("9");
		lblNewLabel_4_1_4_1_2_1.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_4_1_4_1_2_1.setBounds(515, 396, 26, 17);
		contentPane.add(lblNewLabel_4_1_4_1_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Fórmulas para la conversión de escala de temperatura");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_3_1.setBounds(288, 99, 278, 13);
		contentPane.add(lblNewLabel_3_1);
	}
	
	
	public ConversorTemperatura() {
		designGUI();
		this.setLocationRelativeTo(null);
	}
	
	void RegresarMenu() {
		ventanamenu = new MenuPrincipal();
		ventanamenu.setVisible(true);
		this.dispose();
	}
	
	
	private void num(JTextField a) {
	    a.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
	            char c = e.getKeyChar();
	            String text = a.getText();
	            if (!(Character.isDigit(c) || c == '.' || (c == '-' && text.length() == 0))) {
	                e.consume();
	            }
	            if (c == '.' && text.contains(".")) {
	                e.consume();
	            }
	        }
	    });
	}
	
	/*private void num(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c) && c != '.') {
					e.consume();
				}
				if(c == '.' && ingresoDatos1.getText().contains(".")) {
					e.consume();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarConvertir();
			}
		});
	}*/
	
	public double operacionCelsius(double valor) {
		
		return 0;
	}
	
	public double operacionFahrenheit(double valor) {
		fahrenheit = valor * 9/5 + 32;
		if(fahrenheit > -459.67) {
			return fahrenheit;
		} else {
			return 0;
		}
	}
	
	/*public void ecuaciones() {
	textCelsius.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			valorCelsius = Double.parseDouble(textCelsius.getText());
			operacion(valorCelsius);
			textCelsius.setText(textCelsius.getText());
			textFahrenheit.setText(textCelsius.getText());
			textKelvin.setText(textCelsius.getText());
			textRankine.setText(textCelsius.getText());
		}
	});
	}*/
	
	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}	
	
}
