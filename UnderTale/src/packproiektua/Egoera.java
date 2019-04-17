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
	
	
	public Egoera(int pHurrengoEgoera1, int pHurrengoEgoera2, Etsaiak pEtsaia, Npc pNpc, String pDesk1, String pDesk2,String pDesk3) {
		this.hurrengoEgoera1 = pHurrengoEgoera1;
		this.hurrengoEgoera2 = pHurrengoEgoera2;
		this.etsaia = pEtsaia;
		this.npc = pNpc;
		this.deskribapena1 = pDesk1;
		this.deskribapena2 = pDesk2;
		this.deskribapena3 = pDesk3;
	}
	
	public boolean beraDa(Egoera pEgoera){
		boolean bera = false;
		
		if(this.deskribapena1.equals(pEgoera.deskribapena1)){
			bera = true;
		}
		return bera;
	}
	
	public void borroka(){ //Bikoitia Jokalariaren txanda, bakoitia etsaiarena
		int txanda = 0;
		boolean amaitu = false;
		int ps = 0;
		
		while(!amaitu){
			if(this.bikoitiaDa(txanda)){
				Jokalaria.getJokalaria().getPertsonaia().erasoEgin(this.etsaia);
				Jokalaria.getJokalaria().getPertsonaia().eraso.inprimatuIzena();
				System.out.println(" erabili duzu");
				ps = this.etsaia.ps;
				System.out.println("Etsaiaren Ps-ak orain" +ps+ " dira.");
			}
			else{
				this.etsaia.erasoEgin();
				this.etsaia.eraso.inprimatuIzena();
				System.out.println(" erabili du!");
				ps = Jokalaria.getJokalaria().getPertsonaia().ps;
				System.out.println("Zure Ps-ak " +ps+ " dira.");
			}
			
			if(this.etsaia.hilDa()){
				System.out.println(this.etsaia.izena + " hil da...");
				amaitu = true;
			}
			else{
				if(Jokalaria.getJokalaria().getPertsonaia().hilDa()){
					System.out.println("Oh! Hil zara...");
					amaitu = true;
				}
			}
			
			txanda = txanda+1;
		}
	}
	
	private boolean bikoitiaDa(int pZenb){
		boolean bikoitia = false;
		
		if(pZenb%2==0){
			bikoitia = true;
		}
		return bikoitia;
	}
}
