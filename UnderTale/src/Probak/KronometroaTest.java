package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packproiektua.Kronometroa;

public class KronometroaTest {
	Kronometroa krono;

	@Before
	public void setUp() throws Exception {
		krono=Kronometroa.getKronometroa();
	}

	@After
	public void tearDown() throws Exception {
		krono=null;
	}

	@Test
	public void testGetKronometroa() {
		assertNotNull(krono);
	}

	@Test
	public void testZeroanJarri() {
		krono.zeroanJarri();
		assertTrue(0<=krono.hasierakoDenb());
	}

	@Test
	public void testPasaDirenSegunduakLortu() {
		int denbora;
		krono.zeroanJarri();
		denbora=krono.pasaDirenSegunduakLortu();
		assertTrue(0<=denbora);
	}

}
