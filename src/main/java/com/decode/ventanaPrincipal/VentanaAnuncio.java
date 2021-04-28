package com.decode.ventanaPrincipal;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.decode.bd.DBManager;
import com.decode.contacto.Contacto;
import com.decode.objects.Anuncio;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;
import com.decode.ventanaperfil.VentanaConfiguacion;
import com.google.protobuf.StringValue;
import com.toedter.calendar.JDateChooser;
import javax.swing.SwingConstants;

public class VentanaAnuncio extends JFrame{
	
	public VentanaAnuncio(Anuncio anuncio) {

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
					VentanaInicio vi = new VentanaInicio();
					vi.setVisible(true);
					
				}
			});
			
			btnRegistro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaRegistro vr = new VentanaRegistro();
					vr.setVisible(true);
					
				}
			});
			
		}else {
			JLabel lblNewLabel = new JLabel("Has iniciado sesion como:  " + VentanaInicio.getUser().getNomUsuario());
			lblNewLabel.setForeground(Color.LIGHT_GRAY);
			lblNewLabel.setBounds(991, 36, 201, 14);
			panelNorte.add(lblNewLabel);
			
			JLabel lblImagenPerfil = new JLabel("");
			lblImagenPerfil.setBounds(1217, 11, 46, 51);
			panelNorte.add(lblImagenPerfil);


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
					VentanaConfiguacion vc = new VentanaConfiguacion();
					vc.setVisible(true);
					
				}
			});
						
			
		}
		
		
		
		
		ImageIcon ico1= new ImageIcon("imagenes/tonyespañol.png");//meter las rutas en la bd
		
		ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblBandera.getWidth(), lblBandera.getHeight(), Image.SCALE_SMOOTH));
		lblBandera.setIcon(img1);
		
		Panel panelCentro = new Panel();
		panelCentro.setEnabled(false);
		panelCentro.setBackground(Color.GREEN);
		panelCentro.setBounds(25, 156, 912, 619);
		getContentPane().add(panelCentro);
		panelCentro.setLayout(null);
		
		JLabel labelDesc = new JLabel(anuncio.getDescripcion());
		labelDesc.setVerticalAlignment(SwingConstants.TOP);
		labelDesc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelDesc.setBounds(136, 416, 565, 197);
		panelCentro.add(labelDesc);
		

		
		JLabel lblNewLabel_1 = new JLabel("Precio por noche: " + String.valueOf(anuncio.getPrecioNoche()) + " €");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(215, 348, 234, 29);
		panelCentro.add(lblNewLabel_1);
		
		JLabel labelHabitaciones = new JLabel(String.valueOf(anuncio.getApartamento().getNumHabitaciones()) + " habitaciones - " + String.valueOf(anuncio.getApartamento().getMetrosCuad() + " m2 - " + String.valueOf(anuncio.getNumPersonas()) + " personas"));
		labelHabitaciones.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelHabitaciones.setBounds(215, 306, 395, 14);
		panelCentro.add(labelHabitaciones);
		
		JLabel lblNewLabel_2 = new JLabel("Localidad: " + String.valueOf(anuncio.getApartamento().getLocalidad()));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(215, 389, 160, 14);
		panelCentro.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("FOTO");
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(147, 39, 456, 250);
		panelCentro.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("CONTACTAR");
		btnNewButton.setBounds(791, 521, 117, 29);
		panelCentro.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ME GUSTA");
		btnNewButton_1.setBounds(791, 438, 99, 59);
		panelCentro.add(btnNewButton_1);
		
		JPanel panelColor = new JPanel();
		panelColor.setBounds(93, 0, 673, 619);
		panelCentro.add(panelColor);
		panelColor.setLayout(null);
		panelColor.setBackground(new Color(51, 204, 255));
		
		
		
		
		
		JButton btnMapa = new JButton("Mapa");
		btnMapa.setBounds(1049, 120, 123, 23);
		getContentPane().add(btnMapa);
		
		JLabel labelTitulo = new JLabel(anuncio.getTitulo());
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 19));
		labelTitulo.setBounds(351, 120, 338, 23);
		getContentPane().add(labelTitulo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 781, 1273, 130);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblContacto = new JLabel("Contacta con nosotros");
		lblContacto.setBounds(1122, 11, 141, 14);
		panel.add(lblContacto);
		
		JPanel panelColorDerecha = new JPanel();
		panelColorDerecha.setBackground(new Color(0, 51, 255));
		panelColorDerecha.setBounds(943, 106, 330, 675);
		getContentPane().add(panelColorDerecha);
		
	
		
		
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
	}
}
