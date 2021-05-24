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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.decode.bd.DBManager;
import com.decode.objects.Anuncio;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;
import com.decode.ventanaPrincipal.VentanaAnuncio;
import com.decode.ventanaPrincipal.VentanaPrincipal;

public class VentanaPago extends JFrame {

	private JPanel contentPane;
	private DBManager dbm;

	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaPago(Anuncio anuncio) {
		
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
		
		
		JLabel lblTarjeta = new JLabel("");
		lblTarjeta.setBounds(263, 285, 197, 137);
		contentPane.add(lblTarjeta);
		
		JLabel lblReembolso = new JLabel("");
		lblReembolso.setBounds(551, 285, 210, 137);
		contentPane.add(lblReembolso);
		
		//ImageIcon ico1= new ImageIcon("img/tonyespañol.png");
		ImageIcon ico2= new ImageIcon("img/pago-en-efectivo.png");
		ImageIcon ico3 = new ImageIcon("imagenes/tarjeta-de-credito.png");
		
		ImageIcon img2= new ImageIcon(ico2.getImage().getScaledInstance(lblReembolso.getWidth(), lblReembolso.getHeight(), Image.SCALE_SMOOTH));
		lblReembolso.setIcon(img2);
		ImageIcon img3= new ImageIcon(ico3.getImage().getScaledInstance(lblTarjeta.getWidth(), lblTarjeta.getHeight(), Image.SCALE_SMOOTH));
		lblTarjeta.setIcon(img3);
		
		JLabel lblIntro = new JLabel("Seleccione el metodo de pago que desea");
		lblIntro.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIntro.setBounds(344, 121, 576, 55);
		contentPane.add(lblIntro);
		
		
		JButton btnContrareembolso = new JButton("Pagar contrarembolso (en mano el dia de la entrega de llaves)");
		btnContrareembolso.setHorizontalAlignment(SwingConstants.LEFT);
		btnContrareembolso.setBounds(526, 527, 394, 29);
		contentPane.add(btnContrareembolso);
		
		JButton btnTarjeta = new JButton("Tarjeta de credito");
		btnTarjeta.setHorizontalAlignment(SwingConstants.LEFT);
		btnTarjeta.setBounds(316, 530, 138, 23);
		contentPane.add(btnTarjeta);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 140, 89, 23);
		contentPane.add(btnVolver);
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
					VentanaPrincipal vp2 = new VentanaPrincipal("ES",null);
					vp2.setVisible(true);
					
				}
			});

        }
		
		btnTarjeta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaVerTarjetas C = new VentanaVerTarjetas(anuncio);
				 setVisible(false);
				 C.setVisible(true);
			}
		});
		
		
		
		btnContrareembolso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				 VentanaContrareembolso C = new VentanaContrareembolso(anuncio);
				 setVisible(false);
				 C.setVisible(true);
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaPrincipal C = new VentanaPrincipal("ES", null);
				 setVisible(false);
				 C.setVisible(true);
				
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAnuncio va = new VentanaAnuncio(anuncio,null);
				setVisible(false);
				va.setVisible(true);
				
				
			}
			
		});
		
	}
}


