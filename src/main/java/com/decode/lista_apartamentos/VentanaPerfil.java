package com.decode.lista_apartamentos;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import VentanaPrincipal.VentanaPrincipal;
public class VentanaPerfil extends JFrame {
private JPanel contentPane;
private int contC1 = 0;
private int contC2 = 0;
private int contC3 = 0;
private int contC4 = 0;
private int valueProgressBar = 0;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
/**
 * Launch the application.
 */
public static void main(String[] args) {
 EventQueue.invokeLater(new Runnable() {
 public void run() {
 try {
 VentanaPerfil frame = new VentanaPerfil();
 frame.setVisible(true);
 } catch (Exception e) { e.printStackTrace();
 }
 }
 });
}
/**
 * Create the frame.
 */
public VentanaPerfil() {
 
 //CREACION DE INTERFACE
//int contBarra = 0;
//int idUsuario = VenatanaPrincipal.getUsuarioId();
 
 setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
 setBounds(100, 100, 557, 621);
 contentPane = new JPanel();
 contentPane.setBackground(Color.LIGHT_GRAY);
 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 setContentPane(contentPane);
 contentPane.setLayout(null);
 
 //CREADO Y ESCALADO DE IMAGEN
 JLabel imagenPerfil = new JLabel("");
 imagenPerfil.setBounds(415, 14, 105, 103);
 
 contentPane.add(imagenPerfil);
 
 JLabel TextoNombre = new JLabel();
 TextoNombre.setText("Nombre:");
 TextoNombre.setBounds(15, 133, 72, 26);
 contentPane.add(TextoNombre);
 
 
 
 JLabel txtpnInformacinPrivada = new JLabel();
 txtpnInformacinPrivada.setFont(new Font("Tahoma", Font.BOLD, 18));
 txtpnInformacinPrivada.setText("Informacion personal\r\n");
 txtpnInformacinPrivada.setBounds(15, 54, 218, 26);
 contentPane.add(txtpnInformacinPrivada);
 
 JLabel TextoCorreoElectrnico = new JLabel();
 TextoCorreoElectrnico.setText("Correo electrónico:");
 TextoCorreoElectrnico.setBounds(15, 171, 162, 26);
 contentPane.add(TextoCorreoElectrnico);
 
 JTextPane nombreUsuario = new JTextPane();
 JTextPane apellidoUsuario = new JTextPane();
 JTextPane ubicacionProvinciaUsuario = new JTextPane();
 JTextPane textoCorreo = new JTextPane();
 
 JProgressBar progressBar = new JProgressBar();
 progressBar.setBounds(169, 451, 317, 14);
 contentPane.add(progressBar);
  JLabel TextoMisAnuncios = new JLabel();
 TextoMisAnuncios.setText("Mis anuncios:");
 TextoMisAnuncios.setBounds(15, 209, 162, 26);
 contentPane.add(TextoMisAnuncios);
 
 textField = new JTextField();
 textField.setBounds(77, 133, 130, 26);
 contentPane.add(textField);
 textField.setColumns(10);
 
 textField_1 = new JTextField();
 textField_1.setBounds(145, 171, 130, 26);
 contentPane.add(textField_1);
 textField_1.setColumns(10);
 
 textField_2 = new JTextField();
 textField_2.setBounds(130, 209, 130, 26);
 contentPane.add(textField_2);
 textField_2.setColumns(10);
 
 JButton btnNewButton = new JButton("Volver");
 btnNewButton.setBounds(6, 14, 105, 29);
 contentPane.add(btnNewButton);
 
 
 
 btnNewButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 VentanaPrincipal C = new VentanaPrincipal();
 setVisible(false);
 C.setVisible(true);
 }
 });
 
 
 JComboBox comboAnyo = new JComboBox();
 
 
 
 }
}
