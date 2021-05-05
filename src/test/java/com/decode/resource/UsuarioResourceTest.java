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

import com.decode.bd.DBManager;
import com.decode.categories.IntegrationTest;
import com.decode.main.Main;
import com.decode.objects.Usuario;
import com.decode.rsh.UsuarioRSH;


@Category(IntegrationTest.class)
public class UsuarioResourceTest {
	
    private static HttpServer server;
    private static UsuarioRSH rsh;
    
    private static Usuario usuario1;
    private static Usuario usuario2;
    private static Usuario usuario3;
    private static Usuario usuario4;
    private static Usuario usuario5;
    private static Usuario usuario6;
    private List<Usuario> usuariosBD;

    public UsuarioResourceTest() {
    }
    
    @BeforeClass
    public static void setUp() {
    	// start the server
    	
    	
    	server = Main.startServer();
        rsh = UsuarioRSH.getInstance();
       
        DBManager dbm = new DBManager();
    	dbm.deleteUsuarios();
    	
        usuario1 = new Usuario("Juan", "Lopez", "1234");
        usuario2 = new Usuario("Silvia", "Montejo", "1234");
        usuario3 = new Usuario("Luis", "Alonso", "1234");
        usuario4 = new Usuario("Silvia", "Montejo", "1234");
        usuario5 = new Usuario("Luis", "Alonso", "1234");
        usuario6 = new Usuario("Jorge", "Casas", "1234");
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
        rsh.guardarUsuario(usuario1);
        rsh.guardarUsuario(usuario2);
        rsh.guardarUsuario(usuario3);
        rsh.guardarUsuario(usuario4);
        rsh.guardarUsuario(usuario5);
        
    }
    
    @After
    public void Clean() {
        System.out.println(
                "================================================Cleaning data ...================================================");
        usuariosBD = rsh.verUsuarios();
        for (Usuario cl : usuariosBD) {
            rsh.borrarUsuario(cl);
        }
    }
    

	@Test
	public void testVerUsuarios() {
        System.out.println(
                "================================================Test ver usuarios================================================");
        
        usuariosBD = rsh.verUsuarios();
        assertEquals(usuariosBD.size(), 5);
        
        boolean usuario1_found = false;
        boolean usuario2_found = false;
        boolean usuario3_found = false;
        boolean usuario4_found = false;
        boolean usuario5_found = false;
        
		for (Usuario usuario : usuariosBD) {
			if (usuario.equals(usuario1)) {
				usuario1_found = true;
			} else if (usuario.equals(usuario2)) {
				usuario2_found = true;
			} else if (usuario.equals(usuario3)) {
				usuario3_found = true;
			} else if (usuario.equals(usuario4)) {
				usuario4_found = true;
			} else if (usuario.equals(usuario5)) {
				usuario5_found = true;
			}
		}
		assertTrue(usuario1_found && usuario2_found&& usuario3_found&& usuario4_found&& usuario5_found);
	}
	
	@Test
	public void testSubirUsuarios() {
        System.out.println(
                "================================================Test subir usuarios================================================");
        rsh.guardarUsuario(usuario6);
        usuariosBD = rsh.verUsuarios();
        assertEquals(usuariosBD.size(), 6);
        
        boolean usuario6_found = false;
        
        for (Usuario usuario : usuariosBD) {
			if(usuario.equals(usuario6)) {
				usuario6_found = true;
			}
		}
        assertTrue(usuario6_found);
        
	}
	
	@Test
    public void testEliminarUsuario() {
        System.out.println(
                "================================================Test eliminar usuarios================================================");
        rsh.borrarUsuario(usuario1);
        usuariosBD = rsh.verUsuarios();
        assertEquals(usuariosBD.size(), 4);
		
        boolean usuario1_found = false;
        boolean usuario2_found = false;
        boolean usuario3_found = false;
        boolean usuario4_found = false;
        boolean usuario5_found = false;
        
		for (Usuario usuario : usuariosBD) {
			if (usuario.equals(usuario1)) {
				usuario1_found = true;
			} else if (usuario.equals(usuario2)) {
				usuario2_found = true;
			} else if (usuario.equals(usuario3)) {
				usuario3_found = true;
			} else if (usuario.equals(usuario4)) {
				usuario4_found = true;
			} else if (usuario.equals(usuario5)) {
				usuario5_found = true;
			}
		}
		assertTrue(!usuario1_found && usuario2_found&& usuario3_found&& usuario4_found&& usuario5_found);
	}

}
