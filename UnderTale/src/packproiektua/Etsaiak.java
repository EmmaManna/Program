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
	
	public void borrokatu(){
		//TODO
	}
	
	public void gehituHitza(Hitza pHitza){
		this.hitzLista.gehituHitza(pHitza);
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
			mina = (int) (this.erasoa*this.eraso.getMina()*(0.01));
			Jokalaria.getJokalaria().getPertsonaia().minaJaso(mina);
		}
		else{
			Jokalaria.getJokalaria().getPertsonaia().minaJaso(mina);
		}
	}

}
