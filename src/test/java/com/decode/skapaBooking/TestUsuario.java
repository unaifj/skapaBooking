package com.decode.skapaBooking;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decode.objects.Usuario;

public class TestUsuario {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNomUsuario() {
		Usuario usuario=new Usuario("carlitos444", "carlitos@gmail.com","1234");
		assertEquals(usuario.getNomUsuario(),"carlitos444");	
		}

	@Test
	public void testGetCorreo() {
		Usuario usuario=new Usuario("carlitos444", "carlitos@gmail.com","1234");
		assertEquals(usuario.getCorreo(),"carlitos@gmail.com");	
		}

	@Test
	public void testGetContrasenya() {
		Usuario usuario=new Usuario("carlitos444", "carlitos@gmail.com","1234");
		assertEquals(usuario.getContrasenya(),"1234");	
		}

}
