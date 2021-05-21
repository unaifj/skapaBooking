package com.decode.sesion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.multilenguaje.Idioma;
import com.decode.objects.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
	private DBManager dbm;

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
		setBounds(100, 100, 475, 759);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(null);
		panelNorte.setBackground(Color.BLUE);
		panelNorte.setBounds(0, 0, 1273, 106);
		contentPane.add(panelNorte);
		
		JLabel lblTitulo = new JLabel("SKAPABOOKING.COM");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setBounds(10, 0, 250, 37);
		panelNorte.add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 154, 440, 324);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomUsuario = new JLabel("nombredeusuario");
		lblNomUsuario.setBounds(10, 80, 90, 14);
		panel.add(lblNomUsuario);
		
		JLabel lblCorreo = new JLabel("Correo electronico");
		lblCorreo.setBounds(10, 105, 90, 14);
		panel.add(lblCorreo);
		
		JLabel lblContrasenya = new JLabel("Contraseña");
		lblContrasenya.setBounds(10, 130, 90, 14);
		panel.add(lblContrasenya);
		
		JLabel lblContrasenya2 = new JLabel("Repite la contraseña");
		lblContrasenya2.setBounds(11, 155, 99, 14);
		panel.add(lblContrasenya2);
		
		textNomUsuario = new JTextField();
		textNomUsuario.setBounds(152, 80, 222, 20);
		panel.add(textNomUsuario);
		textNomUsuario.setColumns(10);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(152, 105, 222, 20);
		panel.add(textCorreo);
		textCorreo.setColumns(10);
		
		textContrasenya = new JTextField();
		textContrasenya.setBounds(152, 130, 222, 20);
		panel.add(textContrasenya);
		textContrasenya.setColumns(10);
		
		textContrasenya2 = new JTextField();
		textContrasenya2.setBounds(152, 155, 222, 20);
		panel.add(textContrasenya2);
		textContrasenya2.setColumns(10);
		
		JButton btnSingUp = new JButton("SingUp");
		btnSingUp.setBounds(285, 224, 89, 23);
		panel.add(btnSingUp);
		
		JLabel lblNewLabel = new JLabel("Registrate");
		lblNewLabel.setBounds(10, 11, 137, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 590, 983, 130);
		contentPane.add(panel_1);
		
		JLabel lblContacto = new JLabel("Contacta con nosotros");
		lblContacto.setBounds(1122, 11, 141, 14);
		panel_1.add(lblContacto);
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
	
		btnSingUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				nomUsuario = textNomUsuario.getText();
				correo = textCorreo.getText();
				contrasenya = textContrasenya.getText();
				contrasenya2 = textContrasenya2.getText();
				
				Usuario user = new Usuario(nomUsuario, correo, contrasenya);
				
				try {
					if (!dbm.exiteUsuario(user)) {
						if (contrasenya.equals(contrasenya2)) {

							
								
							dbm.insertarUsuario(user);
							
						
							JOptionPane.showMessageDialog(null, "Cuenta creada con exito", "Exito", 1, null);
							
							VentanaInicio vi = new VentanaInicio(null);
							setVisible(false);
							vi.setVisible(true);

					}else {
						JOptionPane.showMessageDialog(null, "Contraseñas no coinciden", "Error", 0, null);
					}
					}else {
						JOptionPane.showMessageDialog(null, "El nombre de usuario ya esta en uso", "Error", 0, null);
					}
					
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		dbm = new DBManager();
	
		usuarios = dbm.getUsuarios();
		
		
		
		
		
	}

}
