package GUIs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ConversorMoneda extends JFrame {

	private JPanel contentPane;
	private JTextField ingresoDatos1;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblALaDivisa;
	private JLabel lblNewLabel_1;
	private JButton btnRegresar;
	private MenuPrincipal ventanamenu;
	private String lista1,lista2;
	private double valorIngresado;
	private JButton btnConvertir;
	private JLabel labelResultado;
	private double resultado;
	

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
	
	void designGUI() {
		setTitle("Conversor de Moneda");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConversorMoneda.class.getResource("/iconos64/flujo-de-dinero64.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> listaOp1 = new JComboBox<String>();
		listaOp1.setBackground(Color.LIGHT_GRAY);
		listaOp1.setFont(new Font("Arial", Font.BOLD, 16));
		listaOp1.setBounds(37, 134, 175, 32);
		contentPane.add(listaOp1);
		listaOp1.addItem("---");
		listaOp1.addItem("Peso COP");
		listaOp1.addItem("Dolar");
		listaOp1.addItem("Euros");
		listaOp1.addItem("Libra Esterlina");
		listaOp1.addItem("Yen Japonés");
		listaOp1.addItem("Won sul-coreano");
		listaOp1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == listaOp1) {
					lista1 = (String) listaOp1.getSelectedItem();
					setLista1(lista1);
				}
			}
		});
		
		JComboBox<String> listaOp2 = new JComboBox<String>();
		listaOp2.setBackground(Color.LIGHT_GRAY);
		listaOp2.setFont(new Font("Arial", Font.BOLD, 16));
		listaOp2.setBounds(222, 134, 170, 32);
		contentPane.add(listaOp2);
		listaOp2.addItem("---");
		listaOp2.addItem("Peso COP");
		listaOp2.addItem("Dolar");
		listaOp2.addItem("Euros");
		listaOp2.addItem("Libra Esterlina");
		listaOp2.addItem("Yen Japonés");
		listaOp2.addItem("Won sul-coreano");
		listaOp2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == listaOp2) {
					lista2 = (String) listaOp2.getSelectedItem();
					setLista2(lista2);
				}
			}
		});
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 52, 416, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ingresoDatos1 = new JTextField();
		num(ingresoDatos1);
		ingresoDatos1.setHorizontalAlignment(SwingConstants.CENTER);
		ingresoDatos1.setBounds(25, 10, 357, 39);
		panel.add(ingresoDatos1);
		ingresoDatos1.setBackground(Color.LIGHT_GRAY);
		ingresoDatos1.setFont(new Font("Arial", Font.BOLD, 16));
		ingresoDatos1.setColumns(10);
		
		lblNewLabel = new JLabel("Desde la divisa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(37, 110, 170, 24);
		contentPane.add(lblNewLabel);
		
		lblALaDivisa = new JLabel("A la divisa");
		lblALaDivisa.setHorizontalAlignment(SwingConstants.CENTER);
		lblALaDivisa.setFont(new Font("Arial", Font.BOLD, 16));
		lblALaDivisa.setBounds(217, 110, 175, 24);
		contentPane.add(lblALaDivisa);
		
		lblNewLabel_1 = new JLabel("Cantidad a convertir");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel_1.setBounds(119, 27, 194, 24);
		contentPane.add(lblNewLabel_1);
		
		btnRegresar = new JButton("");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegresarMenu();
			}
		});
		btnRegresar.setIcon(new ImageIcon(ConversorMoneda.class.getResource("/iconos64/regresar(32).png")));
		btnRegresar.setBounds(10, 10, 32, 32);
		contentPane.add(btnRegresar);
		
		
		
		btnConvertir = new JButton("Convertir");
		btnConvertir.setBackground(Color.LIGHT_GRAY);
		
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorIngresado = Double.parseDouble(ingresoDatos1.getText());
				setValorIngresado(valorIngresado);
				pesocop(valorIngresado);
				labelResultado.setText(String.valueOf(getResultado()));
			}
		});
		btnConvertir.setFont(new Font("Arial", Font.BOLD, 16));
		btnConvertir.setBounds(151, 176, 126, 33);
		contentPane.add(btnConvertir);
		
		labelResultado = new JLabel("");
		labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultado.setFont(new Font("Arial", Font.BOLD, 24));
		labelResultado.setBounds(37, 227, 355, 51);
		contentPane.add(labelResultado);
	}
	
	private void num(JTextField a) {
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
	}
	
	public void habilitarConvertir() {
		if(!ingresoDatos1.getText().isEmpty()) {
			btnConvertir.setEnabled(true);
		} else {
			btnConvertir.setEnabled(false);
		}
	}
	
	public double pesocop(double valor) {
		double copdolar = 0.00021, copeuro = 0.00020, coplibra = 0.00017, copyen = 0.028, copwon = 0.27;
		double dolcop = 4745.28, doleuro = 0.93, dollibra = 0.82, dolyen = 130.74, dolwon = 1295.74;
		double eurcop = 5110.29, eurdolar = 1.08, eurlibra = 0.88, euryen = 140.71, eurwon = 1393.12;
		double libcop = 5807.05, libdolar = 1.22, libeuro = 1.14, libyen = 159.89, libwon = 1585.02;
		double yencop = 36.33, yendolar = 0.0076, yeneuro = 0.0071, yenlibra = 0.0063, yenwon = 9.91;
		double woncop = 36.33, wondolar = 0.0076, woneuro = 0.0071, wonlibra = 0.0063, wonyen = 9.91;
		if((getLista1() == "---" || getLista2() == null) || (getLista1() == null || getLista2() == "---")){
			JOptionPane.showMessageDialog(null, "Rellenar campos faltantes");
		} else if(getLista1() == "Peso COP" && getLista2() == "Peso COP") {
			resultado = valor * 1;
			setResultado(resultado);
		} else if(getLista1() == "Peso COP" && getLista2() == "Dolar") {
			resultado = valor * copdolar;
			setResultado(resultado);
		} else if(getLista1() == "Peso COP" && getLista2() == "Euros") {
			resultado = valor * copeuro;
			setResultado(resultado);
		} else if(getLista1() == "Peso COP" && getLista2() == "Libra Esterlina") {
			resultado = valor * coplibra;
			setResultado(resultado);
		} else if(getLista1() == "Peso COP" && getLista2() == "Yen Japonés") {
			resultado = valor * copyen;
			setResultado(resultado);
		} else if(getLista1() == "Peso COP" && getLista2() == "Won sul-coreano") {
			resultado = valor * copwon;
			setResultado(resultado);
		} else if(getLista1() == "Dolar" && getLista2() == "Dolar") {
			resultado = valor * 1;
			setResultado(resultado);
		} else if(getLista1() == "Dolar" && getLista2() == "Peso COP") {
			resultado = valor * dolcop;
			setResultado(resultado);
		} else if(getLista1() == "Dolar" && getLista2() == "Euros") {
			resultado = valor * doleuro;
			setResultado(resultado);
		} else if(getLista1() == "Dolar" && getLista2() == "Libra Esterlina") {
			resultado = valor * dollibra;
			setResultado(resultado);
		} else if(getLista1() == "Dolar" && getLista2() == "Yen Japonés") {
			resultado = valor * dolyen;
			setResultado(resultado);
		} else if(getLista1() == "Dolar" && getLista2() == "Won sul-coreano") {
			resultado = valor * dolwon;
			setResultado(resultado);
		} else if(getLista1() == "Euros" && getLista2() == "Euros") {
			resultado = valor * 1;
			setResultado(resultado);
		} else if(getLista1() == "Euros" && getLista2() == "Peso COP") {
			resultado = valor * eurcop;
			setResultado(resultado);
		} else if(getLista1() == "Euros" && getLista2() == "Dolar") {
			resultado = valor * eurdolar;
			setResultado(resultado);
		} else if(getLista1() == "Euros" && getLista2() == "Libra Esterlina") {
			resultado = valor * eurlibra;
			setResultado(resultado);
		} else if(getLista1() == "Euros" && getLista2() == "Yen Japonés") {
			resultado = valor * euryen;
			setResultado(resultado);
		} else if(getLista1() == "Euros" && getLista2() == "Won sul-coreano") {
			resultado = valor * eurwon;
			setResultado(resultado);
		} else if(getLista1() == "Libra Esterlina" && getLista2() == "Libra Esterlina") {
			resultado = valor * 1;
			setResultado(resultado);
		} else if(getLista1() == "Libra Esterlina" && getLista2() == "Peso COP") {
			resultado = valor * libcop;
			setResultado(resultado);
		} else if(getLista1() == "Libra Esterlina" && getLista2() == "Dolar") {
			resultado = valor * libdolar;
			setResultado(resultado);
		} else if(getLista1() == "Libra Esterlina" && getLista2() == "Euros") {
			resultado = valor * libeuro;
			setResultado(resultado);
		} else if(getLista1() == "Libra Esterlina" && getLista2() == "Yen Japonés") {
			resultado = valor * libyen;
			setResultado(resultado);
		} else if(getLista1() == "Libra Esterlina" && getLista2() == "Won sul-coreano") {
			resultado = valor * libwon;
			setResultado(resultado);
		} else if(getLista1() == "Yen Japonés" && getLista2() == "Yen Japonés") {
			resultado = valor * 1;
			setResultado(resultado);
		} else if(getLista1() == "Yen Japonés" && getLista2() == "Peso COP") {
			resultado = valor * yencop;
			setResultado(resultado);
		} else if(getLista1() == "Yen Japonés" && getLista2() == "Dolar") {
			resultado = valor * yendolar;
			setResultado(resultado);
		} else if(getLista1() == "Yen Japonés" && getLista2() == "Euros") {
			resultado = valor * yeneuro;
			setResultado(resultado);
		} else if(getLista1() == "Yen Japonés" && getLista2() == "Libra Esterlina") {
			resultado = valor * yenlibra;
			setResultado(resultado);
		} else if(getLista1() == "Yen Japonés" && getLista2() == "Won sul-coreano") {
			resultado = valor * yenwon;
			setResultado(resultado);
		} else if(getLista1() == "Won sul-coreano" && getLista2() == "Won sul-coreano") {
			resultado = valor * 1;
			setResultado(resultado);
		} else if(getLista1() == "Won sul-coreano" && getLista2() == "Peso COP") {
			resultado = valor * woncop;
			setResultado(resultado);
		} else if(getLista1() == "Won sul-coreano" && getLista2() == "Dolar") {
			resultado = valor * wondolar;
			setResultado(resultado);
		} else if(getLista1() == "Won sul-coreano" && getLista2() == "Euros") {
			resultado = valor * woneuro;
			setResultado(resultado);
		} else if(getLista1() == "Won sul-coreano" && getLista2() == "Libra Esterlina") {
			resultado = valor * wonlibra;
			setResultado(resultado);
		} else if(getLista1() == "Won sul-coreano" && getLista2() == "Yen Japonés") {
			resultado = valor * wonyen;
			setResultado(resultado);
		}
		return 0;
	}

	/**
	 * Create the frame.
	 */
	public ConversorMoneda() {
		designGUI();
		this.setLocationRelativeTo(null);
		btnConvertir.setEnabled(false);
	}
	
	void RegresarMenu() {
		ventanamenu = new MenuPrincipal();
		ventanamenu.setVisible(true);
		this.dispose();
	}

	public String getLista1() {
		return lista1;
	}

	public void setLista1(String lista1) {
		this.lista1 = lista1;
	}

	public String getLista2() {
		return lista2;
	}

	public void setLista2(String lista2) {
		this.lista2 = lista2;
	}

	public double getValorIngresado() {
		return valorIngresado;
	}

	public void setValorIngresado(double valorIngresado) {
		this.valorIngresado = valorIngresado;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}	
}