package com.decode.SKBB;

import java.util.ArrayList;

import com.decode.objects.Usuario;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


public class CrearUsuario {
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>() {
        {
            add(new Usuario("Paco", "Paquito2","paco@gmail.com"));
            add(new Usuario("Raul", "Raulito","raul@gmail.com"));
            add(new Usuario("Pedro", "Pedrosa21","pedro@gmail.com"));
        }
    };

	 @POST
	    @Path("/crearUsuario")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response createUser(Usuario crearUsuario) {
	 
	        this.listaUsuarios.add(crearUsuario);
	        return Response.ok(listaUsuarios).build();
	 
	    }
}
