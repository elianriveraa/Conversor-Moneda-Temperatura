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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
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

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/iconos64/abstract.png")));
		setTitle("Conversor de Moneda - Temperatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Conversores");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Conversor de Moneda");
		mntmNewMenuItem.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos16/flujo-de-dinero.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Conversor de Temperatura");
		mntmNewMenuItem_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos16/temperature16.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Salir");
		mntmNewMenuItem_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos16/logout.png")));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Acerca de");
		mntmNewMenuItem_3.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos16/website16.png")));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(231, 237, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Conversor Moneda");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos24/money-exchange.png")));
		btnNewButton.setBackground(new Color(234, 242, 134));
		
		JButton btnNewButton_1 = new JButton("Conversor Temperatura");
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/iconos24/hot.png")));
		btnNewButton_1.setBackground(new Color(243, 138, 133));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED, 3, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
					.addGap(68))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(63))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
