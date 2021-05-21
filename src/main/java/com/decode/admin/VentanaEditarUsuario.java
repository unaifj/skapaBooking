package com.decode.admin;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEditarUsuario extends JFrame{
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JTextField txtNombreParaSkapabooking;
	private JTextField txtContrasea;
	private JTextField txtRepetirContrasea;
	public VentanaEditarUsuario() {
		setBounds(300, 200, 1289, 907);
		getContentPane().setLayout(null);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(null);
		panelNorte.setBackground(Color.BLUE);
		panelNorte.setBounds(0, 0, 1102, 106);
		getContentPane().add(panelNorte);
		
		JLabel lblTitulo = new JLabel("SKAPABOOKING.COM");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitulo.setBounds(10, 0, 250, 37);
		panelNorte.add(lblTitulo);
		
		JLabel lblMoneda = new JLabel("EUR");
		lblMoneda.setForeground(Color.WHITE);
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMoneda.setBounds(765, 8, 46, 24);
		panelNorte.add(lblMoneda);
		
		JLabel lblBandera = new JLabel("New label");
		lblBandera.setBounds(821, 11, 40, 27);
		panelNorte.add(lblBandera);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 106, 1102, 444);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFormulario = new JLabel("Formulario para nuevos clientes\r\n");
		lblFormulario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFormulario.setBounds(27, 11, 358, 32);
		panel.add(lblFormulario);
		
		txtNombre = new JTextField();
		txtNombre.setText("Nombre\r\n");
		txtNombre.setBounds(21, 65, 297, 25);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setText("Apellidos");
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(21, 113, 297, 25);
		panel.add(txtApellidos);
		
		txtCorreo = new JTextField();
		txtCorreo.setText("Correo");
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(21, 289, 297, 25);
		panel.add(txtCorreo);
		
		txtDireccion = new JTextField();
		txtDireccion.setText("Direccion\r\n");
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(21, 337, 297, 25);
		panel.add(txtDireccion);
		
		txtNombreParaSkapabooking = new JTextField();
		txtNombreParaSkapabooking.setText("Nombre para skapabooking\r\n");
		txtNombreParaSkapabooking.setColumns(10);
		txtNombreParaSkapabooking.setBounds(21, 160, 297, 25);
		panel.add(txtNombreParaSkapabooking);
		
		txtContrasea = new JTextField();
		txtContrasea.setText("Contraseña");
		txtContrasea.setColumns(10);
		txtContrasea.setBounds(21, 201, 297, 25);
		panel.add(txtContrasea);
		
		txtRepetirContrasea = new JTextField();
		txtRepetirContrasea.setText("Repetir Contraseña");
		txtRepetirContrasea.setColumns(10);
		txtRepetirContrasea.setBounds(21, 247, 297, 25);
		panel.add(txtRepetirContrasea);
		
		JButton btnInscribirse = new JButton("Inscribirse");
		btnInscribirse.setBounds(50, 393, 89, 23);
		panel.add(btnInscribirse);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(184, 393, 89, 23);
		panel.add(btnAtras);
		
		JLabel lblPregunta = new JLabel("¿Porque SkapaBooking recopila tu datos?");
		lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPregunta.setBounds(641, 23, 395, 37);
		panel.add(lblPregunta);
		
		JTextPane txtpnElPrincipalMotivo = new JTextPane();
		txtpnElPrincipalMotivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnElPrincipalMotivo.setBackground(SystemColor.control);
		txtpnElPrincipalMotivo.setText("El principal motivo por el que te pedimos tus datos personales es para ayudarte a gestionar\r\n tus Reservas de viajes online y asegurar que recibes el mejor servicio posible.\r\n\r\nTambién usamos tus datos personales para ponernos en contacto contigo e informarte de los últimos descuentos y ofertas especiales, así como de otros productos o servicios que podamos considerar de interés para ti, entre otras cosas. Si quieres saber más, sigue leyendo y encontrarás una explicación más detallada.");
		txtpnElPrincipalMotivo.setBounds(651, 71, 385, 243);
		panel.add(txtpnElPrincipalMotivo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 546, 1102, 118);
		getContentPane().add(panel_1);
		
		JLabel lblContacto = new JLabel("Contacta con nosotros");
		lblContacto.setBounds(959, 11, 141, 14);
		panel_1.add(lblContacto);
		
		btnAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaAdmin va = new VentanaAdmin();
				setVisible(true);
				va.setVisible(true);
				
			}
			
		});
		
		
		
	}
}