package com.decode.skapaBooking;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decode.objects.Opinion;

public class TestOpinion {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetidUsuario() {
		Opinion opinion = new Opinion(1, "Gran casa", "Muy buena casa para familias con hijos", 8.5f);
		assertEquals(opinion.getIdUsuario(), 1);
		
	}
	
	@Test
	public void testGetTitulo() {
		Opinion opinion = new Opinion(1, "Gran casa", "Muy buena casa para familias con hijos", 8.5f);
		assertEquals(opinion.getTitulo(), "Gran casa");
	}
	
	@Test
	public void testGetDescripcion() {
		Opinion opinion = new Opinion(1, "Gran casa", "Muy buena casa para familias con hijos", 8.5f);
		assertEquals(opinion.getDescripcion(), "Muy buena casa para familias con hijos");
	}
	
	@Test
	public void testGetPuntuacion() {
		Opinion opinion = new Opinion(1, "Gran casa", "Muy buena casa para familias con hijos", 8.5f);
		assertEquals(opinion.getPuntuacion(), 8.5f, 0);
	}
	

}
