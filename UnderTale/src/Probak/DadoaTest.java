package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packproiektua.Dadoa;

public class DadoaTest {
	Dadoa d1;

	@Before
	public void setUp() throws Exception {
		d1=Dadoa.getDadoa();
	}

	@After
	public void tearDown() throws Exception {
		d1=null;
	}

	@Test
	public void testGetDadoa() {
		Dadoa e=null;
		assertNull(e);
		e=Dadoa.getDadoa();
		assertNotNull(e);

	}

	@Test
	public void testGetGoikoAldea() {
		int zbk;
		d1.bota();
		zbk=d1.getGoikoAldea();
		assertTrue(zbk<=10);
		d1.bota();
		zbk=d1.getGoikoAldea();
		assertTrue(zbk<=10);
		d1.bota();
		zbk=d1.getGoikoAldea();
		assertTrue(zbk<=10);
		d1.bota();
		zbk=d1.getGoikoAldea();
		assertTrue(zbk<=10);
	}

	@Test
	public void testGetAldeKopurua() {
		assertEquals(10,d1.getAldeKopurua());
	}

	@Test
	public void testBota() {
		assertEquals(0,d1.getGoikoAldea()); //0 da dadoa bota gabe 0 delako eta ez null
		d1.bota();
		assertNotNull(d1.getGoikoAldea());

	}

	@Test
	public void testDadoarenLetra() { 
		String letra=" "; 
		letra=d1.dadoarenLetra();
		assertTrue(letra.equals("g")||letra.equals("a")||letra.equals("w")||letra.equals("e")||letra.equals("f")||letra.equals("h")||letra.equals("b")||letra.equals("v")||letra.equals("q")||letra.equals("z")||letra.equals("k"));
				
				//||"a",letra||"w",letra||"e",letra||"f"||"h"||"b"||"v"||"q"||"z"||"k",letra);
	}

}
