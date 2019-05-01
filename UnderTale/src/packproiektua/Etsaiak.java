package packproiektua;

public class Etsaiak extends Pertsonaiak {
	//Atributuak
	private ListaHitzak hitzLista;
	private String deskripzioa;
	private boolean laguna;
	private boolean boss;
	
	//Eraikitzaileak
	public Etsaiak(int pPS, int pErasoa, String pIzena, Erasoa pEraso, String pMota, String pDeskripzio, boolean pLagun, boolean pBoss) {
		super(pPS, pErasoa, pIzena, pEraso, pMota);
		this.hitzLista = new ListaHitzak();
		this.deskripzioa = pDeskripzio;
		this.laguna = pLagun;
		this.boss = pBoss;
	}
	
	//metodoak
	public int getBizitza(){
		return this.ps;
	}
	
	public void deskripzioaEman(){
		System.out.println(this.deskripzioa);
	}
	
	
	public void gehituHitza(Hitza pHitza)throws ListanDago, ElementuGehiegi{
		if(this.hitzLista.sizea()<4){
			this.hitzLista.gehituHitza(pHitza);
		}
		else{
			throw(new ElementuGehiegi());
		}
	}
	
	public boolean izenBeraDu(Etsaiak pEtsaia){
		boolean bera = false;
		
		if(this.izena.equals(pEtsaia.izena)){
			bera = true;
		}
		return bera;
	}
	
	public void erasoEgin(){
		int mina = 0;
		
		if(this.eraso.minEgin()){
			mina = (this.erasoa*this.eraso.getMina()/(2));
			Jokalaria.getJokalaria().getPertsonaia().minaJaso(mina);
		}
		else{
			System.out.println("Erasoak huts egin du!");
			Jokalaria.getJokalaria().getPertsonaia().minaJaso(mina);
		}
	}
	
	public void inprimatuHitzak(){
		this.hitzLista.inprimatuHitzak();
	}
	
	public int listaTamaina(){
		return this.hitzLista.tamaina();
	}
	
	public Hitza bilatuHitza(int pZenb){
		return this.hitzLista.bilatuHitza(pZenb);
	}
	
	public void lagunEgin(){
		this.laguna = true;
	}
	
	public boolean lagunaDa(){
		boolean lagunaDa = false;
		
		if(this.laguna){
			lagunaDa = true;
		}
		
		return lagunaDa;
	}

	public boolean bossDa(){
		boolean boss = false;
		
		if(this.boss){
			boss = true;
		}
		
		return boss;
	}
}
