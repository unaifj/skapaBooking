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
import com.decode.objects.Anuncio;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpinnerNumberModel;

public class VentanaPrincipal extends JFrame  {
	private JTextField textDestino;
	private JTextField txtIntroduzcaElPrecio;
	
	/**
	 * Ejecutamos la aplicación.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaPrincipal() {
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
					VentanaInicio vi = new VentanaInicio();
					vi.setVisible(true);
					
				}
			});
			
			btnRegistro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaRegistro vr = new VentanaRegistro();
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
		

		
		JPanel panelOeste = new JPanel();
		panelOeste.setBounds(0, 109, 323, 409);
		getContentPane().add(panelOeste);
		panelOeste.setBackground(Color.ORANGE);
		panelOeste.setLayout(null);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblBuscar.setBounds(10, 11, 88, 23);
		panelOeste.add(lblBuscar);
		
		JLabel lblDestino = new JLabel("Destino / Nombre alojamiento:");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDestino.setBounds(10, 45, 247, 23);
		panelOeste.add(lblDestino);
		
		textDestino = new JTextField();
		textDestino.setBounds(12, 66, 274, 30);
		panelOeste.add(textDestino);
		textDestino.setColumns(10);
		
		JLabel lblFechaEn = new JLabel("Fecha de entrada");
		lblFechaEn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaEn.setBounds(10, 107, 247, 23);
		panelOeste.add(lblFechaEn);
		
		JDateChooser fechaEntrada = new JDateChooser();
		fechaEntrada.setBounds(10, 135, 276, 30);
		panelOeste.add(fechaEntrada);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de salida");
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
		
		Button buttonBuscar = new Button("Buscar");
		buttonBuscar.setActionCommand("");
		buttonBuscar.setBounds(101, 358, 100, 30);
		panelOeste.add(buttonBuscar);
		
		JLabel lblNNumPersonas = new JLabel("Numero de personas");
		lblNNumPersonas.setBounds(10, 239, 127, 14);
		panelOeste.add(lblNNumPersonas);
		
		JLabel lblPrecio = new JLabel("Precio por noche");
		lblPrecio.setBounds(10, 293, 112, 14);
		panelOeste.add(lblPrecio);
		
		Panel panelSuroeste = new Panel();
		panelSuroeste.setBounds(0, 517, 323, 258);
		getContentPane().add(panelSuroeste);
		panelSuroeste.setLayout(null);
		
		JLabel lblFiltradoPor = new JLabel("Filtrado por:");
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
		
		Panel panelCentro = new Panel();
		panelCentro.setBounds(329, 156, 944, 619);
		getContentPane().add(panelCentro);
		panelCentro.setLayout(null);
		
		
		
		JButton btnMapa = new JButton("Mapa");
		btnMapa.setBounds(1049, 120, 123, 23);
		getContentPane().add(btnMapa);
		
		JLabel lblAlojamientosEncontrados = new JLabel("Alojamientos encontrados");
		lblAlojamientosEncontrados.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblAlojamientosEncontrados.setBounds(351, 120, 338, 23);
		getContentPane().add(lblAlojamientosEncontrados);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 781, 1273, 130);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblContacto = new JLabel("Contacta con nosotros");
		lblContacto.setBounds(1122, 11, 141, 14);
		panel.add(lblContacto);
		
		DBManager dbm = new DBManager();
		List<Anuncio> anuncios;
		
		int y = 0;
		anuncios = dbm.getAnuncios();
		System.out.println(anuncios);
		for (Anuncio a : anuncios) {
			PanelAnuncio pa = new PanelAnuncio(a);
			pa.setVisible(true);
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
					
						PanelAnuncio pa = new PanelAnuncio(a);
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
}
