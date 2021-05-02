package com.decode.resource;

import java.util.List;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.objects.Opinion;
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


@Path("opinion")
public class OpinionResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Opinion> getOpiniones(Usuario usuario) {
		List<Opinion> opiniones = DBManager.getInstance().getOpiniones(usuario);
		return opiniones;
	}
	
	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Opinion modificarOpinion(Opinion op) {
		DBManager.getInstance().actualizarOpinion(op);;
		return op;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Opinion crearOpinion(Opinion opinion) {
		try {
			DBManager.getInstance().insertarOpinion(opinion);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return opinion;
	}
	
	@DELETE
	@Path("/ids/{opinionTitulo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String eliminarOpinion(@PathParam("opinionTitulo") String titulo) {
		DBManager.getInstance().deleteOpinionByTitulo(titulo);
		return "Done deleteOpinion";
	}

}
