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
		Usuario usuario =new Usuario("carlitos444", "carlitos@gmail.com","1234");
		assertEquals(usuario.getNomUsuario(),"carlitos444");	
		}

	@Test
	public void testSetNomUsuario() {
		Usuario usuario =new Usuario("carlitos444", "carlitos@gmail.com","1234");
		String nomUsuario = "carlitos444";
		usuario.setNomUsuario(nomUsuario);
	}

	@Test
	public void testGetCorreo() {
		Usuario usuario=new Usuario("carlitos444", "carlitos@gmail.com","1234");
		assertEquals(usuario.getCorreo(),"carlitos@gmail.com");	
		}

	@Test
	public void testSetCorreo() {
		Usuario usuario =new Usuario("carlitos444", "carlitos@gmail.com","1234");
		String correo = "carlitos@gmail.com";
		usuario.setCorreo(correo);
	}
	@Test
	public void testGetContrasenya() {
		Usuario usuario=new Usuario("carlitos444", "carlitos@gmail.com","1234");
		assertEquals(usuario.getContrasenya(),"1234");	
		}

	@Test
	public void testSetContrasenya() {
		Usuario usuario=new Usuario("carlitos444", "carlitos@gmail.com","1234");
		String contrasenya = "1234";
		usuario.setContrasenya(contrasenya);
	}
}
