package com.decode.sesion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class VentanaInicio extends JFrame {

	private static Usuario user;
	private JPanel contentPane;
	private JTextField textNomUsuario;
	private JTextField textContrasenya;
	private List<Usuario> usuarios;
	private String nomUsuario;
	private String contrasenya;
	private boolean acceso;

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
		try {
			
			usuarios =dbm.listarUsuarios();
			
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomUsuario = new JLabel("Nombre de usuario:");
		lblNomUsuario.setBounds(10, 78, 103, 14);
		contentPane.add(lblNomUsuario);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setBounds(10, 118, 86, 14);
		contentPane.add(lblContraseña);
		
		textNomUsuario = new JTextField();
		textNomUsuario.setBounds(154, 75, 137, 20);
		contentPane.add(textNomUsuario);
		textNomUsuario.setColumns(10);
		
		textContrasenya = new JTextField();
		textContrasenya.setBounds(154, 115, 137, 20);
		contentPane.add(textContrasenya);
		textContrasenya.setColumns(10);
		
		JButton btnLogIn = new JButton("LogIn");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogIn.setBounds(202, 163, 89, 23);
		contentPane.add(btnLogIn);
		
		JLabel lblNewLabel = new JLabel("SKAPABOOKING");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 156, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblReg = new JLabel("No tengo una cuenta skapa");
		lblReg.setBounds(161, 210, 142, 14);
		contentPane.add(lblReg);
		
		
		acceso = false;
		
		btnLogIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				nomUsuario = textNomUsuario.getText();
				contrasenya = textContrasenya.getText();
				
				for (Usuario user : usuarios) {
					if (user.getNomUsuario().equals(nomUsuario) && user.getContrasenya().equals(contrasenya)) {
						acceso = true;
						VentanaInicio.user = user;
						
					}
					
				}
				if (acceso) {
					JOptionPane.showMessageDialog(null, "Inicio de sesion correcto", "Incio correcto", 1, null);
					
					VentanaPrincipal vp = new VentanaPrincipal();
					vp.setVisible(true);
					setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Error con las credenciales", "Error", 0, null);
				}
				
				
			}
		});
		
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
		
		
		
		
	}
	
	public static Usuario getUser() {
		return user;
	}
}
