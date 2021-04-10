package com.decode.contacto;

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
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class COVID extends JFrame{
	public COVID(){
	getContentPane().setBackground(Color.BLUE);
	getContentPane().setLayout(null);
	
	JLabel label1 = new JLabel("NORMATIVA COVID-19");
	label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	label1.setForeground(Color.WHITE);
	label1.setBounds(108, 11, 250, 50);
	getContentPane().add(label1);
	
	JLabel label2 = new JLabel("Para las reservas realizadas el 6 de abril de 2020 o después,");
	label2.setForeground(Color.WHITE);
	label2.setBounds(41, 75, 375, 14);
	getContentPane().add(label2);
	
	JLabel label3 = new JLabel("te recomendamos considerar el riesgo asociado al coronavirus");
	label3.setForeground(Color.WHITE);
	label3.setBounds(41, 91, 375, 14);
	getContentPane().add(label3);
	
	JLabel label4 = new JLabel("(COVID-19) y las medidas que han tomado los Gobiernos.");
	label4.setForeground(Color.WHITE);
	label4.setBounds(41, 110, 375, 14);
	getContentPane().add(label4);
	
	JLabel label5 = new JLabel("Si no reservas una tarifa flexible, es posible que no puedas ");
	label5.setForeground(Color.WHITE);
	label5.setBounds(41, 135, 375, 14);
	getContentPane().add(label5);
	
	JLabel label6 = new JLabel("optar a un reembolso. La petición de cancelación la gestionará el ");
	label6.setForeground(Color.WHITE);
	label6.setBounds(41, 149, 375, 14);
	getContentPane().add(label6);
	
	JLabel label7 = new JLabel("alojamiento teniendo en cuenta las condiciones de la reserva");
	label7.setForeground(Color.WHITE);
	label7.setBounds(41, 164, 375, 14);
	getContentPane().add(label7);
	
	JLabel label8 = new JLabel("En estos tiempos de incertidumbre, te recomendamos reservar\r\n");
	label8.setForeground(Color.WHITE);
	label8.setBounds(41, 213, 385, 14);
	getContentPane().add(label8);
	
	JLabel label9 = new JLabel("y las leyes de protección del consumidor aplicables. ");
	label9.setForeground(Color.WHITE);
	label9.setBounds(41, 181, 375, 14);
	getContentPane().add(label9);
	
	JLabel label10 = new JLabel("opciones con cancelación gratis.Si cambias de planes, podrás\r\n");
	label10.setForeground(Color.WHITE);
	label10.setBounds(41, 229, 375, 14);
	getContentPane().add(label10);
	
	JLabel label11 = new JLabel("cancelación gratis.");
	label11.setForeground(Color.WHITE);
	label11.setBounds(41, 265, 248, 14);
	getContentPane().add(label11);
	
	JLabel label12 = new JLabel("cancelar sin costes hasta la fecha límite del periodo de");
	label12.setForeground(Color.WHITE);
	label12.setBounds(41, 248, 375, 14);
	getContentPane().add(label12);
	
	JLabel label13 = new JLabel("A continuación, un codigo QR con la información actualizada\r\n");
	label13.setForeground(Color.WHITE);
	label13.setBounds(41, 299, 375, 14);
	getContentPane().add(label13);
	
	JLabel label14 = new JLabel("de la situación actual internacional del COVID-19.\r\n");
	label14.setForeground(Color.WHITE);
	label14.setBounds(41, 316, 375, 14);
	getContentPane().add(label14);
	
	JLabel label15 = new JLabel("");
	label15.setBounds(169, 341, 113, 98);
	getContentPane().add(label15);
	setBounds(300,250,442,500);
	
	
	ImageIcon ico1= new ImageIcon("img/normativacovid.PNG");               
	ImageIcon img2= new ImageIcon(ico1.getImage().getScaledInstance(label15.getWidth(), label15.getHeight(), Image.SCALE_SMOOTH));    
	label15.setIcon(img2);
	
	JButton Volver = new JButton("<");
	Volver.setBounds(20, 416, 49, 23);
	getContentPane().add(Volver);
	
	Volver.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Contacto C = new Contacto();
			setVisible(false);
			C.setVisible(true);
			}
		});
	
	}
	}
