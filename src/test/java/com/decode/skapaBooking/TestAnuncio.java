package com.decode.skapaBooking;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decode.objects.Anuncio;
import com.decode.objects.Apartamento;
import com.decode.objects.Localidad;

public class TestAnuncio {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetApartamento() {
		
		Localidad Triana= new Localidad("Andalucia", "Conil", 49503, "Avd maeda 3");
		Apartamento apartamento= new Apartamento(4, 100, Triana);
		Anuncio anuncio=new Anuncio(apartamento, "Titulo anuncio", "Descripcion anuncio", 50, true,6);
		assertEquals(anuncio.getApartamento(),apartamento);
		}

	@Test
	public void testGetTitulo() {
		Localidad Triana= new Localidad("Andalucia", "Conil", 49503, "Avd maeda 3");
		Apartamento apartamento= new Apartamento(4, 100, Triana);
		Anuncio anuncio=new Anuncio(apartamento, "Titulo anuncio", "Descripcion anuncio", 50, true,6);
		assertEquals(anuncio.getTitulo(),"Titulo anuncio");	}

	@Test
	public void testGetDescripcion() {
		Localidad Triana= new Localidad("Andalucia", "Conil", 49503, "Avd maeda 3");
		Apartamento apartamento= new Apartamento(4, 100, Triana);
		Anuncio anuncio=new Anuncio(apartamento, "Titulo anuncio", "Descripcion anuncio", 50, true,6);
		assertEquals(anuncio.getDescripcion(),"Descripcion anuncio");	}

	

	@Test
	public void testGetNumPersonas() {
		Localidad Triana= new Localidad("Andalucia", "Conil", 49503, "Avd maeda 3");
		Apartamento apartamento= new Apartamento(4, 100, Triana);
		Anuncio anuncio=new Anuncio(apartamento, "Titulo anuncio", "Descripcion anuncio", 50, true,6);
		assertEquals(anuncio.getNumPersonas(),6);	}

}
