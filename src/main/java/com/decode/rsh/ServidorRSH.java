package com.decode.rsh;

import java.util.List;


import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import com.decode.objects.Servidor;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ServidorRSH {
	 static ServidorRSH instance = null;
	    Client client;
	    WebTarget target;

	    public static ServidorRSH getInstance() {
	        if (instance == null) {
	            instance = new ServidorRSH();
	        }
	        return instance;
	    }

	    public ServidorRSH() {
	        client = ClientBuilder.newClient();
	        client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
	        target = client.target("http://localhost:8080/myapp").path("servidor"); // http://localhost:8080/myapp/servidor
	    }

	    /**
	     * Ver todos los servidores.
	     * 
	     * @return <Code>List<Servidor></Code> Lista con servidores
	     */
	    public List<Servidor> getServidor() {
	        Invocation.Builder ib = target.request(); 
	        Response response = ib.get(); 
	        List<Servidor> servidores = response.readEntity(new GenericType<List<Servidor>>() { // Crear una lista de servidores
	        });
	        return servidores;
	    }

	    /**
	     * Hacer una petición PUT al servidor para guardar un nuevo Servidor.
	     * 
	     * @param Guardar Servidor.
	     * @return <Code>Servidor</Code> Devuelve el servidor.
	     */
	    public Servidor agregarServidor(Servidor servidor) {
	        Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
	        Response response = ib.put(Entity.entity(servidor, MediaType.APPLICATION_JSON));
	        Servidor servidorId = response.readEntity(Servidor.class);
	        return servidorId;
	    }

	    /**
	     * Modificar el servidor
	     * 
	     */
	    public Servidor modificarServidor(Servidor servidor) {
	        Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
	        Response response = ib.build("PATCH", Entity.json(servidor)).invoke();

	        Servidor servidorId = response.readEntity(Servidor.class);
	        return servidorId;
	    }

	    /**
	     * Borrar un servidor de la BD
	     * 
	     */
	    public void eliminarServidor(Servidor servidor) {
	        Invocation.Builder ib = target.path("/ids/" + servidor.getNomServidor()).request();
	        ib.delete();
	    }
}
