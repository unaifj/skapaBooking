package com.decode.email;

import java.io.IOException;
import java.security.InvalidParameterException;
import javax.mail.MessagingException;


public class EnviarEmail {

	  public static void main(String[] args) {

	        try {
	            Mail m = new Mail("config/configuracion.prop");

	            m.enviarEmail("Test", "Hola mundo", "shifterg29@gmail.com");
	            
	            String correos[] = {"shifterg29@gmail.com", "shifterg29@gmail.com"};
	            
	            m.enviarEmail("Test", "Hola mundo", correos);

	            System.out.println("Se ha enviado!!");
	        } catch (InvalidParameterException | IOException | MessagingException ex) {
	            System.out.println(ex.getMessage());
	        }

	    }
}
