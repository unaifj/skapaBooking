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
	    private static Servidor servidor5;
	    private static Servidor servidor6;
	    private List<Servidor> servidorDB;
	    
	    
	    public ServidorResourceTest() {
	    	
	    }
	    
	    @BeforeClass
	    public static void setUp() {
	    	// start the server
	    	server = Main.startServer();
	        rsh = ServidorRSH.getInstance();
	       
	        servidor1 = new Servidor(0, "Juan", "Lopez", "1234", 0);
	        servidor2 = new Servidor(0, "Silvia", "Montejo", "1234", 0);
	        servidor3 = new Servidor(0, "Luis", "Alonso", "1234", 0);
	        servidor4 = new Servidor(0, "Silvia", "Montejo", "1234", 0);
	        servidor5 = new Servidor(0, "Luis", "Alonso", "1234", 0);
	        servidor6 = new Servidor(0, "Jorge", "Casas", "1234", 0);
	    }
	    
	    @AfterClass
	    public static void tearDown() throws Exception{
	    	server.shutdownNow();
	 
	    }
	    @Before
	    public void PrepareData() {
	    	// Store test
	        System.out.println(
	                "================================================Creando los servidores ...================================================");
	        rsh.agregarServidor(servidor1);
	        rsh.agregarServidor(servidor2);
	        rsh.agregarServidor(servidor3);
	        rsh.agregarServidor(servidor4);
	        rsh.agregarServidor(servidor5);
	        
	    }
	    
	    @After
	    public void Clean() {
	        System.out.println(
	                "================================================Borrando un servidor ...================================================");
	        servidorDB = rsh.getServidor();
	        for (Servidor cl : servidorDB) {
	            rsh.eliminarServidor(cl);
	        }
	    }
	    

		@Test
		public void testVisualizarServidores() {
	        System.out.println(
	                "================================================Test visualizar los distintos Servidores================================================");
	        
	        servidorDB = rsh.getServidor();
	        assertEquals(servidorDB.size(), 5);
	        
	        boolean servidor1_found = false;
	        boolean servidor2_found = false;
	        boolean servidor3_found = false;
	        boolean servidor4_found = false;
	        boolean servidor5_found = false;
	        
			for (Servidor servidor : servidorDB) {
				if (servidor.equals(servidor1)) {
					servidor1_found = true;
				} else if (servidor.equals(servidor2)) {
					servidor2_found = true;
				} else if (servidor.equals(servidor3)) {
					servidor3_found = true;
				} else if (servidor.equals(servidor4)) {
					servidor4_found = true;
				} else if (servidor.equals(servidor5)) {
					servidor5_found = true;
				}
			}
			assertTrue(servidor1_found && servidor2_found&& servidor3_found&& servidor4_found&& servidor5_found);
		}
		
		@Test
		public void testAgregarServidores() {
	        System.out.println(
	                "================================================Test agregar servidores================================================");
	        rsh.agregarServidor(servidor6);
	        servidorDB = rsh.getServidor();
	        assertEquals(servidorDB.size(), 6);
	        
	        boolean servidor6_found = false;
	        
	        for (Servidor servidor : servidorDB) {
				if(servidor.equals(servidor6)) {
					servidor6_found = true;
				}
			}
	        assertTrue(servidor6_found);
	        
		}
		
		@Test
	    public void testEliminarServidor() {
	        System.out.println(
	                "================================================Test eliminando servidores================================================");
	        rsh.eliminarServidor(servidor1);
	        servidorDB = rsh.getServidor();
	        assertEquals(servidorDB.size(), 4);
			
	        boolean servidor1_found = false;
	        boolean servidor2_found = false;
	        boolean servidor3_found = false;
	        boolean servidor4_found = false;
	        boolean servidor5_found = false;
	        
			for (Servidor servidor : servidorDB) {
				if (servidor.equals(servidor1)) {
					servidor1_found = true;
				} else if (servidor.equals(servidor2)) {
					servidor2_found = true;
				} else if (servidor.equals(servidor3)) {
					servidor3_found = true;
				} else if (servidor.equals(servidor4)) {
					servidor4_found = true;
				} else if (servidor.equals(servidor5)) {
					servidor5_found = true;
				}
			}
			assertTrue(!servidor1_found && servidor2_found&& servidor3_found&& servidor4_found&& servidor5_found);
		}
	    
}
