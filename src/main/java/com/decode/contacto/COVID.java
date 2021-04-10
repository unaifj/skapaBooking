package com.decode.contacto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

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
	
	JLabel label1 = new JLabel("NORMATIVA COVID");
	label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	label1.setForeground(Color.WHITE);
	label1.setBounds(95, 11, 174, 19);
	getContentPane().add(label1);
	
	JLabel label2 = new JLabel("Para las reservas realizadas el 6 de abril de 2020 o después,");
	label2.setForeground(Color.WHITE);
	label2.setBounds(41, 75, 303, 14);
	getContentPane().add(label2);
	
	JLabel label3 = new JLabel("te recomendamos considerar el riesgo asociado al coronavirus");
	label3.setForeground(Color.WHITE);
	label3.setBounds(41, 91, 301, 14);
	getContentPane().add(label3);
	
	JLabel label4 = new JLabel("(COVID-19) y las medidas que han tomado los Gobiernos.");
	label4.setForeground(Color.WHITE);
	label4.setBounds(41, 110, 294, 14);
	getContentPane().add(label4);
	
	JLabel label5 = new JLabel("Si no reservas una tarifa flexible, es posible que no puedas ");
	label5.setForeground(Color.WHITE);
	label5.setBounds(41, 135, 303, 14);
	getContentPane().add(label5);
	
	JLabel label6 = new JLabel("optar a un reembolso. La petición de cancelación la gestionará el ");
	label6.setForeground(Color.WHITE);
	label6.setBounds(41, 149, 322, 14);
	getContentPane().add(label6);
	
	JLabel label7 = new JLabel("alojamiento teniendo en cuenta las condiciones de la reserva");
	label7.setForeground(Color.WHITE);
	label7.setBounds(41, 164, 303, 14);
	getContentPane().add(label7);
	
	JLabel label8 = new JLabel("En estos tiempos de incertidumbre, te recomendamos reservar\r\n");
	label8.setForeground(Color.WHITE);
	label8.setBounds(41, 213, 322, 14);
	getContentPane().add(label8);
	
	JLabel label9 = new JLabel("y las leyes de protección del consumidor aplicables. ");
	label9.setForeground(Color.WHITE);
	label9.setBounds(41, 181, 303, 14);
	getContentPane().add(label9);
	
	JLabel label10 = new JLabel("opciones con cancelación gratis.Si cambias de planes, podrás\r\n");
	label10.setForeground(Color.WHITE);
	label10.setBounds(41, 229, 322, 14);
	getContentPane().add(label10);
	
	JLabel label11 = new JLabel("cancelación gratis.");
	label11.setForeground(Color.WHITE);
	label11.setBounds(41, 265, 303, 14);
	getContentPane().add(label11);
	
	JLabel label12 = new JLabel("cancelar sin costes hasta la fecha límite del periodo de");
	label12.setForeground(Color.WHITE);
	label12.setBounds(41, 248, 303, 14);
	getContentPane().add(label12);
	
	JLabel label13 = new JLabel("A continuación, un codigo QR con la información actualizada\r\n");
	label13.setForeground(Color.WHITE);
	label13.setBounds(41, 299, 294, 14);
	getContentPane().add(label13);
	
	JLabel label14 = new JLabel("de la situación actual internacional del COVID-19.\r\n");
	label14.setForeground(Color.WHITE);
	label14.setBounds(41, 316, 282, 14);
	getContentPane().add(label14);
	
	JLabel label15 = new JLabel("New label");
	label15.setBounds(125, 341, 113, 98);
	getContentPane().add(label15);
	setBounds(300,250,389,500);
	
	
	ImageIcon ico1= new ImageIcon("img/normativacovid.PNG");               
	ImageIcon img2= new ImageIcon(ico1.getImage().getScaledInstance(label15.getWidth(), label15.getHeight(), Image.SCALE_SMOOTH));    
	label15.setIcon(img2);
	}
	}
