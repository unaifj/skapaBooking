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
import com.decode.objects.Anuncio;
import com.decode.objects.Apartamento;
import com.decode.objects.Localidad;
import com.decode.objects.Usuario;
import com.decode.rsh.AnuncioRSH;







@Category(IntegrationTest.class)
public class AnuncioResourceTest {
	
    private static HttpServer server;
    private static AnuncioRSH rsh;
    
    private static Usuario usuario1;
    private static Usuario usuario2;
    private static Usuario usuario3;
    private static Usuario usuario4;
    private static Usuario usuario5;
    
    private static Localidad localidad1;
    private static Localidad localidad2;
    private static Localidad localidad3;
    private static Localidad localidad4;
    private static Localidad localidad5;

    private static Apartamento apartamento1;
    private static Apartamento apartamento2;
    private static Apartamento apartamento3;
    private static Apartamento apartamento4;
    private static Apartamento apartamento5;
    
    private static Anuncio anuncio1;
    private static Anuncio anuncio2;
    private static Anuncio anuncio3;
    private static Anuncio anuncio4;
    private static Anuncio anuncio5;
    private static Anuncio anuncio6;

    private List<Anuncio> anunciosBD;

    public AnuncioResourceTest() {
    }
    
    @BeforeClass
    public static void setUp() {
    	// arrancar servidor
    	server = Main.startServer();
        rsh = AnuncioRSH.getInstance();
       
        usuario1 = new Usuario("Juan", "Lopez", "1234");
        usuario2 = new Usuario("Silvia", "Montejo", "1234");
        usuario3 = new Usuario("Luis", "Alonso", "1234");
        usuario4 = new Usuario("Silvia", "Montejo", "1234");
        usuario5 = new Usuario("Luis", "Alonso", "1234");
        
        localidad1= new Localidad("Vizcaya", "Barakaldo", 58600, "Avd Mazarredo");
        localidad2= new Localidad("Madrid", "Bianco", 76600, "Avd Minero");
        localidad3= new Localidad("Canatabria", "Noja", 59600, "Avd Areilza");
        localidad4= new Localidad("Andalucia", "Conil", 58670, "Avd El Cerro");
        localidad5= new Localidad("Vizcaya", "Algorta", 48600, "Avd Los pitufos");
        
        apartamento1= new Apartamento(5,100,localidad1,null);
        apartamento2= new Apartamento(3,80,localidad2,null);
        apartamento3= new Apartamento(2,300,localidad3,null);
        apartamento4= new Apartamento(1,43,localidad4,null);
        apartamento5= new Apartamento(4,95,localidad5,null);

        String ruta = "/ruta";
       
        anuncio1=new Anuncio(usuario1,apartamento1,"Anuncio del titulo 1","descripcion del primer anuncio",57.00,true,4, ruta);
        anuncio2=new Anuncio(usuario2,apartamento2,"Anuncio del titulo 2","descripcion del segundo anuncio",32.00,false,5, ruta );
        anuncio3=new Anuncio(usuario3,apartamento3,"Anuncio del titulo 3","descripcion del tercer anuncio",70.00,true,3, ruta );
        anuncio4=new Anuncio(usuario4,apartamento4,"Anuncio del titulo 4","descripcion del cuarto anuncio",17.00,false,4, ruta );
        anuncio5=new Anuncio(usuario5,apartamento5,"Anuncio del titulo 5","descripcion del quinto anuncio",5.00,true,4, ruta );
        anuncio6= new Anuncio(usuario1,apartamento2,"Anuncio del titulo 6","descripcion del sexto anuncio",5.00,true,4, ruta);
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
        rsh.guardarAnuncio(anuncio1);
        rsh.guardarAnuncio(anuncio2);
        rsh.guardarAnuncio(anuncio3);
        rsh.guardarAnuncio(anuncio4);
        rsh.guardarAnuncio(anuncio5);
        
    }
    
    @After
    public void Clean() {
        System.out.println(
                "================================================Cleaning data ...================================================");
        anunciosBD = rsh.verAnuncios();
        for (Anuncio a : anunciosBD) {
            rsh.borrarAnuncio(a);
        }
    }
    

	@Test
	public void testVerAnuncios() {
        System.out.println(
                "================================================Test ver usuarios================================================");
        
        anunciosBD = rsh.verAnuncios();
        assertEquals(anunciosBD.size(), 8);
        
        boolean anuncio1_found = false;
        boolean anuncio2_found = false;
        boolean anuncio3_found = false;
        boolean anuncio4_found = false;
        boolean anuncio5_found = false;
        
		for (Anuncio anuncio : anunciosBD) {
			if (anuncio.equals(anuncio1)) {
				anuncio1_found = true;
			} else if (anuncio.equals(anuncio2)) {
				anuncio2_found = true;
			} else if (anuncio.equals(anuncio3)) {
				anuncio3_found = true;
			} else if (anuncio.equals(anuncio4)) {
				anuncio4_found = true;
			} else if (anuncio.equals(anuncio5)) {
				anuncio5_found = true;
			}
		}
		assertTrue(anuncio1_found && anuncio2_found&& anuncio3_found&& anuncio4_found&& anuncio5_found);
	}
	
	@Test
	public void testInsertarAnuncios() {
        System.out.println(
                "================================================Test insertar anuncios================================================");
        rsh.guardarAnuncio(anuncio6);
        anunciosBD = rsh.verAnuncios();
        assertEquals(anunciosBD.size(), 14);
        
        boolean anuncio6_found = false;
        
        for (Anuncio anuncio : anunciosBD) {
			if(anuncio.equals(anuncio6)) {
				anuncio6_found = true;
			}
		}
        assertTrue(anuncio6_found);
        
	}
	
	@Test
    public void testEliminarAnuncio() {
        System.out.println(
                "================================================Test eliminar anuncios================================================");
        rsh.borrarAnuncio(anuncio1);
        anunciosBD = rsh.verAnuncios();
        assertEquals(anunciosBD.size(), 19);
		
        boolean anuncio1_found = false;
        boolean anuncio2_found = false;
        boolean anuncio3_found = false;
        boolean anuncio4_found = false;
        boolean anuncio5_found = false;
        
		for (Anuncio anuncio : anunciosBD) {
			if (anuncio.equals(anuncio1)) {
				anuncio1_found = true;
			} else if (anuncio.equals(anuncio2)) {
				anuncio2_found = true;
			} else if (anuncio.equals(anuncio3)) {
				anuncio3_found = true;
			} else if (anuncio.equals(anuncio4)) {
				anuncio4_found = true;
			} else if (anuncio.equals(anuncio5)) {
				anuncio5_found = true;
			}
		}
		assertTrue(!anuncio1_found && anuncio2_found&& anuncio3_found&& anuncio4_found&& anuncio5_found);
	}

}

