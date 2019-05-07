package Probak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packproiektua.Hitza;
import packproiektua.ListaHitzak;
import packproiektua.ListanDago;
import packproiektua.Ondorio;

public class ListaHitzakTest {
	Hitza hitz1,hitz2,hitz3,hitz4,hitz5;
	
	Ondorio ond1,ond2,ond3;
	
	ListaHitzak lishit1;

	@Before
	public void setUp() throws Exception {
		
		//String pIzena, boolean pOndorioa, Ondorio pEfektua
		hitz1= new Hitza("-",true,ond1);
		hitz2=new Hitza("Kaixo guapo",false,ond1);
		hitz3=new Hitza("Tripofobia",true,ond2);
		hitz4=new Hitza("Elefantiasis",false,ond2);
		hitz5=new Hitza("Elefantiasis",false,ond2);
		
		//String pDeskribapen, int pPs, int pEraso, int pKarisma
		ond1= new Ondorio("Ondorio super mega ona",0,5,0);
		ond2= new Ondorio("Ondorio super mega txarra",10,0,0);
		ond3= new Ondorio("Ondorio super mega normala",0,0,0);
		
		lishit1= new ListaHitzak();
		
		
	}

	@After
	public void tearDown() throws Exception {
		lishit1=null;
	}

	@Test
	public void testListaHitzak() {
		assertNotNull(lishit1);
	}

	@Test
	public void testGehituHitza() throws ListanDago {
		lishit1.gehituHitza(hitz1); //hitz hau nulua da, beraz ez da listan sartuko
		lishit1.gehituHitza(hitz2);
		lishit1.gehituHitza(hitz3);
		lishit1.gehituHitza(hitz4);
		
		System.out.println(lishit1.sizea());
		assertEquals(3,lishit1.sizea());
	}

	@Test
	public void testBilatuHitza() throws ListanDago {
		lishit1.gehituHitza(hitz1); //hitz hau nulua da, beraz ez da listan sartuko
		lishit1.gehituHitza(hitz2);
		lishit1.gehituHitza(hitz3);
		lishit1.gehituHitza(hitz4);
		
		assertEquals(hitz2,lishit1.bilatuHitza(0));
		assertEquals(hitz3,lishit1.bilatuHitza(1));
		assertEquals(hitz4,lishit1.bilatuHitza(2));
	}

	@Test
	public void testTamaina() throws ListanDago {
		lishit1.gehituHitza(hitz1); //hitz hau nulua da, beraz ez da listan sartuko
		lishit1.gehituHitza(hitz2);
		lishit1.gehituHitza(hitz3);
		lishit1.gehituHitza(hitz4);
		assertEquals(lishit1.tamaina(),3);
	}

	@Test
	public void testSizea() throws ListanDago {
		lishit1.gehituHitza(hitz1); //hitz hau nulua da, beraz ez da listan sartuko
		lishit1.gehituHitza(hitz2);
		lishit1.gehituHitza(hitz3);
		lishit1.gehituHitza(hitz4);
		assertEquals(lishit1.sizea(),3);
	}

}
