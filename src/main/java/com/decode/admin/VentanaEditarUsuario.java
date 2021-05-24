package com.decode.admin;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.contacto.Contacto;
import com.decode.misanuncios.VentanaMisAnuncios;
import com.decode.objects.Usuario;
import com.decode.sesion.VentanaInicio;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaEditarUsuario extends JFrame{
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	
	public VentanaEditarUsuario(Usuario u) {
		setBounds(300, 200, 1112, 907);
		getContentPane().setLayout(null);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(null);
		panelNorte.setBackground(Color.BLUE);
		panelNorte.setBounds(0, 0, 1102, 106);
		getContentPane().add(panelNorte);
		
		JLabel lblTitulo = new JLabel("SKAPABOOKING.COM");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setBounds(10, 0, 250, 37);
		panelNorte.add(lblTitulo);
		
		JLabel lblMoneda = new JLabel("EUR");
		lblMoneda.setForeground(Color.WHITE);
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMoneda.setBounds(765, 8, 46, 24);
		panelNorte.add(lblMoneda);
		
		JLabel lblBandera = new JLabel("New label");
		lblBandera.setBounds(821, 11, 40, 27);
		panelNorte.add(lblBandera);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 106, 1102, 444);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFormulario = new JLabel("EDICIÓN DE USUARIO");
		lblFormulario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFormulario.setBounds(458, 27, 358, 32);
		panel.add(lblFormulario);
		
		txtNombre = new JTextField();
		txtNombre.setText(u.getNomUsuario());
		txtNombre.setBounds(458, 113, 297, 25);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setText(u.getContrasenya());
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(458, 176, 297, 25);
		panel.add(txtApellidos);
		
		txtCorreo = new JTextField();
		txtCorreo.setText(u.getCorreo());
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(458, 242, 297, 25);
		panel.add(txtCorreo);
		
		JButton btnInscribirse = new JButton("Guardar");
		btnInscribirse.setBounds(458, 334, 89, 23);
		panel.add(btnInscribirse);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(666, 334, 89, 23);
		panel.add(btnAtras);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 750, 1102, 118);
		getContentPane().add(panel_1);
		
		JLabel lblContacto = new JLabel("Contacta con nosotros");
		lblContacto.setBounds(959, 11, 141, 14);
		panel_1.add(lblContacto);
		
		JLabel lblNewLabel = new JLabel("Has iniciado sesion como: admin " );
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(1062, 17, 201, 14);
		panelNorte.add(lblNewLabel);
		
		
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAdmin va = new VentanaAdmin();
				setVisible(true);
				va.setVisible(true);
				
			}
			
		});
		lblContacto.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Contacto c = new Contacto();
				c.setVisible(true);
				
			}
		});
		btnInscribirse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombre= txtNombre.getText();	
				String contra= txtApellidos.getText();
				String correo= txtCorreo.getText();
				
				u.setNomUsuario(nombre);
				u.setContrasenya(contra);
				u.setCorreo(correo);
				
				DBManager dbm = new DBManager();
				dbm.actualizarUsuario(u);
				JOptionPane.showMessageDialog(null, "El usuario se ha actualizado correctamente", "Correcto", 1);
				setVisible(false);
                VentanaAdminUsuarios vma = new VentanaAdminUsuarios();
                vma.setVisible(true);
			}
		});
		
		
	}
}
