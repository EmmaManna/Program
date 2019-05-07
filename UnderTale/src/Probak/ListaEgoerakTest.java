package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packproiektua.Egoera;
import packproiektua.Erasoa;
import packproiektua.Etsaiak;
import packproiektua.ListaEgoerak;
import packproiektua.ListanDago;
import packproiektua.Npc;

public class ListaEgoerakTest {
	ListaEgoerak le1;

	Egoera ego1,ego2,ego3,ego4,ego5,ego6,ego7,ego8,ego9,ego10,ego11,ego12,ego13,ego14,ego15,ego16,ego17,ego18,ego19,ego20,ego21,ego22;
	
	Etsaiak ets1,ets2;
	
	Npc npc1,npc2;
	
	Erasoa era1,era2;


	@Before
	public void setUp() throws Exception {
		le1=ListaEgoerak.getListaEgoerak();

		//int pHurrengoEgoera1, int pHurrengoEgoera2, Etsaiak pEtsaia, Npc pNpc, String pDesk1, String pDesk2,String pDesk3
		ego1= new Egoera(1,2,ets1,npc1,"Oso maltsurra","olakase","deskribapen originala");
		ego2= new Egoera(2,3,ets2,npc1,"-","JUnitak egitea asko gustatzen zaio","ETS kk");
		ego3= new Egoera(2,4,ets1,npc2,"Emma oso guapoa da","-","JonQ oso guapoa da");
		ego4= new Egoera(1,4,ets2,npc2,"emma utzi jolasteari","Kalkua erraza dela esaten du","-");
		ego5= new Egoera(1,2,ets1,npc1,"Oso maltsurra","olakase","deskribapen originala");
		ego6= new Egoera(2,3,ets2,npc1,"-","JUnitak egitea asko gustatzen zaio","ETS kk");
		ego7= new Egoera(2,4,ets1,npc2,"Emma oso guapoa da","-","JonQ oso guapoa da");
		ego8= new Egoera(1,4,ets2,npc2,"emma utzi jolasteari","Kalkua erraza dela esaten du","-");
		ego9= new Egoera(1,2,ets1,npc1,"Oso maltsurra","olakase","deskribapen originala");
		ego10= new Egoera(2,3,ets2,npc1,"-","JUnitak egitea asko gustatzen zaio","ETS kk");
		ego11= new Egoera(2,4,ets1,npc2,"Emma oso guapoa da","-","JonQ oso guapoa da");
		ego12= new Egoera(1,4,ets2,npc2,"emma utzi jolasteari","Kalkua erraza dela esaten du","-");
		ego13= new Egoera(1,2,ets1,npc1,"Oso maltsurra","olakase","deskribapen originala");
		ego14= new Egoera(2,3,ets2,npc1,"-","JUnitak egitea asko gustatzen zaio","ETS kk");
		ego15= new Egoera(2,4,ets1,npc2,"Emma oso guapoa da","-","JonQ oso guapoa da");
		ego16= new Egoera(1,4,ets2,npc2,"emma utzi jolasteari","Kalkua erraza dela esaten du","-");
		ego17= new Egoera(1,2,ets1,npc1,"Oso maltsurra","olakase","deskribapen originala");
		ego18= new Egoera(2,3,ets2,npc1,"-","JUnitak egitea asko gustatzen zaio","ETS kk");
		ego19= new Egoera(2,4,ets1,npc2,"Emma oso guapoa da","-","JonQ oso guapoa da");
		ego20= new Egoera(1,4,ets2,npc2,"emma utzi jolasteari","Kalkua erraza dela esaten du","-");
		ego21= new Egoera(1,2,ets1,npc1,"Oso maltsurra","olakase","deskribapen originala");
		ego22= new Egoera(1,2,ets1,npc1,"Oso maltsurra","olakase","deskribapen originala");
		
		//int pPS, int pErasoa, String pIzena, String pMota
		npc1= new Npc(100,20,"EnnaMamma","Furro");
		npc2= new Npc(200,50,"JirenBailandoLaCumbiaBienOtako","informatikoa");
		
		
		ets1= new Etsaiak(100,10,"El Mentxas",era1,"Furro","Batxiller gainditu zuen negarrik egin gabe",false,false);
		ets2= new Etsaiak(200,30,"Tracer",era2,"Informatikoa","Ace egin zuen eco batean",true,true);
		
		//String pIzena, int pMina, int pHutsa
		era1=new Erasoa("Nagetsukeru",20,9);
		era2=new Erasoa("Tsuki no hikari",17,5);
	
	}

	@After
	public void tearDown() throws Exception {
		le1=null;
		

	}

	@Test
	public void testGetListaEgoerak() {
		le1=ListaEgoerak.getListaEgoerak();
		assertNotNull(le1);

	}

	@Test
	public void testGehituEgoera()throws ListanDago{
		le1.reset();
		
		le1.gehituEgoera(ego1);
		le1.gehituEgoera(ego2);
		le1.gehituEgoera(ego3);
		le1.gehituEgoera(ego4);
		le1.gehituEgoera(ego5);
		le1.gehituEgoera(ego6);
		le1.gehituEgoera(ego7);
		le1.gehituEgoera(ego8);
		le1.gehituEgoera(ego9);
		le1.gehituEgoera(ego10);
		le1.gehituEgoera(ego11);
		le1.gehituEgoera(ego12);
		le1.gehituEgoera(ego13);
		le1.gehituEgoera(ego14);
		le1.gehituEgoera(ego15);
		le1.gehituEgoera(ego16);
		le1.gehituEgoera(ego17);
		le1.gehituEgoera(ego18);
		le1.gehituEgoera(ego19);
		le1.gehituEgoera(ego20);
		le1.gehituEgoera(ego21);
		le1.gehituEgoera(ego22);
		
		assertEquals(22,le1.tamaina());

	}

