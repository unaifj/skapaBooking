package com.decode.admin;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.contacto.Contacto;
import com.decode.crearAnuncio.VentanaCrearAnuncio;
import com.decode.objects.Anuncio;
import com.decode.objects.TarjetaCredito;
import com.decode.objects.Usuario;
import com.decode.pago.VentanaVerTarjetas;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class VentanaAdminUsuarios extends JFrame  {
	
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
	
	public VentanaAdminUsuarios() {
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
		
		
		
		if (VentanaInicio.getUser() == null) {
			
			JButton btnRegistro = new JButton("Hazte cuenta");
			btnRegistro.setBounds(960, 13, 117, 23);
			panelNorte.add(btnRegistro);
			
			JButton btnLogin = new JButton("Iniciar Sesion");
			btnLogin.setBounds(1087, 13, 123, 23);
			panelNorte.add(btnLogin);
			
			btnLogin.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaInicio vi = new VentanaInicio();
					vi.setVisible(true);
					
				}
			});
			
			btnRegistro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaRegistro vr = new VentanaRegistro();
					vr.setVisible(true);
					
				}
			});
			
		}else {
			JLabel lblNewLabel = new JLabel("Has iniciado sesion como:  " + VentanaInicio.getUser().getNomUsuario());
			lblNewLabel.setForeground(Color.LIGHT_GRAY);
			lblNewLabel.setBounds(1062, 17, 201, 14);
			panelNorte.add(lblNewLabel);
			
			
		}
		
		
		ImageIcon ico1= new ImageIcon("imagenes/tonyespañol.png");//meter las rutas en la bd
		
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
		
		JLabel lblNewLabel_1 = new JLabel("LISTA DE USUARIOS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(387, 141, 369, 14);
		getContentPane().add(lblNewLabel_1);
		
	
		List <Usuario> usuarios = new ArrayList<Usuario>();
		DBManager dbm = new DBManager();
		usuarios= dbm.getUsuarios();

		DefaultListModel<Object> modelo = new DefaultListModel<>();
	
		for (Usuario u : usuarios) {
			
			modelo.addElement(u.getNomUsuario());
		}
		
		JList<Object> list = new JList<Object>(modelo);
		list.setBounds(241, 176, 515, 561);
		getContentPane().add(list);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			
				
				Usuario u= new Usuario(getTitle(), getWarningString(), getName());
				
				dbm.deleteUsuarioByNomUsuario(getName());
				
				JOptionPane.showMessageDialog(null, "Tarjeta correctamente añadida", "Añadido correctamente", 1, null);
				VentanaVerTarjetas C = new VentanaVerTarjetas();
				setVisible(false);
				C.setVisible(true);
			}
		});
		
		
	
		
		
	
		
		
		
	}
}