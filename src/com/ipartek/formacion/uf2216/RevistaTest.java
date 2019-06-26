package com.ipartek.formacion.uf2216;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RevistaTest {
	Revista r;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		r = new Revista();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetTitulo() throws RevistaException {
		r.setTitulo("qwe");
		assertEquals("qwe", r.getTitulo());

		try {
			r.setTitulo("rd");
			fail("Deberia de lanzar la excepcion RevistaException");
		} catch (RevistaException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testSetIsbn() throws RevistaException {
		r.setIsbn("1234567890");
		assertEquals("1234567890", r.getIsbn());

		try {
			r.setIsbn("123456789");
			fail("Deberia de lanzar la excepcion RevistaException");
		} catch (RevistaException e) {
			assertTrue(true);
		}
		
		try {
			r.setIsbn("12345678901");
			fail("Deberia de lanzar la excepcion RevistaException");
		} catch (RevistaException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testSetnPaginas() throws RevistaException {
		r.setnPaginas(1);
		assertEquals(1, r.getnPaginas());

		try {
			r.setnPaginas(0);
			fail("Deberia de lanzar la excepcion RevistaException");
		} catch (RevistaException e) {
			assertTrue(true);
		}
		
		try {
			r.setnPaginas(-5);
			fail("Deberia de lanzar la excepcion RevistaException");
		} catch (RevistaException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testSetFormato() throws RevistaException {
		r.setFormato('d');
		assertTrue(r.isFormato());

		r.setFormato('p');
		assertFalse(r.isFormato());

		try {
			r.setFormato('h');
			fail("Deberia de lanzar la excepcion RevistaException");
		} catch (RevistaException e) {
			assertTrue(true);
		}
	}
}