package packproiektua;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


public class Jokalaria {
	//Atributuak
	private Starter pertsonaia;
	private static Jokalaria nireJokalaria = null;
	
	
	//Eraikitzailea
	private Jokalaria() {
		String izena = Teklatua.getTeklatua().irakurriString("Zein da zure izena?");
		String mota = Teklatua.getTeklatua().irakurriString("Zein motatakoa zara?  Furro,  Influencer,  Informatikoa");

		this.pertsonaia = new Starter(100,20, izena, mota, 0, 0);
	}

	//Singleton
	public static synchronized Jokalaria getJokalaria(){
		if(nireJokalaria == null){
			nireJokalaria = new Jokalaria();
		}
		return nireJokalaria;
	}
	
	//Metodoak
	public void partidaJokatu(){
		//TODO
		
	}
	
	public void partidaHaiseratu(){
		//Istorioa hasieratu
		String[] zatiak= new String[40];
		InputStream fitx = this.getClass().getClassLoader().getResourceAsStream("fitxategiak/UndertaleStory.txt");
		InputStreamReader in= new InputStreamReader(fitx);
		
		Scanner sc; 
		sc = new Scanner(in);
		String istorioa = sc.nextLine();
		zatiak = istorioa.split(";");
		
		while(sc.hasNextLine()){
			Npc npc = null;
			Etsaiak etsaia = null;
			Erasoa eraso = null;
			Egoera egoera = null;
			Hitza hitz1, hitz2, hitz3, hitz4 = null;
			Ondorio ondorio1, ondorio2, ondorio3, ondorio4 = null;
			
			String egoerak = sc.nextLine();
			zatiak= egoerak.split(";");
			
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
			String izena = zatiak[9];
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
				npc = new Npc(ps,erasoa,izena,mota);
				//eraso = new Erasoa(izenaEraso,mina,hutsa);
				//etsaia = new Etsaiak(0,0,"-",eraso,"-","-",false,false);
			}
			else{
				//npc = new Npc(0,0,"-","-");
				etsaia = new Etsaiak(ps,erasoa,izena,eraso,mota,deskribapenaEtsai,lagunaDa,bossDa);
				
				ondorio1 = new Ondorio(deskOndorio1, psOn1, erasoOn1, karismaOn1);
				ondorio2 = new Ondorio(deskOndorio2, psOn2, erasoOn2, karismaOn2);
				ondorio3 = new Ondorio(deskOndorio3, psOn3, erasoOn3, karismaOn3);
				ondorio4 = new Ondorio(deskOndorio4, psOn4, erasoOn4, karismaOn4);
				
				hitz1 = new Hitza(izenaHitz1,ondorioH1,ondorio1);
				hitz2 = new Hitza(izenaHitz2,ondorioH2,ondorio2);
				hitz3 = new Hitza(izenaHitz3,ondorioH3,ondorio3);
				hitz4 = new Hitza(izenaHitz4,ondorioH4,ondorio4);
				
				etsaia.gehituHitza(hitz4);
				etsaia.gehituHitza(hitz3);
				etsaia.gehituHitza(hitz2);
				etsaia.gehituHitza(hitz1);
			}
			
			
			
			egoera = new Egoera(hurrengoEgoera1,hurrengoEgoera2,etsaia,npc,deskribapena1, deskribapena2, deskribapena3);
			ListaEgoerak.getListaEgoerak().gehituEgoera(egoera);
		}
		
		//Lista Pertsonaiak hasieratu
		String[] zatiakPertsonai= new String[40];
		InputStream fitxPertsonaiak = this.getClass().getClassLoader().getResourceAsStream("fitxategiak/UndertaleStory.txt");
		InputStreamReader inPertsonaiak= new InputStreamReader(fitxPertsonaiak);
		
		sc = new Scanner(inPertsonaiak);
		String PertsonaiGuztiak = sc.nextLine();
		zatiak= PertsonaiGuztiak.split(";");
		
		while(sc.hasNext()){
			
		}
		
		
	}
	
	public void pertsonaiaSortu(){
		Jokalaria.getJokalaria();
	}
	
	public void aukeratu(){ //Bidean eskuina edo ezkerra aukeratu
		//return String???
		//TODO
	}
	
	public void etsaiekinTopatu(){
		//TODO
	}
	
	public void borrokaPantaila(){
		//TODO
	}
}
