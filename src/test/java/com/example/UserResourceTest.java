package com.example;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.decode.categories.IntegrationTest;
import com.decode.objects.Usuario;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import java.util.List;


@Category(IntegrationTest.class)
public class UserResourceTest {
	
	Usuario u = new Usuario("Mikel","mk@gmail.com","123");
	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
	private HttpServer server;
    private WebTarget appTarget;
    private Client c;
    
    @Before
    public void setUp() throws Exception {
    	
    	server = Main.startServer();
    	
        Client c = ClientBuilder.newClient();

        appTarget = c.target(Main.BASE_URI);
    }
    @After
    public void tearDown() throws Exception {
        server.stop();
    }
    
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testListarUsuarios() {
    	
		Usuario u1 = new  Usuario("Txomin", "t@gmail.com", "344");
    	
    	WebTarget usuarioTarget = appTarget.path("usuario");
    	WebTarget listaUsuariosTarget = usuarioTarget.path("listarUsuarios");
    	
    	List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    	listaUsuarios.add(u);
    	listaUsuarios.add(u1);
    			   			
    	GenericType<List<Usuario>> genericType = new GenericType<List<Usuario>>() {};
    	List<Usuario> usuarios = listaUsuariosTarget.request(MediaType.APPLICATION_JSON).get(genericType);
    	
        assertEquals(listaUsuarios.get(0).getNomUsuario(), usuarios.get(0).getNomUsuario());
        assertEquals(listaUsuarios.get(1).getNomUsuario(), usuarios.get(1).getNomUsuario());
    }
    @Test
    @PerfTest(invocations = 1000, threads = 40)
    public void testEncontrarUsuarios() {
    	
		Usuario u1 = new  Usuario("Txomin", "t@gmail.com", "344");
    	
    	WebTarget usuarioTarget = appTarget.path("usuario");
    	WebTarget encontrarUsuarioTarget = usuarioTarget.path("encontrarUsuario").queryParam("Txomin", "t@gmail.com");
    	
    	GenericType<Usuario> genericType = new GenericType<Usuario>() {};
    	Usuario usuario = encontrarUsuarioTarget.request(MediaType.APPLICATION_JSON).get(genericType);   	
    	
        assertEquals(u1.getNomUsuario(), usuario.getNomUsuario());
    	
   
    }
    
}
