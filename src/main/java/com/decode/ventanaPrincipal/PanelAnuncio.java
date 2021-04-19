package com.decode.ventanaPrincipal;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.decode.objects.Anuncio;
import java.awt.SystemColor;

public class PanelAnuncio extends JPanel implements ActionListener {


    public PanelAnuncio(Anuncio anuncio)
    {
    	setBackground(SystemColor.window);
    	
		this.setBounds(10, 11, 924, 120);
		this.setVisible(true);
		this.setLayout(null);
		
		JLabel lbltitulo = new JLabel(anuncio.getTitulo().toUpperCase());
		lbltitulo.setBounds(10, 11, 483, 14);
		this.add(lbltitulo);
		
		JLabel panelDesc = new JLabel(anuncio.getDescripcion());
		panelDesc.setBackground(SystemColor.inactiveCaption);
		panelDesc.setBounds(10, 36, 849, 48);
		this.add(panelDesc);
		
		JLabel lblm2 = new JLabel(String.valueOf(anuncio.getApartamento().getMetrosCuad()));
		lblm2.setBackground(SystemColor.inactiveCaption);
		lblm2.setBounds(123, 95, 92, 14);
		add(lblm2);
		
		JLabel lblPrecio = new JLabel(String.valueOf(anuncio.getPrecioNoche()));
		lblPrecio.setBounds(796, 95, 118, 14);
		add(lblPrecio);
		
		JLabel lblPers = new JLabel(String.valueOf(anuncio.getNumPersonas()));
		lblPers.setBounds(10, 95, 92, 14);
		add(lblPers);
		
		JLabel lblNewLabel = new JLabel("[IMAGEN]");
		lblNewLabel.setBounds(790, 11, 46, 14);
		add(lblNewLabel);
		
		
       
    }

    public void Mi_Componente(Anuncio anuncio)
    {        
        //instancia nueva a componente
        PanelAnuncio jpc = new PanelAnuncio(anuncio);
        this.add(jpc);//se añade al jpanel
        this.validate();
        //se añade al MAP
    }



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}