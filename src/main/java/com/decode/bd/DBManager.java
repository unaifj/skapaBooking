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
import com.decode.objects.Servidor;
import com.decode.objects.TarjetaCredito;
import com.decode.objects.Usuario;


public class DBManager {
	
	private static DBManager instance = null;

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }

        return instance;
    }

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
			
			Apartamento apar1= new Apartamento(4,100,triana1, null);
			pm.makePersistent(apar1);
			Apartamento apar2= new Apartamento(6,105,conil1, null);
			pm.makePersistent(apar2);
			Apartamento apar3= new Apartamento(8,120,barakaldo1, null);
			pm.makePersistent(apar3);
			
			Anuncio anun1=new Anuncio(userA.getId(), apar1,"Apartamento soleado en la margen izquierda de Sevilla", "Apartamento soleado con vistas al mar ideal para pasar unos dias en el sur de España", 25, true, 4, "img/anuncios/13880304.png");
			pm.makePersistent(anun1);
			Anuncio anun2=new Anuncio(userB.getId(), apar2,"Apartamento soleado muy bien situado en Conil", "Apartamento muy bien situado con vistas a la cala santo amor muy grande y espaciosa", 32, true, 6, "img/anuncios/13880304.png");
			pm.makePersistent(anun2);
			Anuncio anun3=new Anuncio(userC.getId(), apar3,"Apartamento muy bueno y completo para conocer Vizcaya", "Apartamento muy completo con lo basico para dormir cocinar y descansar, lo demas lo dejamos a gusto del cliente", 20, true, 3, "img/anuncios/13880304.png");
			pm.makePersistent(anun3);
			

			Calendar fechaEntrada = new GregorianCalendar(2021, 6, 24);
			Calendar fechaSalida = new GregorianCalendar(2021, 6, 31);
			
//			Reserva res1 = new Reserva(userA,"Contrareembolso", fechaEntrada, fechaSalida, 5);
//			pm.makePersistent(res1);
			
//			List<Reserva>reservasA = new ArrayList<Reserva>();
//			reservasA.add(res1);
		

