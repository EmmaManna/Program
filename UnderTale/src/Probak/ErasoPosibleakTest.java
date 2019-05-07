package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packproiektua.ErasoPosibleak;
import packproiektua.Erasoa;
import packproiektua.ListanDago;

public class ErasoPosibleakTest {
	
	ErasoPosibleak eraposi1;
	
	Erasoa era1,era2;

	@Before
	public void setUp() throws Exception {
		eraposi1=ErasoPosibleak.getErasoPosibleak();
		
		era1=new Erasoa("Nagetsukeru",20,10);
		era2=new Erasoa("Tsuki no hikari",17,5);
	}

	@After
	public void tearDown() throws Exception {
		eraposi1=null;
		
		era1=null;
		era2=null;
	}

	@Test
	public void testGetErasoPosibleak() {
		eraposi1=ErasoPosibleak.getErasoPosibleak();
		assertNotNull(eraposi1);
	}

	@Test
	public void testGehituErasoa() throws ListanDago {
		//tamaina aurretik irakurtzen baitu eta ez dagoelako reset
		assertEquals(2,eraposi1.tamaina());
	}


	@Test
	public void testTamaina() throws ListanDago {
		eraposi1.gehituErasoa(era1);
		eraposi1.gehituErasoa(era2);
		assertEquals(2,eraposi1.tamaina());
	}

	@Test
	public void testAukeratuErasoa() throws ListanDago {
		//tamaina aurretik irakurtzen baitu eta ez dagoelako reset
		assertEquals(era1.getIzena(),eraposi1.aukeratuErasoa(0).getIzena());
	}

}
