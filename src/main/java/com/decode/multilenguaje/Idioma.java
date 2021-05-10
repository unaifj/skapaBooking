package com.decode.multilenguaje;

import java.io.IOException;
import java.util.Properties;

public class Idioma extends Properties{

	private static final long serialVersionUID = 1L;

	public Idioma(String idioma){
        if(idioma.equals("ES")){
            getProperties("espanol.properties");
        }else if(idioma.equals("EN")){
            getProperties("ingles.properties");
        }else{
            getProperties("espanol.properties");
        }
    }

     private void getProperties(String idioma) {
        try {                
            this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {            
        }
   }

}