package com.decode.contacto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class COVID extends JFrame{
	public COVID(){
	getContentPane().setBackground(Color.BLUE);
	getContentPane().setLayout(null);
	
	JLabel lblNewLabel = new JLabel("NORMATIVA COVID");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setBounds(95, 11, 174, 19);
	getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_2 = new JLabel("Para las reservas realizadas el 6 de abril de 2020 o después,");
	lblNewLabel_2.setForeground(Color.WHITE);
	lblNewLabel_2.setBounds(41, 75, 303, 14);
	getContentPane().add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("te recomendamos considerar el riesgo asociado al coronavirus");
	lblNewLabel_3.setForeground(Color.WHITE);
	lblNewLabel_3.setBounds(41, 91, 301, 14);
	getContentPane().add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("(COVID-19) y las medidas que han tomado los Gobiernos.");
	lblNewLabel_4.setForeground(Color.WHITE);
	lblNewLabel_4.setBounds(41, 110, 294, 14);
	getContentPane().add(lblNewLabel_4);
	
	JLabel lblNewLabel_5 = new JLabel("Si no reservas una tarifa flexible, es posible que no puedas ");
	lblNewLabel_5.setForeground(Color.WHITE);
	lblNewLabel_5.setBounds(41, 135, 303, 14);
	getContentPane().add(lblNewLabel_5);
	
	JLabel lblNewLabel_6 = new JLabel("optar a un reembolso. La petición de cancelación la gestionará el ");
	lblNewLabel_6.setForeground(Color.WHITE);
	lblNewLabel_6.setBounds(41, 149, 322, 14);
	getContentPane().add(lblNewLabel_6);
	
	JLabel lblNewLabel_6_1 = new JLabel("alojamiento teniendo en cuenta las condiciones de la reserva");
	lblNewLabel_6_1.setForeground(Color.WHITE);
	lblNewLabel_6_1.setBounds(41, 164, 303, 14);
	getContentPane().add(lblNewLabel_6_1);
	
	JLabel lblNewLabel_6_1_2 = new JLabel("En estos tiempos de incertidumbre, te recomendamos reservar\r\n");
	lblNewLabel_6_1_2.setForeground(Color.WHITE);
	lblNewLabel_6_1_2.setBounds(41, 213, 322, 14);
	getContentPane().add(lblNewLabel_6_1_2);
	
	JLabel lblNewLabel_6_1_3 = new JLabel("y las leyes de protección del consumidor aplicables. ");
	lblNewLabel_6_1_3.setForeground(Color.WHITE);
	lblNewLabel_6_1_3.setBounds(41, 181, 303, 14);
	getContentPane().add(lblNewLabel_6_1_3);
	
	JLabel lblNewLabel_1 = new JLabel("opciones con cancelación gratis.Si cambias de planes, podrás\r\n");
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setBounds(41, 229, 322, 14);
	getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_1_1 = new JLabel("cancelación gratis.");
	lblNewLabel_1_1.setForeground(Color.WHITE);
	lblNewLabel_1_1.setBounds(41, 265, 303, 14);
	getContentPane().add(lblNewLabel_1_1);
	
	JLabel lblNewLabel_7 = new JLabel("cancelar sin costes hasta la fecha límite del periodo de");
	lblNewLabel_7.setForeground(Color.WHITE);
	lblNewLabel_7.setBounds(41, 248, 303, 14);
	getContentPane().add(lblNewLabel_7);
	setBounds(300,250,389,500);
	}
	}
