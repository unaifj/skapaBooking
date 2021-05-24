package com.decode.admin;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JTextField;

import com.decode.bd.DBManager;
import com.decode.contacto.Contacto;
import com.decode.objects.Opinion;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;

import javax.swing.JButton;

public class VentanaEditarOpiniones extends JFrame {
	private JTextField textTitulo;
	private JTextField textDesc;
	private JTextField textField_1;
	
	
	public VentanaEditarOpiniones(Opinion o) {
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
		textTitulo.setText(o.getTitulo());
		textTitulo.setColumns(10);
		textTitulo.setBounds(10, 124, 343, 26);
		getContentPane().add(textTitulo);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(10, 181, 106, 26);
		getContentPane().add(lblDescripcion);
		
		textDesc = new JTextField();
		textDesc.setText(o.getDescripcion());
		textDesc.setColumns(10);
		textDesc.setBounds(10, 228, 343, 83);
		getContentPane().add(textDesc);
		
		JLabel lblPuntacion = new JLabel("Puntuacion:");
		lblPuntacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPuntacion.setBounds(10, 352, 106, 26);
		getContentPane().add(lblPuntacion);
		
		textField_1 = new JTextField();
		textField_1.setText(String.valueOf(o.getPuntuacion()));
		textField_1.setColumns(10);
		textField_1.setBounds(116, 352, 113, 26);
		getContentPane().add(textField_1);
		
		JButton btnEditar = new JButton("Guardar");
		btnEditar.setBounds(71, 428, 96, 35);
		getContentPane().add(btnEditar);
		
		JButton btnVolver = new JButton("Volver\r\n");
		btnVolver.setBounds(256, 428, 89, 35);
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAdminOpinion vlo = new VentanaAdminOpinion();
				setVisible(false);
				vlo.setVisible(true);
				
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				// TODO Auto-generated method stub
				String titulo= textTitulo.getText();	
				String descripcion= textDesc.getText();
				Float puntuacion=  Float.parseFloat(textField_1.getText());
				
				o.setTitulo(titulo);
				o.setDescripcion(descripcion);
				o.setPuntuacion(puntuacion);
				
				DBManager dbm = new DBManager();
				dbm.actualizarOpinion(o);
				JOptionPane.showMessageDialog(null, "Opinion actualizada correctamente", "Correcto", 1);
				setVisible(false);
                VentanaAdminOpinion vma = new VentanaAdminOpinion();
                vma.setVisible(true);
			}
		});
		
		
		
		
	}
}
