package packproiektua;

public class Npc extends Pertsonaiak {

	public Npc(int pPS, int pErasoa, String pIzena, String pMota) { //Supongo que quitando izena/mota todos tendrán valores default
		super(pPS, pErasoa, pIzena,null, pMota);
		// TODO Auto-generated constructor stub
	}
	
	//Metodoak
	public boolean izenBeraDu(Npc pNpc){
		boolean bera = false;
		
		if(this.izena.equals(pNpc.izena)){
			bera = true;
		}
		return bera;
	}

}
