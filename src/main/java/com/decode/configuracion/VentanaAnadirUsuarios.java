package com.decode.configuracion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import com.decode.contacto.Contacto;
import com.decode.sesion.VentanaInicio;
import com.decode.sesion.VentanaRegistro;

import javax.swing.JButton;

public class VentanaAnadirUsuarios extends JFrame{
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JTextField txtNombreParaSkapabooking;
	private JTextField txtContrasea;
	private JTextField txtRepetirContrasea;
	public VentanaAnadirUsuarios() {
		setBounds(300, 200, 1289, 809);
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
		txtContrasea.setText("Contrase??a");
		txtContrasea.setColumns(10);
		txtContrasea.setBounds(21, 201, 297, 25);
		panel.add(txtContrasea);
		
		txtRepetirContrasea = new JTextField();
		txtRepetirContrasea.setText("Repetir Contrase??a");
		txtRepetirContrasea.setColumns(10);
		txtRepetirContrasea.setBounds(21, 247, 297, 25);
		panel.add(txtRepetirContrasea);
		if (VentanaInicio.getUser() == null) {
			
			JButton btnRegistro1 = new JButton("Hazte cuenta");
			btnRegistro1.setBounds(960, 13, 117, 23);
			panelNorte.add(btnRegistro1);
			
			JButton btnLogin1 = new JButton("Iniciar Sesion");
			btnLogin1.setBounds(1087, 13, 123, 23);
			panelNorte.add(btnLogin1);
			
			btnLogin1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaInicio vi = new VentanaInicio(null);
					vi.setVisible(true);
					
				}
			});
			
			btnRegistro1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					VentanaRegistro vr = new VentanaRegistro(null);
					vr.setVisible(true);
					
				}
			});
			
		}else {
			JLabel lblNewLabel1 = new JLabel("Has iniciado sesion como:  " + VentanaInicio.getUser().getNomUsuario());
			lblNewLabel1.setForeground(Color.LIGHT_GRAY);
			lblNewLabel1.setBounds(1062, 17, 201, 14);
			panelNorte.add(lblNewLabel1);
			
			
		}
		
		JButton btnNewButton = new JButton("Inscribirse");
		btnNewButton.setBounds(50, 393, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.setBounds(184, 393, 89, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("??Porque SkapaBooking recopila tu datos?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(684, 23, 318, 37);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("El principal motivo por el que te pedimos tus datos personales es para ayudarte a gestionar\r\n tus Reservas de viajes online y asegurar que recibes el mejor servicio posible.\r\n\r\nTambi??n usamos tus datos personales para ponernos en contacto contigo e informarte de los ??ltimos descuentos y ofertas especiales, as?? como de otros productos o servicios que podamos considerar de inter??s para ti, entre otras cosas. Si quieres saber m??s, sigue leyendo y encontrar??s una explicaci??n m??s detallada.");
		lblNewLabel_1.setBounds(597, 65, 454, 292);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 546, 1102, 118);
		getContentPane().add(panel_1);
		
		JLabel lblContacto = new JLabel("Contacta con nosotros");
		lblContacto.setBounds(959, 11, 141, 14);
		panel_1.add(lblContacto);
		
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
