package packproiektua;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.NumberFormatException;

import java.util.InputMismatchException;


public class Jokalaria {
	//Atributuak
	private Starter pertsonaia;
	private static Jokalaria nireJokalaria = null;
	
	
	//Eraikitzailea
	private Jokalaria() {
		String izena = Teklatua.getTeklatua().irakurriString("Zein da zure izena?");
		
		boolean ondo = false;
		String mota = "-";
		int ps = 0;
		int erasoa = 0;
		
		do{
			try{
				mota = Teklatua.getTeklatua().irakurriString("Zein motatakoa zara?  Furro,  Influencer,  Informatikoa");
				if(mota.equals("Furro")){
					ps = 100;
					erasoa = 12;
					ondo = true;
				}
				else{
					if(mota.equals("Influencer")){
						ps = 80;
						erasoa = 8;
						ondo = true;
					}
					else{
						if(mota.equals("Informatikoa")){
							ps = 120;
							erasoa = 9;
							ondo = true;
						}
						else{
							throw(new TeklaOkerra());
					
						}
					}
				}
			}
			catch(TeklaOkerra e){
				System.out.println("Hori ez da mota bat");
			}
		}while(!ondo);
		
		
		Erasoa eraso = new Erasoa("-",0,1); //Default luego se cambia
		this.pertsonaia = new Starter(ps,erasoa, izena, eraso, mota, 0, 0);
	}

	//Singleton
	public static synchronized Jokalaria getJokalaria(){
		if(nireJokalaria == null){
			nireJokalaria = new Jokalaria();
		}
		return nireJokalaria;
	}
	
	//Getterra
	public Starter getPertsonaia(){
		return this.pertsonaia;
	}
	
