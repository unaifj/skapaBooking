package com.decode.contacto;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

public class Contacto extends JFrame{
	public Contacto() {
		getContentPane().setBackground(Color.BLUE);
		getContentPane().setLayout(null);
		setBounds(300,250,389,500);
		
		JButton btnChat = new JButton("Chat");
		btnChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChat.setBounds(136, 190, 89, 23);
		getContentPane().add(btnChat);
		
		JButton btnCorreo = new JButton("Correo");
		btnCorreo.setBounds(136, 244, 89, 23);
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
		btnTelefono.setBounds(136, 289, 89, 23);
		getContentPane().add(btnTelefono);
		
		JLabel texto1 = new JLabel("En SkapaBooking vemos esencial la comunicación entre\r\n cliente y ");
		texto1.setBounds(33, 42, 330, 34);
		getContentPane().add(texto1);
		
		JLabel texto2 = new JLabel("También ofrecemos la comunicación con nuestras oficinas \r\n");
		texto2.setBounds(33, 102, 314, 14);
		getContentPane().add(texto2);
		
		JLabel texto3 = new JLabel("anfitrión. Por eso ofrecemos estas \r\ndiferentes comunicaciones.");
		texto3.setBounds(33, 77, 303, 14);
		getContentPane().add(texto3);
		
		JLabel texto4 = new JLabel("para posibles dudas y necesidades de los usuarios.\r\n");
		texto4.setBounds(36, 127, 300, 14);
		getContentPane().add(texto4);
		
		JButton btnNewButton_3 = new JButton("Videollamada\r\n");
		btnNewButton_3.setBounds(131, 341, 104, 23);
		getContentPane().add(btnNewButton_3);
		
		JButton btnAyuda = new JButton("?");
		btnAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAyuda.setBounds(23, 391, 89, 23);
		getContentPane().add(btnAyuda);
		
		JButton btnCOVID = new JButton("COVID");
		btnCOVID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCOVID.setBounds(258, 391, 89, 23);
		getContentPane().add(btnCOVID);
		
		JTextPane txtpnContacto = new JTextPane();
		txtpnContacto.setText("CONTACTO");
		txtpnContacto.setBounds(154, 11, 63, 20);
		getContentPane().add(txtpnContacto);
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
