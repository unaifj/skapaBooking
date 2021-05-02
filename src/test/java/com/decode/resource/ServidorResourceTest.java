package com.decode.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.decode.categories.IntegrationTest;
import com.decode.main.Main;
import com.decode.objects.Servidor;
import com.decode.rsh.ServidorRSH;


@Category(IntegrationTest.class)
public class ServidorResourceTest {
	 private static HttpServer server;
	    private static ServidorRSH rsh;
	    
	    private static Servidor servidor1;
	    private static Servidor servidor2;
	    private static Servidor servidor3;
	    private static Servidor servidor4;
	    private List<Servidor> servidorDB;
	    
	    
	    public ServidorResourceTest() {
	    	
	    }
	    
	    @BeforeClass
	    public static void setUp() {
	    	// start the server
	    	server = Main.startServer();
	        rsh = ServidorRSH.getInstance();
	       
	        servidor1 = new Servidor(0, "S1", "S1@gmail.com", "1234", 0);
	        servidor2 = new Servidor(0, "S2", "S2@gmail.com", "3455", 0);
	        servidor3 = new Servidor(0, "S3", "S3@gmail.com", "7574", 0);
	        servidor4 = new Servidor(0, "S4", "S4@gmail.com", "7645", 0);
	     
	    }
	    
	    @AfterClass
	    public static void tearDown() throws Exception{
	    	server.shutdownNow();
	 
	    }
	    @Before
	    public void PrepareData() {
	        System.out.println(
	                "================================================Creando los servidores ...================================================");
	        rsh.agregarServidor(servidor1);
	        rsh.agregarServidor(servidor2);
	        rsh.agregarServidor(servidor3);
	  
	        
	    }
	    
	    @After
	    public void Clean() {
	        System.out.println(
	                "================================================Borrando un servidor ...================================================");
	        servidorDB = rsh.getServidor();
	        for (Servidor s : servidorDB) {
	            rsh.eliminarServidor(s);
	        }
	    }
	    

		@Test
		public void testVisualizarServidores() {
	        System.out.println(
	                "================================================Test visualizar los distintos Servidores================================================");
	        
	        servidorDB = rsh.getServidor();
	        assertEquals(servidorDB.size(), 3);
	        
	        boolean servidor1_found = false;
	        boolean servidor2_found = false;
	        boolean servidor3_found = false;
	      
	        
			for (Servidor servidor : servidorDB) {
				if (servidor.equals(servidor1)) {
					servidor1_found = true;
				} else if (servidor.equals(servidor2)) {
					servidor2_found = true;
				} else if (servidor.equals(servidor3)) {
					servidor3_found = true;
				
				}
			}
			assertTrue(servidor1_found && servidor2_found && servidor3_found);
		}
		
		@Test
		public void testAgregarServidores() {
	        System.out.println(
	                "================================================Test agregar servidores================================================");
	        rsh.agregarServidor(servidor4);
	        servidorDB = rsh.getServidor();
	        assertEquals(servidorDB.size(), 4);
	        
	        boolean servidor4_found = false;
	        
	        for (Servidor servidor : servidorDB) {
				if(servidor.equals(servidor4)) {
					servidor4_found = true;
				}
			}
	        assertTrue(servidor4_found);
	        
		}
		
		@Test
	    public void testEliminarServidor() {
	        System.out.println(
	                "================================================Test eliminando servidores================================================");
	        rsh.eliminarServidor(servidor1);
	        servidorDB = rsh.getServidor();
	        assertEquals(servidorDB.size(), 2);
			
	        boolean servidor1_found = false;
	        boolean servidor2_found = false;
	        boolean servidor3_found = false;
	        
			for (Servidor servidor : servidorDB) {
				if (servidor.equals(servidor1)) {
					servidor1_found = true;
				} else if (servidor.equals(servidor2)) {
					servidor2_found = true;
				} else if (servidor.equals(servidor3)) {
					servidor3_found = true;
				
			}
			assertTrue(!servidor1_found && servidor2_found&& servidor3_found);
		}
	    
		}
}