package com.decode.admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.decode.bd.DBManager;
import com.decode.objects.Anuncio;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;

public class VentanaAdminAnuncio extends JFrame  {
	
	/**
	 * Ejecutamos la aplicación.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdmin frame = new VentanaAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaAdminAnuncio() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 62));
		setBounds(300, 200, 1289, 907);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1066, 3, -1066, 696);
		getContentPane().add(scrollPane);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBounds(0, 3, 1273, 106);
		getContentPane().add(panelNorte);
		panelNorte.setBackground(Color.BLUE);
		panelNorte.setLayout(null);
		
		JLabel lblTitulo = new JLabel("SKAPABOOKING.COM");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(10, 0, 250, 37);
		panelNorte.add(lblTitulo);
		
		JLabel lblMoneda = new JLabel("EUR");
		lblMoneda.setForeground(Color.WHITE);
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMoneda.setBounds(765, 8, 46, 24);
		panelNorte.add(lblMoneda);
		
		JLabel lblBandera = new JLabel("New label");
		lblBandera.setIcon(new ImageIcon("C:\\Users\\mikel\\Downloads\\descarga.png"));
		lblBandera.setBounds(821, 11, 40, 27);
		panelNorte.add(lblBandera);
		
		
	
		JLabel lblNewLabel = new JLabel("Has iniciado sesion como: admin " );
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(1062, 17, 201, 14);
		panelNorte.add(lblNewLabel);
		
			
			
		
		
		
		ImageIcon ico1= new ImageIcon("img/tonyespañol.png");//meter las rutas en la bd
		
		ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblBandera.getWidth(), lblBandera.getHeight(), Image.SCALE_SMOOTH));
		lblBandera.setIcon(img1);
		
		
		
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setBounds(781, 665, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.setBounds(781, 714, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Atras");
		btnNewButton_2.setBounds(26, 137, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("LISTA DE ANUNCIOS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(387, 141, 369, 14);
		getContentPane().add(lblNewLabel_1);
		
	
		List <Anuncio> anuncios = new ArrayList<Anuncio>();
		DBManager dbm = new DBManager();
		anuncios= dbm.getAnuncios();

		DefaultListModel<Anuncio> modelo = new DefaultListModel<>();
	
		for (Anuncio a : anuncios) {
			
			modelo.addElement(a);
			
		}
		
		JList<Anuncio> list = new JList<Anuncio>(modelo);
		list.setBounds(241, 176, 515, 561);
		getContentPane().add(list);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					DBManager dbm = new DBManager();
					Anuncio a=list.getSelectedValue();
					dbm.deleteAnuncio(a);
				
				
				
				JOptionPane.showMessageDialog(null, "Anuncio correctamente eliminado", "Eliminado correctamente", 1, null);
				
			}
		});
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBManager dbm = new DBManager();
				Anuncio anuncio=list.getSelectedValue();
				VentanaEditarAnuncioAdmin p= new VentanaEditarAnuncioAdmin(anuncio);
				p.setVisible(true);
				setVisible(false);
				
			}
		});
		
		
	
		
		
		
	}
}