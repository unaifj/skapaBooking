package com.decode.SKBB;

import java.util.ArrayList;

import com.decode.objects.Usuario;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class EliminarUsuario {
	private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>() {
        {
            add(new Usuario("Paco", "Paquito2","paco@gmail.com"));
            add(new Usuario("Raul", "Raulito","raul@gmail.com"));
            add(new Usuario("Pedro", "Pedrosa21","pedro@gmail.com"));
        }
    };

    @DELETE
    @Path("/eliminarUsuario/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("nombre") String nombre) {
        Usuario found = null;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getNomUsuario().equalsIgnoreCase(nombre)) {
                found = listaUsuarios.get(i);
                listaUsuarios.remove(found);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("User not found").build();
        } else {
            return Response.ok(listaUsuarios).build();
        }
    }
}
