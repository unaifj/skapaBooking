package com.decode.admin;

import java.awt.Color;
import java.awt.EventQueue;
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

import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;
import com.decode.ventanaPrincipal.VentanaListaAnuncios;
import com.decode.ventanaPrincipal.VentanaPrincipal;

public class VentanaAdmin extends JFrame  {
	
	/**
	 * Ejecutamos la aplicación.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdmin frame = new VentanaAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaAdmin() {
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
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(398, 636, 158, 47);
		getContentPane().add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 727, 1273, 130);
		getContentPane().add(panel);
		
		JLabel lblContacto = new JLabel("Contacta con nosotros");
		lblContacto.setBounds(1076, 11, 141, 14);
		panel.add(lblContacto);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(255, 151, 442, 443);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdministrarUsuarios = new JButton("Administrar usuarios");
		btnAdministrarUsuarios.setBounds(89, 115, 228, 39);
		panel_1.add(btnAdministrarUsuarios);
		
		JLabel lblNewLabel_1 = new JLabel("BIENVENIDO ADMINISTRADOR");
		lblNewLabel_1.setBounds(51, 0, 439, 90);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton btnAdministrarAnuncios = new JButton("Administrar anuncios");
		btnAdministrarAnuncios.setBounds(89, 212, 228, 39);
		panel_1.add(btnAdministrarAnuncios);
		
		JButton btnAdministrarOpiniones = new JButton("Administrar opiniones");
		btnAdministrarOpiniones.setBounds(89, 309, 228, 39);
		panel_1.add(btnAdministrarOpiniones);
		
		btnAdministrarOpiniones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				VentanaPrincipal p= new VentanaPrincipal("ES", null);

			

				setVisible(false);
				p.setVisible(true);
			}
		});
		
			
			btnAdministrarAnuncios.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					VentanaAdminAnuncio p = new VentanaAdminAnuncio();
					setVisible(false);
					p.setVisible(true);
				}
			});
		
		btnAdministrarUsuarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaAdminUsuarios p = new VentanaAdminUsuarios();
				setVisible(false);
				p.setVisible(true);
			}
		});
		
		
	
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal p= new VentanaPrincipal("ES", null);
				setVisible(false);
				p.setVisible(true);
				
				
			}
		});
		
		
		
	}
}