	//Metodoak
	public void partidaJokatu(){
		Jokalaria.getJokalaria().partidaHaiseratu();
		
		//Hasierako egoera, istorioa kontatu
		boolean pazifikoa = true;
		boolean flowey = false;
		
		Egoera egungoEgoera = null;
		Pertsonaiak jokalaria = null;
		String erantzuna = "-";
		
		egungoEgoera = ListaEgoerak.getListaEgoerak().hurrengoEgoera(0);
		
		if(egungoEgoera.deskDago1()){
			egungoEgoera.inprimatuDesk1();
		}
		if(egungoEgoera.deskDago2()){
			egungoEgoera.inprimatuDesk2();
		}
		if(egungoEgoera.deskDago3()){
			egungoEgoera.inprimatuDesk3();
		}
		
		//Hasten da jokoa
		egungoEgoera = ListaEgoerak.getListaEgoerak().hurrengoEgoera(1);
		if(egungoEgoera.deskDago1()){
			egungoEgoera.inprimatuDesk1();
		}
		if(egungoEgoera.deskDago2()){
			egungoEgoera.inprimatuDesk2();
		}
		Jokalaria.getJokalaria();
		jokalaria = Jokalaria.getJokalaria().getPertsonaia();
		
		boolean aukeratuIzena = false;
		while(!aukeratuIzena){
			try{
				System.out.println("Oh! Izen aukera ona... orduan " + jokalaria.izena + " da zure izena?");
				System.out.println("Ondo,ondo... izen polita, " + jokalaria.izena+ " ezta?");
				System.out.println("Mmmmm... berriro galdetuko dizut, " +jokalaria.izena+ " izena gustoko duzu?");
				erantzuna = Teklatua.getTeklatua().irakurriString("Aukeratu: Bai   Ez");
		
				if(erantzuna.equals("Ez")){
					String izena = Teklatua.getTeklatua().irakurriString("Zein da zure izena?");
					jokalaria.setIzenaAldatu(izena);
				}
				else{
					if(erantzuna.equals("Bai")){
						aukeratuIzena = true;
					}
					else{
						throw(new TeklaOkerra());
					}
				}
			}
			catch(TeklaOkerra e){
				System.out.println("Hori ez da emandako aukeretako bat");
			}
		}
		boolean aukeratuErasoa = false;
		Erasoa eraso = null;
		
		while(!aukeratuErasoa){
			try{
				System.out.println("Orain zure erasoa aukeratzeko momentua da! Ondo erabaki, ezin izango duzu aldatu eta!");
				ErasoPosibleak.getErasoPosibleak().inprimatuErasoak();
				int erasoZenb = Teklatua.getTeklatua().irakurriInt("Zein da nahi duzun erasoaren zenbakia?", 0, ErasoPosibleak.getErasoPosibleak().tamaina()-1);
				eraso = ErasoPosibleak.getErasoPosibleak().aukeratuErasoa(erasoZenb);
				jokalaria.setErasoa(eraso);
				aukeratuErasoa = true;
			}
			catch(NumberFormatException e1){
				System.out.println("Ez duzu zenbaki bat sartu...");
			}
			catch(TeklaOkerra e){
				System.out.println("Aukeratutako erasoa ez da existitzen...");
			}
			
		}
		
		if(egungoEgoera.deskDago3()){
			egungoEgoera.inprimatuDesk3();
		}
		
		egungoEgoera = ListaEgoerak.getListaEgoerak().hurrengoEgoera(2);
		
		//Partidaren atal nagusia
		boolean amaitu = false;
		amaitu = this.partidaJarraitu();
		
		boolean hilda = false;
		boolean bukatuta = false;
		
		while(amaitu && !hilda && !bukatuta){
		
			if(ListaEgoerak.getListaEgoerak().flowey(egungoEgoera)){
				flowey = true;
			}
			
			if(egungoEgoera.deskDago1()){
				egungoEgoera.inprimatuDesk1();
			}
			
			if(egungoEgoera.deskDago2()){
				egungoEgoera.inprimatuDesk2();
			}
			
			if(!egungoEgoera.npcDa()){
				egungoEgoera.etsaiarenDeskribapena();
				Jokalaria.getJokalaria().zerEgin(egungoEgoera);
				Jokalaria.getJokalaria().getPertsonaia().karismaHaiseratu();
				if(egungoEgoera.hilDaEtsaia()){
					Jokalaria.getJokalaria().getPertsonaia().experientziaIgo();
					pazifikoa = false;
				}
			}
			
			
			hilda = this.getPertsonaia().hilDa();
			
			if(!hilda){
				if(egungoEgoera.deskDago3()){
					egungoEgoera.inprimatuDesk3();
				}
					
				if(egungoEgoera.getHurrengoEgoera1() < 0){
					bukatuta = true;
				}
				else{	
					//8 edo 16 egoera bada, kasu berezia bidean
					if(ListaEgoerak.getListaEgoerak().egoeraBereziaDa(egungoEgoera) &&(!flowey || !(Jokalaria.getJokalaria().pertsonaia.getXp()==3))){
						if(egungoEgoera.hilDaEtsaia()){
							egungoEgoera = ListaEgoerak.getListaEgoerak().hurrengoEgoera(egungoEgoera.getHurrengoEgoera2());
						}
						else{
							egungoEgoera = ListaEgoerak.getListaEgoerak().hurrengoEgoera(egungoEgoera.getHurrengoEgoera1());
						}
					}
					else{
						if(ListaEgoerak.getListaEgoerak().gaztelua(egungoEgoera)){
							if(pazifikoa){
								egungoEgoera = ListaEgoerak.getListaEgoerak().hurrengoEgoera(egungoEgoera.getHurrengoEgoera2());
							}
							else{
								egungoEgoera = ListaEgoerak.getListaEgoerak().hurrengoEgoera(egungoEgoera.getHurrengoEgoera1());
							}
						}
						else{
							if(ListaEgoerak.getListaEgoerak().bifurk(egungoEgoera)&&flowey&&Jokalaria.getJokalaria().pertsonaia.getXp()==3){
								egungoEgoera = ListaEgoerak.getListaEgoerak().hurrengoEgoera(25);
							}
							else{
								egungoEgoera = this.aukeratu(egungoEgoera);
							}
						}
					}
					if(!egungoEgoera.npcDa()){
						amaitu = this.partidaJarraitu();
					}
				}
			}
		}
		
		if(hilda){
			System.out.println("Oso ongi borrokatu duzu, baina ez da nahikoa izan. Hurrengorarte lagun <3");
		}
		else{
			if(!amaitu){
				System.out.println("Ea noiz bueltatzen zaren! Zure zain egongo gara!");
			}
			else{
				System.out.println("Zorionak! Amaierara heldu zara, jokoa amaitu da");
			}
		}
	}
	
	
	
	
	public void partidaHaiseratu(){ //FUNCIONA ARREGLAR, METER NULLS EN LISTAS
		//Istorioa hasieratu
		boolean fitxOndo = false;
		String izena = "fitxategiak/UndertaleStory.txt";
		InputStreamReader in = null;
		String[] zatiak= new String[40];
		
		while(!fitxOndo){
			try{
				InputStream fitx = this.getClass().getClassLoader().getResourceAsStream(izena);
				in = new InputStreamReader(fitx);
				fitxOndo = true;
			}
			catch(NullPointerException e){
				System.out.println("Fitxategiaren izena txarto dago");
				izena = Teklatua.getTeklatua().irakurriString("Sartu berriz direktorioa eta izena mesedez");
			}
		}

		Scanner sc; 
		sc = new Scanner(in);
		
		int kont = 0;
		
		try{
			while(sc.hasNextLine()){
				System.out.println("Kartatutako egoerak: "+kont);
				Npc npc = null;
				Etsaiak etsaia = null;
				Erasoa eraso = null;
				Egoera egoera = null;
				Hitza hitz1, hitz2, hitz3, hitz4 = null;
				Ondorio ondorio1, ondorio2, ondorio3, ondorio4 = null;
			
				String istorioa = sc.nextLine();
				zatiak = istorioa.split(";");
			
				//Egoerak
				String hurrengoE1 = zatiak[0];
				int hurrengoEgoera1 = Integer.parseInt(hurrengoE1);
				String hurrengoE2 = zatiak[1];
				int hurrengoEgoera2 = Integer.parseInt(hurrengoE2);
			
				//Pertsonaiak
				String etsaia1 = zatiak[2];
				boolean etsaiaDa = Boolean.parseBoolean(etsaia1);
				String npc1 = zatiak[3];
				boolean npcDa = Boolean.parseBoolean(npc1);
				//Deskribapenak
				String deskribapena1 = zatiak[4];
				String deskribapena2 = zatiak[5];
				String deskribapena3 = zatiak[6];
			
				//Pertsonaia
				String ps1 = zatiak[7];
				int ps = Integer.parseInt(ps1);
				String erasoa1 = zatiak[8];
				int erasoa = Integer.parseInt(erasoa1);
				String izenaP = zatiak[9];
				String mota = zatiak[10];
			
				//Etsaia
				String deskribapenaEtsai = zatiak[11];
				String laguna = zatiak[12];
				boolean lagunaDa = Boolean.parseBoolean(laguna);
				String boss = zatiak[13];
				boolean bossDa = Boolean.parseBoolean(boss);
			
				//Erasoak
				String izenaEraso = zatiak[14];
				String mina1 = zatiak[15];
				int mina = Integer.parseInt(mina1);
				String hutsa1 = zatiak[16];
				int hutsa = Integer.parseInt(hutsa1);
			
				//Hitzak
				String izenaHitz1 = zatiak[17];
				String ondorioaHitz1 = zatiak[18];
				boolean ondorioH1 = Boolean.parseBoolean(ondorioaHitz1);

				String izenaHitz2 = zatiak[19];
				String ondorioaHitz2 = zatiak[20];
				boolean ondorioH2 = Boolean.parseBoolean(ondorioaHitz2);
			
				String izenaHitz3 = zatiak[21];
				String ondorioaHitz3 = zatiak[22];
				boolean ondorioH3 = Boolean.parseBoolean(ondorioaHitz3);
			
				String izenaHitz4 = zatiak[23];
				String ondorioaHitz4 = zatiak[24];
				boolean ondorioH4 = Boolean.parseBoolean(ondorioaHitz4);
			
				//Ondorioak
				String deskOndorio1 = zatiak[25];
				String psO1 = zatiak[26];
				int psOn1 = Integer.parseInt(psO1);
				String erasoO1 = zatiak[27];
				int erasoOn1 = Integer.parseInt(erasoO1);
				String karismaO1 = zatiak[28];
				int karismaOn1 = Integer.parseInt(karismaO1);
			
				String deskOndorio2 = zatiak[29];
				String psO2 = zatiak[30];
				int psOn2 = Integer.parseInt(psO2);
				String erasoO2 = zatiak[31];
				int erasoOn2 = Integer.parseInt(erasoO2);
				String karismaO2 = zatiak[32];
				int karismaOn2 = Integer.parseInt(karismaO2);
			
				String deskOndorio3 = zatiak[33];
				String psO3 = zatiak[34];
				int psOn3 = Integer.parseInt(psO3);
				String erasoO3 = zatiak[35];
				int erasoOn3 = Integer.parseInt(erasoO3);
				String karismaO3 = zatiak[36];
				int karismaOn3 = Integer.parseInt(karismaO3);
			
				String deskOndorio4 = zatiak[37];
				String psO4 = zatiak[38];
				int psOn4 = Integer.parseInt(psO4);
				String erasoO4 = zatiak[39];
				int erasoOn4 = Integer.parseInt(erasoO4);
				String karismaO4 = zatiak[40];
				int karismaOn4 = Integer.parseInt(karismaO4);
			
			
				if(npcDa){
					npc = new Npc(ps,erasoa,izenaP,mota);
					try{
						ListaPertsonaiak.getListaPertsonaiak().PertsonaiaGehitu(npc);
					}
					catch(ListanDago e){
						System.out.println("Npc-a listan dago");
					}
					
					eraso = new Erasoa("-",0,-1);
					etsaia = new Etsaiak(0,0,"-",eraso,"-","-",false,false);
				}
				else{
					if(etsaiaDa){
						npc = new Npc(0,0,"-","-");
						eraso = new Erasoa(izenaEraso,mina,hutsa);
						etsaia = new Etsaiak(ps,erasoa,izenaP,eraso,mota,deskribapenaEtsai,lagunaDa,bossDa);
				
						try{
							ErasoPosibleak.getErasoPosibleak().gehituErasoa(eraso);
						}
						catch(ListanDago e){
							System.out.println("Erasoa listan dago jada");
						}
				
						ondorio1 = new Ondorio(deskOndorio1, psOn1, erasoOn1, karismaOn1);
						ondorio2 = new Ondorio(deskOndorio2, psOn2, erasoOn2, karismaOn2);
						ondorio3 = new Ondorio(deskOndorio3, psOn3, erasoOn3, karismaOn3);
						ondorio4 = new Ondorio(deskOndorio4, psOn4, erasoOn4, karismaOn4);
				
						hitz1 = new Hitza(izenaHitz1,ondorioH1,ondorio1);
						hitz2 = new Hitza(izenaHitz2,ondorioH2,ondorio2);
						hitz3 = new Hitza(izenaHitz3,ondorioH3,ondorio3);
						hitz4 = new Hitza(izenaHitz4,ondorioH4,ondorio4);
				
						try{
							HitzPosibleak.getHitzPosibleak().gehituHitza(hitz1);
						}
						catch(ListanDago e){
							System.out.println("Hitza listan dago");
						}
						try{
							HitzPosibleak.getHitzPosibleak().gehituHitza(hitz2);
						}
						catch(ListanDago e){
							System.out.println("Hitza listan dago");
						}
						try{
							HitzPosibleak.getHitzPosibleak().gehituHitza(hitz3);
						}
						catch(ListanDago e){
							System.out.println("Hitza listan dago");
						}
						try{
							HitzPosibleak.getHitzPosibleak().gehituHitza(hitz4);
						}
						catch(ListanDago e){
							System.out.println("Hitza listan dago");
						}
						
						
						
				
						try{
							etsaia.gehituHitza(hitz4);
						}
						catch(ListanDago e1){
							System.out.println("Hitza listan dago");
						}
						catch(ElementuGehiegi e2){
							System.out.println("Etsai honek lau hitz ditu bere listan jada");
						}
						try{
							etsaia.gehituHitza(hitz3);
						}
						catch(ListanDago e1){
							System.out.println("Hitza listan dago");
						}
						catch(ElementuGehiegi e2){
							System.out.println("Etsai honek lau hitz ditu bere listan jada");
						}
						try{
							etsaia.gehituHitza(hitz2);
						}
						catch(ListanDago e1){
							System.out.println("Hitza listan dago");
						}
						catch(ElementuGehiegi e2){
							System.out.println("Etsai honek lau hitz ditu bere listan jada");
						}
						try{
							etsaia.gehituHitza(hitz1);
						}
						catch(ListanDago e1){
							System.out.println("Hitza listan dago");
						}
						catch(ElementuGehiegi e2){
							System.out.println("Etsai honek lau hitz ditu bere listan jada");
						}
				
						
						
						try{
							ListaPertsonaiak.getListaPertsonaiak().PertsonaiaGehitu(etsaia);
						}
						catch(ListanDago e){
							System.out.println("Etsaia listan dago");
						}
						
					}
					else{
					eraso = new Erasoa("-",0,-1);
						etsaia = new Etsaiak(0,0,"-",eraso,"-","-",false,false);
						npc = new Npc(0,0,"-","-");
					}
				}
			
			
				egoera = new Egoera(hurrengoEgoera1,hurrengoEgoera2,etsaia,npc,deskribapena1, deskribapena2, deskribapena3);
				try{
					ListaEgoerak.getListaEgoerak().gehituEgoera(egoera);
				}
				catch(ListanDago e){
					System.out.println("Egoera listan dago jada");
				}
			kont = kont+1;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Sartutako datua ez da zenbakia. Datuak ezin dira kargatu. Konprobatu fitxategia mesedez");
		}
	}
	
	public void pertsonaiaSortu(){
		Jokalaria.getJokalaria();
	}
	
	public Egoera aukeratu(Egoera pEgoera){ //Bidean eskuina edo ezkerra aukeratu
		String zer = "-";
		boolean ondo = false;
		Egoera aukera = null;
		
		do{
			try{
				if(pEgoera.getHurrengoEgoera1() == pEgoera.getHurrengoEgoera2()){
					zer = Teklatua.getTeklatua().irakurriString("Sakatu a");
					if(zer.equals("a")){
						aukera = ListaEgoerak.getListaEgoerak().hurrengoEgoera(pEgoera.getHurrengoEgoera1());
						ondo = true;
					}
					else{
						throw (new TeklaOkerra());
					}
				}
				else{
					zer = Teklatua.getTeklatua().irakurriString("Zer egin nahi duzu? a edo b");
					if(zer.equals("a")){
						aukera = ListaEgoerak.getListaEgoerak().hurrengoEgoera(pEgoera.getHurrengoEgoera1());
						ondo = true;
					}
					else{
						if(zer.equals("b")){
							aukera = ListaEgoerak.getListaEgoerak().hurrengoEgoera(pEgoera.getHurrengoEgoera2());
							ondo= true;
						}
						else{
							throw (new TeklaOkerra());
						}
					}
				}
			}
			
			catch(TeklaOkerra e){
				System.out.println("Hartutako aukera baliogabea da... Berriz saiatu");
			}
			
		}while(!ondo);
		
		return aukera;
	}
	
	public int erasoEgin(int pErasoa){
		String emandakoa = " ";
		String letra = " ";
		System.out.println("Eraso egiteko momentua da.");
		Kronometroa.getKronometroa().zeroanJarri();
		boolean ondo = false;
		long denbora = 0;
		int erasoa = 0;
		
		do{
			try{
				System.out.println("Azkar!");
				letra = Dadoa.getDadoa().dadoarenLetra();
				emandakoa = Teklatua.getTeklatua().irakurriString("Erasotzeko tekla "+letra+  " da. Enter ere sakatu behar da");
				
				if(emandakoa.equals(letra)){
					ondo = true;
				}
				else{
					throw(new TeklaOkerra());
				}
			}
			
			catch(TeklaOkerra e){
				System.out.println("Tekla hori ez da esandakoa!");
			}
		}while(!ondo);
		
		denbora = Kronometroa.getKronometroa().pasaDirenSegunduakLortu();
		erasoa = (int) (pErasoa - denbora);
		
		if(erasoa < 0){
			erasoa = 0;
		}
		
		return erasoa;
	}
	
	public boolean partidaJarraitu(){
		boolean jarraitu = false;
		String zer = "-";
		boolean ondo = false;
		
		while(!ondo){
			try{
				System.out.println("Partida jokatzen jarraitu nahi duzu?");
				zer = Teklatua.getTeklatua().irakurriString("Aukeratu: Bai   Ez");
				if(zer.equals("Bai")){
					ondo = true;
					jarraitu = true;
				}
				else{
					if(zer.equals("Ez")){
						ondo = true;
						jarraitu = false;
					}
					else{
						throw (new TeklaOkerra());
					}
				}
			}
			catch(TeklaOkerra e){
				System.out.println("Bai edo Ez erantzun behar duzu.");
			}
		}
		
		return jarraitu;
	}
	
	public void zerEgin(Egoera pEgoera){
		boolean hilDaS = false;
		boolean hilDaE = false;
		boolean aldeEgin = false;
		
		while(!hilDaS && !hilDaE && !aldeEgin){
			aldeEgin = this.getPertsonaia().aginduaEgin(pEgoera);
			
			if(this.getPertsonaia().hilDa()){
				hilDaS = true;
			}
			else{
				if(pEgoera.hilDaEtsaia()){
					hilDaE = true;
				}
			}
		}
	}
}
