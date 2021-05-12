package com.decode.main;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.decode.sesion.VentanaInicio;
import com.decode.ventanaPrincipal.VentanaPrincipal;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
     * application.
     * 
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example package
        final ResourceConfig rc = new ResourceConfig().packages(true, "com", "com.atenea", "com.atenea.resource");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Lanzar la ventana si se ejecuta desde el jar normal
        // Lanzar el servidor si se ejecuta desde la consola

        if (args.length == 1 && args[0].equals("--server")) {
            // Para ejecturar el servidor " mvn exec:java -Dexec.args="--server" "
            // En power shell es " mvn exec:java "-Dexec.args='--server'" "
            // Si args esta vacio lanzamos el servidor

            final HttpServer server = startServer();
            System.out.println(String.format(
                    "Jersey app started with WADL available at " + "%sapplication.wadl\n Hit enter to stop it...",
                    BASE_URI));
            System.in.read();
            server.shutdownNow();
        } else {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                       	new VentanaPrincipal("ES").setVisible(true);
                    } catch (Exception e) {
                    }
                }
            });
        }
    }
}
