package packproiektua;

public class Npc extends Pertsonaiak {

	public Npc(int pPS, int pErasoa, String pIzena, String pMota){
		super(pPS, pErasoa, pIzena,null, pMota);
		// TODO Auto-generated constructor stub
	}
	
	//Metodoak
	public boolean izenBeraDu(Npc pNpc){
		return this.izena.equals(pNpc.izena);
	}

}
