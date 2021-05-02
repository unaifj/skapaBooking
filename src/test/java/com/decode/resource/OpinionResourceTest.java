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
import com.decode.objects.Opinion;
import com.decode.objects.Usuario;
import com.decode.rsh.OpinionRSH;


@Category(IntegrationTest.class)
public class OpinionResourceTest {
	
	private static HttpServer server;
	private static OpinionRSH rsh;
	
	
	private static Opinion opinion1;
	private static Opinion opinion2;
	private static Opinion opinion3;
    private static Opinion opinion4;
    private static Opinion opinion5;
    private List<Opinion> opinionBD;
    
    public OpinionResourceTest() {
    }
    
    @BeforeClass
    public static void setUp() {
    	//arranca el servidor
    	server = Main.startServer();
    	rsh = OpinionRSH.getInstance();
    	//Visualizamos todas las opiniones de un solo usuario
    	Usuario usuario = new Usuario("Juan", "Lopez", "1234");
    	opinion1 = new Opinion(usuario, "Buena casa", "Muy buena casa para estar en familia", 7.5f);
    	opinion2 = new Opinion(usuario, "Gran casa", "Muy buena casa acogedora y bien localizada", 9f);
    	opinion3 = new Opinion(usuario, "Mala experiencia", "Casa en malas condiciones", 1.5f);
    	opinion4 = new Opinion(usuario, "Buena opcion para pasar dias tranquilos", "Casa muy agradable para estar en familia ", 7f);
    	opinion5 = new Opinion(usuario, "Casa en muy mal estado", "La casa estaba en mal estado ", 0f);

    }

    @AfterClass
    public static void tearDown() throws Exception{
    	server.shutdownNow();
 
    }
    
    @Before
    public void PrepareData() {
    	// Store test
        System.out.println(
                "================================================Creating data ...================================================");
        rsh.guardarOpinion(opinion1);
        rsh.guardarOpinion(opinion2);
        rsh.guardarOpinion(opinion3);
        rsh.guardarOpinion(opinion4);
    
    }
    
    @After
    public void Clean() {
        System.out.println(
                "================================================Cleaning data ...================================================");
        
        opinionBD = rsh.verOpiniones();
        for(Opinion op :opinionBD ) {
        	rsh.borrarOpinion(op);
        }
    
    }
    
    @Test
	public void testVerOpinion() {
        System.out.println(
                "================================================Test ver opiniones================================================");
        opinionBD = rsh.verOpiniones();
        assertEquals(opinionBD.size(), 4);
        
        boolean opinion1_found = false;
        boolean opinion2_found = false;
        boolean opinion3_found = false;
        boolean opinion4_found = false;
       
        for(Opinion opinion : opinionBD) {
        	if(opinion.equals(opinion1)) {
        		opinion1_found = true;
        	}else if(opinion.equals(opinion2)) {
        		opinion2_found = true;
        	}else if(opinion.equals(opinion3)) {
        		opinion3_found = true;
        	}else if(opinion.equals(opinion4)) {
        		opinion4_found = true;
        	}
        }
    assertTrue(opinion1_found && opinion2_found&& opinion3_found&& opinion4_found);
    }
    
    @Test
    public void testSubirOpiniones() {
    	System.out.println(
                "================================================Test subir opiniones================================================");
    	rsh.guardarOpinion(opinion5);
    	opinionBD = rsh.verOpiniones();
    	assertEquals(opinionBD.size(), 5);
    	
    	boolean opinion5_found = false;
    	
    	for(Opinion opinion : opinionBD) {
    		if(opinion.equals(opinion5)) {
    			opinion5_found = true;
    		}
    	}
    	
    	assertTrue(opinion5_found);
    }
    
    @Test
    public void testEliminarOpinion() {
    	System.out.println(
                "================================================Test eliminar opiniones================================================");
    	rsh.borrarOpinion(opinion1);
    	opinionBD = rsh.verOpiniones();
    	assertEquals(opinionBD.size(), 3);
    	
    	boolean opinion1_found = false;
        boolean opinion2_found = false;
        boolean opinion3_found = false;
        boolean opinion4_found = false;
        
        for(Opinion opinion : opinionBD) {
        	if(opinion.equals(opinion1)) {
        		opinion1_found = true;
        	}else if(opinion.equals(opinion2)) {
        		opinion2_found = true;
        	}else if(opinion.equals(opinion3)) {
        		opinion3_found = true;
        	}else if(opinion.equals(opinion4)) {
        		opinion4_found = true;
        	}
        }
    assertTrue(opinion1_found && opinion2_found&& opinion3_found&& opinion4_found);
    }
    	
    
}
