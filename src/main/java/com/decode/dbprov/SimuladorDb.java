package com.decode.dbprov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.decode.objects.Usuario;

public class SimuladorDb {
	
public ArrayList<Usuario> importarUsuarios () {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	
	    String ruta = "data/usuarios";
	
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
	        	 
	        	 linea = br.readLine();
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
	
	public void exportarUsuarios (ArrayList<Usuario> usuarios) {
		
		FileWriter fichero = null;
		try {

			fichero = new FileWriter("data/usuarios");
			int cont = 0;

			// Escribimos linea a linea en el fichero
			for (Usuario user : usuarios) {
				cont++;
				String nomUsuario = user.getNomUsuario();
				String correo = user.getCorreo();
				String contrasenya = user.getContrasenya();
	
				if (usuarios.size() == cont) {
					fichero.write( nomUsuario + "," + correo + "," + contrasenya);
				}else {
					fichero.write( nomUsuario + "," + correo + "," + contrasenya + "\n");
				}
				
			}

			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}
	
	public boolean comprobarUsuario (String nomUsuario) {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		
		boolean existe = false;
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	
	    String ruta = "data/usuarios";
	
	      try {
	         archivo = new File (ruta);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         
	         String linea = br.readLine();
	         while(linea!=null) {
	        	 String[] palabras = linea.split(",");
	        	 
	        	if (nomUsuario.equals(palabras[0])) {
	        		existe = true;
	        	}
	        	 linea = br.readLine();
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
			
		return existe;
			
	}
	}


