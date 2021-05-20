package com.decode.ventanaPrincipal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.JButton;

public class VentanaListaAnuncios extends JFrame  {
	public VentanaListaAnuncios() {
		setBounds(300, 200, 1289, 809);
		getContentPane().setLayout(null);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(null);
		panelNorte.setBackground(Color.BLUE);
		panelNorte.setBounds(0, 0, 1273, 106);
		getContentPane().add(panelNorte);
		
		JLabel lblTitulo = new JLabel("SKAPABOOKING.COM");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setBounds(10, 0, 250, 37);
		panelNorte.add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 650, 1273, 120);
		getContentPane().add(panel);
		
		JLabel lblContacto = new JLabel("Contacta con nosotros");
		lblContacto.setBounds(1122, 27, 141, 14);
		panel.add(lblContacto);
		
		JList list = new JList((ListModel) null);
		list.setBounds(184, 174, 725, 420);
		getContentPane().add(list);
		
		JLabel lblAnuncios = new JLabel("Anuncios");
		lblAnuncios.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAnuncios.setBounds(473, 130, 89, 26);
		getContentPane().add(lblAnuncios);
		
		JButton btnNewButton = new JButton("Añadir Anuncio");
		btnNewButton.setBounds(225, 616, 105, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.setBounds(501, 616, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Volver\r\n");
		btnNewButton_2.setBounds(780, 616, 89, 23);
		getContentPane().add(btnNewButton_2);
	}
}