//			Opinion op = new Opinion(userA, "opinion titulo", "Descripcion", 8.7f);
//			pm.makePersistent(op);
			
			Servidor s1 = new Servidor(0, "Server1", "servidor@gmail.com", "server1233", 80);
			pm.makePersistent(s1);
			Servidor s2 = new Servidor(0, "Server2", "servidor@gmail.com", "server1233", 90);
			pm.makePersistent(s2);
			Servidor s3 = new Servidor(0, "Server3", "servidor@gmail.com", "server1233", 78);
			pm.makePersistent(s3);


			tx.commit();
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	
	public Usuario selectUsuario (int idUsuario) {
		
  		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
  		PersistenceManager pm = pmf.getPersistenceManager();
  		Transaction tx = pm.currentTransaction();
      	
  	
  		Usuario usuario = null;
  		 
          try {
              System.out.println("* Viendo todas los usuarios");
              tx.begin();

              Extent<Usuario> usuarioExtent = pm.getExtent(Usuario.class, true);
             
              for (Usuario user : usuarioExtent) {
              	if (idUsuario == user.getId()) {
              		
              		usuario = new Usuario(user.getNomUsuario(), user.getCorreo(), user.getContrasenya());
              		usuario.setId(user.getId());
              	}
           
              }

              tx.commit();
          } catch (Exception ex) {
              System.out.println("$ Error viendo todos Metodos de pago: " + ex.getMessage());
          } finally {
              if (tx != null && tx.isActive()) {
                  tx.rollback();
              }

              pm.close();
          }
          return usuario;

	      
	}
	
	 public void deleteAnuncio(Anuncio anuncio) {
		 PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	  		PersistenceManager pm = pmf.getPersistenceManager();
	  		Transaction tx = pm.currentTransaction();
	        try {
	     
	            tx.begin();

	            Extent<Anuncio> e = pm.getExtent(Anuncio.class, true);
	            Iterator<Anuncio> iter = e.iterator();
	            while (iter.hasNext()) {
	            	Anuncio anuncio1 = (Anuncio) iter.next();
	            	System.out.println(anuncio.getId() + " - " + anuncio1.getId());
	            	if (anuncio1.getTitulo().equals(anuncio.getTitulo())) {
	            		pm.deletePersistent(anuncio1);
	      
	            	
	            	}else {
	            	
	            	}
	                 
	                
	            }

	            tx.commit();
	        } catch (Exception ex) {
	            
	        } finally {
	            if (tx != null && tx.isActive()) {
	                tx.rollback();
	            }
	            pm.close();
	        }
	    }
	
	//VACIAR TABLAS 
	 public void deleteUsuarios() {
		 PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	  		PersistenceManager pm = pmf.getPersistenceManager();
	  		Transaction tx = pm.currentTransaction();
	        try {
	     
	            tx.begin();

	            Extent<Usuario> e = pm.getExtent(Usuario.class, true);
	            Iterator<Usuario> iter = e.iterator();
	            while (iter.hasNext()) {
	            	Usuario usuario = (Usuario) iter.next();
	                 pm.deletePersistent(usuario);
	                
	            }

	            tx.commit();
	        } catch (Exception ex) {
	            
	        } finally {
	            if (tx != null && tx.isActive()) {
	                tx.rollback();
	            }
	            pm.close();
	        }
	    }

	
	//LISTAR USUARIOS DE BD
	  public List<Usuario> getUsuarios() {
  		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
  		PersistenceManager pm = pmf.getPersistenceManager();
  		Transaction tx = pm.currentTransaction();
      	
  		List<Usuario> usuarios = new ArrayList<Usuario>();

          try {
              System.out.println("* Viendo todas los usuarios");
              tx.begin();

              Extent<Usuario> usuarioExtent = pm.getExtent(Usuario.class, true);

              for (Usuario user : usuarioExtent) {
              	
              	Usuario usuario = new Usuario(user.getNomUsuario(), user.getCorreo(), user.getContrasenya());
              	usuario.setId(user.getId());
              	usuarios.add(usuario);
              }

              tx.commit();
          } catch (Exception ex) {
              System.out.println("$ Error viendo todos Metodos de pago: " + ex.getMessage());
          } finally {
              if (tx != null && tx.isActive()) {
                  tx.rollback();
              }

              pm.close();
          }
          return usuarios;

      }
	//LISTAR SERVIDORES DE BD
	  public List<Servidor> getServidor() {
  		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
  		PersistenceManager pm = pmf.getPersistenceManager();
  		Transaction tx = pm.currentTransaction();
      	
  		List<Servidor> servidores = new ArrayList<Servidor>();

          try {
              System.out.println("* Viendo todos los servidores");
              tx.begin();

              Extent<Servidor> servidorExtent = pm.getExtent(Servidor.class, true);

              for (Servidor ser : servidorExtent) {
              	
              	Servidor servidor = new Servidor(0, ser.getNomServidor(), ser.getCorreoS(), ser.getContrasenyaS(), 9000);
              	servidores.add(servidor);
              }

              tx.commit();
          } catch (Exception ex) {
              System.out.println("$ Error viendo todos los servidores: " + ex.getMessage());
          } finally {
              if (tx != null && tx.isActive()) {
                  tx.rollback();
              }

              pm.close();
          }
          return servidores;

      }
	//COMPROBAR SI USUARIO EXISTE
	public boolean exiteUsuario(Usuario usuario) throws DBException{
		
		boolean existe = false;
		List<Usuario> usuarios = getUsuarios();
		
		for (Usuario user : usuarios) {
			if (user.getNomUsuario().equals(usuario.getNomUsuario())) {
				existe = true;
			}
		}

		return existe;

	}
	
	//INSERTAR USUARIO
	public void insertarUsuario(Usuario user){
		
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
	//AGREGAR SERVIDOR
		public void agregarServidor(Servidor servidores){
			
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			
			try {
				tx.begin();
				
				pm.makePersistent(servidores);

				tx.commit();
				
			} finally {
				if (tx.isActive()) {
					tx.rollback();
				}
				pm.close();
			}	
		}
		
	//ELIMINAR USUARIO
	 public void deleteUsuarioByNomUsuario(String nomUsuario) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
	        try {
	            System.out.println("Eliminando usuario con nomusuario: " + nomUsuario);
	            tx.begin();

	            Extent<Usuario> e = pm.getExtent(Usuario.class, true);
	            Iterator<Usuario> iter = e.iterator();
	            while (iter.hasNext()) {
	                Usuario usuario = (Usuario) iter.next();
	                if (usuario.getNomUsuario() == null ? nomUsuario == null : usuario.getNomUsuario().equals(nomUsuario)) {
	                    pm.deletePersistent(usuario);
	                }
	            }

	            tx.commit();
	        } catch (Exception ex) {
	            System.out.println("Error obteniendo usuario: " + ex.getMessage());
	        } finally {
	            if (tx != null && tx.isActive()) {
	                tx.rollback();
	            }
	            pm.close();
	        }
	    }

	 
	//ELIMINAR ANUNCIO
		 public void deleteAnuncioPorTitulo(String titulo) {
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
		        try {
		            System.out.println("Eliminando anuncio con titulo de anuncio: " + titulo);
		            tx.begin();

		            Extent<Anuncio> e = pm.getExtent(Anuncio.class, true);
		            Iterator<Anuncio> iter = e.iterator();
		            while (iter.hasNext()) {
		                Anuncio anuncio = (Anuncio) iter.next();
		                if (anuncio.getTitulo() == null ? titulo == null : anuncio.getTitulo().equals(titulo)) {
		                    pm.deletePersistent(titulo);
		                }
		            }

		            tx.commit();
		        } catch (Exception ex) {
		            System.out.println("Error obteniendo anuncio: " + ex.getMessage());
		        } finally {
		            if (tx != null && tx.isActive()) {
		                tx.rollback();
		            }
		            pm.close();
		        }
		    }


	//ELIMINAR SERVIDOR
	 public void eliminarServidorPorNombreServidor(String nombreServidor) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
	        try {
	            System.out.println("Eliminando servidor por el nombre que contenga: " + nombreServidor);
	            tx.begin();

	            Extent<Servidor> e = pm.getExtent(Servidor.class, true);
	            Iterator<Servidor> iter = e.iterator();
	            
	            while (iter.hasNext()) {
	            	Servidor servidor = (Servidor) iter.next();
	                if (servidor.getNomServidor() == null ? nombreServidor == null : servidor.getNomServidor().equals(nombreServidor)) {
	                    pm.deletePersistent(servidor);
	                }
	            }

	            tx.commit();
	        } catch (Exception ex) {
	            System.out.println("Error obteniendo servidor: " + ex.getMessage());
	        } finally {
	            if (tx != null && tx.isActive()) {
	                tx.rollback();
	            }
	            pm.close();
	        }
	    }

	 
	 //ELIMINAR OPINION
	 public void deleteOpinionByTitulo(String titulo) {
		 PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			
			try {
				System.out.println("Eliminando opinion con idUsuario: " + titulo);
				tx.begin();
				
				Extent<Opinion> e = pm.getExtent(Opinion.class, true);
    			Iterator<Opinion> iter = e.iterator();
    			  while (iter.hasNext()) {
    				  Opinion opinion = (Opinion) iter.next();
    				  if(opinion.getTitulo() == null ? titulo == null : opinion.getTitulo().equals(titulo) ) {
    					  pm.deletePersistent(opinion);  
    				  }
    			  }
				tx.commit();
				
			}catch (Exception ex) {
				System.out.println("Error obteniendo la id del usuario: " + ex.getMessage());
			}finally {
				 if (tx != null && tx.isActive()) {
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
			
			pm.makePersistent(anuncio);
		
	
			
			tx.commit();
			
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
	}
	
	
	//INSERTAR RESERVA
		public void insertarReserva(Reserva reserva) throws DBException{
			
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			
			try {
				tx.begin();
				
				pm.makePersistent(reserva.getUsuario());	
				pm.makePersistent(reserva);
				tx.commit();
				
			} finally {
				if (tx.isActive()) {
					tx.rollback();
				}
				pm.close();
			}
		}
		
		//INSERTAR TARJETA
				public void insertarTarjeta(TarjetaCredito tarjeta) throws DBException{
					
					System.out.println("----TARJETA DBM----- ");
					System.out.println("A: " + tarjeta);
					
					PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
					PersistenceManager pm = pmf.getPersistenceManager();
					Transaction tx = pm.currentTransaction();
					
					try {
						tx.begin();
						
						pm.makePersistent(tarjeta);
						tx.commit();
						
					} finally {
						if (tx.isActive()) {
							tx.rollback();
						}
						pm.close();
					}
				}
		
		//LISTAR TARJETAS DE CREDITOS
		
        public List<TarjetaCredito> getTarjeta(Usuario user) {
    		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    		PersistenceManager pm = pmf.getPersistenceManager();
    		Transaction tx = pm.currentTransaction();
        	
    		List<TarjetaCredito> tarjetasUsuario = new ArrayList<TarjetaCredito>();

            try {
                System.out.println("* Viendo todas las tarjetas");
                tx.begin();

                Extent<TarjetaCredito> tarjetaCreditoExtent = pm.getExtent(TarjetaCredito.class, true);

                for (TarjetaCredito tarjeta : tarjetaCreditoExtent) {
                	
                	
             	
                	TarjetaCredito t = new TarjetaCredito(tarjeta.getIdUsuario(), tarjeta.getNumTarjeta(), tarjeta.getNumTarjeta(), tarjeta.getCvv());
                	
                	System.out.println(t);
                	
//                	if (t.getUsuario().getNomUsuario() == user.getNomUsuario()) {
//                		tarjetasUsuario.add(tarjeta);
//                	}
          
                }

                tx.commit();
            } catch (Exception ex) {
                System.out.println("$ Error viendo todos Metodos de pago: " + ex.getMessage());
            } finally {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }

                pm.close();
            }
            return tarjetasUsuario;

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
        public List<Opinion> getOpinionesSinUser() {
    		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    		PersistenceManager pm = pmf.getPersistenceManager();
    		Transaction tx = pm.currentTransaction();
        	

            List<Opinion> opiniones = new ArrayList<Opinion>();

            try {
                System.out.println("* Viendo todos Anuncios");
                tx.begin();

                Extent<Opinion> opinionExtent = pm.getExtent(Opinion.class, true);

                for (Opinion opinion : opinionExtent) {
            
                	
                
                	
                	Opinion o= new Opinion(opinion.getUsuario(),opinion.getTitulo(),opinion.getDescripcion(), opinion.getPuntuacion());
                
                	opiniones.add(o);
                	
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
                	
                	
                	Anuncio a = new Anuncio(anuncio.getIdUsuario(), aparta, anuncio.getTitulo(), 
                			anuncio.getDescripcion(), anuncio.getPrecioNoche(), anuncio.isDisponibilidad(), anuncio.getNumPersonas(), anuncio.getImg());
                
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
        


      //CREAR NUEVO APARTAMENTO
    	public void insertarApartamento(Apartamento apartamento) throws DBException{
    		
    		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    		PersistenceManager pm = pmf.getPersistenceManager();
    		Transaction tx = pm.currentTransaction();
    		
    		try {
    			tx.begin();
    			pm.makePersistent(apartamento);
    			tx.commit();
    			
    		} finally {
    			if (tx.isActive()) {
    				tx.rollback();
    			}
    			pm.close();
    		}
    	}
    	  //CREAR NUEVA LOCALIDAD
    	public void insertarLocalidad(Localidad localidad) throws DBException{
    		
    		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    		PersistenceManager pm = pmf.getPersistenceManager();
    		Transaction tx = pm.currentTransaction();
    		
    		try {
    			tx.begin();
    			pm.makePersistent(localidad);
    			tx.commit();
    			
    		} finally {
    			if (tx.isActive()) {
    				tx.rollback();
    			}
    			pm.close();
    		}
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

                  
                    	
                    	Anuncio a = new Anuncio(anuncio.getIdUsuario(), aparta, anuncio.getTitulo(), anuncio.getDescripcion(), 
                    			anuncio.getPrecioNoche(), anuncio.isDisponibilidad(), anuncio.getNumPersonas(), anuncio.getImg());    
     
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
    	
    	//Actualizar usuario
    	
    	public void actualizarUsuario(Usuario u) {
    		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    		PersistenceManager pm = pmf.getPersistenceManager();
    		Transaction tx = pm.currentTransaction();

            try {
                tx.begin();

                Extent<Usuario> e = pm.getExtent(Usuario.class, true);
                Iterator<Usuario> iter = e.iterator();
                while (iter.hasNext()) {
                    Usuario usuario = (Usuario) iter.next();
                    if (usuario.getNomUsuario().equals(u.getNomUsuario())) {
                        System.out.println("* Updating: " + usuario + "\n* To: " + u);
                        usuario.setNomUsuario(u.getNomUsuario());
                        usuario.setCorreo(u.getCorreo());
                        usuario.setContrasenya(u.getContrasenya());
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

    	//Actualizar anuncios
    	public void actualizarAnuncio(Anuncio anun) {
    		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    		PersistenceManager pm = pmf.getPersistenceManager();
    		Transaction tx = pm.currentTransaction();

            

                try {
                    tx.begin();

                    Extent<Anuncio> e = pm.getExtent(Anuncio.class, true);
                    Iterator<Anuncio> iter = e.iterator();

                    while (iter.hasNext()) {
                    	Anuncio anuncio = (Anuncio) iter.next();
                        if (anuncio.getTitulo() == anun.getTitulo()) {
                            System.out.println("* Updating: " + anuncio + "\n* To: " + anun);
                            anuncio.setApartamento(anun.getApartamento());
                            anuncio.setDescripcion(anun.getDescripcion());
                            anuncio.setId(anun.getId());
                            anuncio.setNumPersonas(anun.getNumPersonas());
                            anuncio.setPrecioNoche(anun.getPrecioNoche());
                            anuncio.setTitulo(anun.getTitulo());
                         
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


    	//ACTUALIZAR LOS SERVIDORES
    	public void actualizarServidor(Servidor servidores) {
    		
    		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    		PersistenceManager pm = pmf.getPersistenceManager();
    		Transaction tx = pm.currentTransaction();

            

                try {
                    tx.begin();

                    Extent<Servidor> e = pm.getExtent(Servidor.class, true);
                    Iterator<Servidor> iter = e.iterator();

                    while (iter.hasNext()) {
                        Servidor servidor = (Servidor) iter.next();
                        if (servidor.getId() == servidores.getId()) {
                            System.out.println("* Updating: " + servidores + "\n* To: " + servidores);
                            servidor.setNomServidor(servidores.getNomServidor());
                            servidor.setCorreoS(servidores.getCorreoS());
                            servidor.setContrasenyaS(servidores.getContrasenyaS());
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

    	
    	//Actualizar opinion
    	
    	
    	public void actualizarOpinion(Opinion op) {
    		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
    		PersistenceManager pm = pmf.getPersistenceManager();
    		Transaction tx = pm.currentTransaction();
    		
    		try {
    			
    			tx.begin();
    			
    			Extent<Opinion> e = pm.getExtent(Opinion.class, true);
    			Iterator<Opinion> iter = e.iterator();
    			  while (iter.hasNext()) {
    				  Opinion opinion = (Opinion) iter.next();
    				  if (opinion.getTitulo() == op.getTitulo()) {
    					  System.out.println("* Updating: " + opinion + "\n* To: " + op);
    					  opinion.setUsuario(op.getUsuario());
    					  opinion.setTitulo(op.getTitulo());
    					  opinion.setPuntuacion(op.getPuntuacion());
    					  opinion.setDescripcion(op.getDescripcion());
    					  
    				  }
    			  }
    			  tx.commit();
    			
    		}catch (Exception ex) {
    			System.out.println("$ Error updating: " + ex.getMessage());
    		}finally {
    			if (tx != null && tx.isActive()) {
    				 tx.rollback();
    			}
    			
    			pm.close();
    		}
    		
    	}

}
