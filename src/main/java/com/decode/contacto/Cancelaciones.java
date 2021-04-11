package com.decode.contacto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Cancelaciones extends JFrame {
	public Cancelaciones() {
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
		
		JButton boton1 = new JButton("¿ Puedo anular mi reserva ?");
		boton1.setBounds(22, 101, 379, 51);
		getContentPane().add(boton1);
		
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancelaciones2 C2 = new Cancelaciones2();
				setVisible(false);
				C2.setVisible(true);
				}
			});
		
		JButton boton2 = new JButton("¿ Cómo puedo saber si mi reserva se ha anulado ?");
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		boton2.setBounds(22, 181, 379, 51);
		getContentPane().add(boton2);
		
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancelaciones3 C3 = new Cancelaciones3();
				setVisible(false);
				C3.setVisible(true);
				}
			});
		
		JButton boton3 = new JButton("Si anulo mi reserva, ¿se me realizará algún cargo?");
		boton3.setBounds(22, 265, 379, 51);
		getContentPane().add(boton3);
		
		JLabel lblNewLabel_1 = new JLabel("Cancelaciones");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(88, 66, 247, 14);
		getContentPane().add(lblNewLabel_1);
		
		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancelaciones4 C4 = new Cancelaciones4();
				setVisible(false);
				C4.setVisible(true);
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
