package packproiektua;

public class Egoera {
	//Atributuak
	private int hurrengoEgoera1;
	private int hurrengoEgoera2;
	private Etsaiak etsaia;
	private Npc npc;
	private String deskribapena;
	
	
	public Egoera() {
		// TODO
	}
	
	public boolean beraDa(Egoera pEgoera){
		boolean bera = false;
		
		if(this.deskribapena.equals(pEgoera.deskribapena)){
			bera = true;
		}
		return bera;
	}
}
