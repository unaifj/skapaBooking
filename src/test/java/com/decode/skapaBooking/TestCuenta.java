package com.decode.skapaBooking;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decode.objects.Cuenta;
import com.decode.objects.Localidad;
import com.decode.objects.Usuario;



public class TestCuenta {

	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	@Test
	public void testGettipoDeCuenta() {
		
		Cuenta Cuenta1= new Cuenta("Cuenta Corriente",7363234567373324L, "Aitor", "07/23",645);
		assertEquals(Cuenta1.getTipoDeCuenta(),"Cuenta Corriente");
		}
	@Test
	public void testSettipoDeCuenta() {
		Cuenta Cuenta1= new Cuenta("Cuenta Corriente",7363234567373324L, "Aitor", "07/23",645);
		String tipoCuenta = "Cuenta Corriente";
		Cuenta1.setTipoDeCuenta(tipoCuenta);
	}

	@Test
	public void testGetcuentaBancaria() {
		Cuenta Cuenta1= new Cuenta("Cuenta Corriente",7363234567373324L, "Aitor", "07/23",645);
		assertEquals(Cuenta1.getCuentaBancaria(),7363234567373324L);
		}
	@Test
	public void testSetcuentaBancaria() {
		Cuenta Cuenta1= new Cuenta("Cuenta Corriente",7363234567373324L, "Aitor", "07/23",645);
		long cBan = 7363234567373324L;
		Cuenta1.setCuentaBancaria(cBan);
	}
	@Test
	public void testGetTitular() {
		Cuenta Cuenta1= new Cuenta("Cuenta Corriente",7363234567373324L, "Aitor", "07/23",645);
		assertEquals(Cuenta1.getTitular(),"Aitor");
		}
	@Test
	public void testSetTitular() {
		Cuenta Cuenta1= new Cuenta("Cuenta Corriente",7363234567373324L, "Aitor", "07/23",645);
		String titular = "Aitor";
		Cuenta1.setTitular(titular);
	}

	@Test
	public void testGetfechaCaducidad() {
		Cuenta Cuenta1= new Cuenta("Cuenta Corriente",7363234567373324L, "Aitor", "07/23",645);
		assertEquals(Cuenta1.getFechaCaducidad(),"07/23");
		}
	@Test
	public void testSetfechaCaducidad() {
		Cuenta Cuenta1= new Cuenta("Cuenta Corriente",7363234567373324L, "Aitor", "07/23",645);
		String fC = "07/23";
		Cuenta1.setFechaCaducidad(fC);
	}

	@Test
	public void testGetCVV() {
		Cuenta Cuenta1= new Cuenta("Cuenta Corriente",7363234567373324L, "Aitor", "07/23",645);
		assertEquals(Cuenta1.getCVV(),645);
		}
	@Test
	public void testSetCVV() {
		Cuenta Cuenta1= new Cuenta("Cuenta Corriente",7363234567373324L, "Aitor", "07/23",645);
		int tc = 645;
		Cuenta1.setCVV(tc);
	}
}
