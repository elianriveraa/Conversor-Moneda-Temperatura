package GUIs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {
	private ConversorMoneda ventanam;
	private ConversorTemperatura ventanat;
	private JPanel panelContenidoMenu;
	
	/*
	 * Inicio de la aplicación
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * Inicio diseño de aplicación
	 */
	
	void designGUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/iconos64/abstract.png")));
		setTitle("Conversor de Moneda - Temperatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuOpciones = new JMenu("Opciones");
		menuBar.add(menuOpciones);
		
		JMenuItem optionConMoneda = new JMenuItem("Conversor de Moneda");
		optionConMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMoneda();
			}
		});
		optionConMoneda.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos16/flujo-de-dinero.png")));
		menuOpciones.add(optionConMoneda);
		
		JMenuItem optionConTemperatura = new JMenuItem("Conversor de Temperatura");
		optionConTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTemperatura();
			}
		});
		optionConTemperatura.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos16/temperature16.png")));
		menuOpciones.add(optionConTemperatura);
		
		JMenuItem optionSalir = new JMenuItem("Salir");
		optionSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir de la aplicación?","Salir"
						,JOptionPane.YES_NO_OPTION)==0)System.exit(0);
			}
		});
		optionSalir.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos16/logout.png")));
		menuOpciones.add(optionSalir);
		
		JMenu menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);
		
		JMenuItem optionAcercade = new JMenuItem("Acerca de");
		optionAcercade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Desarrollado por: Elian Rivera");
			}
		});
		optionAcercade.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos16/website16.png")));
		menuAyuda.add(optionAcercade);
		panelContenidoMenu = new JPanel();
		panelContenidoMenu.setBackground(new Color(231, 237, 234));
		panelContenidoMenu.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelContenidoMenu);
		
		JButton BtnConMoneda = new JButton("Conversor Moneda");
		BtnConMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMoneda();
			}
		});
		BtnConMoneda.setFont(new Font("Arial", Font.BOLD, 16));
		BtnConMoneda.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos24/money-exchange.png")));
		BtnConMoneda.setBackground(new Color(234, 242, 134));
		
		JButton btnConTemperatura = new JButton("Conversor Temperatura");
		btnConTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTemperatura();
			}
		});
		btnConTemperatura.setFont(new Font("Arial", Font.BOLD, 16));
		btnConTemperatura.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos24/hot.png")));
		btnConTemperatura.setBackground(new Color(243, 138, 133));
		GroupLayout gl_panelContenidoMenu = new GroupLayout(panelContenidoMenu);
		gl_panelContenidoMenu.setHorizontalGroup(
			gl_panelContenidoMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContenidoMenu.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_panelContenidoMenu.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelContenidoMenu.createSequentialGroup()
							.addComponent(btnConTemperatura)
							.addPreferredGap(ComponentPlacement.RELATED, 3, GroupLayout.PREFERRED_SIZE))
						.addComponent(BtnConMoneda, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
					.addGap(68))
		);
		gl_panelContenidoMenu.setVerticalGroup(
			gl_panelContenidoMenu.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelContenidoMenu.createSequentialGroup()
					.addGap(46)
					.addComponent(BtnConMoneda)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnConTemperatura, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(63))
		);
		panelContenidoMenu.setLayout(gl_panelContenidoMenu);
	}

	
	public MenuPrincipal() {
		designGUI();
		this.setLocationRelativeTo(null);
	}
	
	void cargarMoneda() {
		ventanam = new ConversorMoneda();
		//ventanam.show();
		ventanam.setVisible(true);
		this.dispose();
	}
	
	void cargarTemperatura() {
		ventanat = new ConversorTemperatura();
		//ventanam.show();
		ventanat.setVisible(true);
		this.dispose();
	}
}