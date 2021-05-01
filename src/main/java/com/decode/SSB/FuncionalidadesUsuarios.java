package com.decode.SSB;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;


public class FuncionalidadesUsuarios {

	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>() {
<<<<<<< HEAD
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
            add(new Usuario(0, "Paco", "Paquito2","paco@gmail.com"));
            add(new Usuario(0, "Raul", "Raulito","raul@gmail.com"));
            add(new Usuario(0, "Pedro", "Pedrosa","pedro@gmail.com"));
=======
        {
            add(new Usuario("Paco", "Paquito2","paco@gmail.com"));
            add(new Usuario("Raul", "Raulito","raul@gmail.com"));
            add(new Usuario("Pedro", "Pedrosa21","pedro@gmail.com"));
>>>>>>> master
        }
    };
 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return Response.ok(listaUsuarios).build();
    }
 
 
    /**
     * URL: http://localhost:8080/miaplicacion/
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
            if (listaUsuarios.get(i).getNombre().equalsIgnoreCase(name)) {
                found = listaUsuarios.get(i);
            }
        }
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("User not found").build();
        } else {
            return Response.ok(found).build();
        }
    }
 
    /**
     * URL: http://localhost:8080/miaplicacion/crearUsuario 
     * Parameters in
     * Postman: {"nombre":"Mikel","misaga":"misi@gmail.com"}
     * 
    
     */
    @POST
    @Path("/crearUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(Usuario crearUsuario) {
 
        this.listaUsuarios.add(crearUsuario);
        return Response.ok(listaUsuarios).build();
 
    }
 
    /**
     * URL: http://localhost:8080/miaplicacion/actualizarUsuario Parameters in
     * Postman: {"name":"Mikel","misaga":"misaga@gmail.com"}
     * 
     
     */
    @PUT
    @Path("/actualizarUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(Usuario actualizarUsuario) {
        Usuario found = null;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getNombre().equalsIgnoreCase(actualizarUsuario.getNombre())) {
                found = listaUsuarios.get(i);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Usuario no encontrado").build();
        } else {
            found.setNombreUsuario(actualizarUsuario.getNombreUsuario());
            return Response.ok(found).build();
        }
    }
 
    /**
     * URL: http://localhost:8080/miaplicacion/eliminarUsuario/Paco
     * 
     */
    @DELETE
    @Path("/eliminarUsuario/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("nombre") String nombre) {
        Usuario found = null;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getNombre().equalsIgnoreCase(nombre)) {
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
