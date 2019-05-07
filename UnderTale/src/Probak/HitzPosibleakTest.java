package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packproiektua.HitzPosibleak;
import packproiektua.Hitza;
import packproiektua.ListanDago;
import packproiektua.Ondorio;

public class HitzPosibleakTest {
	HitzPosibleak hitzposi1;
	
	Hitza hitz1,hitz2,hitz3,hitz4;
	
	Ondorio ond1,ond2;



	@Before
	public void setUp() throws Exception {
		hitzposi1=HitzPosibleak.getHitzPosibleak();
		
		//String pIzena, boolean pOndorioa, Ondorio pEfektua
		hitz1= new Hitza("-",true,ond1);
		hitz2=new Hitza("Kaixo guapo",false,ond1);
		hitz3=new Hitza("Tripofobia",true,ond2);
		hitz4=new Hitza("Elefantiasis",false,ond2);
		
		
		//String pDeskribapen, int pPs, int pEraso, int pKarisma
		ond1= new Ondorio("Ondorio super mega ona",0,5,0);
		ond2= new Ondorio("Ondorio super mega txarra",10,0,0);

	}

	@After
	public void tearDown() throws Exception {
		hitzposi1=null;
		
		hitz1=null;
		hitz2=null;
		hitz3=null;
		hitz4=null;
		
		ond1=null;
		ond2=null;

	}

	@Test
	public void testGetHitzPosibleak() {
		assertNotNull(hitzposi1);
	}

	@Test
	public void testGehituHitza() throws ListanDago {
		hitzposi1.gehituHitza(hitz1); //nulua da
		hitzposi1.gehituHitza(hitz2);
		hitzposi1.gehituHitza(hitz3);
		hitzposi1.gehituHitza(hitz4);
		assertEquals(3,hitzposi1.tamaina());

	}

	@Test
	public void testTamaina() throws ListanDago {
		assertEquals(0,hitzposi1.tamaina());
	}

}
