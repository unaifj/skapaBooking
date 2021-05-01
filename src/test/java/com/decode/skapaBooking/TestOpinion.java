package com.decode.skapaBooking;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decode.objects.Opinion;
import com.decode.objects.Usuario;

public class TestOpinion {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetidUsuario() {
		Usuario user = new Usuario("Micho", "Misga@opendesuto.es", "micho123");
		Opinion opinion = new Opinion(user, "Gran casa", "Muy buena casa para familias con hijos", 8.5f);
		assertEquals(opinion.getUsuario().getId(), 1);
		
	}
	
	@Test
	public void testGetTitulo() {
		Usuario user = new Usuario("Micho", "Misga@opendesuto.es", "micho123");
		Opinion opinion = new Opinion(user, "Gran casa", "Muy buena casa para familias con hijos", 8.5f);
		assertEquals(opinion.getTitulo(), "Gran casa");
	}
	
	@Test
	public void testGetDescripcion() {
		Usuario user = new Usuario("Micho", "Misga@opendesuto.es", "micho123");
		Opinion opinion = new Opinion(user, "Gran casa", "Muy buena casa para familias con hijos", 8.5f);
		assertEquals(opinion.getDescripcion(), "Muy buena casa para familias con hijos");
	}
	
	@Test
	public void testGetPuntuacion() {
		Usuario user = new Usuario("Micho", "Misga@opendesuto.es", "micho123");
		Opinion opinion = new Opinion(user, "Gran casa", "Muy buena casa para familias con hijos", 8.5f);
		assertEquals(opinion.getPuntuacion(), 8.5f, 0);
	}
	

}
