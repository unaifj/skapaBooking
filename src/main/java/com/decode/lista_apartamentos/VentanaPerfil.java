package com.decode.lista_apartamentos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import com.decode.bd.LogController;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaPerfil extends JFrame {

	private JPanel contentPane;
	private int contC1 = 0;
	private int contC2 = 0;
	private int contC3 = 0;
	private int contC4 = 0;
	private int valueProgressBar = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LogController.log ( Level.INFO, "Inicio Ventana " + (new Date()),null);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPerfil frame = new VentanaPerfil();
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
	public VentanaPerfil() {
		
		//CREACION DE INTERFACE
	//int contBarra = 0;
	//int idUsuario = VenatanaPrincipal.getUsuarioId();
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 557, 621);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//CREADO Y ESCALADO DE IMAGEN
		JLabel imagenPerfil = new JLabel("");
		imagenPerfil.setBounds(415, 14, 105, 103);
	
		ImageIcon imagenP = new ImageIcon("../skapaProyect/multimedia/FotoPerfil.png");
		
		Icon icono = new ImageIcon(imagenP.getImage().getScaledInstance(imagenPerfil.getWidth(), imagenPerfil.getHeight(), Image.SCALE_DEFAULT));
		imagenPerfil.setIcon(icono);
		
		contentPane.add(imagenPerfil);
		
		JLabel TextoNombre = new JLabel();
		TextoNombre.setText("Nombre");
		TextoNombre.setBounds(15, 133, 72, 26);
		contentPane.add(TextoNombre);
		
		
		
		JLabel txtpnInformacinPrivada = new JLabel();
		txtpnInformacinPrivada.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnInformacinPrivada.setText("Informacion personal\r\n");
		txtpnInformacinPrivada.setBounds(15, 16, 218, 26);
		contentPane.add(txtpnInformacinPrivada);
		
		JLabel TextoCorreoElectrnico = new JLabel();
		TextoCorreoElectrnico.setText("Correo electr\u00F3nico");
		TextoCorreoElectrnico.setBounds(15, 171, 162, 26);
		contentPane.add(TextoCorreoElectrnico);
		
		JTextPane nombreUsuario = new JTextPane();
		JTextPane apellidoUsuario = new JTextPane();
		JTextPane ubicacionProvinciaUsuario = new JTextPane();
		JTextPane textoCorreo = new JTextPane();
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(169, 451, 317, 14);
		contentPane.add(progressBar);
		
		JLabel TextoMisAnuncios = new JLabel();
		TextoMisAnuncios.setText("Mis anuncios:");
		TextoMisAnuncios.setBounds(15, 209, 162, 26);
		contentPane.add(TextoMisAnuncios);
		
		
		
		

		JComboBox comboAnyo = new JComboBox();
		
		
		
		}
}
