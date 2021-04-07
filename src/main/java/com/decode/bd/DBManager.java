package com.decode.bd;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.decode.objects.Usuario;

public class DBManager {
	
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	PersistenceManager pm = pmf.getPersistenceManager();
	Transaction tx = pm.currentTransaction();
	
	
	//INSTALACION DE DATOS
	public void preparedData () {
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
	
	

	
			
}
	


