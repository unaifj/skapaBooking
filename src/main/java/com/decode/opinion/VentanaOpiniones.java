package com.decode.opinion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		/*try {
			
			int cont = 16;
			int contS=0;
			
			ArrayList<JPanel> paneles = new ArrayList<JPanel>();
			
			while () {
				
				JPanel panelNuevo = new JPanel();
				panelNuevo.setBackground(Color.white);
				panelNuevo.setBounds(15, cont, 351, 95);
				panelOpiniones.add(panelNuevo);
				panelNuevo.setLayout(null);
				
				JLabel lblLabeltitulo = new JLabel();
				lblLabeltitulo.setFont();
				
				lblLabeltitulo.setBounds(15, 16, 321, 20);
				panelNuevo.add(lblLabeltitulo);
				
				JLabel labelOpinion = new JLabel();
				labelOpinion.setBounds(15, 41, 321, 38);
				panelNuevo.add(labelOpinion);
			
				
				cont = cont + 105;
				contS++;
				
			}
			
		}catch (ClassNotFoundException e1) {
			System.out.println("No se ja podido cargar el driver");
			e1.printStackTrace();
		}catch (SQLException e1) {
			System.out.println("No se ha podido conectar a BD");
			e1.printStackTrace();
		}*/
		
		
		btnNuevoComentario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaCrearOpinion vco = new VentanaCrearOpinion();
				vco.setVisible(true);
				setVisible(false);
				
				
			}
		});
		
	}

}
