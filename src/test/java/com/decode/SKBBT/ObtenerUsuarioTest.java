package com.decode.SKBBT;

import static org.junit.Assert.assertEquals;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.decode.SKBB.Main;
import com.decode.categories.IntegrationTest;
import com.decode.objects.Usuario;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;


@Category(IntegrationTest.class)
public class ObtenerUsuarioTest {
	@Rule public ContiPerfRule rule = new ContiPerfRule();

    private HttpServer server;
    private WebTarget target;
    
    
    @Before
    public void setUp() throws Exception {
    
   
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }
        
        @Test
        @PerfTest(invocations = 3000, threads = 200)
        public void testGetIt() {
            String nombre = target.path("nombre").request().get(String.class);
            assertEquals("Nombre encontrado", nombre);
    }
}
