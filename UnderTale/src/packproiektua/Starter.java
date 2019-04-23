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
	public void karismaHaiseratu(){
		if(karisma >=7){
			this.karisma = 0;
		}
	}
	
	public boolean aginduaEgin(Egoera pEgoera){ //FUNCIONA
		boolean aldeEgin = false;
		boolean ondo = false;
		String bidalitakoAgindua="";
		
		do{
		bidalitakoAgindua = Teklatua.getTeklatua().irakurriString("Zer egingo duzu:   MERCY   ACT   FIGHT");
		
			try{
				if(bidalitakoAgindua.equals("MERCY")){
					aldeEgin = pEgoera.barkamenaEskatu();
					ondo = true;
				}
				else{
					if(bidalitakoAgindua.equals("ACT")){
						pEgoera.hitzEgin();
						ondo = true;
					}
					else{
						if(bidalitakoAgindua.equals("FIGHT")){
							pEgoera.borroka();
							ondo = true;
						}
						else{
							throw(new TeklaOkerra());
						}
					}
				}
			}
			catch(TeklaOkerra e){
				System.out.println("Hori ez da emandako aukera bat. Berriz saiatu");
			}
		}while(!ondo);
		
		return aldeEgin;
	}
	
	public boolean barkamenaEskatu(Etsaiak pEtsaia){ //MERCY //FUNCIONA
		boolean barkatuta = false;
		System.out.println(pEtsaia.izena+"-ren aurrean belaunikatu zara");
		System.out.println("+ Barkaidazu mesedez, utzidazu nire bidea jarraitzen");
		
		if(this.karisma >= 7 || pEtsaia.lagunaDa()){
			pEtsaia.lagunEgin();
			System.out.println("- Ongi da, barkatuta zaude, segi zure bidea.");
			barkatuta = true;
		}
		else{
			System.out.println("- Kar! Kar! Kar! Ze espero zenuen? Pasatzen uztea ezer egin gabe?");
			System.out.println("- Kar! Kar! Kar! Momentuz hemen geldituko zara");
		}
		return barkatuta;

	}
	
	public void hitzEgin(Etsaiak pEtsaia){ //FUNCIONA, ARREGLAR LISTA
		boolean ondo = false;
		int zenb = 0;
		Hitza hitz = null;
		
		while(!ondo){
			try{
				System.out.println("Zer esan nahi duzu?");
				pEtsaia.inprimatuHitzak();
				zenb = Teklatua.getTeklatua().irakurriInt("Sartu zenbakia mezedez", 0, pEtsaia.listaTamaina());
				hitz = pEtsaia.bilatuHitza(zenb);
				ondo = true;
			
			}
			catch(TeklaOkerra e){
				System.out.println("Hori ez da emandako aukera bat, berriz saiatu");
			}
		}
		
		if(hitz.ondorioaDu()){
			int efektua = hitz.ondorioaEgikaratu();
			Ondorio ondorio = hitz.getEfektua();
			this.egikaratuOndorioa(efektua, ondorio);
		}
		else{
			System.out.println("Esandakoak ez du inolako eraginik...");
		}
		
		
	}
	
	
	public void erasoEgin(Etsaiak pEtsaia){ //NO FUNCIONA
		int eras = 0;
		
		if(this.eraso.minEgin()){
			eras = Jokalaria.getJokalaria().erasoEgin(this.erasoa);
			eras = (eras*this.eraso.getMina()/(2));
			pEtsaia.minaJaso(eras);
		}
		else{
			System.out.println("Erasoak huts egin du!");
			pEtsaia.minaJaso(eras);
		}
		
	}
	
	public void egikaratuOndorioa(int pEfektua, Ondorio pOndorio){ //FUNCIONA
		boolean positibo = false;
		if(pEfektua > 0){
			positibo = true;
		}
		
		pOndorio.imprimatuDesk();
		
		if(pOndorio.erasoa()){
			this.erasoa = this.erasoa + pEfektua;
			if(positibo){
				System.out.println("Zure erasoa igo da!");
			}
			else{
				System.out.println("Oh! Zure erasoa jaitsi da...");
			}
			System.out.println("Erasoa orain " + this.erasoa + " da.");
		}
		else{
			if(pOndorio.karisma()){
				this.karisma = this.karisma + pEfektua;
				if(positibo){
					System.out.println("Zure karisma igo da!");
				}
				else{
					System.out.println("Oh! Zure karisma jaitsi da...");
				}
				System.out.println("Karisma orain " + this.karisma + " da.");
			}
			else{
				if(pOndorio.ps()){
					this.ps = this.ps + pEfektua;
					if(positibo){
						System.out.println("Zure ps-ak igo dira!");
					}
					else{
						System.out.println("Oh! Zure ps-ak jaitsi dira...");
					}
					System.out.println("Ps-ak orain " + this.ps + " dira.");
				}
			}
		}
	}

}
