package com.decode.skapaBooking;



import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.decode.objects.Servidor;
import com.decode.objects.Usuario;


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
	public void testSetId() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		int id = 0;
		s1.setId(id);
	}
	@Test
	public void testgetNomServidor() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		assertEquals(s1.getNomServidor(),"s1");
	}
	@Test
	public void testSetNomServidor() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		String nomServidor = "s1";
		s1.setNomServidor(nomServidor);
	}
	@Test
	public void testgetCorreoS() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		assertEquals(s1.getCorreoS(),"s1@gmail.com");
	}
	@Test
	public void testSetCorreoS() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		String correo = "s1@gmail.com";
		s1.setCorreoS(correo);
	}
	
	@Test
	public void testgetContrasenyaS() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		assertEquals(s1.getContrasenyaS(),"7645");
	}
	@Test
	public void testSetContrasenyaS() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		String contra = "7645";
		s1.setContrasenyaS(contra);
	}

	@Test
	public void testgetPuerto() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		assertEquals(s1.getPuerto(),8080);
	}
	@Test
	public void testSetPuerto() {
		Servidor s1 = new Servidor(0, "s1", "s1@gmail.com", "7645", 8080);
		int puerto = 8080;
		s1.setPuerto(puerto);
	}

}
