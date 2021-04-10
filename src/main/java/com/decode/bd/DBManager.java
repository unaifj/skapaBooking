package com.decode.bd;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.decode.objects.Usuario;
import com.decode.objects.Anuncio;
import com.decode.objects.Apartamento;
import com.decode.objects.Localidad;

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
			
			Localidad triana1=new Localidad("Andalucia","Triana",49500, "Avd San Miguel 4");
			pm.makePersistent(triana1);
			Localidad conil1=new Localidad("Andaluzcia","Conil",48500, "Avd San Patricio 6");
			pm.makePersistent(conil1);
			Localidad barakaldo1=new Localidad("Pais Vasco","Barakaldo",48300, "Avd Bagatza 8");
			pm.makePersistent(barakaldo1);
			
			Apartamento apar1= new Apartamento(4,100,triana1);
			pm.makePersistent(apar1);
			Apartamento apar2= new Apartamento(6,105,conil1);
			pm.makePersistent(apar2);
			Apartamento apar3= new Apartamento(8,120,barakaldo1);
			pm.makePersistent(apar3);
			
			Anuncio anun1=new Anuncio(apar1,"Apartamento soleado en la margen izquierda de Sevilla", "Apartamento soleado con vistas al mar ideal para pasar unos dias en el sur de España", 25, true, 4);
			pm.makePersistent(anun1);
			Anuncio anun2=new Anuncio(apar2,"Apartamento soleado muy bien situado en Conil", "Apartamento muy bien situado con vistas a la cala santo amor muy grande y espaciosa", 32, true, 6);
			pm.makePersistent(anun2);
			Anuncio anun3=new Anuncio(apar3,"Apartamento muy bueno y completo para conocer Vizcaya", "Apartamento muy completo con lo basico para dormir cocinar y descansar, lo demas lo dejamos a gusto del cliente", 20, true, 3);
			pm.makePersistent(anun3);

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
	
	//LISTAR APARTAMENTOS
	public List<Apartamento> listarApartamentos() throws DBException{
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		tx.begin();
		
		Query<Apartamento> query = pm.newQuery("javax.jdo.query.SQL","select * from " + "Apartamento");
		query.setClass(Apartamento.class);
			
		List<Apartamento> results = query.executeList();
		
		tx.commit();
		pm.close();
		return results;
		
	}
	

	
			
}
	


