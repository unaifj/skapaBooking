package com.decode.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
import com.decode.rest.Usuario;
 
@Path("/aprendec")
public class Servidor {
	@POST
	 @Path("/validaUsuario")
	 @Consumes({ MediaType.APPLICATION_JSON })
	 @Produces({ MediaType.APPLICATION_JSON })
	 public Usuario validaUsuario(Usuario u) {
	  u.setUserValido(false);
	  if (u.getUsuario().equals("aprendec") && u.getPassword().equals("123")) {
	   u.setUserValido(true);
	  }
	  return u;
	 }
}
