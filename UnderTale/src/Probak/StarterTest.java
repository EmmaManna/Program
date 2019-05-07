package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packproiektua.Egoera;
import packproiektua.Erasoa;
import packproiektua.Etsaiak;
import packproiektua.Npc;
import packproiektua.Ondorio;
import packproiektua.Starter;

public class StarterTest {
	Starter str1,str2;
	
	Etsaiak ets1;
	
	Npc npc1;
	
	Egoera ego1;
	
	Erasoa era1,era2;

	@Before
	public void setUp() throws Exception {
		
		//int pPS, int pErasoa, String pIzena, Erasoa pEraso,String pMota, int pXp, int pKarisma
		str1=new Starter(100,20,"NiIdea",era1,"Furro",11,7);	
		str2=new Starter(100,20,"NiIdea",era1,"Furro",314,2);
		
		ets1= new Etsaiak(100,10,"El Mentxas",era1,"Furro","Batxiller gainditu zuen negarrik egin gabe",false,false);
		
		npc1= new Npc(314,10,"Irati","Influencer");
		
		ego1= new Egoera(1,2,ets1,npc1,"Oso maltsurra","olakase","deskribapen originala");
		
		
		era1=new Erasoa("Nagetsukeru",20,10);
	}

	@After
	public void tearDown() throws Exception {
		str1=null;
		str2=null;
		
		era1=null;
	}

	@Test
	public void testStarter() {
		assertNotNull(str1);
		assertNotNull(str2);
	}

	@Test
	public void testKarismaHaiseratu() {
		str1.karismaHaiseratu();
		assertEquals(0,str1.getKarisma());
		str2.karismaHaiseratu();
		assertEquals(2,str2.getKarisma());
	}
	
	@Test
	public void testGetKarisma(){
		assertEquals(str1.getKarisma(),7);
		assertEquals(2,str2.getKarisma());
	}

	@Test
	public void testGetXp() {
		assertEquals(11,str1.getXp());
		assertEquals(314,str2.getXp());
		
	}

	@Test
	public void testExperientziaIgo() {
		str1.experientziaIgo();
		assertEquals(12,str1.getXp());
		str2.experientziaIgo();
		assertEquals(315,str2.getXp());
	}

	@Test
	public void testAginduaEgin() {
		

		assertNotNull(str1.aginduaEgin(ego1));
	}

	@Test
	public void testBarkamenaEskatu() {
		Etsaiak ets1;
		ets1= new Etsaiak(100,10,"El Mentxas",era1,"Furro","Batxiller gainditu zuen negarrik egin gabe",false,false);
		
		assertFalse(str2.barkamenaEskatu(ets1));
		
		assertTrue(str1.barkamenaEskatu(ets1));
	}

	@Test
	public void testHitzEgin() {
		Etsaiak ets1;
		ets1= new Etsaiak(100,10,"El Mentxas",era1,"Furro","Batxiller gainditu zuen negarrik egin gabe",false,false);
		str1.hitzEgin(ets1);
	}

	@Test
	public void testErasoEgin() {
		Etsaiak ets1;
		ets1= new Etsaiak(100,10,"El Mentxas",era1,"Furro","Batxiller gainditu zuen negarrik egin gabe",false,false);
		str2.erasoEgin(ets1);
		assertTrue(100>=ets1.getPs());
	}

	@Test
	public void testEgikaratuOndorioa() {
		Ondorio ond1,ond2,ond3;
		
		ond1= new Ondorio("Ondorio super mega ona",50,0,0);
		ond2= new Ondorio("Ondorio super mega txarra",0,-25,0);
		ond3= new Ondorio("Ondorio super mega normala",0,0,10);
		
		str1.egikaratuOndorioa(5, ond1);
		assertEquals(105,str1.getPs());
		
		str1.egikaratuOndorioa(-10, ond2);
		assertEquals(10,str1.getErasoa());
		
		str1.egikaratuOndorioa(23, ond3);
		assertEquals(30,str1.getKarisma());
	}

}