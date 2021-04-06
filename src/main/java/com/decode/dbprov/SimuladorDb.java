package com.decode.dbprov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.decode.objects.Usuario;

public class SimuladorDb {
	
public ArrayList<Usuario> importarStock () {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	
	    String ruta = "data/usuarios.txt";
	
	      try {
	         archivo = new File (ruta);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         
	         String linea = br.readLine();
	         while(linea!=null) {
	        	 
	        	 String[] palabras = linea.split(",");
	        	 String nomUsuario = palabras[0];
	        	 String correo = palabras[1];
	        	 String contrasenya = palabras[2];
	        	
	        	 Usuario usuario = new Usuario(nomUsuario, correo, contrasenya);
	        	 usuarios.add(usuario);
	         }
	         
	      }catch(Exception e){
	         e.printStackTrace();
	         
	      }finally{
	    	  
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
			
		return usuarios;
			
	}
	
	public void exportarStock (ArrayList<Usuario> usuarios) {
		
		FileWriter fichero = null;
		try {

			fichero = new FileWriter("data/usuarios.txt");

			// Escribimos linea a linea en el fichero
			for (Usuario user : usuarios) {
				String nomUsuario = user.getNomUsuario();
				String correo = user.getCorreo();
				String contrasenya = user.getContrasenya();
	
				fichero.write( nomUsuario + "," + correo + "," + contrasenya + "\n");
			}

			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}

}
