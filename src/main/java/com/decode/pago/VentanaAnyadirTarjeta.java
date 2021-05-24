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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.objects.Anuncio;
import com.decode.objects.Apartamento;
import com.decode.objects.Localidad;
import com.decode.objects.Reserva;
import com.decode.objects.TarjetaCredito;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;
import com.decode.ventanaPrincipal.VentanaPrincipal;
import com.decode.ventanaPrincipal.VentanaPrincipal2;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class VentanaAnyadirTarjeta extends JFrame {

	private JPanel contentPane;
	
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField txtNumTarjeta;
	private JTextField txtFecha;
	private JTextField txtCVV;

	

	/**
	 * Create the frame.
	 */
	public VentanaAnyadirTarjeta(Anuncio anuncio) {
		
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
		
		
		
		
		ImageIcon ico1= new ImageIcon("img/tonyespañol.png");
		
		JLabel lblNewLabel = new JLabel("Nombre y apellidos: ");
		lblNewLabel.setBounds(43, 245, 232, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(43, 272, 244, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion de facrturacion: ");
		lblNewLabel_4.setBounds(43, 319, 184, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(43, 346, 244, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAnyadir = new JButton("Añadir");
		btnAnyadir.setBounds(372, 541, 117, 29);
		contentPane.add(btnAnyadir);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(24, 132, 117, 29);
		contentPane.add(btnAtras);
		
		JLabel lblNewLabel_4_1 = new JLabel("DNI:");
		lblNewLabel_4_1.setBounds(43, 393, 184, 16);
		contentPane.add(lblNewLabel_4_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(43, 420, 244, 26);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Numero tarjeta:");
		lblNewLabel_1.setBounds(386, 246, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNumTarjeta = new JTextField();
		txtNumTarjeta.setBounds(386, 275, 232, 23);
		contentPane.add(txtNumTarjeta);
		txtNumTarjeta.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha de caducidad:");
		lblFecha.setBounds(386, 320, 173, 14);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(386, 349, 232, 26);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CVV:");
		lblNewLabel_3.setBounds(386, 405, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtCVV = new JTextField();
		txtCVV.setBounds(388, 423, 230, 23);
		contentPane.add(txtCVV);
		txtCVV.setColumns(10);
		
		DBManager dbm = new DBManager();
		if (VentanaInicio.getUser() == null) {
			
			JButton btnRegistro = new JButton("Hazte cuenta");
			btnRegistro.setBounds(960, 13, 117, 23);
			panelNorte.add(btnRegistro);
			
			JButton btnLogin = new JButton("Iniciar Sesion");
			btnLogin.setBounds(1087, 13, 123, 23);
			panelNorte.add(btnLogin);
			
			btnLogin.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaInicio vi = new VentanaInicio(null);
					vi.setVisible(true);
					
				}
			});
			
			btnRegistro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaRegistro vr = new VentanaRegistro(null);
					vr.setVisible(true);
					
				}
			});
			
		}else {
			JLabel lblNewLabel1 = new JLabel("Has iniciado sesion como:  " + VentanaInicio.getUser().getNomUsuario());
			lblNewLabel1.setForeground(Color.LIGHT_GRAY);
			lblNewLabel1.setBounds(1062, 17, 201, 14);
			panelNorte.add(lblNewLabel1);
			
			JButton btnCerrarSesion = new JButton("Cerrar sesion");
			btnCerrarSesion.setBounds(785, 83, 152, 23);
			panelNorte.add(btnCerrarSesion);
			
			btnCerrarSesion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaPrincipal2 vp2 = new VentanaPrincipal2("ES",null);
					vp2.setVisible(true);
					
				}
			});
			
		}
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaVerTarjetas C= new VentanaVerTarjetas(anuncio);
				setVisible(false);
				C.setVisible(true);
			}
			
		});
		
		btnAnyadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Integer numTarjeta= Integer.parseInt(txtNumTarjeta.getText());
				Integer fecha= Integer.parseInt(txtFecha.getText());
				Integer cvv = Integer.parseInt(txtCVV.getText());
				
				TarjetaCredito tarjeta=new TarjetaCredito(VentanaInicio.getUser().getId(),numTarjeta,fecha,cvv);
				DBManager dbm = new DBManager();

				try {
					
					dbm.insertarTarjeta(tarjeta);
					
					JOptionPane.showMessageDialog(null, "Tarjeta correctamente añadida", "Añadido correctamente", 1, null);
					VentanaVerTarjetas C = new VentanaVerTarjetas(anuncio);
					setVisible(false);
					C.setVisible(true);
					
				}catch (DBException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
			}
		});

			
		}
	}

