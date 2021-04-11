package com.decode.contacto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class Cancelaciones4 extends JFrame {
	public Cancelaciones4() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Si anulo mi reserva, ¿se me realizará algún cargo?\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(44, 66, 368, 44);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Si tienes una reserva con cancelación gratis, no pagarás ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(44, 132, 350, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel(" ningún cargo de cancelación. Si tu reserva ya no se puede");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(44, 155, 350, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("cancelar gratis o no es reembolsable, pagarás el cargo de\r\n");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(44, 180, 350, 14);
		getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("cancelación. El alojamiento es el encargado de determinar");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2_1.setBounds(44, 204, 350, 14);
		getContentPane().add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("los cargos de cancelación. Cualquier tipo de gasto adicional");
		lblNewLabel_2_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2_1_1.setBounds(44, 229, 350, 14);
		getContentPane().add(lblNewLabel_2_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("lo pagarás al alojamiento.");
		lblNewLabel_2_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2_1_1_1.setBounds(44, 254, 350, 14);
		getContentPane().add(lblNewLabel_2_2_1_1_1);
		
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cancelaciones C = new Cancelaciones();
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
