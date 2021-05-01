package com.decode.opinion;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.decode.objects.Opinion;

public class PanelOpinion extends JPanel implements ActionListener  {
	
	
	public  PanelOpinion(Opinion opinion) {
		
        setBackground(SystemColor.window);
    	
		this.setBounds(10, 11, 924, 120);
		this.setVisible(true);
		this.setLayout(null);
		
		JLabel lbltitulo = new JLabel(opinion.getTitulo().toUpperCase());
		lbltitulo.setBounds(10, 11, 469, 14);
		this.add(lbltitulo);
		
		
		JLabel panelDesc = new JLabel(opinion.getDescripcion());
		panelDesc.setBackground(SystemColor.inactiveCaption);
		panelDesc.setBounds(10, 36, 849, 51);
		this.add(panelDesc);
		
		JLabel lblPuntuacion = new JLabel(Float.toString(opinion.getPuntuacion()));
		lblPuntuacion.setBackground(SystemColor.inactiveCaption);
		lblPuntuacion.setBounds(588, -3, 68, 42);
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
