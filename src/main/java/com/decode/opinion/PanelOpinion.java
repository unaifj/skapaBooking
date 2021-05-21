package com.decode.opinion;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.decode.objects.Opinion;
import java.awt.Font;
import java.awt.Color;

public class PanelOpinion extends JPanel implements ActionListener  {
	
	
	public  PanelOpinion(Opinion opinion) {
		
        setBackground(Color.LIGHT_GRAY);
    	
		this.setBounds(10, 11, 822, 144);
		this.setVisible(true);
		this.setLayout(null);
		
		JLabel lbltitulo = new JLabel(opinion.getTitulo().toUpperCase());
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltitulo.setBounds(10, 25, 469, 28);
		this.add(lbltitulo);
		
		
		JLabel panelDesc = new JLabel(opinion.getDescripcion());
		panelDesc.setBackground(SystemColor.inactiveCaption);
		panelDesc.setBounds(10, 64, 802, 69);
		this.add(panelDesc);
		
		JLabel lblPuntuacion = new JLabel(Float.toString(opinion.getPuntuacion()));
		lblPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPuntuacion.setBackground(new Color(0, 100, 0));
		lblPuntuacion.setBounds(721, 11, 68, 42);
		this.add(lblPuntuacion);
		
		
		
		
		
	}
	
	
	
	
	
	public void Mi_Componente(Opinion opinion) {
		
		PanelOpinion jpo = new PanelOpinion(opinion);
		this.add(jpo);
		this.validate();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
