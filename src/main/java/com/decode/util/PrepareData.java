package com.decode.util;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;


import com.decode.objects.Usuario;

public class PrepareData {

	public static void main(String[] args) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Usuario userA = new Usuario("John", "j@gmail.com", "123");
			pm.makePersistent(userA);
			Usuario userB = new Usuario("Albert", "a@gmail.com", "456");
			pm.makePersistent(userB);
			Usuario userC = new Usuario("Isaac", "i@gmail.com", "333");
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
