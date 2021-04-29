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
import com.decode.ventanaPrincipal.VentanaPrincipal;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class VentanaPago extends JFrame {

	private JPanel contentPane;
	private DBManager dbm;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPago frame = new VentanaPago();
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
	public VentanaPago() {
		
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
		ImageIcon ico2= new ImageIcon("imagenes/pago-en-efectivo.png");
		ImageIcon ico3 = new ImageIcon("imagenes/tarjeta-de-credito.png");
		
		JLabel lblIntro = new JLabel("Seleccione el metodo de pago que desea");
		lblIntro.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIntro.setBounds(272, 121, 576, 55);
		contentPane.add(lblIntro);
		
		JButton btnGuardar = new JButton("Confirmar pago");
		btnGuardar.setBounds(1061, 674, 130, 37);
		contentPane.add(btnGuardar);
		
		JButton btnContrareembolso = new JButton("Pagar contrarembolso (en mano el dia de la entrega de llaves)");
		btnContrareembolso.setBounds(526, 527, 329, 29);
		contentPane.add(btnContrareembolso);
		
		JButton btnTarjeta = new JButton("Tarjeta de credito");
		btnTarjeta.setBounds(316, 530, 124, 23);
		contentPane.add(btnTarjeta);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(10, 140, 89, 23);
		contentPane.add(btnNewButton);
		
		btnTarjeta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnContrareembolso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				 VentanaContrareembolso C = new VentanaContrareembolso();
				 setVisible(false);
				 C.setVisible(true);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaPrincipal C = new VentanaPrincipal();
				 setVisible(false);
				 C.setVisible(true);
				
			}
		});
		
	}
}


