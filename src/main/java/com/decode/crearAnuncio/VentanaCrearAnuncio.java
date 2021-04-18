package com.decode.crearAnuncio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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

import javax.swing.JTextField;

public class VentanaCrearAnuncio extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtLocalizacion;
	private JTextField txtMetrosCuadrados;
	private JTextField txtHabitaciones;
	private JTextField txtPrecio;
	private JTextField txtDescripcion;
	private DBManager dbm;

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
		
		JLabel lblBandera = new JLabel("New label");
		lblBandera.setIcon(new ImageIcon("C:\\Users\\mikel\\Downloads\\descarga.png"));
		lblBandera.setBounds(821, 11, 40, 27);
		panelNorte.add(lblBandera);
		
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
		
		ImageIcon ico1= new ImageIcon("imagenes/tonyespañol.png");//meter las rutas en la bd
		
		ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblBandera.getWidth(), lblBandera.getHeight(), Image.SCALE_SMOOTH));
		lblBandera.setIcon(img1);
		
		JLabel lblIntro = new JLabel("Introduzca los datos de su apartamento");
		lblIntro.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIntro.setBounds(10, 120, 576, 55);
		contentPane.add(lblIntro);
		
		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setBounds(918, 176, 378, 408);
		contentPane.add(lblFoto);
		
		txtNombre = new JTextField();
		txtNombre.setText("Introduzca el nombre de su apartamento");
		txtNombre.setBounds(207, 178, 258, 30);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtLocalizacion = new JTextField();
		txtLocalizacion.setText("Localizacion exacta de la vivienda");
		txtLocalizacion.setColumns(10);
		txtLocalizacion.setBounds(207, 219, 258, 30);
		contentPane.add(txtLocalizacion);
		
		txtMetrosCuadrados = new JTextField();
		txtMetrosCuadrados.setText("Metros cuadrados de la vivienda");
		txtMetrosCuadrados.setColumns(10);
		txtMetrosCuadrados.setBounds(207, 260, 258, 30);
		contentPane.add(txtMetrosCuadrados);
		
		txtHabitaciones = new JTextField();
		txtHabitaciones.setText("Introduzca el numero de habitaciones de su vivienda");
		txtHabitaciones.setColumns(10);
		txtHabitaciones.setBounds(207, 301, 258, 30);
		contentPane.add(txtHabitaciones);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("Introduzca el precio deseado por noche para su vivienda");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(207, 342, 258, 30);
		contentPane.add(txtPrecio);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setText("Descripcion");
		txtDescripcion.setBounds(207, 383, 258, 180);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JButton btnImagen = new JButton("Añadir imagen");
		btnImagen.setBounds(872, 582, 130, 23);
		contentPane.add(btnImagen);
		btnImagen.setBackground(Color.WHITE);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(1061, 674, 130, 37);
		contentPane.add(btnGuardar);
		
		JLabel lblNewLabel = new JLabel("Titulo");
		lblNewLabel.setBounds(10, 186, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Loxcalizacion");
		lblNewLabel_1.setBounds(10, 227, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Metros cuadrados (m2)");
		lblNewLabel_2.setBounds(10, 268, 122, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero de habitaciones");
		lblNewLabel_3.setBounds(10, 309, 122, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Precio por noche");
		lblNewLabel_4.setBounds(10, 342, 122, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion");
		lblNewLabel_5.setBounds(10, 373, 92, 14);
		contentPane.add(lblNewLabel_5);
		
		//BOTON IMAGEN 
		btnImagen.addActionListener(new ActionListener() {
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
				
				String nombre = txtNombre.getText();
				String desc = txtDescripcion.getText();
				String loc = txtLocalizacion.getText();
				int numHab = Integer.parseInt(txtHabitaciones.getText());
				double precio = Double.parseDouble(txtPrecio.getText());
				int m2 = Integer.parseInt(txtMetrosCuadrados.getText());
				
				Localidad local = new Localidad("", "", 00000, loc);
				Apartamento aparta = new Apartamento(numHab, m2, null);
				Anuncio anuncio = new Anuncio(aparta, loc, desc, precio, false, m2);
				
				try {
					dbm.insertarAnuncio(anuncio);
				} catch (DBException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		
		
		
	}
}
