package com.decode.contacto;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.Font;

public class Ayuda extends JFrame{
	public Ayuda() {
		
		
		getContentPane().setBackground(Color.BLUE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AYUDA");
		lblNewLabel.setBounds(158, 11, 68, 14);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Te damos la bienvenida a la Página de ayuda");
		lblNewLabel_1.setBounds(30, 62, 353, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Estamos disponibles 24 horas al día\r\n");
		lblNewLabel_2.setBounds(65, 87, 227, 14);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(lblNewLabel_2);
		
		JButton boton1 = new JButton("Normativa COVID                     -->");
		boton1.setBounds(92, 164, 221, 23);
		getContentPane().add(boton1);
		setBounds(300,250,389,500);
		
		
		JButton boton2 = new JButton("Cancelaciones                      -->");
		boton2.setBounds(92, 164, 221, 23);
		getContentPane().add(boton2);
		setBounds(300,250,389,500);
		
		JButton boton3 = new JButton("Pago                     -->");
		boton3.setBounds(92, 164, 221, 23);
		getContentPane().add(boton3);
		setBounds(300,250,389,500);
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
