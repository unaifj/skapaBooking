package com.decode.SKBB;

import java.util.ArrayList;
import java.util.List;

import com.decode.objects.Usuario;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class ObtenerUsuario {
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>() {
        {
            add(new Usuario("Paco", "Paquito2","paco@gmail.com"));
            add(new Usuario("Raul", "Raulito","raul@gmail.com"));
            add(new Usuario("Pedro", "Pedrosa21","pedro@gmail.com"));
        }
    };
	/**
     * URL: http://localhost:8080/myapp/
     * 
     * @param nombre String
     * @return Response
     */
	 @GET
	    @Path("/{nombre}")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getUserById(@PathParam("nombre") String name) {
	        Usuario found = null;
	        for (int i = 0; i < listaUsuarios.size(); i++) {
	            if (listaUsuarios.get(i).getNomUsuario().equalsIgnoreCase(name)) {
	                found = listaUsuarios.get(i);
	            }
	        }
	        if (found == null) {
	            return Response.status(Status.BAD_REQUEST).entity("User not found").build();
	        } else {
	            return Response.ok(found).build();
	        }
	    }
}
