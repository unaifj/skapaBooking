package com.decode.misanuncios;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.objects.Anuncio;
import com.decode.objects.Apartamento;
import com.decode.objects.Localidad;
import com.decode.objects.Reserva;
import com.decode.objects.Usuario;
import com.decode.sesion.VentanaInicio;

public class VentanaNuevoAnuncio extends JFrame {

	private JPanel contentPane;
	private JFileChooser fileChooser ;
	private JTextField textNumHab;
	private JTextField textTitulo;
	private JTextField textDesc;
	private JTextField textNumPers;
	private JTextField textPrecioNoche;
	private JTextField textM2;
	private JTextField textDir;
	private JTextField textIndic;
	private JTextField textcp;
	private JTextField textProvincia;
	private JTextField textMunicipio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevoAnuncio frame = new VentanaNuevoAnuncio(null);
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
	public VentanaNuevoAnuncio(Usuario user) {

		
		
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
		
		JButton btnActImagen = new JButton("Seleccionar imagen");
		btnActImagen.setBounds(587, 422, 130, 23);
		contentPane.add(btnActImagen);
		btnActImagen.setBackground(Color.WHITE);
		
		JButton btnPublicar = new JButton("Publicar");
		btnPublicar.setBounds(1091, 696, 130, 37);
		contentPane.add(btnPublicar);
		
		JLabel lblNewLabel = new JLabel("Titulo");
		lblNewLabel.setBounds(40, 240, 135, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Informacion basica");
		lblNewLabel_1.setBounds(10, 215, 165, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(40, 266, 135, 14);
		contentPane.add(lblDescripcion);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de personas");
		lblNewLabel_2.setBounds(40, 350, 135, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio por noche");
		lblNewLabel_3.setBounds(40, 375, 135, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Especificaciones apartamento");
		lblNewLabel_4.setBounds(10, 426, 165, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNumeroDeHabitaciones = new JLabel("Numero de habitaciones");
		lblNumeroDeHabitaciones.setBounds(40, 451, 135, 14);
		contentPane.add(lblNumeroDeHabitaciones);
		
		JLabel lblMetrosCuadrados = new JLabel("Metros cuadrados");
		lblMetrosCuadrados.setBounds(40, 476, 135, 14);
		contentPane.add(lblMetrosCuadrados);
		
		JLabel lblNewLabel_5 = new JLabel("Localidad");
		lblNewLabel_5.setBounds(10, 531, 165, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Direccion");
		lblNewLabel_6.setBounds(40, 563, 135, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Observaciones");
		lblNewLabel_6_1.setBounds(40, 588, 135, 14);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7 = new JLabel("Codigo postal");
		lblNewLabel_7.setBounds(40, 668, 135, 14);
		contentPane.add(lblNewLabel_7);
		
		textNumHab = new JTextField();
		textNumHab.setBounds(273, 448, 201, 20);
		contentPane.add(textNumHab);
		textNumHab.setColumns(10);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(273, 237, 201, 20);
		contentPane.add(textTitulo);
		
		textDesc = new JTextField();
		textDesc.setColumns(10);
		textDesc.setBounds(273, 263, 201, 55);
		contentPane.add(textDesc);
		
		textNumPers = new JTextField();
		textNumPers.setColumns(10);
		textNumPers.setBounds(273, 347, 201, 20);
		contentPane.add(textNumPers);
		
		textPrecioNoche = new JTextField();
		textPrecioNoche.setColumns(10);
		textPrecioNoche.setBounds(273, 372, 163, 20);
		contentPane.add(textPrecioNoche);
		
		textM2 = new JTextField();
		textM2.setColumns(10);
		textM2.setBounds(273, 473, 163, 20);
		contentPane.add(textM2);
		
		textDir = new JTextField();
		textDir.setColumns(10);
		textDir.setBounds(273, 560, 201, 20);
		contentPane.add(textDir);
		
		textIndic = new JTextField();
		textIndic.setColumns(10);
		textIndic.setBounds(273, 585, 201, 20);
		contentPane.add(textIndic);
		
		textcp = new JTextField();
		textcp.setColumns(10);
		textcp.setBounds(273, 665, 201, 20);
		contentPane.add(textcp);
		
		JLabel lblNewLabel_8 = new JLabel("Completa tu pagina");
		lblNewLabel_8.setBounds(587, 215, 165, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblImagen = new JLabel();
		lblImagen.setBounds(587, 240, 555, 176);
		contentPane.add(lblImagen);
		
		ImageIcon iconoImg= new ImageIcon("img/imagen-galeria.png");
		ImageIcon img= new ImageIcon(iconoImg.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
		lblImagen.setIcon(img);
		
		JLabel lblDescripcion_1 = new JLabel("Descripcion");
		lblDescripcion_1.setBounds(587, 495, 135, 14);
		contentPane.add(lblDescripcion_1);
		
		JTextPane textDesc_1 = new JTextPane();
		textDesc_1.setBounds(587, 531, 634, 154);
		contentPane.add(textDesc_1);
		
		textProvincia = new JTextField();
		textProvincia.setColumns(10);
		textProvincia.setBounds(273, 610, 201, 20);
		contentPane.add(textProvincia);
		
		JLabel lblNewLabel_7_1 = new JLabel("Provincia");
		lblNewLabel_7_1.setBounds(40, 613, 135, 14);
		contentPane.add(lblNewLabel_7_1);
		
		textMunicipio = new JTextField();
		textMunicipio.setColumns(10);
		textMunicipio.setBounds(273, 638, 201, 20);
		contentPane.add(textMunicipio);
		
		JLabel lblNewLabel_7_2 = new JLabel("Municipio");
		lblNewLabel_7_2.setBounds(40, 641, 135, 14);
		contentPane.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_9 = new JLabel("m2");
		lblNewLabel_9.setBounds(446, 476, 28, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("€");
		lblNewLabel_10.setBounds(446, 375, 28, 14);
		contentPane.add(lblNewLabel_10);
			
//		ImageIcon iconoImg= new ImageIcon();
//		ImageIcon img2= new ImageIcon(iconoImg.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
//		lblImagen.setIcon(img2);
//		
		//BOTON IMAGEN 
		btnActImagen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		       fileChooser = new JFileChooser();
		       fileChooser.showOpenDialog(fileChooser);
	
		       String orig = fileChooser.getSelectedFile().getPath();
		       Path origen = Paths.get(orig); 
		       String dest = System.getProperty("user.dir") + "/img/anuncios/" + fileChooser.getSelectedFile().getName();
		       Path destino = Paths.get(dest); 
		      
		       try {
				Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
				
				
				
				
				ImageIcon ico2= new ImageIcon("/img/anuncios/" + fileChooser.getSelectedFile().getName());
				ImageIcon img2= new ImageIcon(ico2.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
				lblImagen.setIcon(img2);
				
				lblImagen.setVisible(true);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			}
			
		});
		
		btnPublicar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            	
            	String titulo = textTitulo.getText();
            	String desc = textDesc.getText();
				String provincia = textProvincia.getText();
				int numHab = Integer.parseInt(textNumHab.getText());
				double precio = Double.parseDouble(textPrecioNoche.getText());
				int m2 = Integer.parseInt(textM2.getText());
				String municipio= textMunicipio.getText();
				int codigo= Integer.parseInt(textcp.getText());
				String direccion= textDir.getText();
            	String ruta = "/img/anuncios/" + fileChooser.getSelectedFile().getName();
            	//float puntuacion = Float.parseFloat(textField.getText());
            	
            	if (titulo.equals("") || desc.equals("") || provincia.equals("") || numHab == 0 || precio == 0.0 || m2 == 0 ||
            			municipio.equals("") || codigo == 0 || direccion.equals("") || ruta.equals("")) {
            		JOptionPane.showMessageDialog(null, "Error creando el anuncio", "Alguno de los campos es incorrecto o nulo", 0);
            		
            	}else {
            		Localidad loc= new Localidad(provincia, municipio,codigo,direccion);
                	List<Reserva> reservas = new ArrayList<Reserva>();
    				Apartamento aparta = new Apartamento(numHab, m2, loc,reservas);
    				Anuncio anuncio = new Anuncio(VentanaInicio.getUser(),aparta,titulo, desc, precio, false, m2, ruta);

    				
    				DBManager dbm = new DBManager();
    				try {
    					dbm.insertarAnuncio(anuncio);
    					JOptionPane.showMessageDialog(null, "El anuncio se a creado correctamente", "Correcto", 1);
    				} catch (DBException e1) {
    					JOptionPane.showMessageDialog(null, "Error creando el anuncio", "Error de conexion", 0);
    					e1.printStackTrace();
    				}
    				setVisible(false);
                    VentanaMisAnuncios vma = new VentanaMisAnuncios(user);
                    vma.setVisible(true);
            	}
            	
            	

            }
        });

	}
}
