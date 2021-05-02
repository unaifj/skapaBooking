package com.decode.resource;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.decode.bd.DBManager;
import com.decode.objects.Servidor;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("servidor")
public class ServidorResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Servidor> getServidor() {
		List<Servidor> servidor = DBManager.getInstance().getServidor();
		return servidor;
	}

	@PATCH
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Servidor modificarServidor(Servidor servidor) {
		DBManager.getInstance().actualizarServidor(servidor);
		return servidor;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Servidor agregarServidor(Servidor servidor) {
		DBManager.getInstance().agregarServidor(servidor);
		return servidor;
	}

	@DELETE
	@Path("/ids/{servidorId}")
	@Produces(MediaType.TEXT_PLAIN)
	
	public String eliminarServidor(@PathParam("servidorId") String nombreServidor) {
		DBManager.getInstance().eliminarServidorPorNombreServidor(nombreServidor);
		return "Hecho";
	}
	
}
