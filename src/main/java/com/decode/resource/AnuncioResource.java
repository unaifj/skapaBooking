package com.decode.resource;

import java.util.List;

import com.decode.bd.DBException;
import com.decode.bd.DBManager;
import com.decode.objects.Anuncio;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("anuncio")
public class AnuncioResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Anuncio> getAnuncios() {
		List<Anuncio> anuncios = DBManager.getInstance().getAnuncios();
		return anuncios;
	}

	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Anuncio modificarAnuncio(Anuncio anuncio) {
		DBManager.getInstance().actualizarAnuncio(anuncio);
		return anuncio;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Anuncio crearUsuario(Anuncio anuncio) throws DBException {
		DBManager.getInstance().insertarAnuncio(anuncio);
		return anuncio;
	}

	@DELETE
	@Path("/ids/{titulo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String eliminarAnuncio(@PathParam("titulo") String titulo) {
		DBManager.getInstance().deleteAnuncioPorTitulo(titulo);
		return "Done deleteAnuncio";
	}
}
