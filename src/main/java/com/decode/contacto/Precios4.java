package com.decode.contacto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Precios4 extends JFrame {
	public Precios4() {
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
		
		JLabel lblNewLabel_1 = new JLabel("¿ El precio incluye impuestos ?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(44, 66, 364, 44);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Depende de cada establecimiento y del tipo de alojamiento.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(44, 132, 350, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Pero puedes comparar fácilmente distintas opciones para");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(44, 155, 350, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("ver lo que está incluido y lo que no. La legislación de");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(44, 180, 350, 14);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("impuestos varía según el país, por lo que es recomendable");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2_1.setBounds(44, 205, 350, 14);
		getContentPane().add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("que la consultes.");
		lblNewLabel_2_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2_2.setBounds(44, 230, 350, 14);
		getContentPane().add(lblNewLabel_2_2_2);
		
	
		
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Precios Pr = new Precios();
				setVisible(false);
				Pr.setVisible(true);
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
