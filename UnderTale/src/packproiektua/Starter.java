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
	
	public int getXp(){
		return this.xp;
	}
	
	public int getKarisma(){
		return this.karisma;
	}
	
	public void experientziaIgo(){
		this.xp = this.xp+1;
		System.out.println("Zure experientzia orain "+this.xp+" da.");
	}
	
	public boolean aginduaEgin(Egoera pEgoera){ //FUNCIONA
		boolean aldeEgin = false;
		boolean ondo = false;
		String bidalitakoAgindua="";
		
		do{
		bidalitakoAgindua = Teklatua.getTeklatua().irakurriString("Zer egingo duzu:   MERCY   ACT   FIGHT");
		
			try{
				if(bidalitakoAgindua.equals("MERCY")){
					aldeEgin = this.barkamenaEskatu(pEgoera);
					ondo = true;
				}
				else{
					if(bidalitakoAgindua.equals("ACT")){
						this.hitzEgin(pEgoera);
						ondo = true;
					}
					else{
						if(bidalitakoAgindua.equals("FIGHT")){
							this.borroka(pEgoera);
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
	
	
	private boolean barkamenaEskatu(Egoera pEgoera){
		boolean barkatuta = false;
		
		if(pEgoera.bossDa()){
			System.out.println(pEgoera.etsaiarenIzena()+" Boss bat da, ezin duzu alde egin.");
		}
		else{
			System.out.println(pEgoera.etsaiarenIzena()+"-ren aurrean belaunikatu zara");
			System.out.println("+ Barkaidazu mesedez, utzidazu nire bidea jarraitzen");
			
			if(this.karisma >= 7 || pEgoera.lagunaDa()){
				pEgoera.lagunEgin();
				System.out.println("- Ongi da, barkatuta zaude, segi zure bidea.");
				barkatuta = true;
			}
			else{
				System.out.println("- Kar! Kar! Kar! Ze espero zenuen? Pasatzen uztea ezer egin gabe?");
				System.out.println("- Kar! Kar! Kar! Momentuz hemen geldituko zara");
			}	
		}
		
		return barkatuta;

	}
	
	private void hitzEgin(Egoera pEgoera){
		boolean ondo = false;
		int zenb = 0;
		Hitza hitz = null;
		
		if(pEgoera.listaTamaina() == 0){
			System.out.println("Ezin duzu " +pEgoera.etsaiarenIzena()+"-rekin hitz egin");
		}
		else{
			while(!ondo){
				try{
					System.out.println("Zer esan nahi duzu?");
					pEgoera.inprimatuHitzak();
					zenb = Teklatua.getTeklatua().irakurriInt("Sartu zenbakia mezedez", 0, pEgoera.listaTamaina()-1);
					hitz = pEgoera.bilatuHitza(zenb);
					ondo = true;
				
				}
				catch(TeklaOkerra e){
					System.out.println("Hori ez da emandako aukera bat, berriz saiatu");
				}
				catch(NumberFormatException e1){
					System.out.println("Hori ez da zenbaki bat");
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
		System.out.println(" ");
		pEgoera.erasoEgin();
		System.out.println(pEgoera.erasoarenIzena()+" erabili du!");
		ps = Jokalaria.getJokalaria().getPertsonaia().ps;
		System.out.println("Zure Ps-ak " +ps+ " dira.");
		
	}
	
	private void borroka(Egoera pEgoera){ //Bikoitia Jokalariaren txanda, bakoitia etsaiarena
		int txanda = 0;
		boolean amaitu = false;
		
		while(!amaitu){
			if(pEgoera.bikoitiaDa(txanda)){
				pEgoera.etsaiariErasotu();
			}
			else{
				pEgoera.erasoEgin();
			}
			
			if(pEgoera.hilDa()){
				System.out.println(pEgoera.etsaiarenIzena() + " hil da...");
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
	
	private void egikaratuOndorioa(int pEfektua, Ondorio pOndorio){
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
