package com.decode.pago;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.objects.Anuncio;
import com.decode.objects.Apartamento;
import com.decode.objects.Localidad;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class VentanaPagar extends JFrame {

	private JPanel contentPane;
	private DBManager dbm;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPagar frame = new VentanaPagar();
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
	public VentanaPagar() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 1289, 809);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		ImageIcon ico1= new ImageIcon("imagenes/tonyespañol.png");
		
		JLabel lblIntro = new JLabel("Seleccione el metodo de pago que desea");
		lblIntro.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIntro.setBounds(31, 121, 576, 55);
		contentPane.add(lblIntro);
		
		JButton btnGuardar = new JButton("Confirmar pago");
		btnGuardar.setBounds(1061, 674, 130, 37);
		contentPane.add(btnGuardar);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pagar contrarembolso (en mano el dia de la entrega de llaves)");
		rdbtnNewRadioButton.setBounds(41, 188, 426, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Tarjeta de credito ");
		rdbtnNewRadioButton_1.setBounds(40, 223, 199, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel = new JLabel("Nombre y apellidos: ");
		lblNewLabel.setBounds(41, 283, 232, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(41, 311, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de tarjeta de credito:");
		lblNewLabel_1.setBounds(41, 426, 184, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(41, 453, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de caducidad:");
		lblNewLabel_2.setBounds(41, 508, 138, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(41, 534, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CVV:");
		lblNewLabel_3.setBounds(41, 572, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(41, 600, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion de facrturacion: ");
		lblNewLabel_4.setBounds(41, 349, 184, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(41, 377, 130, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.setBounds(345, 239, 117, 29);
		contentPane.add(btnNewButton);
		
		if (rdbtnNewRadioButton.isSelected()==true) {
			lblNewLabel.setVisible(true);
			textField.setVisible(true);
			lblNewLabel_4.setVisible(true);
			textField_4.setVisible(true);
			lblNewLabel_1.setVisible(false);
			textField_1.setVisible(false);
			lblNewLabel_2.setVisible(false);
			textField_2.setVisible(false);
			lblNewLabel_3.setVisible(false);
			textField_3.setVisible(false);
			
		}else if(rdbtnNewRadioButton_1.isSelected()==true) {
			lblNewLabel.setVisible(true);
			textField.setVisible(true);
			lblNewLabel_4.setVisible(true);
			textField_4.setVisible(true);
			lblNewLabel_1.setVisible(true);
			textField_1.setVisible(true);
			lblNewLabel_2.setVisible(true);
			textField_2.setVisible(true);
			lblNewLabel_3.setVisible(true);
			textField_3.setVisible(true);
			
		}else {
			lblNewLabel.setVisible(false);
			textField.setVisible(false);
			lblNewLabel_4.setVisible(false);
			textField_4.setVisible(false);
			lblNewLabel_1.setVisible(false);
			textField_1.setVisible(false);
			lblNewLabel_2.setVisible(false);
			textField_2.setVisible(false);
			lblNewLabel_3.setVisible(false);
			textField_3.setVisible(false);

			
		}
		
		
		
	}
}



