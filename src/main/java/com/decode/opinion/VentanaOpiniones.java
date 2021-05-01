package com.decode.opinion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.decode.bd.DBManager;
import com.decode.objects.Opinion;
import com.decode.sesion.VentanaInicio;
import com.decode.ventanaPrincipal.VentanaPrincipal;



import com.decode.opinion.*;

public class VentanaOpiniones extends JFrame {
	
	
	
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpiniones frame = new VentanaOpiniones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaOpiniones() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelOpiniones = new JPanel();
		panelOpiniones.setBackground(Color.PINK);
		panelOpiniones.setBounds(27, 11, 366, 439);
		contentPane.add(panelOpiniones);
		panelOpiniones.setLayout(null);
		
		
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(15, 466, 115, 29);
		contentPane.add(btnAtras);
		
		JButton btnNuevoComentario = new JButton("Nuevo comentario");
		btnNuevoComentario.setBounds(205, 466, 161, 29);
		contentPane.add(btnNuevoComentario);
		
		DBManager dbm = new DBManager();
			
		List<Opinion> opiniones = new ArrayList<Opinion>();
		
		int y =0;
		opiniones = dbm.getOpiniones(VentanaInicio.getUser());
		System.out.println(opiniones);
		for(Opinion op : opiniones){
			PanelOpinion PanelOp = new PanelOpinion(op);
			PanelOp.setVisible(true);
			panelOpiniones.add(PanelOp);
			PanelOp.setBounds(PanelOp.getX(), y, PanelOp.getWidth(), PanelOp.getHeight());
			y = y + 125;
		}
		
		
			
			
			
			
		
		btnNuevoComentario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaCrearOpinion vco = new VentanaCrearOpinion();
				vco.setVisible(true);
				setVisible(false);
				
				
			}
		});
		
	}

}
