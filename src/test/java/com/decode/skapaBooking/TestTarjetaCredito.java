package com.decode.skapaBooking;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decode.objects.TarjetaCredito;
import com.decode.objects.Usuario;

public class TestTarjetaCredito {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNumTarjeta() {
		Usuario usuario=new Usuario("carlitos444", "carlitos@gmail.com","1234");
		TarjetaCredito t= new TarjetaCredito(usuario.getId(),5426,1509,778);
		assertEquals(t.getNumTarjeta(),5426);	
		}

	@Test
	public void testGetFecha() {
		Usuario usuario=new Usuario("carlitos444", "carlitos@gmail.com","1234");
		TarjetaCredito t= new TarjetaCredito(usuario.getId(),5426,1509,778);
		assertEquals(t.getFecha(),1509);	
		}

	@Test
	public void testGetCvv() {
		Usuario usuario=new Usuario("carlitos444", "carlitos@gmail.com","1234");
		TarjetaCredito t= new TarjetaCredito(usuario.getId(),5426,1509,778);
		assertEquals(t.getCvv(),778);	
		}
	
	

}
