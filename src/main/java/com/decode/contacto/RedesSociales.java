package com.decode.contacto;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class RedesSociales extends JFrame {
	public RedesSociales() {
		 getContentPane().setBackground(Color.BLUE);
			getContentPane().setLayout(null);
			
			JLabel label1 = new JLabel("Redes sociales");
			label1.setForeground(Color.WHITE);
			label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			label1.setBounds(149, 11, 151, 25);
			getContentPane().add(label1);
			
			JLabel lblNewLabel_1 = new JLabel("\r\n");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(44, 47, 107, 87);
			getContentPane().add(lblNewLabel_1);
			setBounds(300,250,448,240);
			
			JLabel lblNewLabel_1_1 = new JLabel("\r\n");
			lblNewLabel_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_1.setBounds(280, 47, 107, 87);
			getContentPane().add(lblNewLabel_1_1);
			
			JButton Volver = new JButton("<");
			Volver.setBounds(21, 167, 49, 23);
			getContentPane().add(Volver);
			
			ImageIcon ico1= new ImageIcon("img/nuevo-logo-instagram-android.jpg");
			ImageIcon img2= new ImageIcon(ico1.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH));    
			lblNewLabel_1.setIcon(img2);
			
			ImageIcon ico2= new ImageIcon("img/twitter.png");               
			ImageIcon img3= new ImageIcon(ico2.getImage().getScaledInstance(lblNewLabel_1_1.getWidth(), lblNewLabel_1_1.getHeight(), Image.SCALE_SMOOTH));    
			lblNewLabel_1_1.setIcon(img3);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setBounds(137, 125, 14, 9);
			getContentPane().add(btnNewButton);
			
			btnNewButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(java.awt.Desktop.isDesktopSupported()) {
						java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
						
						if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
							try {
								java.net.URI uri = new java.net.URI("https://www.instagram.com/skapabooking/");
								desktop.browse(uri);
							}catch (URISyntaxException | IOException ex) {}
							}
						}
					
				}
				
			});
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.setBounds(373, 125, 14, 9);
			getContentPane().add(btnNewButton_1);
			
			btnNewButton_1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(java.awt.Desktop.isDesktopSupported()) {
						java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
						
						if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
							try {
								java.net.URI uri = new java.net.URI("https://twitter.com/BookingSkapa");
								desktop.browse(uri);
							}catch (URISyntaxException | IOException ex) {}
							}
						}
					
				}
				
			});
			
			Volver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Contacto C = new Contacto();
					setVisible(false);
					C.setVisible(true);
					}
				});
			
	 }
}
