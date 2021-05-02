package com.decode.SKBB;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.decode.objects.Usuario;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("users")
public class UserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsers() {
    	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Query<Usuario> q = pm.newQuery(Usuario.class);
		q.setOrdering("surname desc");
		
		List<Usuario> users = q.executeList();

		pm.close();
		
		return users;
    }
	@GET
   	@Path("listarUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public static List<Usuario> listarUsuarios(){
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Usuario> query = pm.newQuery("javax.jdo.query.SQL","select * from usuario");
		query.setClass(Usuario.class);
		List<Usuario> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
	@GET
	@Path("encontrarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
     public static boolean encontrarUsuario(Usuario usuario){
 		
 		boolean encontrado = false;
 		List<Usuario> usuarios = listarUsuarios();
 		
 		for (Usuario user : usuarios) {
 			if (user.getNomUsuario().equals(usuario.getNomUsuario())) {
 				encontrado = true;
 			}
 		}

 		return encontrado;

 	}
   
}

