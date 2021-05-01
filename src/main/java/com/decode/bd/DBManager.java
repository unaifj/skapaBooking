package com.decode.bd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.decode.objects.Anuncio;
import com.decode.objects.Apartamento;
import com.decode.objects.Localidad;
import com.decode.objects.Opinion;
import com.decode.objects.Reserva;
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
			
			Localidad triana1=new Localidad("Andalucia","Triana",49500, "Avd San Miguel 4");
			pm.makePersistent(triana1);
			Localidad conil1=new Localidad("Andaluzcia","Conil",48500, "Avd San Patricio 6");
			pm.makePersistent(conil1);
			Localidad barakaldo1=new Localidad("Pais Vasco","Barakaldo",48300, "Avd Bagatza 8");
			pm.makePersistent(barakaldo1);
			
			Calendar fechaEntrada = new GregorianCalendar(2021, 6, 24);
			Calendar fechaSalida = new GregorianCalendar(2021, 6, 31);
			Reserva res1 = new Reserva(userA, fechaEntrada, fechaSalida, 5);
			pm.makePersistent(res1);
			
			List<Reserva>reservasA = new ArrayList<Reserva>();
			reservasA.add(res1);
			
			Apartamento apar1= new Apartamento(4,100,triana1, reservasA);
			pm.makePersistent(apar1);
			Apartamento apar2= new Apartamento(6,105,conil1, null);
			pm.makePersistent(apar2);
			Apartamento apar3= new Apartamento(8,120,barakaldo1, null);
			pm.makePersistent(apar3);

			Anuncio anun1=new Anuncio(userA, apar1,"Apartamento soleado en la margen izquierda de Sevilla", "Apartamento soleado con vistas al mar ideal para pasar unos dias en el sur de España", 25, true, 4);
			pm.makePersistent(anun1);
			Anuncio anun2=new Anuncio(userB, apar2,"Apartamento soleado muy bien situado en Conil", "Apartamento muy bien situado con vistas a la cala santo amor muy grande y espaciosa", 32, true, 6);
			pm.makePersistent(anun2);
			Anuncio anun3=new Anuncio(userC, apar3,"Apartamento muy bueno y completo para conocer Vizcaya", "Apartamento muy completo con lo basico para dormir cocinar y descansar, lo demas lo dejamos a gusto del cliente", 20, true, 3);
			pm.makePersistent(anun3);
			
			Opinion op = new Opinion(userA, "opinion titulo", "Descripcion", 8.7f);
			pm.makePersistent(op);

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
	
	//COMPROBAR SI USUARIO EXISTE
	public boolean exiteUsuario(Usuario usuario) throws DBException{
		
		boolean existe = false;
		List<Usuario> usuarios = listarUsuarios();
		
		for (Usuario user : usuarios) {
			if (user.getNomUsuario().equals(usuario.getNomUsuario())) {
				existe = true;
			}
		}

		return existe;

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
	
	//INSERTAR ANUNCIO
	public void insertarAnuncio(Anuncio anuncio) throws DBException{
		
		System.out.println("----ANUNCIO DBM----- ");
		System.out.println("A: " + anuncio);
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			
			pm.makePersistent(anuncio.getApartamento().getLocalidad());
			pm.makePersistent(anuncio.getApartamento());	
			pm.makePersistent(anuncio);
			tx.commit();
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	

	
	//INSERTAR NUEVA OPINION 
	
        public void insertarOpinion(Opinion opinion) throws DBException{
		
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		try {
			tx.begin();
			pm.makePersistent(opinion);
			tx.commit();
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		
		
		}
		
        }
        
        //LISTAR OPINIONES
        public List<Opinion>getOpiniones(Usuario user){
        	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    		PersistenceManager pm = pmf.getPersistenceManager();
    		Transaction tx = pm.currentTransaction();
    		
    		List<Opinion> opiniones = new ArrayList<Opinion>();
    		
    		try {
    			
    			System.out.println("* Tus opiniones");
    			tx.begin();
    			
    			Extent<Opinion> opinionExtent = pm.getExtent(Opinion.class, true);
    			
    			for(Opinion opinion: opinionExtent) {
    				
    				Opinion op = new Opinion(opinion.getUsuario(), opinion.getTitulo(), opinion.getDescripcion(), opinion.getPuntuacion());
    				
    				if(op.getUsuario().getId() == user.getId()) {
    					
    					opiniones.add(op);
    				}
    				
    				
    				
    			}
    			
    			tx.commit();
    			
    		}catch (Exception ex) {
                System.out.println("$ Error viendo tus opiniones: " + ex.getMessage());
            } finally {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }

                pm.close();
            }
        	
        	
        	
        	
        	
			return opiniones;
        	
        }
        
      //LISTAR ANUNCIOS
        public List<Anuncio> getAnuncios() {
    		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    		PersistenceManager pm = pmf.getPersistenceManager();
    		Transaction tx = pm.currentTransaction();
        	

            List<Anuncio> anuncios = new ArrayList<Anuncio>();

            try {
                System.out.println("* Viendo todos Anuncios");
                tx.begin();

                Extent<Anuncio> anuncioExtent = pm.getExtent(Anuncio.class, true);

                for (Anuncio anuncio : anuncioExtent) {
            
                	Localidad loc = new Localidad (anuncio.getApartamento().getLocalidad().getProvincia(), 
                			anuncio.getApartamento().getLocalidad().getMunicipio(), 
                			anuncio.getApartamento().getLocalidad().getCp(), anuncio.getApartamento().getLocalidad().getDireccion());
                	Apartamento aparta = new Apartamento(anuncio.getApartamento().getNumHabitaciones(), 
                			anuncio.getApartamento().getMetrosCuad(), loc, anuncio.getApartamento().getReservas());
                	
                	Usuario user = new Usuario(anuncio.getUsuario().getNomUsuario(), 
                			anuncio.getUsuario().getCorreo(), anuncio.getUsuario().getContrasenya());
                	user.setId(anuncio.getUsuario().getId());
                	
                	Anuncio a = new Anuncio(user, aparta, anuncio.getTitulo(), 
                			anuncio.getDescripcion(), anuncio.getPrecioNoche(), anuncio.isDisponibilidad(), anuncio.getNumPersonas());
                
                	anuncios.add(a);
                	
                }

                tx.commit();
            } catch (Exception ex) {
                System.out.println("$ Error viendo todos Anuncios: " + ex.getMessage());
            } finally {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }

                pm.close();
            }
            return anuncios;

        }
        
    	
    	//MOSTRAR ANUNCIOS POR FILTROS
    	public List<Anuncio> getFiltrados(String titulo, Calendar fechaEntrada, Calendar fechaSalida, int numPersonas, int precioMin, int precioMax) {
    		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    		PersistenceManager pm = pmf.getPersistenceManager();
    		Transaction tx = pm.currentTransaction();

            List<Anuncio> anuncios = new ArrayList<Anuncio>();

            try {
                System.out.println("* Viendo todos Anuncios filtrados");
                tx.begin();

                Extent<Anuncio> anuncioExtent = pm.getExtent(Anuncio.class, true);

                for (Anuncio anuncio : anuncioExtent) {

                		Localidad loc = new Localidad (anuncio.getApartamento().getLocalidad().getProvincia(), 
                    			anuncio.getApartamento().getLocalidad().getMunicipio(), 
                    			anuncio.getApartamento().getLocalidad().getCp(), anuncio.getApartamento().getLocalidad().getDireccion());
                    	Apartamento aparta = new Apartamento(anuncio.getApartamento().getNumHabitaciones(), 
                    			anuncio.getApartamento().getMetrosCuad(), loc, anuncio.getApartamento().getReservas());
                    	aparta.setReservas(anuncio.getApartamento().getReservas());

                    	Usuario user = new Usuario(anuncio.getUsuario().getNomUsuario(), 
                    			anuncio.getUsuario().getCorreo(), anuncio.getUsuario().getContrasenya());
                    	user.setId(anuncio.getUsuario().getId());
                    	
                    	Anuncio a = new Anuncio(user, aparta, anuncio.getTitulo(), anuncio.getDescripcion(), 
                    			anuncio.getPrecioNoche(), anuncio.isDisponibilidad(), anuncio.getNumPersonas());    
     
                    	int cont = 0;
                    	int contV = 0;
                    	
                    	if (!a.getTitulo().equals("")) {
                    		cont++;
                    		if (a.getTitulo().contains(titulo) || a.getTitulo().toLowerCase().contains(titulo)) {
                    			contV++;
                    		}
                    	}
                    	
                    	if (fechaEntrada != null && fechaSalida != null) {
                    		cont ++;
                    		if (a.comprobarDis(fechaEntrada, fechaSalida)) {
                        		contV++;
                    		}
                    	}
                    	
                    	if (numPersonas != 0) {
                    		cont ++;
                    		if (a.getNumPersonas() >= numPersonas) {
                    			contV++;
                    		}
                    	}
                    	
                    	if (precioMax != 0) {
                    		cont ++;
                    		if (a.getPrecioNoche() >= precioMin && a.getPrecioNoche() <= precioMax) {
                    			contV++;
                    		}
                    	}
                    	
                    	
                    	if (cont == contV) {
                    		anuncios.add(a);
				
                    	}
               }

                tx.commit();
            } catch (Exception ex) {
                System.out.println("$ Error viendo todos Anuncios: " + ex.getMessage());
            } finally {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }

                pm.close();
            }
            return anuncios;

    	}	
    	
    	public void actualizarUsuario(Usuario user) {
    		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    		PersistenceManager pm = pmf.getPersistenceManager();
    		Transaction tx = pm.currentTransaction();

            try {
                tx.begin();

                Extent<Usuario> e = pm.getExtent(Usuario.class, true);
                Iterator<Usuario> iter = e.iterator();
                while (iter.hasNext()) {
                    Usuario usuario = (Usuario) iter.next();
                    if (usuario.getId() == user.getId()) {
                        System.out.println("* Updating: " + usuario + "\n* To: " + user);
                        usuario.setNomUsuario(user.getNomUsuario());
                        usuario.setCorreo(user.getCorreo());
                        usuario.setContrasenya(user.getContrasenya());
                    }
                }
                tx.commit();
            } catch (Exception ex) {
                System.out.println("$ Error updating: " + ex.getMessage());
            } finally {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }

                pm.close();
            }
        }
}
