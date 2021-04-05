package VentanaPrincipal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;



import javax.swing.JMenuBar;
import java.awt.Rectangle;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;

public class VentanaPrincipal extends JFrame  {
	private JTextField textField;
	
	/**
	 * Ejecutamos la aplicación.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaPrincipal() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 62));
		getContentPane().setLayout(null);
		setBounds(300, 200, 1289, 809);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1066, 3, -1066, 696);
		getContentPane().add(scrollPane);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBounds(0, 3, 1273, 106);
		getContentPane().add(panelNorte);
		panelNorte.setBackground(Color.BLUE);
		panelNorte.setLayout(null);
		
		JLabel lblTitulo = new JLabel("SKAPABOOKING.COM");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(10, 0, 250, 37);
		panelNorte.add(lblTitulo);
		
		JLabel lblMoneda = new JLabel("EUR");
		lblMoneda.setForeground(Color.WHITE);
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMoneda.setBounds(765, 8, 46, 24);
		panelNorte.add(lblMoneda);
		
		JLabel lblBandera = new JLabel("New label");
		lblBandera.setIcon(new ImageIcon("C:\\Users\\mikel\\Downloads\\descarga.png"));
		lblBandera.setBounds(821, 11, 40, 27);
		panelNorte.add(lblBandera);
		
		JButton btnRegistro = new JButton("Hazte cuenta");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistro.setBounds(960, 13, 117, 23);
		panelNorte.add(btnRegistro);
		
		JButton btnLogin = new JButton("Iniciar Sesion");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(1087, 13, 123, 23);
		panelNorte.add(btnLogin);
		
		ImageIcon ico1= new ImageIcon("imagenes/tonyespañol.png");//meter las rutas en la bd
		
		ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblBandera.getWidth(), lblBandera.getHeight(), Image.SCALE_SMOOTH));
		lblBandera.setIcon(img1);
		
		JPanel panelOeste = new JPanel();
		panelOeste.setBounds(0, 150, 323, 392);
		getContentPane().add(panelOeste);
		panelOeste.setBackground(Color.ORANGE);
		panelOeste.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(10, 11, 88, 23);
		panelOeste.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Destino / Nombre alojamiento:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 45, 247, 23);
		panelOeste.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(12, 66, 274, 30);
		panelOeste.add(textField);
		textField.setColumns(10);
		
		
	}
}
