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
		label1.setBounds(158, 11, 68, 14);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(label1);
		
		JLabel label2 = new JLabel("Te damos la bienvenida a la Página de ayuda");
		label2.setBounds(30, 62, 353, 14);
		label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label2.setForeground(Color.WHITE);
		getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Estamos disponibles 24 horas al día\r\n");
		label3.setBounds(65, 87, 227, 14);
		label3.setForeground(Color.WHITE);
		label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(label3);
		
		JButton boton1 = new JButton("Normativa COVID                     -->");
		boton1.setBounds(92, 233, 221, 23);
		getContentPane().add(boton1);
		setBounds(300,250,389,500);
		
		
		JButton boton2 = new JButton("Cancelaciones                      -->");
		boton2.setBounds(92, 199, 221, 23);
		getContentPane().add(boton2);
		setBounds(300,250,389,500);
		
		JButton boton3 = new JButton("Pago                     -->");
		boton3.setBounds(92, 164, 221, 23);
		getContentPane().add(boton3);
		setBounds(300,250,389,500);
		
		
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
