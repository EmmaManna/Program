package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packproiektua.Npc;

public class NpcTest {
	
	Npc npc1,npc2,npc3,npc4;

	@Before
	public void setUp() throws Exception {
		
		//int pPS, int pErasoa, String pIzena, String pMota
		npc1= new Npc(100,20,"-","Furro");
		npc2= new Npc(200,50,"-","informatikoa");
		npc3= new Npc(314,10,"Irati","Influencer");
		npc4= new Npc(168,10,"Gondra","Influencer");
	}

	@After
	public void tearDown() throws Exception {
		npc1=null;
		npc2=null;
		npc3=null;
		npc4=null;
	}

	@Test
	public void testNpc() {
		assertNotNull(npc1);
		assertNotNull(npc2);
		assertNotNull(npc3);
		assertNotNull(npc4);
	}

	@Test
	public void testIzenBeraDu() {
		assertTrue(npc1.izenBeraDu(npc2));
		assertTrue(npc2.izenBeraDu(npc1));
		assertFalse(npc1.izenBeraDu(npc3));
		assertFalse(npc3.izenBeraDu(npc4));
		assertFalse(npc2.izenBeraDu(npc3));
	}

}