	@Test
	public void testHurrengoEgoera() throws ListanDago {
		le1.reset();
		
		le1.gehituEgoera(ego1);
		le1.gehituEgoera(ego2);
		le1.gehituEgoera(ego3);
		le1.gehituEgoera(ego4);
		le1.gehituEgoera(ego5);
		le1.gehituEgoera(ego6);
		le1.gehituEgoera(ego7);
		le1.gehituEgoera(ego8);
		le1.gehituEgoera(ego9);
		le1.gehituEgoera(ego10);
		le1.gehituEgoera(ego11);
		le1.gehituEgoera(ego12);
		le1.gehituEgoera(ego13);
		le1.gehituEgoera(ego14);
		le1.gehituEgoera(ego15);
		le1.gehituEgoera(ego16);
		le1.gehituEgoera(ego17);
		le1.gehituEgoera(ego18);
		le1.gehituEgoera(ego19);
		le1.gehituEgoera(ego20);
		le1.gehituEgoera(ego21);
		le1.gehituEgoera(ego22);
		
		assertEquals(ego6,le1.hurrengoEgoera(5));
	}

	@Test
	public void testEgoeraBereziaDa() throws ListanDago {
		le1.reset();
		
		le1.gehituEgoera(ego1);
		le1.gehituEgoera(ego2);
		le1.gehituEgoera(ego3);
		le1.gehituEgoera(ego4);
		le1.gehituEgoera(ego5);
		le1.gehituEgoera(ego6);
		le1.gehituEgoera(ego7);
		le1.gehituEgoera(ego8);
		le1.gehituEgoera(ego9);
		le1.gehituEgoera(ego10);
		le1.gehituEgoera(ego11);
		le1.gehituEgoera(ego12);
		le1.gehituEgoera(ego13);
		le1.gehituEgoera(ego14);
		le1.gehituEgoera(ego15);
		le1.gehituEgoera(ego16);
		le1.gehituEgoera(ego17);
		le1.gehituEgoera(ego18);
		le1.gehituEgoera(ego19);
		le1.gehituEgoera(ego20);
		le1.gehituEgoera(ego21);
		le1.gehituEgoera(ego22);
		
		
		assertTrue(le1.egoeraBereziaDa(ego18));
		assertTrue(le1.egoeraBereziaDa(ego9));
		assertTrue(le1.egoeraBereziaDa(ego6));
		
		assertFalse(le1.egoeraBereziaDa(ego1));
		assertFalse(le1.egoeraBereziaDa(ego10));
		assertFalse(le1.egoeraBereziaDa(ego5));
	}

	@Test
	public void testGaztelua() throws ListanDago {
		le1.reset();
		
		le1.gehituEgoera(ego1);
		le1.gehituEgoera(ego2);
		le1.gehituEgoera(ego3);
		le1.gehituEgoera(ego4);
		le1.gehituEgoera(ego5);
		le1.gehituEgoera(ego6);
		le1.gehituEgoera(ego7);
		le1.gehituEgoera(ego8);
		le1.gehituEgoera(ego9);
		le1.gehituEgoera(ego10);
		le1.gehituEgoera(ego11);
		le1.gehituEgoera(ego12);
		le1.gehituEgoera(ego13);
		le1.gehituEgoera(ego14);
		le1.gehituEgoera(ego15);
		le1.gehituEgoera(ego16);
		le1.gehituEgoera(ego17);
		le1.gehituEgoera(ego18);
		le1.gehituEgoera(ego19);
		le1.gehituEgoera(ego20);
		le1.gehituEgoera(ego21);
		le1.gehituEgoera(ego22);
		
		assertTrue(le1.gaztelua(ego22));
		assertFalse(le1.gaztelua(ego1));
	}

	@Test
	public void testFlowey() throws ListanDago{
		le1.reset();
		
		le1.gehituEgoera(ego1);
		le1.gehituEgoera(ego2);
		le1.gehituEgoera(ego3);
		le1.gehituEgoera(ego4);
		
		
		assertTrue(le1.flowey(ego4));
		assertFalse(le1.flowey(ego1));
	}
	
	
	@Test
	public void testBifurk() throws ListanDago{
		le1.reset();
		
		le1.gehituEgoera(ego1);
		le1.gehituEgoera(ego2);
		le1.gehituEgoera(ego3);
		le1.gehituEgoera(ego4);
		le1.gehituEgoera(ego5);
		le1.gehituEgoera(ego6);
		le1.gehituEgoera(ego7);
		le1.gehituEgoera(ego8);
		le1.gehituEgoera(ego9);
		le1.gehituEgoera(ego10);
		le1.gehituEgoera(ego11);
		le1.gehituEgoera(ego12);
		le1.gehituEgoera(ego13);
		le1.gehituEgoera(ego14);
		le1.gehituEgoera(ego15);
		le1.gehituEgoera(ego16);
		le1.gehituEgoera(ego17);
		le1.gehituEgoera(ego18);
		
		assertTrue(le1.bifurk(ego18));
		
		assertFalse(le1.bifurk(ego1));
		assertFalse(le1.bifurk(ego16));
	}

}

