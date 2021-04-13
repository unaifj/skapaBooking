package com.decode.contacto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NuestroCorreo extends JFrame{
	public NuestroCorreo() {
		 getContentPane().setBackground(Color.BLUE);
			getContentPane().setLayout(null);
			setBounds(300,250,453,305);
			JLabel label1 = new JLabel("Correo");
			label1.setForeground(Color.WHITE);
			label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			label1.setBounds(163, 11, 107, 25);
			getContentPane().add(label1);
			
			JLabel lblNewLabel = new JLabel("Nuestro correo electrónico : skapabooking@gmail.com ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(44, 73, 363, 14);
			getContentPane().add(lblNewLabel);
			
			
			JButton Volver = new JButton("<");
			Volver.setBounds(10, 227, 49, 23);
			getContentPane().add(Volver);
			
			JLabel lblNewLabel_1 = new JLabel("Para contactar con los correos electronicos de los \r\n");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(44, 110, 338, 14);
			getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("huespedes tendrás que mirar en cada uno de los \r\n\r\n");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(44, 135, 338, 14);
			getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("anuncios.\r\n");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(44, 160, 94, 14);
			getContentPane().add(lblNewLabel_3);
			
		/*	Volver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Contacto C = new Contacto();
					setVisible(false);
					C.setVisible(true);
					}
				});
			*/
	 }
}