package com.decode.rsh;

import java.util.List;

import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import com.decode.objects.Opinion;


import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class OpinionRSH {

	
	static OpinionRSH instance = null;
	Client client;
    WebTarget target;
    
    public static OpinionRSH getInstance() {
    	if (instance == null) {
    		instance = new OpinionRSH();
    	}
    	
    	return instance;
    }
    
    public OpinionRSH() {
        client = ClientBuilder.newClient();
        client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
        target = client.target("http://localhost:8080/myapp").path("opinion"); // http://localhost:8080/myapp/opinion
    }

    
    public List<Opinion> verOpiniones(){
    	Invocation.Builder ib = target.request(); // Construir la petición
        Response response = ib.get(); // Realizar una petición GET
        List<Opinion> opiniones = response.readEntity(new GenericType<List<Opinion>>() { // Crear una lista de usuarios
    });
        return opiniones;
    
    }
    
    public Opinion guardarOpinion(Opinion opinion) {
    	Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
        Response response = ib.put(Entity.entity(opinion, MediaType.APPLICATION_JSON));
        Opinion opTitulo = response.readEntity(Opinion.class);
        return opTitulo;
    	
    }
    
    public Opinion modificarOpinion(Opinion opinion) {
    	Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
        Response response = ib.build("PATCH", Entity.json(opinion)).invoke();
        
        Opinion opConTitulo = response.readEntity(Opinion.class);
        return opConTitulo;
        
    }
    
    public void borrarOpinion(Opinion opinion) {
    	Invocation.Builder ib = target.path("/ids/" + opinion.getTitulo()).request();
        ib.delete();
    }
    
    
    
}
