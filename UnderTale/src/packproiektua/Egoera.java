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
}
