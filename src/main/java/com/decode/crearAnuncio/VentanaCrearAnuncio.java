package com.decode.crearAnuncio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.objects.Anuncio;
import com.decode.objects.Apartamento;
import com.decode.objects.Localidad;
import com.decode.objects.Reserva;
import com.decode.sesion.VentanaInicio;
import com.decode.ventanaperfil.VentanaPerfil;

import javax.swing.JTextField;

public class VentanaCrearAnuncio extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtLocalizacion;
	private JTextField txtMetrosCuadrados;
	private JTextField txtHabitaciones;
	private JTextField txtPrecio;
	private JTextField txtDescripcion;
	private JTextField textField;
	private JTextField txtCodigoPostal;
	private JTextField txtMunicipio;
	private JTextField txtDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrearAnuncio frame = new VentanaCrearAnuncio();
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
	public VentanaCrearAnuncio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 1289, 809);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JButton btnRegistro = new JButton("Hazte cuenta");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistro.setBounds(960, 13, 117, 23);
		panelNorte.add(btnRegistro);
		
		JButton btnLogin = new JButton("Iniciar Sesion");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(1087, 13, 123, 23);
		panelNorte.add(btnLogin);
		
		ImageIcon ico1= new ImageIcon("imagenes/tonyespañol.png");
		
		JLabel lblIntro = new JLabel("Introduzca los datos de su apartamento");
		lblIntro.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIntro.setBounds(10, 120, 576, 55);
		contentPane.add(lblIntro);
		
		JLabel lblFoto = new JLabel("FOOOOTOOO");
		lblFoto.setBounds(623, 153, 378, 408);
		contentPane.add(lblFoto);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(207, 178, 258, 30);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtLocalizacion = new JTextField();
		txtLocalizacion.setColumns(10);
		txtLocalizacion.setBounds(207, 223, 258, 23);
		contentPane.add(txtLocalizacion);
		
		txtMetrosCuadrados = new JTextField();
		txtMetrosCuadrados.setColumns(10);
		txtMetrosCuadrados.setBounds(207, 355, 258, 30);
		contentPane.add(txtMetrosCuadrados);
		
		txtHabitaciones = new JTextField();
		txtHabitaciones.setColumns(10);
		txtHabitaciones.setBounds(207, 396, 258, 30);
		contentPane.add(txtHabitaciones);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(207, 446, 258, 30);
		contentPane.add(txtPrecio);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(207, 579, 258, 180);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JButton btnImagen = new JButton("Añadir imagen");
		btnImagen.setBounds(548, 594, 130, 23);
		contentPane.add(btnImagen);
		btnImagen.setBackground(Color.WHITE);
		
		JButton btnPublicar = new JButton("Publicar");
		btnPublicar.setBounds(1066, 693, 130, 37);
		contentPane.add(btnPublicar);
		
		JLabel lblNewLabel = new JLabel("Titulo:");
		lblNewLabel.setBounds(10, 186, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Provincia:");
		lblNewLabel_1.setBounds(10, 227, 104, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Metros cuadrados (m2):");
		lblNewLabel_2.setBounds(10, 363, 160, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero de habitaciones:");
		lblNewLabel_3.setBounds(10, 409, 160, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Precio por noche:");
		lblNewLabel_4.setBounds(10, 454, 122, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion:");
		lblNewLabel_5.setBounds(10, 579, 92, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Numero de personas:");
		lblNewLabel_6.setBounds(10, 495, 141, 16);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(207, 487, 258, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Codigo Postal: ");
		lblNewLabel_7.setBounds(10, 318, 104, 14);
		contentPane.add(lblNewLabel_7);
		
		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setBounds(207, 315, 258, 20);
		contentPane.add(txtCodigoPostal);
		txtCodigoPostal.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Municipio:");
		lblNewLabel_8.setBounds(10, 272, 75, 14);
		contentPane.add(lblNewLabel_8);
		
		txtMunicipio = new JTextField();
		txtMunicipio.setBounds(207, 269, 258, 20);
		contentPane.add(txtMunicipio);
		txtMunicipio.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Direccion:");
		lblNewLabel_9.setBounds(10, 547, 75, 14);
		contentPane.add(lblNewLabel_9);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(207, 544, 263, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		//BOTON IMAGEN 
//		btnImagen.addActionListener(new ActionListener() {
//			
//			
//		});
		
		btnPublicar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	
            	String nombre = txtNombre.getText();
            	String desc = txtDescripcion.getText();
				String provincia = txtLocalizacion.getText();
				int numHab = Integer.parseInt(txtHabitaciones.getText());
				double precio = Double.parseDouble(txtPrecio.getText());
				int m2 = Integer.parseInt(txtMetrosCuadrados.getText());
				String municipio= txtMunicipio.getText();
				int codigo= Integer.parseInt(txtCodigoPostal.getText());
				String direccion= txtDireccion.getText();
            	
            	float puntuacion = Float.parseFloat(textField.getText());
            	
            	Localidad loc= new Localidad(provincia, municipio,codigo,direccion);
            	List<Reserva> reservas = new ArrayList<Reserva>();
				Apartamento aparta = new Apartamento(numHab, m2, loc,reservas);
				Anuncio anuncio = new Anuncio(VentanaInicio.getUser(),aparta,nombre, desc, precio, false, m2);

				System.out.println("EL ANUNCIO" + anuncio);
				
				DBManager dbm = new DBManager();
				try {
					dbm.insertarAnuncio(anuncio);
				} catch (DBException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                VentanaPerfil C = new VentanaPerfil();
				 setVisible(false);
				 C.setVisible(true);



            }
        });
		
		
		
		
		
	}
}
