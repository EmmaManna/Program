package packproiektua;

public class Hitza {
	//Atributuak
	private String izena;
	private boolean ondorioa;
	private Ondorio efektua;
	
	//Eraikitzailea
	public Hitza(String pIzena, boolean pOndorioa, Ondorio pEfektua){
		this.izena = pIzena;
		this.ondorioa = pOndorioa;
		this.efektua = pEfektua;
	}
	
	//Metodoak
	public boolean izenBeraDu(Hitza pHitza){
		boolean bera = false;
		
		if(this.izena.equals(pHitza.izena)){
			bera = true;
		}
		
		return bera;
	}
	
	public String getIzena(){
		//TODO
		return this.izena;
	}
	
	public Ondorio getEfektua(){
		//TODO
		return this.efektua;
	}
	
	
	public boolean ondorioaDu(){
		return this.ondorioa;
	}
	
	public void inprimatuIzena(){
		System.out.println(this.izena);
	}
	
	public int ondorioaEgikaratu(){
		int efektua = 0;
		efektua = this.efektua.ondorioaEragin();
		
		return efektua;
	}

}
