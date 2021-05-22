package com.decode.ventanaperfil;

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
import com.decode.objects.Usuario;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpinnerNumberModel;

public class VentanaConfiguacion extends JFrame  {
	private JTextField textNomUsu;
	private JTextField textNom;
	private JTextField textApe;
	private JTextField textCorreo;
	private int contNomUsuario;
	private int contNomAp;
	private int contCorreo;
	private JTextField textContrasenyaActual;
	private JTextField textNuevaCon;
	private JTextField textNuevaCon2;
	/**
	 * Ejecutamos la aplicación.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConfiguacion frame = new VentanaConfiguacion(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaConfiguacion(Usuario user) {
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
			
			
		}
		
		
		ImageIcon ico1= new ImageIcon("imagenes/tonyespañol.png");//meter las rutas en la bd
		
		ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblBandera.getWidth(), lblBandera.getHeight(), Image.SCALE_SMOOTH));
		lblBandera.setIcon(img1);
		
		JLabel lblNewLabel_1 = new JLabel("Configuracion general");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 120, 179, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Configuracion avanzada");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 467, 179, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Informacion de la cuenta");
		lblNewLabel_3.setBounds(59, 145, 130, 14);
		getContentPane().add(lblNewLabel_3);
		
		textNomUsu = new JTextField(user.getNomUsuario());
		textNomUsu.setEditable(false);
		textNomUsu.setBounds(218, 187, 130, 20);
		getContentPane().add(textNomUsu);
		textNomUsu.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre de usuario");
		lblNewLabel_4.setBounds(82, 190, 107, 14);
		getContentPane().add(lblNewLabel_4);
		
		textNom = new JTextField();
		textNom.setEditable(false);
		textNom.setBounds(218, 229, 130, 20);
		getContentPane().add(textNom);
		textNom.setColumns(10);
		
		JButton btnEditarNomUsuario = new JButton("Editar");
		btnEditarNomUsuario.setBounds(381, 186, 80, 23);
		getContentPane().add(btnEditarNomUsuario);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre");
		lblNewLabel_5.setBounds(82, 232, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Apellidos");
		lblNewLabel_6.setBounds(82, 257, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		textApe = new JTextField();
		textApe.setEditable(false);
		textApe.setBounds(218, 254, 130, 20);
		getContentPane().add(textApe);
		textApe.setColumns(10);
		
		JButton btnEditarNombreApp = new JButton("Editar");
		btnEditarNombreApp.setBounds(381, 253, 80, 23);
		getContentPane().add(btnEditarNombreApp);
		
		JLabel lblNewLabel_7 = new JLabel("Imagen");
		lblNewLabel_7.setBounds(643, 257, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		JButton btnEditarImagen = new JButton("Select");
		btnEditarImagen.setBounds(954, 253, 80, 23);
		getContentPane().add(btnEditarImagen);
		
		JLabel lblNewLabel_4_1 = new JLabel("Correo electronico");
		lblNewLabel_4_1.setBounds(643, 183, 107, 14);
		getContentPane().add(lblNewLabel_4_1);
		
		textCorreo = new JTextField(user.getNomUsuario());
		textCorreo.setEditable(false);
		textCorreo.setColumns(10);
		textCorreo.setBounds(760, 180, 149, 20);
		getContentPane().add(textCorreo);
		
		JButton btnEditarCorreo = new JButton("Editar");
		btnEditarCorreo.setBounds(954, 179, 80, 23);
		getContentPane().add(btnEditarCorreo);
		
		JLabel lblNewLabel_3_1 = new JLabel("Cambiar contraseña");
		lblNewLabel_3_1.setBounds(59, 330, 130, 14);
		getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Contraseña actual");
		lblNewLabel_4_2.setBounds(82, 370, 107, 14);
		getContentPane().add(lblNewLabel_4_2);
		
		textContrasenyaActual = new JTextField();
		textContrasenyaActual.setColumns(10);
		textContrasenyaActual.setBounds(199, 367, 130, 20);
		getContentPane().add(textContrasenyaActual);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Nueva contraseña");
		lblNewLabel_4_2_1.setBounds(365, 370, 107, 14);
		getContentPane().add(lblNewLabel_4_2_1);
		
		textNuevaCon = new JTextField();
		textNuevaCon.setColumns(10);
		textNuevaCon.setBounds(482, 367, 130, 20);
		getContentPane().add(textNuevaCon);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("Repetir nueva contraseña");
		lblNewLabel_4_2_2.setBounds(643, 370, 149, 14);
		getContentPane().add(lblNewLabel_4_2_2);
		
		textNuevaCon2 = new JTextField();
		textNuevaCon2.setColumns(10);
		textNuevaCon2.setBounds(802, 367, 130, 20);
		getContentPane().add(textNuevaCon2);
		
		JButton btnContrasenya = new JButton("Guardar");
		btnContrasenya.setBounds(954, 366, 89, 23);
		getContentPane().add(btnContrasenya);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(72, 415, 89, 23);
		getContentPane().add(btnNewButton);
		
		DBManager dbm = new DBManager();
		
	
		contNomUsuario = 0;
		
		btnEditarNomUsuario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contNomUsuario % 2 ==0 || contNomUsuario == 0) {
					textNomUsu.setEditable(true);
					btnEditarNomUsuario.setText("Guardar");
					
				}else {
					textNomUsu.setEditable(false);
					btnEditarNomUsuario.setText("Editar");
					user.setNomUsuario(textNomUsu.getText());
					dbm.actualizarUsuario(user);
					
				}
				contNomUsuario++;
				
				
			}
		});
		
		contNomAp = 0;
		btnEditarNombreApp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contNomAp % 2 ==0 || contNomAp == 0) {
					textNom.setEditable(true);
					textApe.setEditable(true);
					btnEditarNombreApp.setText("Guardar");
				}else {
					textNom.setEditable(false);
					textApe.setEditable(false);
					btnEditarNombreApp.setText("Editar");
					
				}
				contNomAp++;
				
			
				
			}
		});
		
		contCorreo = 0;
		btnEditarCorreo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (contCorreo % 2 == 0 || contCorreo == 0) {
					textCorreo.setEditable(true);
					btnEditarCorreo.setText("Guardar");
				}else {
					textCorreo.setEditable(false);
					btnEditarCorreo.setText("Editar");
					user.setCorreo(textCorreo.getText());
					dbm.actualizarUsuario(user);
				}
				
				contCorreo++;
				
			
				
			}
		});
		
		
		btnContrasenya.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (textContrasenyaActual.getText().equals(user.getContrasenya())) {
					if (textNuevaCon.getText().equals(textNuevaCon2.getText())) {
						user.setContrasenya(textNuevaCon.getText());
						dbm.actualizarUsuario(user);
						
					}
				}
				
				textContrasenyaActual.setText("");
				textNuevaCon.setText("");
				textNuevaCon2.setText("");
				
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 VentanaCrearAnuncio C = new VentanaCrearAnuncio();
				 setVisible(false);
				 C.setVisible(true);				
			}
			
		});
		btnEditarImagen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				JFileChooser fc = new JFileChooser();
				fc.setCurrentDirectory(new File(".")); //Abre el directorio raiz de mi proyecto
				//fc.setCurrentDirectory(new File("src")); //Abre la carpeta src de mi proyecto
				int seleccionado = fc.showOpenDialog(null);
				if(seleccionado == JFileChooser.APPROVE_OPTION) {
					File ficheroSeleccionado = fc.getSelectedFile();
					ficheroSeleccionado.getAbsolutePath();
				}
				
			}
		});
		
		
		

	
		
		
	
		
		
		
	}
}
