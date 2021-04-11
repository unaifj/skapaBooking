package com.decode.contacto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Pago extends JFrame{

	public Pago() {
		getContentPane().setBackground(Color.BLUE);
		getContentPane().setLayout(null);
		setBounds(300,250,453,500);
		JButton Volver = new JButton("<");
		Volver.setBounds(20, 416, 49, 23);
		getContentPane().add(Volver);
		
		JLabel lblNewLabel = new JLabel("Preguntas Frecuentes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(132, 11, 180, 44);
		getContentPane().add(lblNewLabel);
		
		JButton boton1 = new JButton("¿ Qué formas de pago se aceptan ?");
		boton1.setBounds(20, 105, 391, 51);
		getContentPane().add(boton1);
		
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pago2 P2 = new Pago2();
				setVisible(false);
				P2.setVisible(true);
				}
			});
		
		JButton boton2 = new JButton("¿ Puedo pagar por adelantado o con un depósito ?");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		boton2.setBounds(20, 180, 391, 51);
		getContentPane().add(boton2);
		
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pago3 P3 = new Pago3();
				setVisible(false);
				P3.setVisible(true);
				}
			});
		
		JButton boton3 = new JButton(" Ya me han cobrado. ¿ Tengo que hacer algo ?");
		boton3.setBounds(20, 269, 391, 51);
		getContentPane().add(boton3);
		
		JLabel lblNewLabel_1 = new JLabel("Pago\r\n");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(104, 66, 247, 28);
		getContentPane().add(lblNewLabel_1);
		
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pago4 P4 = new Pago4();
				setVisible(false);
				P4.setVisible(true);
				}
			});
		Volver.addActionListener(new ActionListener() {
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
