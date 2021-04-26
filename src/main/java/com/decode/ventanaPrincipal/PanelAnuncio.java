package com.decode.ventanaPrincipal;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.decode.objects.Anuncio;
import javax.swing.JButton;

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
		
		JLabel lblm2 = new JLabel(String.valueOf(anuncio.getApartamento().getMetrosCuad()) + " m2");
		lblm2.setBackground(SystemColor.inactiveCaption);
		lblm2.setBounds(123, 99, 92, 14);
		add(lblm2);
		
		JLabel lblPrecio = new JLabel(String.valueOf(anuncio.getPrecioNoche()) + " €");
		lblPrecio.setBounds(796, 99, 118, 14);
		add(lblPrecio);
		
		JLabel lblPers = new JLabel(String.valueOf(anuncio.getNumPersonas()));
		lblPers.setBounds(10, 99, 13, 14);
		add(lblPers);
		
		JLabel lblImage = new JLabel("[IMAGEN]");
		lblImage.setBounds(790, 11, 46, 14);
		add(lblImage);
			
		
		
		JLabel lblIconoPers = new JLabel("New label");
		lblIconoPers.setBounds(20, 95, 13, 22);
		add(lblIconoPers);
		

		ImageIcon ico1= new ImageIcon("img/iconoPersonas.PNG");               
		ImageIcon img2= new ImageIcon(ico1.getImage().getScaledInstance(lblIconoPers.getWidth(), lblIconoPers.getHeight(), Image.SCALE_SMOOTH));    
		lblIconoPers.setIcon(img2);
		
		JButton btnAnuncio = new JButton("Entrar");
		btnAnuncio.setBounds(661, 95, 89, 23);
		add(btnAnuncio);
		btnAnuncio.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
       
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