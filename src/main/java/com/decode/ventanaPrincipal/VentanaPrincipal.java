package com.decode.ventanaPrincipal;

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
import java.util.Calendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.contacto.Contacto;
import com.decode.misanuncios.VentanaMisAnuncios;
import com.decode.multilenguaje.Idioma;
import com.decode.objects.Anuncio;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;
import com.decode.ventanaperfil.VentanaConfiguacion;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.Scrollbar;

public class VentanaPrincipal extends JFrame  {
	private JTextField textDestino;
	private JTextField txtIntroduzcaElPrecio;	
	private Idioma idiom;

	
	/**
	 * Ejecutamos la aplicación.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaPrincipal(String idioma) {
		
		idiom = new Idioma(idioma);
		
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 62));
		getContentPane().setLayout(null);
		setBounds(300, 200, 1289, 907);
		
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
		
		
		ImageIcon ico1= new ImageIcon("imagenes/tonyespañol.png");//meter las rutas en la bd
		
		ImageIcon img1= new ImageIcon(ico1.getImage().getScaledInstance(lblBandera.getWidth(), lblBandera.getHeight(), Image.SCALE_SMOOTH));
		
		
		ImageIcon ico2= new ImageIcon("img/banderaEN.png");//meter las rutas en la bd
		
		ImageIcon img2= new ImageIcon(ico2.getImage().getScaledInstance(lblBandera.getWidth(), lblBandera.getHeight(), Image.SCALE_SMOOTH));
		
		if (idioma.equals("ES")) {
			lblBandera.setIcon(img1);
		}else {
			lblBandera.setIcon(img2);
		}
		
		lblBandera.addMouseListener(new MouseListener() {
			
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
				
			if (idioma.equals("EN")) {
				VentanaPrincipal vp = new VentanaPrincipal("ES");
				setVisible(false);
				vp.setVisible(true);
					
			}else {
				VentanaPrincipal vp = new VentanaPrincipal("EN");
				setVisible(false);
				vp.setVisible(true);
				
			}
			
				
				
				
			}
		});
		
		
		
		
		JPanel panelOeste = new JPanel();
		panelOeste.setBounds(0, 109, 323, 409);
		getContentPane().add(panelOeste);
		panelOeste.setBackground(Color.ORANGE);
		panelOeste.setLayout(null);
		
		JLabel lblBuscar = new JLabel(idiom.getProperty("buscar"));
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblBuscar.setBounds(10, 11, 88, 23);
		panelOeste.add(lblBuscar);
		
		JLabel lblDestino = new JLabel(idiom.getProperty("destino"));
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDestino.setBounds(10, 45, 247, 23);
		panelOeste.add(lblDestino);
		
		textDestino = new JTextField();
		textDestino.setBounds(12, 66, 274, 30);
		panelOeste.add(textDestino);
		textDestino.setColumns(10);
		
		JLabel lblFechaEn = new JLabel(idiom.getProperty("fechaEntrada"));
		lblFechaEn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaEn.setBounds(10, 107, 247, 23);
		panelOeste.add(lblFechaEn);
		
		JDateChooser fechaEntrada = new JDateChooser();
		fechaEntrada.setBounds(10, 135, 276, 30);
		panelOeste.add(fechaEntrada);
		
		JLabel lblFechaDeSalida = new JLabel(idiom.getProperty("fechaSalida"));
		lblFechaDeSalida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaDeSalida.setBounds(10, 176, 247, 23);
		panelOeste.add(lblFechaDeSalida);
		
		JDateChooser fechaSalida = new JDateChooser();
		fechaSalida.setBounds(10, 198, 276, 30);
		panelOeste.add(fechaSalida);
		
		JSpinner spinnerNumPersonas = new JSpinner();
		spinnerNumPersonas.setToolTipText("Adultos 4");
		spinnerNumPersonas.setBounds(10, 259, 276, 23);
		panelOeste.add(spinnerNumPersonas);
		
		JSpinner spinnerPrecioMin = new JSpinner();
		spinnerPrecioMin.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(10)));
		spinnerPrecioMin.setToolTipText("Niños");
		spinnerPrecioMin.setBounds(10, 318, 127, 23);
		panelOeste.add(spinnerPrecioMin);
		
		JSpinner spinnerPrecioMax = new JSpinner();
		spinnerPrecioMax.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(10)));
		spinnerPrecioMax.setBounds(153, 318, 133, 23);
		panelOeste.add(spinnerPrecioMax);
		
		Button buttonBuscar = new Button(idiom.getProperty("buscar"));
		buttonBuscar.setActionCommand("");
		buttonBuscar.setBounds(101, 358, 100, 30);
		panelOeste.add(buttonBuscar);
		
		JLabel lblNNumPersonas = new JLabel(idiom.getProperty("numeroPersonas"));
		lblNNumPersonas.setBounds(10, 239, 127, 14);
		panelOeste.add(lblNNumPersonas);
		
		JLabel lblPrecio = new JLabel(idiom.getProperty("precioNoche"));
		lblPrecio.setBounds(10, 293, 112, 14);
		panelOeste.add(lblPrecio);
		
		Panel panelSuroeste = new Panel();
		panelSuroeste.setBounds(0, 517, 323, 258);
		getContentPane().add(panelSuroeste);
		panelSuroeste.setLayout(null);
		
		JLabel lblFiltradoPor = new JLabel(idiom.getProperty("filtrarPor"));
		lblFiltradoPor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFiltradoPor.setBounds(10, 28, 128, 23);
		panelSuroeste.add(lblFiltradoPor);
		
		JCheckBox chckbxCancelacion = new JCheckBox("Cancelacion gratuita");
		chckbxCancelacion.setBounds(10, 89, 158, 23);
		panelSuroeste.add(chckbxCancelacion);
		
		txtIntroduzcaElPrecio = new JTextField();
		txtIntroduzcaElPrecio.setText("Introduzca el precio");
		txtIntroduzcaElPrecio.setBounds(10, 62, 245, 20);
		panelSuroeste.add(txtIntroduzcaElPrecio);
		txtIntroduzcaElPrecio.setColumns(10);
		
		JCheckBox chckbxParking = new JCheckBox("Parking");
		chckbxParking.setBounds(10, 219, 97, 23);
		panelSuroeste.add(chckbxParking);
		
		JCheckBox chckbxPiscina = new JCheckBox("Piscina");
		chckbxPiscina.setBounds(10, 193, 97, 23);
		panelSuroeste.add(chckbxPiscina);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("Casas y apartamentos");
		chckbxNewCheckBox_2_1.setBounds(10, 115, 158, 23);
		panelSuroeste.add(chckbxNewCheckBox_2_1);
		
		JCheckBox chckbxHoteles = new JCheckBox("Hoteles y pensiones");
		chckbxHoteles.setBounds(10, 141, 189, 23);
		panelSuroeste.add(chckbxHoteles);
		
		JCheckBox chckbxRurales = new JCheckBox("Casa rurales");
		chckbxRurales.setBounds(10, 167, 189, 23);
		panelSuroeste.add(chckbxRurales);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBounds(345, 156, 918, 619);
		getContentPane().add(panelCentro);
		panelCentro.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar(Scrollbar.VERTICAL, 10, 60, 0, 100);
		scrollBar.setBounds(901, 0, 17, 619);
		panelCentro.add(scrollBar);

	
		
		


	
		

		
		
		JButton btnMapa = new JButton("Mapa");
		btnMapa.setBounds(1049, 120, 123, 23);
		getContentPane().add(btnMapa);
		
		JLabel lblAlojamientosEncontrados = new JLabel(idiom.getProperty("alojamientosEncontrados"));
		lblAlojamientosEncontrados.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblAlojamientosEncontrados.setBounds(351, 120, 338, 23);
		getContentPane().add(lblAlojamientosEncontrados);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 781, 1273, 130);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		if (VentanaInicio.getUser() == null) {
			
			JButton btnRegistro = new JButton(idiom.getProperty("crearCuenta"));
			btnRegistro.setBounds(874, 13, 146, 23);
			panelNorte.add(btnRegistro);
			
			JButton btnLogin = new JButton(idiom.getProperty("iniciarSesion"));
			btnLogin.setBounds(1087, 13, 123, 23);
			panelNorte.add(btnLogin);
			
			btnLogin.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaInicio vi = new VentanaInicio(idiom);
					vi.setVisible(true);
					
				}
			});
			
			btnRegistro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaRegistro vr = new VentanaRegistro(idiom);
					vr.setVisible(true);
					
				}
			});
			
		}else {
			JLabel lblNewLabel = new JLabel(idiom.getProperty("hasIniciadoComo") + " "   + VentanaInicio.getUser().getNomUsuario());
			lblNewLabel.setForeground(Color.LIGHT_GRAY);
			lblNewLabel.setBounds(991, 36, 201, 14);
			panelNorte.add(lblNewLabel);
			
			JLabel lblImagenPerfil = new JLabel("");
			lblImagenPerfil.setBounds(1217, 11, 46, 51);
			panelNorte.add(lblImagenPerfil);


			ImageIcon iconoperfil = new ImageIcon("img/perfil.PNG");               
			ImageIcon img3= new ImageIcon(iconoperfil.getImage().getScaledInstance(lblImagenPerfil.getWidth(), lblImagenPerfil.getHeight(), Image.SCALE_SMOOTH));    
			lblImagenPerfil.setIcon(img3);
			
			JButton btnAnuncios = new JButton(idiom.getProperty("misAnuncios"));
			btnAnuncios.setBounds(1023, 85, 113, 21);
			panelNorte.add(btnAnuncios);
			
			JButton btnConfig = new JButton(idiom.getProperty("configuracion"));
			btnConfig.setBounds(1150, 85, 113, 21);
			panelNorte.add(btnConfig);
			
			
			btnAnuncios.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaMisAnuncios vma = new VentanaMisAnuncios(VentanaInicio.getUser());
					vma.setVisible(true);
					
					
				}
			});
			
			btnConfig.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaConfiguacion vc = new VentanaConfiguacion(VentanaInicio.getUser());
					vc.setVisible(true);
					
				}
			});
			
			
			
			
						
			
		}
		
		
		
		
		
		
		JLabel lblContacto = new JLabel(idiom.getProperty("contacta"));
		lblContacto.setBounds(1031, 11, 141, 14);
		panel.add(lblContacto);
		
		DBManager dbm = new DBManager();
		List<Anuncio> anuncios;
		
		int y = 0;
		anuncios = dbm.getAnuncios();
		System.out.println(anuncios);
		for (Anuncio a : anuncios) {
			PanelAnuncio pa = new PanelAnuncio(a, false, null);
			pa.setVisible(true);
			scrollBar.add(pa);
			panelCentro.add(pa);
			pa.setBounds(pa.getX(), y, pa.getWidth(), pa.getHeight());
			y = y + 125;
			
		}
		
		
		buttonBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panelCentro.removeAll();
				panelCentro.revalidate();

				String titulo = textDestino.getText();
			
				
				int y = 0;
				
				List <Anuncio> anunciosFiltrados;
				
				anunciosFiltrados = dbm.getFiltrados(titulo, fechaEntrada.getCalendar(), fechaSalida.getCalendar(), 
						(Integer)spinnerNumPersonas.getValue(), (Integer)spinnerPrecioMin.getValue(), 
								(Integer)spinnerPrecioMax.getValue());
				
				for (Anuncio a : anunciosFiltrados) {
				
					if (a.getTitulo() != null) {
						
						//COMPROBACION FECHAS
					
						PanelAnuncio pa = new PanelAnuncio(a, false, null);
						pa.setVisible(true);
						panelCentro.add(pa);
						pa.setBounds(pa.getX(), y, pa.getWidth(), pa.getHeight());
						y = y + 125;
						

						
					}
					
					
				}
				
				getContentPane().add(panelCentro);
			}
		});
		
		lblContacto.addMouseListener(new MouseListener() {
			
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
				setVisible(false);
				Contacto c = new Contacto();
				c.setVisible(true);
				
			}
		});

		
	}
	
	public Idioma getIdiom () {
		
		return idiom;
		
	}
}
