package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packproiektua.TeklaOkerra;
import packproiektua.Teklatua;

public class TeklatuaTest {
	Teklatua te1;

	@Before
	public void setUp() throws Exception {
		te1= Teklatua.getTeklatua();
	}

	@After
	public void tearDown() throws Exception {
		te1=null;
	}

	@Test
	public void testGetTeklatua() {
		assertNotNull(te1);
	}

	@Test
	public void testIrakurriString() {
		te1.irakurriString("hello world");
		te1.irakurriString("Osatu esaldia: Arriba...");

	}

	@Test
	public void testIrakurriInt()throws NumberFormatException, TeklaOkerra  {
		te1.irakurriInt("Sartu zenbaki bat", 1, 5);
		te1.irakurriInt("Sartu zenbaki bat", 10, 11);

	}

}
