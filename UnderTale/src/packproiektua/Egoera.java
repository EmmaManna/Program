package packproiektua;

public class Egoera {
	//Atributuak
	private int hurrengoEgoera1;
	private int hurrengoEgoera2;
	private Etsaiak etsaia;
	private Npc npc;
	private String deskribapena1;
	private String deskribapena2;
	private String deskribapena3;
	
	//Eraikitzailea
	public Egoera(int pHurrengoEgoera1, int pHurrengoEgoera2, Etsaiak pEtsaia, Npc pNpc, String pDesk1, String pDesk2,String pDesk3) {
		this.hurrengoEgoera1 = pHurrengoEgoera1;
		this.hurrengoEgoera2 = pHurrengoEgoera2;
		this.etsaia = pEtsaia;
		this.npc = pNpc;
		this.deskribapena1 = pDesk1;
		this.deskribapena2 = pDesk2;
		this.deskribapena3 = pDesk3;
	}
	
	
	//Getterrak
	public int getHurrengoEgoera1(){
		return this.hurrengoEgoera1;
	}
	
	public int getHurrengoEgoera2(){
		return this.hurrengoEgoera2;
	}
	
	
	//Gainontzeko metodoak
	public boolean beraDa(Egoera pEgoera){
		return this.equals(pEgoera);
	}
	
	public boolean bikoitiaDa(int pZenb){
		boolean bikoitia = false;
		
		if(pZenb%2==0){
			bikoitia = true;
		}
		return bikoitia;
	}
	
	public void inprimatuDesk1(){
		System.out.println(deskribapena1);
	}
	
	public void inprimatuDesk2(){
		System.out.println(deskribapena2);
	}
	
	public void inprimatuDesk3(){
		System.out.println(deskribapena3);
	}
	
	public boolean deskDago1(){
		return !this.deskribapena1.equals("-");
	}
	
	public boolean deskDago2(){
		return !this.deskribapena2.equals("-");
	}
	
	public boolean deskDago3(){
		return !this.deskribapena3.equals("-");
	}
	
	public boolean hilDaEtsaia(){
		return this.etsaia.hilDa();
	}
	
	public boolean npcDa(){
		boolean npc = false;
		
		if(!this.npc.izena.equals("-")||(this.npc.izena.equals("-")&&this.etsaia.izena.equals("-"))){
			npc = true;
		}
		return npc;
	}
	
	public void etsaiarenDeskribapena(){
		this.etsaia.deskripzioaEman();
	}
	
	public boolean lagunaDa(){
		return this.etsaia.lagunaDa();
	}
	
	public boolean bossDa(){
		return this.etsaia.bossDa();
	}
	
	public void lagunEgin(){
		this.etsaia.lagunEgin();
	}
	
	public String etsaiarenIzena(){
		return this.etsaia.izena;
	}
	
	public int listaTamaina(){
		return this.etsaia.listaTamaina();
	}
	
	public void inprimatuHitzak(){
		this.etsaia.inprimatuHitzak();
	}
	
	public Hitza bilatuHitza(int pZenb){
		return this.etsaia.bilatuHitza(pZenb);
	}
	
	public void erasoEgin(){
		this.etsaia.erasoEgin();
	}
	
	public String erasoarenIzena(){
		return this.etsaia.eraso.getIzena();
	}
	
	public int psLortu(){
		return this.etsaia.ps;
	}
	
	public void etsaiariErasotu(){
		int eras = 0;
		int ps = 0;
		eras = Jokalaria.getJokalaria().erasoEgin(Jokalaria.getJokalaria().getPertsonaia().erasoa);
		
		if(Jokalaria.getJokalaria().getPertsonaia().eraso.minEgin()){
			eras = (eras*Jokalaria.getJokalaria().getPertsonaia().eraso.getMina()/(2));
			this.etsaia.minaJaso(eras);
			System.out.println(Jokalaria.getJokalaria().getPertsonaia().eraso.getIzena()+" erabili duzu");
			ps = this.psLortu();
			System.out.println("Etsaiaren Ps-ak orain " +ps+ " dira.");
		}
		else{
			System.out.println("Zure erasoak huts egin du!");
		}
	}
}

