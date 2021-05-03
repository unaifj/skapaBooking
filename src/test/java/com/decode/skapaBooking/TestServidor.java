package com.decode.skapaBooking;



import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.decode.objects.Servidor;


public class TestServidor {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetId() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		assertEquals(s1.getId(),0);
	}
	@Test
	public void testgetNomServidor() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		assertEquals(s1.getNomServidor(),"s1");
	}
	@Test
	public void testgetCorreoS() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		assertEquals(s1.getCorreoS(),"s1@gmail.com");
	}
	
	@Test
	public void testgetContrasenyaS() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		assertEquals(s1.getContrasenyaS(),"7645");
	}
	@Test
	public void testgetPuerto() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		assertEquals(s1.getPuerto(),8080);
	}
}
