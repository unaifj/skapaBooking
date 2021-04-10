package com.decode.skapaBooking;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.decode.skapaBooking.User;


public class TestUser {

	@Before
	public void setUp() throws Exception {
		System.out.println("Set Up @BeforeEach");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Tear Down @AfterEach");
	}

	@Test
	public void testGetCode() {
		User user=new User(01, "Carlos", "Fernandez");
		assertEquals(user.getCode(), 01);
		
	}

	@Test
	public void testGetName() {
		User user=new User(01, "Carlos", "Fernandez");
		assertEquals(user.getName(), "Carlos");	}

	@Test
	public void testGetSurname() {
		User user=new User(01, "Carlos", "Fernandez");
		assertEquals(user.getSurname(), "Fernandez");	}

}
