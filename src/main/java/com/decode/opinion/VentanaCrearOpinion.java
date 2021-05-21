package com.decode.opinion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.contacto.Ayuda;
import  com.decode.objects.Opinion;
import com.decode.sesion.VentanaInicio;



public class VentanaCrearOpinion extends JFrame {
	
	private JTextField textTitulo;
	private JTextField textDesc;
	private JTextField textField;
	
	public VentanaCrearOpinion() {
		
		int idU = VentanaInicio.getUser().getId();
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 473, 551);
			getContentPane().setBackground(new Color(30, 144, 255));
			getContentPane().setLayout(null);
			
			JLabel lblCabecera = new JLabel("Dejanos tu opinion acerca del alojamineto");
			lblCabecera.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblCabecera.setBounds(10, 0, 424, 107);
			getContentPane().add(lblCabecera);
			
			JLabel lblTitulo = new JLabel("Titulo");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTitulo.setBounds(30, 97, 65, 20);
			getContentPane().add(lblTitulo);
			
			textTitulo = new JTextField();
			textTitulo.setBounds(30, 130, 343, 26);
			getContentPane().add(textTitulo);
			textTitulo.setColumns(10);
			
			JLabel lblDescripcion = new JLabel("Descripcion");
			lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblDescripcion.setBounds(30, 167, 106, 26);
			getContentPane().add(lblDescripcion);
			
			textDesc = new JTextField();
			textDesc.setBounds(30, 204, 343, 83);
			getContentPane().add(textDesc);
			textDesc.setColumns(10);
			
			JLabel lblPuntacion = new JLabel("Puntuacion:");
			lblPuntacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPuntacion.setBounds(30, 314, 106, 26);
			getContentPane().add(lblPuntacion);
			
			textField = new JTextField();
			textField.setBounds(124, 316, 113, 26);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			JButton btnPublicar = new JButton("Publicar\r\n ");
			btnPublicar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(null, "Gracias por tu opinión", "Correcto", 1);
				}
			});
			btnPublicar.setBounds(61, 407, 96, 35);
			getContentPane().add(btnPublicar);
			
			JButton btnCancelar = new JButton("Volver\r\n");
			btnCancelar.setBounds(284, 407, 89, 35);
			getContentPane().add(btnCancelar);
			
			DBManager dbm = new DBManager();
			
			btnPublicar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
										
					String titulo = textTitulo.getText();
					String descripcion = textDesc.getText();
					float puntuacion = Float.parseFloat(textField.getText());
					
					Opinion opinion = new Opinion(VentanaInicio.getUser(), titulo, descripcion, puntuacion);
					try {
						dbm.insertarOpinion(opinion);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					
					
				}
			});
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaOpiniones vo = new VentanaOpiniones();
					setVisible(false);
					vo.setVisible(true);
					}
				});
			
			
			
			

		}
}
