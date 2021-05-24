package com.decode.pago;

import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.decode.bd.DBManager;
import com.decode.objects.Anuncio;
import com.decode.objects.TarjetaCredito;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;
import com.decode.ventanaPrincipal.VentanaPrincipal;


public class VentanaVerTarjetas extends JFrame {

	private JPanel contentPane;

	


	/**
	 * Create the frame.
	 */
	public VentanaVerTarjetas(Anuncio anuncio) {
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
					VentanaInicio vi = new VentanaInicio(null);
					vi.setVisible(true);
					
				}
			});
			
			btnRegistro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaRegistro vr = new VentanaRegistro(null);
					vr.setVisible(true);
					
				}
			});
			
		}else {
			JLabel lblNewLabel = new JLabel("Has iniciado sesion como:  " + VentanaInicio.getUser().getNomUsuario());
			lblNewLabel.setForeground(Color.LIGHT_GRAY);
			lblNewLabel.setBounds(1062, 17, 201, 14);
			panelNorte.add(lblNewLabel);
			
			JButton btnCerrarSesion = new JButton("Cerrar sesion");
			btnCerrarSesion.setBounds(785, 83, 152, 23);
			panelNorte.add(btnCerrarSesion);
			
			btnCerrarSesion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaPrincipal vp2 = new VentanaPrincipal("ES", null);
					vp2.setVisible(true);
					
				}
			});
			
		}
		
		
		ImageIcon ico1= new ImageIcon("img/tonyespañol.png");//meter las rutas en la bd
		
		ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblBandera.getWidth(), lblBandera.getHeight(), Image.SCALE_SMOOTH));
		lblBandera.setIcon(img1);
		
		JButton btnAnyadir = new JButton("Añadir tarjeta");
		btnAnyadir.setBounds(771, 676, 125, 23);
		getContentPane().add(btnAnyadir);
		
		JButton btnNewButton_2 = new JButton("Atras");
		btnNewButton_2.setBounds(26, 137, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("LISTA DE TARJETAS DE "+ VentanaInicio.getUser().getNomUsuario());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(387, 141, 369, 14);
		getContentPane().add(lblNewLabel_1);
		
	
		List <TarjetaCredito> tarjetasUsuario = new ArrayList<TarjetaCredito>();
		DBManager dbm = new DBManager();
		tarjetasUsuario= dbm.getTarjeta(VentanaInicio.getUser());

		DefaultListModel<TarjetaCredito> modelo = new DefaultListModel<>();
	
		for (TarjetaCredito tar : tarjetasUsuario) {
			
			modelo.addElement(tar);
			
		}
		
		JList<TarjetaCredito> list = new JList<TarjetaCredito>(modelo);
		list.setBounds(241, 176, 515, 561);
		getContentPane().add(list);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(771, 710, 125, 32);
		getContentPane().add(btnPagar);
		
		
		btnAnyadir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					VentanaAnyadirTarjeta a = new VentanaAnyadirTarjeta(anuncio);
					a.setVisible(true);
					setVisible(false);
				
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				VentanaPago p = new VentanaPago(anuncio);
				p.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnPagar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBManager dbm = new DBManager();
				TarjetaCredito t=list.getSelectedValue();
				
				
				VentanaPagoDatos C = new VentanaPagoDatos(t,anuncio);
				setVisible(false);
				C.setVisible(true);
			}
		});
		
		
	
		
		
		
	}
}