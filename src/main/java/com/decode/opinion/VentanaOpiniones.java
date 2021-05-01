package com.decode.opinion;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaOpiniones extends JFrame {
	
	
	
	private JPanel contentPane;
	
	public VentanaOpiniones() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelOpiniones = new JPanel();
		panelOpiniones.setBackground(Color.PINK);
		panelOpiniones.setBounds(27, 11, 366, 439);
		contentPane.add(panelOpiniones);
		panelOpiniones.setLayout(null);
		
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 466, 115, 29);
		contentPane.add(btnAtras);
		
		JButton btnNuevoComentario = new JButton("Nuevo comentario");
		btnNuevoComentario.setBounds(205, 466, 161, 29);
		contentPane.add(btnNuevoComentario);
		
		
		
	}

}
