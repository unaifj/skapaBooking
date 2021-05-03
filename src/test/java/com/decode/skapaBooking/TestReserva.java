package com.decode.skapaBooking;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decode.objects.Anuncio;
import com.decode.objects.Apartamento;
import com.decode.objects.Localidad;
import com.decode.objects.Reserva;
import com.decode.objects.Usuario;

public class TestReserva {
	
	//public class TestAnuncio {

		@Before
		public void setUp() throws Exception {
		}

		@After
		public void tearDown() throws Exception {
		}

		@Test
		public void testGetUsuario() {
			Usuario user = new Usuario("tony", "tony.@gmail.com", "123");
			Calendar fechaEntrada = new GregorianCalendar(2021, 6, 24);
			Calendar fechaSalida = new GregorianCalendar(2021, 6, 31);
			Reserva reserva = new Reserva(user, null, fechaEntrada, fechaSalida, 6);
			assertEquals(reserva.getUsuario(), user);	
		}
		
		@Test
		public void testGetNumPersonas() {
			Usuario user = new Usuario("tony", "tony.@gmail.com", "123");
			Calendar fechaEntrada = new GregorianCalendar(2021, 6, 24);
			Calendar fechaSalida = new GregorianCalendar(2021, 6, 31);
			Reserva reserva = new Reserva(user, null, fechaEntrada, fechaSalida, 6);
			assertEquals(reserva.getNumPersonas(), 6);
			
		}
		
		
	//}

}
