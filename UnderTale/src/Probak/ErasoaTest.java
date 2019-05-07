package Probak;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packproiektua.Erasoa;

public class ErasoaTest {
	
	Erasoa era1,era2,era3,era4;

	@Before
	public void setUp() throws Exception {
		
		//String pIzena, int pMina, int pHutsa
		era1=new Erasoa("Nagetsukeru",20,10);
		era2=new Erasoa("Tsuki no hikari",17,5);
		era3=new Erasoa("-",20,4);
		era4=new Erasoa("Nagetsukeru",20,10);
	}

	@After
	public void tearDown() throws Exception {
		era1=null;
		era2=null;
		era3=null;
		era4=null;
	}

	@Test
	public void testErasoa() {
		assertNotNull(era1);
		assertNotNull(era2);
	}

	@Test
	public void testGetMina() {
		assertEquals(20,era1.getMina());
		assertEquals(17,era2.getMina());
	}

	@Test
	public void testGetIzena() {
		assertEquals("Nagetsukeru",era1.getIzena());
		assertEquals("Tsuki no hikari",era2.getIzena());
	}

	@Test
	public void testNuluaDa() {
		assertFalse(era1.nuluaDa());
		assertFalse(era2.nuluaDa());
		assertTrue(era3.nuluaDa());
	}

	@Test
	public void testMinEgin() {
		assertTrue(era1.minEgin()||era1.minEgin()||era1.minEgin()||era1.minEgin()||era1.minEgin()||era1.minEgin()||era1.minEgin()||era1.minEgin()||era1.minEgin()||era1.minEgin());
	}

	@Test
	public void testIzenBeraDu() {
		assertTrue(era1.izenBeraDu(era4));
		assertTrue(era4.izenBeraDu(era1));
		
		assertFalse(era2.izenBeraDu(era1));
		assertFalse(era1.izenBeraDu(era3));
		assertFalse(era3.izenBeraDu(era4));
	}
}
