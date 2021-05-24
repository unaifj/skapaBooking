package com.decode.ventanaPrincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.decode.chat.ChatSkapaBookingCliente;
import com.decode.configuracion.VentanaConfiguacion;
import com.decode.contacto.Contacto;
import com.decode.objects.Anuncio;
import com.decode.objects.Usuario;
import com.decode.pago.VentanaPago;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;

public class VentanaAnuncio extends JFrame{
	
	public VentanaAnuncio(Anuncio anuncio, Usuario user) {
		getContentPane().setBackground(Color.WHITE);

		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 62));
		getContentPane().setLayout(null);
		setBounds(300, 200, 1289, 907);
		
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
		
		
		
		if (user == null) {
			
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
			JLabel lblNewLabel = new JLabel("Has iniciado sesion como:  " + user.getNomUsuario());
			lblNewLabel.setForeground(Color.LIGHT_GRAY);
			lblNewLabel.setBounds(991, 36, 201, 14);
			panelNorte.add(lblNewLabel);
			
			JLabel lblImagenPerfil = new JLabel("");
			lblImagenPerfil.setBounds(1217, 11, 46, 51);
			panelNorte.add(lblImagenPerfil);

			JButton btnCerrarSesion = new JButton("Cerrar sesion");
			btnCerrarSesion.setBounds(785, 83, 152, 23);
			panelNorte.add(btnCerrarSesion);
			
			btnCerrarSesion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaPrincipal vp2 = new VentanaPrincipal("ES", null);
					vp2.setVisible(true);
					
				}
			});
			ImageIcon iconoperfil = new ImageIcon("img/perfil.PNG");               
			ImageIcon img2= new ImageIcon(iconoperfil.getImage().getScaledInstance(lblImagenPerfil.getWidth(), lblImagenPerfil.getHeight(), Image.SCALE_SMOOTH));    
			lblImagenPerfil.setIcon(img2);
			
			
			lblImagenPerfil.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					VentanaConfiguacion vc = new VentanaConfiguacion(VentanaInicio.getUser());
					vc.setVisible(true);
					
				}
			});
						
			
		}
		
		
		
		
		ImageIcon ico1= new ImageIcon("img/tonyespañol.png");//meter las rutas en la bd
		
		ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblBandera.getWidth(), lblBandera.getHeight(), Image.SCALE_SMOOTH));
		lblBandera.setIcon(img1);
		
	
		
		
		Panel panelCentro = new Panel();
		panelCentro.setBackground(Color.WHITE);
		panelCentro.setBounds(6, 158, 943, 617);
		getContentPane().add(panelCentro);
		panelCentro.setLayout(null);
		
		JLabel labelDesc = new JLabel(anuncio.getDescripcion());
		labelDesc.setVerticalAlignment(SwingConstants.TOP);
		labelDesc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelDesc.setBounds(72, 448, 641, 114);
		panelCentro.add(labelDesc);
		

		
		JLabel lblNewLabel_1 = new JLabel("Precio por noche: " + String.valueOf(anuncio.getPrecioNoche()) + " €");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(72, 334, 395, 29);
		panelCentro.add(lblNewLabel_1);
		
		JLabel labelHabitaciones = new JLabel(String.valueOf(anuncio.getApartamento().getNumHabitaciones()) + " habitaciones - " + String.valueOf(anuncio.getApartamento().getMetrosCuad() + " m2 - " + String.valueOf(anuncio.getNumPersonas()) + " personas"));
		labelHabitaciones.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelHabitaciones.setBounds(72, 302, 424, 21);
		panelCentro.add(labelHabitaciones);
		
		JLabel lblNewLabel_2 = new JLabel("Localidad: " + String.valueOf(anuncio.getApartamento().getLocalidad().getMunicipio()));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(72, 374, 459, 21);
		panelCentro.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(48, 11, 837, 265);
		panelCentro.add(lblNewLabel_3);
		
		ImageIcon ico= new ImageIcon(anuncio.getImg());
		ImageIcon img= new ImageIcon(ico.getImage().getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel_3.setIcon(img);
		
		JButton btnReservar = new JButton("Reservar");
		btnReservar.setBounds(817, 573, 89, 23);
		panelCentro.add(btnReservar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(26, 573, 89, 23);
		panelCentro.add(btnAtras);
		
		JButton btnChat = new JButton("Chat");
		btnChat.setBounds(703, 573, 89, 23);
		panelCentro.add(btnChat);
		
		JLabel lblDireccion = new JLabel("Direccion: " + String.valueOf(anuncio.getApartamento().getLocalidad().getDireccion()));
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDireccion.setBounds(72, 406, 459, 21);
		panelCentro.add(lblDireccion);
		
		JLabel labelTitulo = new JLabel(anuncio.getTitulo());
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 19));
		labelTitulo.setBounds(163, 120, 526, 32);
		getContentPane().add(labelTitulo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 781, 1273, 76);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblContacto = new JLabel("Contacta con nosotros");
		lblContacto.setBounds(1122, 11, 141, 14);
		panel.add(lblContacto);
		
		JPanel panelColorDerecha = new JPanel();
		panelColorDerecha.setBackground(Color.WHITE);
		panelColorDerecha.setBounds(955, 113, 318, 662);
		getContentPane().add(panelColorDerecha);
		panelColorDerecha.setLayout(null);
		
	
		
		
		lblContacto.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Contacto c = new Contacto();
				c.setVisible(true);
				
			}
		});

		btnReservar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPago vp = new VentanaPago(anuncio);
				setVisible(false);
				vp.setVisible(true);
				
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				VentanaPrincipal vp = new VentanaPrincipal("ES", user);
				vp.setVisible(true);
				
				
			}
		});
		btnChat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChatSkapaBookingCliente vc = new ChatSkapaBookingCliente();
				vc.setVisible(true);
				
				
			}
		});
		
		
	}
}
