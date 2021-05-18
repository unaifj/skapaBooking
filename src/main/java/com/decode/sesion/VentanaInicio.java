package com.decode.sesion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.decode.admin.VentanaAdmin;
import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.objects.Usuario;
import com.decode.ventanaPrincipal.VentanaPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaInicio extends JFrame {

	private static Usuario user;
	private JPanel contentPane;
	private JTextField textNomUsuario;
	private JTextField textContrasenya;
	private List<Usuario> usuarios;
	private String nomUsuario;
	private String contrasenya;
	private boolean acceso;
	private boolean accesoAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInicio() {
		

		DBManager dbm = new DBManager();
	
			
		usuarios =dbm.getUsuarios();
			

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 676);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(null);
		panelNorte.setBackground(Color.BLUE);
		panelNorte.setBounds(0, 0, 858, 106);
		contentPane.add(panelNorte);
		
		JLabel lblTitulo = new JLabel("SKAPABOOKING.COM");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setBounds(10, 0, 250, 37);
		panelNorte.add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 117, 400, 379);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomUsuario = new JLabel("Nombre de usuario:");
		lblNomUsuario.setBounds(10, 100, 103, 14);
		panel.add(lblNomUsuario);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setBounds(10, 128, 86, 14);
		panel.add(lblContraseña);
		
		textNomUsuario = new JTextField();
		textNomUsuario.setBounds(148, 97, 137, 20);
		panel.add(textNomUsuario);
		textNomUsuario.setColumns(10);
		
		textContrasenya = new JTextField();
		textContrasenya.setBounds(148, 125, 137, 20);
		panel.add(textContrasenya);
		textContrasenya.setColumns(10);
		
		JButton btnLogIn = new JButton("LogIn");
		btnLogIn.setBounds(193, 194, 89, 23);
		panel.add(btnLogIn);
		
		JLabel lblReg = new JLabel("No tengo una cuenta skapa");
		lblReg.setBounds(10, 198, 142, 14);
		panel.add(lblReg);
		
		JLabel lblNewLabel = new JLabel("Inicio de sesion");
		lblNewLabel.setBounds(10, 22, 156, 20);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 507, 851, 130);
		contentPane.add(panel_1);
		
		JLabel lblContacto = new JLabel("Contacta con nosotros");
		lblContacto.setBounds(1122, 11, 141, 14);
		panel_1.add(lblContacto);
		
		lblReg.addMouseListener(new MouseListener() {
			
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
				VentanaRegistro vr = new VentanaRegistro();
				vr.setVisible(true);
				setVisible(false);
				
			}
		});
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnLogIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				nomUsuario = textNomUsuario.getText();
				contrasenya = textContrasenya.getText();
				
				for (Usuario user : usuarios) {
					if (user.getNomUsuario().equals(nomUsuario) && user.getContrasenya().equals(contrasenya)) {
						acceso = true;
						VentanaInicio.user = user;
						
					} else if(nomUsuario.equals("admin") && contrasenya.equals("admin123")) {
						accesoAdmin=true;
						
					}
					
				}
				if (acceso) {
					JOptionPane.showMessageDialog(null, "Inicio de sesion correcto", "Incio correcto", 1, null);
					
					VentanaPrincipal vp = new VentanaPrincipal("ES");
					vp.setVisible(true);
					setVisible(false);
					
				}else if(accesoAdmin){
					JOptionPane.showMessageDialog(null, "Inicio de sesion como admin correcto", "Incio correcto", 1, null);
					
					VentanaAdmin vp = new VentanaAdmin();
					vp.setVisible(true);
					setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Error con las credenciales", "Error", 0, null);
				}
				
				
			}
		});
		
		
		acceso = false;
		accesoAdmin=false;
		
		
		
		
	}
	
	public static Usuario getUser() {
		return user;
	}
}
