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
import com.decode.objects.TarjetaCredito;
import com.decode.objects.Usuario;

public class TestReserva {
	
	Usuario user = new Usuario("tony", "tony.@gmail.com", "123");
	Calendar fechaEntrada = new GregorianCalendar(2021, 6, 24);
	Calendar fechaSalida = new GregorianCalendar(2021, 6, 31);
	Apartamento apar= new Apartamento(0, 0, null, null);
	TarjetaCredito t= new TarjetaCredito(0, 0, 0, 0);
	
	Reserva reserva = new Reserva(user.getId(),apar.getId(), null, fechaEntrada, fechaSalida, 6,t.getNumTarjeta());
	

		@Before
		public void setUp() throws Exception {
		}

		@After
		public void tearDown() throws Exception {
		}

		
		@Test
		public void testGetNumPersonas() {
			assertEquals(reserva.getNumPersonas(), 6);
			
		}
		
		
		
		@Test
		public void testGetIdReserva() {
			reserva.setId(0);
			assertEquals(reserva.getId(), 0);
		}
		
		@Test
		public void testGetFechaEntrada() {
			assertEquals(reserva.getFechaEntrada(), fechaEntrada);
			
		}
		
		@Test
		public void testFechaSalida() {
			assertEquals(reserva.getFechaSalida(), fechaSalida);
			
		}
		
		

}
