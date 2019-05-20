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
		if(this.hitzLista.sizea()>3){
			throw(new ElementuGehiegi());
		}
		
		this.hitzLista.gehituHitza(pHitza);
	}
	
	public boolean izenBeraDu(Etsaiak pEtsaia){
		return this.izena.equals(pEtsaia.izena);
	}
	
	public void erasoEgin(){
		int mina = 0;
		int ps = 0;
		
		if(this.eraso.minEgin()){
			mina = (this.erasoa*this.eraso.getMina()/(2));
			Jokalaria.getJokalaria().getPertsonaia().minaJaso(mina);
			
			System.out.println(this.eraso.getIzena()+" erabili du!");
			ps = Jokalaria.getJokalaria().getPertsonaia().ps;
			System.out.println("Zure Ps-ak " +ps+ " dira.");
		}
		else{
			System.out.println(this.izena+"-ren erasoak huts egin du!");
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
		return this.laguna;
	}

	public boolean bossDa(){
		return this.boss;
	}
}
