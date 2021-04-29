package com.decode.skapaBooking;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decode.objects.Pago;
import com.decode.objects.Usuario;

public class TestPago {

	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetCantidad() {
		Usuario usuarioA = new Usuario("Paco","paco@gmail.com","123");
		Usuario usuarioB = new Usuario("Lucia","lucia@gmail.com","323");
		Pago Pago1= new Pago(50,usuarioA,usuarioB);
		assertEquals(Pago1.getCantidad(),50,0);
		}

	@Test
	public void testGetUsuarioEmisor() {
		Usuario usuarioA = new Usuario("Paco","paco@gmail.com","123");
		Usuario usuarioB = new Usuario("Lucia","lucia@gmail.com","323");
		Pago Pago1= new Pago(50,usuarioA,usuarioB);
		assertEquals(Pago1.getUsuarioEmisor(),usuarioA);
		}

	@Test
	public void testGetUsuarioReceptor() {
		Usuario usuarioA = new Usuario("Paco","paco@gmail.com","123");
		Usuario usuarioB = new Usuario("Lucia","lucia@gmail.com","323");
		Pago Pago1= new Pago(50,usuarioA,usuarioB);
		assertEquals(Pago1.getUsuarioReceptor(),usuarioB);
		}
}
