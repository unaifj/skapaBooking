package com.decode.contacto;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Telefono extends JFrame {
 public Telefono() {
	 getContentPane().setBackground(Color.BLUE);
		getContentPane().setLayout(null);
		
		JLabel label1 = new JLabel("TELÉFONO");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label1.setBounds(163, 11, 107, 25);
		getContentPane().add(label1);
		
		JLabel lblNewLabel = new JLabel("Nuestro número de teléfono fijo: 944321223 ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(44, 73, 363, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nuestro número de teléfono movil: 653423521 ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(44, 47, 363, 14);
		getContentPane().add(lblNewLabel_1);
		setBounds(300,250,448,193);
		
		JButton Volver = new JButton("<");
		Volver.setBounds(21, 120, 49, 23);
		getContentPane().add(Volver);
		
		/*Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contacto C = new Contacto();
				setVisible(false);
				C.setVisible(true);
				}
			});
		*/
 }


}
