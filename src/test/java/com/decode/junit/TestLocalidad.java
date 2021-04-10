package com.decode.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decode.objects.Localidad;

public class TestLocalidad {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetProvincia() {
		Localidad Triana= new Localidad("Andalucia", "Conil", 49503, "Avd maeda 3");
		assertEquals(Triana.getProvincia(),"Andalucia");
		}

	@Test
	public void testGetMunicipio() {
		Localidad Triana= new Localidad("Andalucia", "Conil", 49503, "Avd maeda 3");
		assertEquals(Triana.getMunicipio(),"Conil");	}

	@Test
	public void testGetCp() {
		Localidad Triana= new Localidad("Andalucia", "Conil", 49503, "Avd maeda 3");
		assertEquals(Triana.getCp(),49503);	}

	@Test
	public void testGetDireccion() {
		Localidad Triana= new Localidad("Andalucia", "Conil", 49503, "Avd maeda 3");
		assertEquals(Triana.getDireccion(),"Avd maeda 3");	
		}

}
