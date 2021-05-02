package com.decode.rsh;

import java.util.List;



import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import com.decode.objects.Anuncio;
import com.decode.objects.Usuario;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class AnuncioRSH {

    static AnuncioRSH instance = null;
    Client client;
    WebTarget target;

    public static AnuncioRSH getInstance() {
        if (instance == null) {
            instance = new AnuncioRSH();
        }
        return instance;
    }

    public AnuncioRSH() {
        client = ClientBuilder.newClient();
        client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
        target = client.target("http://localhost:8080/myapp").path("anuncio"); 
    }

    /**
     * Ver todas los usuarios del servidor.
     * 
     * @return <Code>List<Usuario></Code> Lista con usuarios
     */
    public List<Anuncio> verAnuncios() {
        Invocation.Builder ib = target.request(); // Construir la petición
        Response response = ib.get(); // Realizar una petición GET
        List<Anuncio> anuncios = response.readEntity(new GenericType<List<Anuncio>>() { // Crear una lista de usuarios
        });
        return anuncios;
    }

    /**
     * Hacer una petición PUT al servidor para guardar el usuario.
     * 
     * @param Usuario a guardar.
     * @return <Code>Usuario</Code> Usuario con el dni ya guardado en la DB.
     */
    public Anuncio guardarAnuncio(Anuncio anuncio) {
        Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
        Response response = ib.put(Entity.entity(anuncio, MediaType.APPLICATION_JSON));
        Anuncio anuncioApar = response.readEntity(Anuncio.class);
        return anuncioApar;
    }

    /**
     * Modificar el usuario en el servidor
     * 
     * @param <Code>Usuario</Code> Usuario a modificar
     * @return <Code>Usuario</Code> Usuario con el dni ya guardado en la BD
     */
    public Anuncio modificarAnuncio(Anuncio anuncio) {
        Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
        Response response = ib.build("PATCH", Entity.json(anuncio)).invoke();

        Anuncio anuncioApar = response.readEntity(Anuncio.class);
        return anuncioApar;
    }

    /**
     * Borrar un usuario de la BD
     * 
     * @param <Code>Usuario</Code> Usuario a borrar
     */
    public void borrarAnuncio(Anuncio anuncio) {
        Invocation.Builder ib = target.path("/ids/" + anuncio.getId()).request();
        ib.delete();
    }

}