package com.decode.skapaBooking;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decode.objects.Apartamento;
import com.decode.objects.Localidad;

public class TestApartamento {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNumHabitaciones() {
		Localidad Triana= new Localidad("Andalucia", "Conil", 49503, "Avd maeda 3");
		Apartamento apartamento= new Apartamento(4, 100, Triana);
		assertEquals(apartamento.getNumHabitaciones(),4);	
		}

	@Test
	public void testGetMetrosCuad() {
		Localidad Triana= new Localidad("Andalucia", "Conil", 49503, "Avd maeda 3");
		Apartamento apartamento= new Apartamento(4, 100, Triana);
		assertEquals(apartamento.getMetrosCuad(),100);		}

	@Test
	public void testGetLocalidad() {
		Localidad Triana= new Localidad("Andalucia", "Conil", 49503, "Avd maeda 3");
		Apartamento apartamento= new Apartamento(4, 100, Triana);
		assertEquals(apartamento.getLocalidad(),Triana);		}

}
