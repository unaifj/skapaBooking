package com.decode.bd;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.decode.objects.Usuario;

public class DBManager {
	
	
	
	
	//INSTALACION DE DATOS
	public void preparedData () throws DBException{
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			Usuario userA = new Usuario("John", "jhon@gmail.com", "john123");
			pm.makePersistent(userA);
			Usuario userB = new Usuario("Albert", "albert@gmail.com", "albert123");
			pm.makePersistent(userB);
			Usuario userC = new Usuario("Isaac", "isaac@gmail.com", "isaac123");
			pm.makePersistent(userC);

			tx.commit();
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	//LISTAR USUARIOS DE BD
	
	
	public List<Usuario> listarUsuarios() throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Usuario> query = pm.newQuery("javax.jdo.query.SQL","select * from " + "usuario");
		query.setClass(Usuario.class);
			
		List<Usuario> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
	
	//INSERTAR USUARIO
	public void insertarUsuario(Usuario user) throws DBException{
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			
			pm.makePersistent(user);

			tx.commit();
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}
	
	

	
			
}
	


