package VentanaPrincipal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class plantillaHoteles extends JPanel {
	public plantillaHoteles() {
		setLayout(null);
		
		JLabel lblFoto = new JLabel("New label");
		lblFoto.setBounds(10, 43, 170, 163);
		add(lblFoto);
		
		JLabel lblNombre = new JLabel("New label");
		lblNombre.setBounds(199, 29, 269, 28);
		add(lblNombre);
		
		JLabel lblLocalizacion = new JLabel("New label");
		lblLocalizacion.setBounds(199, 68, 269, 28);
		add(lblLocalizacion);
		
		JLabel lblDescripcion = new JLabel("New label");
		lblDescripcion.setBounds(197, 117, 271, 99);
		add(lblDescripcion);
		
		JLabel lblPuntuacion = new JLabel("New label");
		lblPuntuacion.setBounds(570, 36, 54, 51);
		add(lblPuntuacion);
		
		JButton btnReserva = new JButton("Reservar");
		btnReserva.setBackground(Color.GRAY);
		btnReserva.setForeground(Color.BLACK);
		btnReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReserva.setBounds(551, 113, 89, 23);
		add(btnReserva);
	}
}
