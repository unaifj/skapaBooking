package com.decode.resource;

import java.util.List;

import com.decode.bd.DBManager;
import com.decode.objects.Usuario;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("usuario")
public class UsuarioResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = DBManager.getInstance().getUsuarios();
		return usuarios;
	}

	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario modificarUsuario(Usuario usuario) {
		DBManager.getInstance().actualizarUsuario(usuario);
		return usuario;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario crearUsuario(Usuario usuario) {
		DBManager.getInstance().insertarUsuario(usuario);
		return usuario;
	}

	@DELETE
	@Path("/ids/{usuarioDni}")
	@Produces(MediaType.TEXT_PLAIN)
	public String eliminarUsuario(@PathParam("usuarioNomUsuario") String nomUsuario) {
		DBManager.getInstance().deleteUsuarioByNomUsuario(nomUsuario);
		return "Done deleteUsuario";
	}
}
