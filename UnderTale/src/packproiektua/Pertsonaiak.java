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

	//Metodoak
	/*public void borrokatu(){
		//TODO
		public boolean aldeEgin(){
			//TODO
			 int etsaiarenBizitza
			if(this.ps>)
		}
	}*/
	
	public void minaJaso(int pErasoa){
		this.ps = this.ps-pErasoa;
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
