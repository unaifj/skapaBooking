package com.decode.contacto;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Contacto extends JFrame{
	private JTextField txtContacto;
	public Contacto() {
		getContentPane().setBackground(Color.GREEN);
		getContentPane().setLayout(null);
		
		txtContacto = new JTextField();
		txtContacto.setText("CONTACTO");
		txtContacto.setBounds(143, 11, 65, 20);
		getContentPane().add(txtContacto);
		txtContacto.setColumns(10);
		
		JButton btnChat = new JButton("Chat");
		btnChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChat.setBounds(136, 184, 89, 23);
		getContentPane().add(btnChat);
		
		JButton btnCorreo = new JButton("Correo");
		btnCorreo.setBounds(136, 233, 89, 23);
		getContentPane().add(btnCorreo);
		
		JButton btnTelefono = new JButton("Teléfono");
		btnTelefono.setBounds(136, 289, 89, 23);
		getContentPane().add(btnTelefono);
		
		JLabel texto1 = new JLabel("En SkapaBooking vemos esencial la comunicación entre\r\n cliente y ");
		texto1.setBounds(23, 42, 330, 34);
		getContentPane().add(texto1);
		
		JLabel texto2 = new JLabel("También ofrecemos la comunicación con nuestras oficinas \r\n");
		texto2.setBounds(23, 102, 314, 14);
		getContentPane().add(texto2);
		
		JLabel texto3 = new JLabel("anfitrión. Por eso ofrecemos estas \r\ndiferentes comunicaciones.");
		texto3.setBounds(20, 74, 303, 14);
		getContentPane().add(texto3);
		
		JLabel texto4 = new JLabel("para posibles dudas y necesidades de los usuarios.\r\n");
		texto4.setBounds(23, 124, 300, 14);
		getContentPane().add(texto4);
		
		JButton btnNewButton_3 = new JButton("Videollamada\r\n");
		btnNewButton_3.setBounds(131, 346, 104, 23);
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
		btnCOVID.setBounds(248, 391, 89, 23);
		getContentPane().add(btnCOVID);
	}
}
