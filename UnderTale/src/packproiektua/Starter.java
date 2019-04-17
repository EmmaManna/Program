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
				this.hautatuErasoak();
		}
	}
	
	public void barkamenaEskatu(){ //MERCY
		//TODO
		String bidalitakoAgindua="";
		//esto ya lo hace arriba
		//bidalitakoAgindua = Teklatua.getTeklatua().irakurriString("Zer egingo duzu:   MERCY   ACT   FIGHT");
		switch(bidalitakoAgindua){
		case "alde egin":
			this.aldeEgin();
		}

	}
	
	public void hitzEgin(){
		//TODO
		Ondorio izangoDuenOndorioa;
		String bidalitakoAgindua="";
		//Esto lo hace arriba
		//bidalitakoAgindua = Teklatua.getTeklatua().irakurriString("Zer egingo duzu:   MERCY   ACT   FIGHT");
		izangoDuenOndorioa=this.lista.zerEsanDu(bidalitakoAgindua);
		izangoDuenOndorioa.ondorioaEragin(this.ps, this.karisma,this.erasoa);
	
	}
	
	public void hautatuErasoak(){
		//TODO
	}
	
	public void erasoEgin(Etsaiak pEtsaia){
		int eras = 0;
		eras = Jokalaria.getJokalaria().erasoEgin(this.erasoa);
		pEtsaia.minaJaso(eras);
	}

}
