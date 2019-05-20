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
	
	//Metodoak{
	public boolean nuluaDa(){
		return this.izena.equals("-");
	}
	
	public boolean izenBeraDu(Hitza pHitza){
		return this.izena.equals(pHitza.izena);
	}
	
	public String getIzena(){
		return this.izena;
	}
	
	public Ondorio getEfektua(){
		return this.efektua;
	}
	
	
	public boolean ondorioaDu(){
		return this.ondorioa;
	}
	
	public void inprimatuIzena(){
		if(!this.izena.equals("-")){
			System.out.println(this.izena);
		}
	}
	
	public int ondorioaEgikaratu(){
		return this.efektua.ondorioaEragin();
	}

}
