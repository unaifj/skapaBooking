package com.decode.pago;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.objects.Anuncio;
import com.decode.objects.Reserva;
import com.decode.objects.TarjetaCredito;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;
import com.decode.ventanaPrincipal.VentanaPrincipal;
import com.toedter.calendar.JDateChooser;


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
			
			JButton btnCerrarSesion = new JButton("Cerrar sesion");
			btnCerrarSesion.setBounds(785, 83, 152, 23);
			panelNorte.add(btnCerrarSesion);
			
			btnCerrarSesion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaPrincipal vp2 = new VentanaPrincipal("ES",null);
					vp2.setVisible(true);
					
				}
			});
			
		}
		
		
		ImageIcon ico1= new ImageIcon("img/tonyespa??ol.png");//meter las rutas en la bd
		
		ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblBandera.getWidth(), lblBandera.getHeight(), Image.SCALE_SMOOTH));
		lblBandera.setIcon(img1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(329, 143, 438, 474);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Atras");
		btnNewButton_2.setBounds(62, 355, 84, 30);
		panel.add(btnNewButton_2);
		
	
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(264, 355, 102, 30);
		panel.add(btnPagar);
		
		JLabel lblNewLabel_2 = new JLabel("Datos de la reserva");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(148, 11, 152, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Numero de personas:");
		lblNewLabel_1.setBounds(25, 84, 164, 19);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textFieldNumPersonas = new JTextField();
		textFieldNumPersonas.setBounds(215, 85, 77, 20);
		panel.add(textFieldNumPersonas);
		textFieldNumPersonas.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha de salida:");
		lblNewLabel_1_1_1.setBounds(229, 147, 164, 19);
		panel.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(229, 183, 143, 23);
		panel.add(dateChooser_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha de entrada:");
		lblNewLabel_1_1.setBounds(25, 147, 164, 19);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(25, 183, 143, 23);
		panel.add(dateChooser);
		
		btnPagar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBManager dbm = new DBManager();
				int numPersonas= Integer.parseInt(textFieldNumPersonas.getText());
				
				Reserva r= new Reserva(VentanaInicio.getUser().getId(),anuncio.getApartamento().getId(),"Tarjeta de credito", null, null, numPersonas,t.getNumTarjeta() );
				
				try {
					dbm.insertarReserva(r);
					JOptionPane.showMessageDialog(null, "Reserva realizada, gracias por confiar en skapaBooking", "Reserva a??adida correctamente", 1, null);
					VentanaPrincipal C = new VentanaPrincipal("ES", null);
					setVisible(false);
					C.setVisible(true);
					
				}catch(DBException e1){
					
				}
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				VentanaPago p = new VentanaPago(anuncio);
				p.setVisible(true);
				setVisible(false);
				
			}
		});
		
		
	
		
		
		
	}
}
