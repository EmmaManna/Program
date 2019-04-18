package packproiektua;

public class Starter extends Pertsonaiak {
	//Atributuak
	private int xp;
	private int karisma;
	
	//Eraikitzailea
	public Starter(int pPS, int pErasoa, String pIzena, Erasoa pEraso,String pMota, int pXp, int pKarisma) {
		super(pPS, pErasoa, pIzena, pEraso, pMota);
		this.xp = pXp;
		this.karisma = pKarisma;
	}
	
	
	//metodoak
	public void aginduaEgin(){
		//TODO
		String bidalitakoAgindua="";
		bidalitakoAgindua = Teklatua.getTeklatua().irakurriString("Zer egingo duzu:   MERCY   ACT   FIGHT");
		
		switch(bidalitakoAgindua){
			case "MERCY":
				this.barkamenaEskatu();
			case "ACT":
				this.hitzEgin();
			case "FIGHT":
				this.erasoEgin();
		}
	}
	
	public void barkamenaEskatu(){ //MERCY
		//TODO
		boolean bool;
		String bidalitakoAgindua="";
		//esto ya lo hace arriba
		//bidalitakoAgindua = Teklatua.getTeklatua().irakurriString("Zer egingo duzu:   MERCY   ACT   FIGHT");
		switch(bidalitakoAgindua){
		case "alde egin":
			bool=this.aldeEgin();
			if (!bool){
				this.aginduaEgin();
			}
			else{

			}
		}

	}
	
	public void hitzEgin(){
		//TODO
		Ondorio izangoDuenOndorioa;
		//Esto lo hace arriba
		//bidalitakoAgindua = Teklatua.getTeklatua().irakurriString("Zer egingo duzu:   MERCY   ACT   FIGHT");
		izangoDuenOndorioa=this.lista.zerEsanDu(bidalitakoAgindua);
		izangoDuenOndorioa.ondorioaEragin(this.ps, this.karisma,this.erasoa);
		this.aginduaEgin();
	}
	
	/*public void hautatuErasoak(){
		//TODO
	}*/
	
	public void erasoEgin(Etsaiak pEtsaia){
		int eras = 0;
		
		if(this.eraso.minEgin()){
			eras = Jokalaria.getJokalaria().erasoEgin(this.erasoa);
			eras = (int) (eras*this.eraso.getMina()*(0.01));
			pEtsaia.minaJaso(eras);
		}
		else{
			System.out.println("Erasoak huts egin du!");
			pEtsaia.minaJaso(eras);
		}
		
	}

}
