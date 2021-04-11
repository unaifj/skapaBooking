package com.decode.contacto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Pago2 extends JFrame {
	public Pago2() {
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
		
		JLabel lblNewLabel_1 = new JLabel("¿ Qué formas de pago se aceptan ?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(44, 66, 364, 44);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Las tarjetas de crédito son la forma de pago más extendida ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(44, 132, 350, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(" entre los alojamientos de Booking.com. La mayoría de ellos");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(44, 155, 350, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("necesita la tarjeta para poder validar la reserva.");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(44, 180, 350, 14);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("En la confirmación de la reserva verás las formas de pago \r\n");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2_1.setBounds(44, 205, 350, 14);
		getContentPane().add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("que acepta tu alojamiento. Si quieres que te confirmen");
		lblNewLabel_2_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2_2.setBounds(44, 230, 350, 14);
		getContentPane().add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("alguna, puedes llamar directamente al alojamiento.");
		lblNewLabel_2_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2_3.setBounds(44, 255, 350, 14);
		getContentPane().add(lblNewLabel_2_2_3);
		
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pago P = new Pago();
				setVisible(false);
				P.setVisible(true);
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
