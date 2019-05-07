package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packproiektua.Ondorio;

public class OndorioTest {
	
	Ondorio ond1,ond2,ond3,ond4;

	@Before
	public void setUp() throws Exception {
		
		//String pDeskribapen, int pPs, int pEraso, int pKarisma
		ond1= new Ondorio("Ondorio super mega ona",50,0,0);
		ond2= new Ondorio("Ondorio super mega txarra",0,-25,0);
		ond3= new Ondorio("Ondorio super mega normala",0,0,10);
		ond4= new Ondorio("Ondorio super mega azpergarria",0,0,0);
	}

	@After
	public void tearDown() throws Exception {
		ond1=null;
		ond2=null;
		ond3=null;
		ond4=null;
	}

	@Test
	public void testOndorio() {
		assertNotNull(ond1);
		assertNotNull(ond2);
		assertNotNull(ond3);
	}

	@Test
	public void testOndorioaEragin() {
		assertEquals(50,ond1.ondorioaEragin());
		assertEquals(-25,ond2.ondorioaEragin());
		assertEquals(10,ond3.ondorioaEragin());
		assertEquals(0,ond4.ondorioaEragin());
	}

	@Test
	public void testPs() {
		assertTrue(ond1.ps());
		
		assertFalse(ond2.ps());
		assertFalse(ond3.ps());
		assertFalse(ond4.ps());
	}

	@Test
	public void testKarisma() {
		assertTrue(ond3.karisma());
		
		assertFalse(ond1.karisma());
		assertFalse(ond2.karisma());
		assertFalse(ond4.karisma());
	}

	@Test
	public void testErasoa() {
		assertTrue(ond2.erasoa());
		
		assertFalse(ond1.erasoa());
		assertFalse(ond3.erasoa());
		assertFalse(ond4.erasoa());
	}
}
