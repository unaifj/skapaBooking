package com.decode.admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import com.decode.*;
import com.decode.bd.DBManager;
import com.decode.contacto.Contacto;
import com.decode.objects.Opinion;
import com.decode.objects.Usuario;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;

public class VentanaAdminOpinion extends JFrame {
	public VentanaAdminOpinion() {
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
		
		
		
		JLabel lblTusOpiniones = new JLabel("Tus Opiniones");
		lblTusOpiniones.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTusOpiniones.setBounds(509, 135, 173, 26);
		getContentPane().add(lblTusOpiniones);
		
		JButton btnEliminar = new JButton("Eliminar Opinion");
		btnEliminar.setBounds(288, 603, 128, 23);
		getContentPane().add(btnEliminar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(556, 603, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(848, 603, 89, 23);
		getContentPane().add(btnAtras);
		
		List <Opinion> opiniones = new ArrayList<Opinion>();
		DBManager dbm = new DBManager();
		opiniones= dbm.getOpinionesSinUser();

		DefaultListModel<Opinion> modelo = new DefaultListModel<>();
	
		for (Opinion o : opiniones) {
			modelo.addElement(o);;
			
			
		}
		JList listOpiniones = new JList(modelo);
		listOpiniones.setBounds(228, 172, 725, 420);
		getContentPane().add(listOpiniones);
	
		JLabel lblNewLabel = new JLabel("Has iniciado sesion como: admin " );
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(1062, 17, 201, 14);
		panelNorte.add(lblNewLabel);
			
			
		
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
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				VentanaAdmin va = new VentanaAdmin();
				va.setVisible(true);
				
				
				
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBManager dbm = new DBManager();
				Opinion o=(Opinion) listOpiniones.getSelectedValue();
				dbm.deleteOpinionByTitulo(o.getTitulo());
			
			
			
			JOptionPane.showMessageDialog(null, "Usuario correctamente eliminada", "Eliminado correctamente", 1, null);
			}
		});
		
		btnEditar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBManager dbm = new DBManager();
				Opinion o=(Opinion) listOpiniones.getSelectedValue();
				setVisible(false);
				VentanaEditarOpiniones veo = new VentanaEditarOpiniones(o);
				veo.setVisible(true);
				
			}
			
		});
		
	}
}
