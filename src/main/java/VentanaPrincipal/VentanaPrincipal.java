package VentanaPrincipal;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.decode.chat.ChatSkapaBookingCliente;
import com.decode.contacto.Contacto;
import com.toedter.calendar.*;


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
		setBounds(300, 200, 1289, 809);
		
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
		
		JPanel panelOeste = new JPanel();
		panelOeste.setBounds(0, 109, 323, 392);
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
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 135, 276, 30);
		panelOeste.add(dateChooser);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de salida");
		lblFechaDeSalida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFechaDeSalida.setBounds(10, 176, 247, 23);
		panelOeste.add(lblFechaDeSalida);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(10, 198, 276, 30);
		panelOeste.add(dateChooser_1);
		
		JSpinner spinnerAdultos = new JSpinner();
		spinnerAdultos.setToolTipText("Adultos 4");
		spinnerAdultos.setBounds(10, 259, 276, 23);
		panelOeste.add(spinnerAdultos);
		
		JSpinner spinnerNinos = new JSpinner();
		spinnerNinos.setToolTipText("Niños");
		spinnerNinos.setBounds(10, 298, 127, 23);
		panelOeste.add(spinnerNinos);
		
		JSpinner spinnerHabitaciones = new JSpinner();
		spinnerHabitaciones.setBounds(138, 298, 148, 23);
		panelOeste.add(spinnerHabitaciones);
		
		Button buttonBuscar = new Button("Buscar");
		buttonBuscar.setActionCommand("");
		buttonBuscar.setBounds(99, 340, 100, 30);
		panelOeste.add(buttonBuscar);
		
		Panel panelSuroeste = new Panel();
		panelSuroeste.setBounds(0, 501, 323, 274);
		getContentPane().add(panelSuroeste);
		panelSuroeste.setLayout(null);
		
		JLabel lblFiltradoPor = new JLabel("Filtrado por:");
		lblFiltradoPor.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFiltradoPor.setBounds(10, 11, 128, 23);
		panelSuroeste.add(lblFiltradoPor);
		
		JCheckBox chckbxCancelacion = new JCheckBox("Cancelacion gratuita");
		chckbxCancelacion.setBounds(10, 68, 158, 23);
		panelSuroeste.add(chckbxCancelacion);
		
		txtIntroduzcaElPrecio = new JTextField();
		txtIntroduzcaElPrecio.setText("Introduzca el precio");
		txtIntroduzcaElPrecio.setBounds(10, 41, 245, 20);
		panelSuroeste.add(txtIntroduzcaElPrecio);
		txtIntroduzcaElPrecio.setColumns(10);
		
		JCheckBox chckbxParking = new JCheckBox("Parking");
		chckbxParking.setBounds(10, 198, 97, 23);
		panelSuroeste.add(chckbxParking);
		
		JCheckBox chckbxPiscina = new JCheckBox("Piscina");
		chckbxPiscina.setBounds(10, 172, 97, 23);
		panelSuroeste.add(chckbxPiscina);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("Casas y apartamentos");
		chckbxNewCheckBox_2_1.setBounds(10, 94, 158, 23);
		panelSuroeste.add(chckbxNewCheckBox_2_1);
		
		JCheckBox chckbxHoteles = new JCheckBox("Hoteles y pensiones");
		chckbxHoteles.setBounds(10, 120, 189, 23);
		panelSuroeste.add(chckbxHoteles);
		
		JCheckBox chckbxRurales = new JCheckBox("Casa rurales");
		chckbxRurales.setBounds(10, 146, 189, 23);
		panelSuroeste.add(chckbxRurales);
		
		Panel panelCentro = new Panel();
		panelCentro.setBounds(324, 156, 953, 604);
		getContentPane().add(panelCentro);
		
		JButton btnMapa = new JButton("Mapa");
		btnMapa.setBounds(1049, 120, 123, 23);
		getContentPane().add(btnMapa);
		
		JLabel lblAlojamientosEncontrados = new JLabel("Alojamientos encontrados");
		lblAlojamientosEncontrados.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblAlojamientosEncontrados.setBounds(351, 120, 338, 23);
		getContentPane().add(lblAlojamientosEncontrados);
		
		JButton btnNewButton = new JButton("Contacto");
		btnNewButton.setBounds(900, 120, 123, 23);
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contacto C = new Contacto();
				setVisible(false);
				C.setVisible(true);
				}
			});
	
	
		
		
		
	}
}
