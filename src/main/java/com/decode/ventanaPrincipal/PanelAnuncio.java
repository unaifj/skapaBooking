package com.decode.ventanaPrincipal;

import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.decode.bd.DBManager;
import com.decode.crearAnuncio.VentanaEditarAnuncio;
import com.decode.misanuncios.VentanaMisAnuncios;
import com.decode.objects.Anuncio;
import com.decode.sesion.VentanaRegistro;

import javax.swing.JButton;

public class PanelAnuncio extends JPanel implements ActionListener {


    public PanelAnuncio(Anuncio anuncio, boolean editable)
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
		
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(755, 11, 81, 73);
		add(lblImage);
		
		ImageIcon ico= new ImageIcon(anuncio.getImg());
		ImageIcon img= new ImageIcon(ico.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
		lblImage.setIcon(img);
		
		
		JLabel lblIconoPers = new JLabel();
		lblIconoPers.setBounds(20, 95, 13, 22);
		add(lblIconoPers);
		

		ImageIcon ico1= new ImageIcon("img/iconoPersonas.PNG");               
		ImageIcon img2= new ImageIcon(ico1.getImage().getScaledInstance(lblIconoPers.getWidth(), lblIconoPers.getHeight(), Image.SCALE_SMOOTH));    
		lblIconoPers.setIcon(img2);
		
		JButton btnAnuncio = new JButton("Entrar");
		btnAnuncio.setBounds(661, 95, 89, 23);
		add(btnAnuncio);
		
		if (editable) {
			
			JButton btnEditar = new JButton();
			btnEditar.setBounds(603, 95, 24, 23);
			add(btnEditar);
			
			JButton btnEliminar = new JButton();
			btnEliminar.setBounds(569, 95, 24, 23);
			add(btnEliminar);
			
			ImageIcon iconoEditar = new ImageIcon("img/lapiz.png");
			ImageIcon iconoEliminar = new ImageIcon("img/eliminar.png");
			
			ImageIcon imgEditar= new ImageIcon(iconoEditar.getImage().getScaledInstance(btnEditar.getWidth(), btnEditar.getHeight(), Image.SCALE_SMOOTH));
			ImageIcon imgEliminar= new ImageIcon(iconoEliminar.getImage().getScaledInstance(btnEliminar.getWidth(), btnEliminar.getHeight(), Image.SCALE_SMOOTH));
			btnEditar.setIcon(imgEditar);
			btnEliminar.setIcon(imgEliminar);
			
			DBManager dbm = new DBManager();
			
			btnEditar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					VentanaEditarAnuncio vea = new VentanaEditarAnuncio(anuncio);
					vea.setVisible(true);
					
				}
			});
			
			btnEliminar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int conf = JOptionPane.showConfirmDialog(null, "¿Eliminar " + anuncio.getTitulo() + " ?");
					if (JOptionPane.OK_OPTION == conf ) {
						System.out.println("AN:" + anuncio);
						dbm.deleteAnuncio(anuncio);
						JOptionPane.showMessageDialog(null, "Anuncio eliminado correctamente", "Correcto", 1);
						
						for (Window win : Window.getWindows()) {
							win.setVisible(false);
						}
						
						VentanaMisAnuncios vma = new VentanaMisAnuncios(anuncio.getUsuario());
						vma.setVisible(true);
					}else {
						
						System.out.println("vale... no borro nada...");
					
				}}
			});
			
		}
		btnAnuncio.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Window win : Window.getWindows()) {
					win.setVisible(false);
				}
				
				VentanaAnuncio vr = new VentanaAnuncio(anuncio);
				vr.setVisible(true);
			}
		});
		
		
       
    }

    public void Mi_Componente(Anuncio anuncio, boolean editable)
    {        
        //instancia nueva a componente
        PanelAnuncio jpc = new PanelAnuncio(anuncio, editable);
        this.add(jpc);//se añade al jpanel
        this.validate();
        //se añade al MAP
    }



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
}