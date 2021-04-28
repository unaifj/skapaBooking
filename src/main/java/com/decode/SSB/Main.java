package com.decode.SSB;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

public class Main {
	
	public static final String BASE_URI = "https://localhost:8080/miaplicacion/";
	
	
	public static HttpServer iniciarServer() {
		final ResourceConfig rcg = new ResourceConfig().packages("SSB");
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),rcg);
	}
	public static void main(String[] args) throws IOException {
		final HttpServer servidor = iniciarServer();
		System.out.println("Jersey aplicacion inicializada, para finalizar pulsar enter");
		System.in.read();
		servidor.stop();
	}
}
