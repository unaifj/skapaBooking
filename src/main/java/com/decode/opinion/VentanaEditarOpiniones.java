package com.decode.opinion;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaEditarOpiniones extends JFrame {
	private JTextField textTitulo;
	private JTextField textDesc;
	private JTextField textField_1;
	
	
	public VentanaEditarOpiniones() {
		getContentPane().setBackground(new Color(30, 144, 255));
		getContentPane().setForeground(SystemColor.textHighlight);
		setBounds(100, 100, 473, 551);
		getContentPane().setLayout(null);
		
		JLabel lblEditaTuOpinion = new JLabel("Edita tu opinion de los apartamentos");
		lblEditaTuOpinion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEditaTuOpinion.setBounds(10, 0, 447, 107);
		getContentPane().add(lblEditaTuOpinion);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(10, 93, 65, 20);
		getContentPane().add(lblTitulo);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(10, 124, 343, 26);
		getContentPane().add(textTitulo);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(10, 181, 106, 26);
		getContentPane().add(lblDescripcion);
		
		textDesc = new JTextField();
		textDesc.setColumns(10);
		textDesc.setBounds(10, 228, 343, 83);
		getContentPane().add(textDesc);
		
		JLabel lblPuntacion = new JLabel("Puntuacion:");
		lblPuntacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPuntacion.setBounds(10, 352, 106, 26);
		getContentPane().add(lblPuntacion);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(116, 352, 113, 26);
		getContentPane().add(textField_1);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(71, 428, 96, 35);
		getContentPane().add(btnEditar);
		
		JButton btnCancelar = new JButton("Volver\r\n");
		btnCancelar.setBounds(256, 428, 89, 35);
		getContentPane().add(btnCancelar);
		
		
		
	}
}
