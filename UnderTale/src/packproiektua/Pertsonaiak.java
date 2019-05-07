package packproiektua;

public abstract class Pertsonaiak {
	//Atributuak
	protected int ps;
	protected int erasoa;
	protected String izena;
	protected Erasoa eraso;
	protected String mota;
	
	//Eraikitzailea
	public Pertsonaiak(int pPS, int pErasoa, String pIzena, Erasoa pEraso, String pMota) {
		this.ps = pPS;
		this.erasoa = pErasoa;
		this.izena = pIzena;
		this.eraso = pEraso;
		this.mota = pMota;
	}
	
	//Setterrak
	public void setIzenaAldatu(String pIzena){
		this.izena = pIzena;
	}
	
	public void setErasoa(Erasoa pEraso){
		this.eraso = pEraso;
	}

	public int getPs(){
		return this.ps;
	}
	
	public int getErasoa(){
		return this.erasoa;
	}
	
	//Metodoak
	
	public void minaJaso(int pErasoa){
		if(this.ps-pErasoa >= 0){
			this.ps = this.ps-pErasoa;
		}
		else{
			this.ps = 0;
		}
	}
	
	public void idatziIzena(){
		System.out.println(this.izena);
	}
	
	public boolean hilDa(){
		boolean hilda = false;
		
		if(this.ps <= 0){
			hilda = true;
		}
		return hilda;
	}
}
