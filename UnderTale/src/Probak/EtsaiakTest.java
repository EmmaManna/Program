package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packproiektua.ElementuGehiegi;
import packproiektua.Erasoa;
import packproiektua.Etsaiak;
import packproiektua.Hitza;
import packproiektua.Jokalaria;
import packproiektua.ListanDago;
import packproiektua.Ondorio;

public class EtsaiakTest {
	Etsaiak ets1,ets2;
	Erasoa era1,era2;
	Hitza hitz1,hitz2,hitz3,hitz4;
	Ondorio ond1,ond2,ond3;


	@Before
	public void setUp() throws Exception {
		//public Etsaiak(int pPS, int pErasoa, String pIzena, Erasoa pEraso, String pMota, String pDeskripzio, boolean pLagun, boolean pBoss) {
		ets1= new Etsaiak(100,10,"El Mentxas",era1,"Furro","Batxiller gainditu zuen negarrik egin gabe",false,false);
		ets2= new Etsaiak(200,30,"Tracer",era2,"Informatikoa","Ace egin zuen eco batean",true,true);

				

		//String pDeskribapen, int pPs, int pEraso, int pKarisma
		ond1= new Ondorio("Ondorio super mega ona",50,5,20);
		ond2= new Ondorio("Ondorio super mega txarra",-100,-50,-10);
		ond3= new Ondorio("Ondorio super mega normala",0,0,0);
				
				
		//String pIzena, int pMina, int pHutsa
		era1=new Erasoa("Nagetsukeru",20,9);
		era2=new Erasoa("Tsuki no hikari",17,5);
				
				
		//String pIzena, boolean pOndorioa, Ondorio pEfektua
		hitz1= new Hitza("ze guapo zauden",false,ond1);
		hitz2=new Hitza("Espainola naiz",true,ond2);
		hitz3= new Hitza("Sub to PewDiePie",false,ond1);
		hitz4=new Hitza("gilets jaunes",true,ond3);

	}

	@After
	public void tearDown() throws Exception {
		ets1=null;
		ets2=null;
		
		ond1=null;
		ond2=null;
		
		era1=null;
		era2=null;
		
		hitz1=null;
		hitz2=null;
	}


	@Test
	public void testEtsaiak() {
		assertNotNull(ets1);
		assertNotNull(ets2);

	}

	@Test
	public void testGetBizitza() {
		assertEquals(100,ets1.getBizitza());
		assertEquals(200,ets2.getBizitza());

	}

	@Test
	public void testGehituHitza() throws ListanDago, ElementuGehiegi {
		assertEquals(0,ets1.listaTamaina());
		
		ets1.gehituHitza(hitz1);
		assertEquals(1,ets1.listaTamaina());
		
		ets1.gehituHitza(hitz2);
		assertEquals(2,ets1.listaTamaina());

	}

	@Test
	public void testIzenBeraDu() {
		Etsaiak ets3;
		ets3= new Etsaiak(100,10,"El Mentxas",era1,"furro","Batxiller gainditu zuen negarrik egin gabe",false,false);
		
		assertTrue(ets1.izenBeraDu(ets3));
		assertFalse(ets2.izenBeraDu(ets1));

	}

	@Test
	public void testErasoEgin() {
		int bizitza= Jokalaria.getJokalaria().getPertsonaia().getPs();
		ets1.erasoEgin();
		assertTrue(bizitza<=Jokalaria.getJokalaria().getPertsonaia().getPs());
	}

	@Test
	public void testListaTamaina() throws ListanDago, ElementuGehiegi {
		ets1.gehituHitza(hitz1);
		ets1.gehituHitza(hitz2);
		assertEquals(2,ets1.listaTamaina());
		ets1.gehituHitza(hitz3);
		ets1.gehituHitza(hitz4);
		assertEquals(4,ets1.listaTamaina());
	}

	@Test
	public void testBilatuHitza() throws ListanDago, ElementuGehiegi {
		ets2.gehituHitza(hitz1);
		ets2.gehituHitza(hitz2);
		ets2.gehituHitza(hitz3);
		ets2.gehituHitza(hitz4);
		
		
		assertEquals(hitz1,ets2.bilatuHitza(0));
		assertEquals(hitz2,ets2.bilatuHitza(1));
		assertEquals(hitz3,ets2.bilatuHitza(2));
		assertEquals(hitz4,ets2.bilatuHitza(3));

	}

	@Test
	public void testLagunEgin() {
		assertFalse(ets1.lagunaDa());
		ets1.lagunEgin();
		assertTrue(ets1.lagunaDa());
		
		assertTrue(ets2.lagunaDa());
		ets2.lagunaDa();
		assertTrue(ets2.lagunaDa());

	}

	@Test
	public void testLagunaDa() {
		assertFalse(ets1.lagunaDa());
		assertTrue(ets2.lagunaDa());

	}

	@Test
	public void testBossDa() {
		assertFalse(ets1.bossDa());
		assertTrue(ets2.bossDa());
	}
}
