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
import javax.swing.JList;

public class VentanaVerTarejtas extends JFrame {

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
	public VentanaVerTarejtas() {
		
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
		
		
		
		
		//ImageIcon ico1= new ImageIcon("imagenes/tonyespañol.png");
		ImageIcon ico2= new ImageIcon("imagenes/pago-en-efectivo.png");
		ImageIcon ico3 = new ImageIcon("imagenes/tarjeta-de-credito.png");
		
		JLabel lblIntro = new JLabel("Tarjetas");
		lblIntro.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIntro.setBounds(485, 121, 156, 55);
		contentPane.add(lblIntro);
		
		JButton btnAnyadirTarjeta = new JButton("Añadir tarjeta");
		btnAnyadirTarjeta.setBounds(789, 649, 130, 37);
		contentPane.add(btnAnyadirTarjeta);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(10, 140, 89, 23);
		contentPane.add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(185, 190, 566, 400);
		contentPane.add(list);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAnyadirTarjeta C = new VentanaAnyadirTarjeta();
				 setVisible(false);
				 C.setVisible(true);
				
			}
		});
		btnAnyadirTarjeta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAnyadirTarjeta C = new VentanaAnyadirTarjeta();
				 setVisible(false);
				 C.setVisible(true);
			}
		}
		);
		
	}
}