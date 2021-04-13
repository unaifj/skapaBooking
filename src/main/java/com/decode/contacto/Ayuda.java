package com.decode.contacto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ayuda extends JFrame{
	public Ayuda() {
		
		
		getContentPane().setBackground(Color.BLUE);
		getContentPane().setLayout(null);
		setBounds(300,250,389,500);
		
		JLabel label1 = new JLabel("AYUDA");
		label1.setBounds(158, 11, 68, 25);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Te damos la bienvenida a la Página de ayuda");
		label2.setBounds(30, 62, 353, 25);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label2.setForeground(Color.WHITE);
		getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Estamos disponibles 24 horas al día\r\n");
		label3.setBounds(65, 87, 227, 14);
		label3.setForeground(Color.WHITE);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(label3);
		
		JButton boton1 = new JButton("Precios                 >");
		boton1.setBounds(92, 267, 221, 23);
		getContentPane().add(boton1);
		setBounds(300,250,389,500);
		
		/*boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Precios Pr = new Precios();
				setVisible(false);
				Pr.setVisible(true);
				}
			});
		*/
		JButton boton2 = new JButton("Cancelaciones         >");
		boton2.setBounds(92, 222, 221, 23);
		getContentPane().add(boton2);
		setBounds(300,250,389,500);
		
		/*boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancelaciones C = new Cancelaciones();
				setVisible(false);
				C.setVisible(true);
				}
			});*/
		JButton boton3 = new JButton("Pago                    >");
		boton3.setBounds(92, 176, 221, 23);
		getContentPane().add(boton3);
		setBounds(300,250,389,500);
		
		/*boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pago P = new Pago();
				setVisible(false);
				P.setVisible(true);
				}
			});
		*/
		JButton Volver = new JButton("<");
		Volver.setBounds(20, 416, 49, 23);
		getContentPane().add(Volver);
		
		JLabel lblNewLabel = new JLabel("Preguntas frecuentes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(103, 133, 260, 32);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("En caso de que siga teniendo dudas podria contactarnos\r\n ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 338, 343, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("por las diferentes vias que aparecen en contacto.\r\n ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 363, 327, 14);
		getContentPane().add(lblNewLabel_2);
		
		/*Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contacto C = new Contacto();
				setVisible(false);
				C.setVisible(true);
				}
			});
			*/
	}
	
	
	
	
	
	
	 public static void main(String[] args) {
	 
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ayuda frame = new Ayuda();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }); 
    }

}