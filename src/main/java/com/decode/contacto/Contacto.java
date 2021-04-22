package com.decode.contacto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.decode.chat.ChatSkapaBooking;
import com.decode.chat.ChatSkapaBookingCliente;
import com.decode.ventanaPrincipal.VentanaPrincipal;



public class Contacto extends JFrame{
	public Contacto() {
		getContentPane().setBackground(Color.BLUE);
		getContentPane().setLayout(null);
		setBounds(300,250,453,500);

		JButton btnChat = new JButton("Chat.S");
		
		btnChat.setBounds(81, 185, 89, 23);
		getContentPane().add(btnChat);
		
		btnChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatSkapaBooking C = new ChatSkapaBooking();
								C.setVisible(true);
				}
			});
		JButton btnChat2 = new JButton("Chat.C");
		btnChat2.setBounds(253, 185, 89, 23);
		getContentPane().add(btnChat2);
		
		btnChat2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatSkapaBookingCliente C = new ChatSkapaBookingCliente();
				C.setVisible(true);
				}
			});
		
		JButton btnCorreo = new JButton("Correo");
		btnCorreo.setBounds(167, 240, 89, 23);
		getContentPane().add(btnCorreo);
		
		btnCorreo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
					
					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://accounts.google.com/AccountChooser/signinchooser?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AccountChooser");
							desktop.browse(uri);
						}catch (URISyntaxException | IOException ex) {}
						}
					}
				
			}
			
		});
		
		JButton btnTelefono = new JButton("Teléfono");
		btnTelefono.setBounds(167, 289, 89, 23);
		getContentPane().add(btnTelefono);
		
		btnTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Telefono T = new Telefono();
				setVisible(false);
				T.setVisible(true);
				}
			});
		
		JLabel texto1 = new JLabel("En SkapaBooking vemos esencial la comunicación entre\r\n cliente y ");
		texto1.setForeground(Color.WHITE);
		texto1.setBounds(35, 45, 387, 34);
		getContentPane().add(texto1);
		
		JLabel texto2 = new JLabel("También ofrecemos la comunicación con nuestras oficinas \r\n");
		texto2.setForeground(Color.WHITE);
		texto2.setBounds(33, 102, 389, 14);
		getContentPane().add(texto2);
		
		JLabel texto3 = new JLabel("anfitrión. Por eso ofrecemos estas \r\ndiferentes comunicaciones.");
		texto3.setForeground(Color.WHITE);
		texto3.setBounds(33, 77, 389, 14);
		getContentPane().add(texto3);
		
		JLabel texto4 = new JLabel("para posibles dudas y necesidades de los usuarios.\r\n");
		texto4.setForeground(Color.WHITE);
		texto4.setBounds(36, 127, 386, 14);
		getContentPane().add(texto4);
		
		JButton btnVideoLLamada = new JButton("Videollamada\r\n");
		btnVideoLLamada.setBounds(156, 340, 115, 23);
		getContentPane().add(btnVideoLLamada);
		
		btnVideoLLamada.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(java.awt.Desktop.isDesktopSupported()) {
					java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
					
					if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
						try {
							java.net.URI uri = new java.net.URI("https://discord.gg/EXb9BAHbPd");
							desktop.browse(uri);
						}catch (URISyntaxException | IOException ex) {}
						}
					}
				
			}
			
		});
		
		
		
		JButton btnCOVID = new JButton("COVID");
		btnCOVID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCOVID.setBounds(303, 391, 89, 23);
		getContentPane().add(btnCOVID);
		
		btnCOVID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				COVID C = new COVID();
				setVisible(false);
				C.setVisible(true);
				}
			});
		
		JLabel lblNewLabel = new JLabel("CONTACTO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(167, 11, 104, 23);
		getContentPane().add(lblNewLabel);
		
		JButton btnAyuda = new JButton("?");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAyuda.setBounds(33, 391, 89, 23);
		getContentPane().add(btnAyuda);
		
		JButton botonCorreo = new JButton("Nuestro correo\r\n");
		botonCorreo.setBounds(277, 240, 127, 23);
		getContentPane().add(botonCorreo);
		
		JButton botonRedesSociales = new JButton("Redes Sociales\r\n");
		botonRedesSociales.setBounds(10, 240, 129, 23);
		getContentPane().add(botonRedesSociales);
		
		JButton botonVP = new JButton("Ventana Principal\r\n");
		botonVP.setBounds(141, 427, 142, 23);
		getContentPane().add(botonVP);
		
		botonVP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal VP = new VentanaPrincipal();
				setVisible(false);
				VP.setVisible(true);
				}
			});
		botonRedesSociales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RedesSociales RS = new RedesSociales();
				setVisible(false);
				RS.setVisible(true);
				}
			});
		
		botonCorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuestroCorreo NC = new NuestroCorreo();
				setVisible(false);
				NC.setVisible(true);
				}
			});
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ayuda A = new Ayuda();
				setVisible(false);
				A.setVisible(true);
				}
			});
		
		
		
				
	}
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Contacto frame = new Contacto();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
