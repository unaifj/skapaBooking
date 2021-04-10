package com.decode.contacto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Precios extends JFrame{
	
	public Precios() {
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
		
		JButton boton1 = new JButton("¿ El precio incluye desayuno ?");
		boton1.setBounds(20, 105, 391, 51);
		getContentPane().add(boton1);
		
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Precios2 Pr2 = new Precios2();
				setVisible(false);
				Pr2.setVisible(true);
				}
			});
		
		JButton boton2 = new JButton("¿ Qué incluye el precio ?");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		boton2.setBounds(20, 180, 391, 51);
		getContentPane().add(boton2);
		
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Precios3 Pr3 = new Precios3();
				setVisible(false);
				Pr3.setVisible(true);
				}
			});
		
		JButton boton3 = new JButton("¿ El precio incluye impuestos ? ");
		boton3.setBounds(20, 269, 391, 51);
		getContentPane().add(boton3);
		
		JLabel lblNewLabel_1 = new JLabel("Precios\r\n");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(104, 66, 247, 28);
		getContentPane().add(lblNewLabel_1);
		
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Precios4 Pr4 = new Precios4();
				setVisible(false);
				Pr4.setVisible(true);
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