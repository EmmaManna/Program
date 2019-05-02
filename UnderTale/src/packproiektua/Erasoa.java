package packproiektua;


public class Erasoa {
	//Atributuak
	private String izena;
	private int mina;
	private int hutsa; //1-10 zenbakia
	
	//eraikitzailea
	public Erasoa(String pIzena, int pMina, int pHutsa) {
		this.izena = pIzena;
		this.mina = pMina;
		this.hutsa = pHutsa;
		//hau da dena lagunak!!
	}
	
	//getterrak
	public int getMina(){
		return this.mina;
	}
	
	public String getIzena(){
		return this.izena;
	}
	
	//metodoak
	public boolean nuluaDa(){
		boolean nulua = false;
		
		if(this.izena.equals("-")){
			nulua = true;
		}
		return nulua;
	}
	
	private boolean hutsEgin(){
		boolean emangoDio = false;
		Dadoa.getDadoa().bota();
		int zbk = Dadoa.getDadoa().getGoikoAldea();

		if(this.hutsa!=zbk){
			emangoDio=true;
		}
		return emangoDio;
	}

	public boolean minEgin(){
		return this.hutsEgin();
	}
	
	public boolean izenBeraDu(Erasoa pEraso){
		boolean bera = false;
		
		if(this.izena.equals(pEraso.izena)){
			bera = true;
		}
		
		return bera;
	}
	
	public void inprimatuIzena(){
		System.out.println(this.izena);
	}
}
