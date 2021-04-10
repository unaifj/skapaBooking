package com.decode.sesion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.objects.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textNomUsuario;
	private JTextField textCorreo;
	private JTextField textContrasenya;
	private JTextField textContrasenya2;
	private List<Usuario> usuarios;
	private String nomUsuario;
	private String correo;
	private String contrasenya;
	private String contrasenya2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SKAPABOOKING");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 137, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomUsuario = new JLabel("Nombre de usuario");
		lblNomUsuario.setBounds(10, 71, 90, 14);
		contentPane.add(lblNomUsuario);
		
		JLabel lblCorreo = new JLabel("Correo electronico");
		lblCorreo.setBounds(10, 96, 90, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblContrasenya = new JLabel("Contraseña");
		lblContrasenya.setBounds(10, 121, 90, 14);
		contentPane.add(lblContrasenya);
		
		JLabel lblContrasenya2 = new JLabel("Repite la contraseña");
		lblContrasenya2.setBounds(10, 146, 99, 14);
		contentPane.add(lblContrasenya2);
		
		textNomUsuario = new JTextField();
		textNomUsuario.setBounds(147, 68, 222, 20);
		contentPane.add(textNomUsuario);
		textNomUsuario.setColumns(10);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(147, 93, 222, 20);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);
		
		textContrasenya = new JTextField();
		textContrasenya.setBounds(147, 118, 222, 20);
		contentPane.add(textContrasenya);
		textContrasenya.setColumns(10);
		
		textContrasenya2 = new JTextField();
		textContrasenya2.setBounds(147, 143, 222, 20);
		contentPane.add(textContrasenya2);
		textContrasenya2.setColumns(10);
		
		JButton btnSingUp = new JButton("SingUp");
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSingUp.setBounds(280, 214, 89, 23);
		contentPane.add(btnSingUp);
		
		DBManager dbm = new DBManager();
		try {
			usuarios = dbm.listarUsuarios();
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		btnSingUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				nomUsuario = textNomUsuario.getText();
				correo = textCorreo.getText();
				contrasenya = textContrasenya.getText();
				contrasenya2 = textContrasenya2.getText();
				
				if (contrasenya.equals(contrasenya2)) {

						Usuario user = new Usuario(nomUsuario, correo, contrasenya);
						
						try {
							
							dbm.insertarUsuario(user);
						
						} catch (DBException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Cuenta creada con exito", "Exito", 1, null);
						
						VentanaInicio vi = new VentanaInicio();
						setVisible(false);
						vi.setVisible(true);

				}else {
					JOptionPane.showMessageDialog(null, "Contraseñas no coinciden", "Error", 0, null);
				}
				
			}
		});
		
		
		
		
		
	}

}
