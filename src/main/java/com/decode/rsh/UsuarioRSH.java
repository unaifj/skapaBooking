package com.decode.rsh;

import java.util.List;



import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import com.decode.objects.Usuario;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class UsuarioRSH {

    static UsuarioRSH instance = null;
    Client client;
    WebTarget target;

    public static UsuarioRSH getInstance() {
        if (instance == null) {
            instance = new UsuarioRSH();
        }
        return instance;
    }

    public UsuarioRSH() {
        client = ClientBuilder.newClient();
        client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);
        target = client.target("http://localhost:8080/myapp").path("usuario"); // http://localhost:8080/myapp/usuario
    }

    /**
     * Ver todas los usuarios del servidor.
     * 
     * @return <Code>List<Usuario></Code> Lista con usuarios
     */
    public List<Usuario> verUsuarios() {
        Invocation.Builder ib = target.request(); // Construir la petición
        Response response = ib.get(); // Realizar una petición GET
        List<Usuario> usuarios = response.readEntity(new GenericType<List<Usuario>>() { // Crear una lista de usuarios
        });
        return usuarios;
    }

    /**
     * Hacer una petición PUT al servidor para guardar el usuario.
     * 
     * @param Usuario a guardar.
     * @return <Code>Usuario</Code> Usuario con el dni ya guardado en la DB.
     */
    public Usuario guardarUsuario(Usuario usuario) {
        Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
        Response response = ib.put(Entity.entity(usuario, MediaType.APPLICATION_JSON));
        Usuario usuarioConDni = response.readEntity(Usuario.class);
        return usuarioConDni;
    }

    /**
     * Modificar el usuario en el servidor
     * 
     * @param <Code>Usuario</Code> Usuario a modificar
     * @return <Code>Usuario</Code> Usuario con el dni ya guardado en la BD
     */
    public Usuario modificarUsuario(Usuario usuario) {
        Invocation.Builder ib = target.request(MediaType.APPLICATION_JSON);
        Response response = ib.build("PATCH", Entity.json(usuario)).invoke();

        Usuario usuarioConDni = response.readEntity(Usuario.class);
        return usuarioConDni;
    }

    /**
     * Borrar un usuario de la BD
     * 
     * @param <Code>Usuario</Code> Usuario a borrar
     */
    public void borrarUsuario(Usuario usuario) {
        Invocation.Builder ib = target.path("/ids/" + usuario.getNomUsuario()).request();
        ib.delete();
    }

}
