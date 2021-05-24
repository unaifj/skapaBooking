package com.decode.pago;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.decode.admin.VentanaEditarUsuario;
import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.objects.Anuncio;
import com.decode.objects.Apartamento;
import com.decode.objects.Localidad;
import com.decode.objects.Reserva;
import com.decode.objects.TarjetaCredito;
import com.decode.objects.Usuario;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;
import com.decode.ventanaPrincipal.VentanaPrincipal;


import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;


public class VentanaPagoDatos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNumPersonas;

	
	
	/**
	 * Create the frame.
	 */
	public VentanaPagoDatos(TarjetaCredito t, Anuncio anuncio) {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 62));
		setBounds(300, 200, 1289, 907);
		getContentPane().setLayout(null);
		
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
			JLabel lblNewLabel = new JLabel("Has iniciado sesion como:  " + VentanaInicio.getUser().getNomUsuario());
			lblNewLabel.setForeground(Color.LIGHT_GRAY);
			lblNewLabel.setBounds(1062, 17, 201, 14);
			panelNorte.add(lblNewLabel);
			
			
		}
		
		
		ImageIcon ico1= new ImageIcon("img/tonyespañol.png");//meter las rutas en la bd
		
		ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblBandera.getWidth(), lblBandera.getHeight(), Image.SCALE_SMOOTH));
		lblBandera.setIcon(img1);
		
		JButton btnNewButton_2 = new JButton("Atras");
		btnNewButton_2.setBounds(26, 137, 89, 23);
		getContentPane().add(btnNewButton_2);
		
	
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(771, 710, 125, 32);
		getContentPane().add(btnPagar);
		
		textFieldNumPersonas = new JTextField();
		textFieldNumPersonas.setBounds(232, 229, 77, 20);
		getContentPane().add(textFieldNumPersonas);
		textFieldNumPersonas.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de personas:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(58, 228, 164, 19);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha de entrada:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(58, 298, 164, 19);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha de salida:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(368, 298, 164, 19);
		getContentPane().add(lblNewLabel_1_1_1);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				VentanaPago p = new VentanaPago(anuncio);
				p.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnPagar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBManager dbm = new DBManager();
				int numPersonas= Integer.parseInt(textFieldNumPersonas.getText());
				
				Reserva r= new Reserva(VentanaInicio.getUser().getId(),anuncio.getApartamento().getId(),"Tarjeta de credito", null, null, numPersonas,t.getNumTarjeta() );
				
				try {
					dbm.insertarReserva(r);
					JOptionPane.showMessageDialog(null, "Reserva realizada, gracias por confiar en skapaBooking", "Reserva añadida correctamente", 1, null);
					VentanaPrincipal C = new VentanaPrincipal("ES", null);
					setVisible(false);
					C.setVisible(true);
					
				}catch(DBException e1){
					
				}
			}
		});
		
		
	
		
		
		
	}
}
