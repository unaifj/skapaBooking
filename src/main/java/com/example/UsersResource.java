package com.example;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.decode.objects.Usuario;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("users")
public class UsersResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
    	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		
		Query<User> q = pm.newQuery(User.class);
		q.setOrdering("surname desc");
		
		List<User> users = q.executeList();

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
		List<Usuario> resultados = query.executeList();
		
		tx.commit();
		pm.close();
		
		return resultados;
		
	}
 	
 	@GET
	@Path("encontrarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
     public static boolean encontrarUsuario(Usuario usuario){
 		
 		boolean encontrado = false;
 		List<Usuario> usuarios = listarUsuarios();
 		
 		for (Usuario u : usuarios) {
 			if (u.getNomUsuario().equals(usuario.getNomUsuario())) {
 				encontrado = true;
 			}
 		}

 		return encontrado;

 	}
 	
 	@POST
	@Path("crearUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
    public void crearUsuario(Usuario usuarios){
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			
			pm.makePersistent(usuarios);

			tx.commit();
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
     }
 	
}

