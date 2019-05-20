package packproiektua;

public class Ondorio {
	//Atributuak
	private String deskribapena;
	private int psIgoJaitsi;
	private int erasoaIgoJaitsi;
	private int karismaIgoJaitsi;
	
	
	//Eraikitzailea
	public Ondorio(String pDeskribapen, int pPs, int pEraso, int pKarisma){
		this.deskribapena = pDeskribapen;
		this.psIgoJaitsi = pPs;
		this.erasoaIgoJaitsi = pEraso;
		this.karismaIgoJaitsi = pKarisma;
	}
	
	//Metodoa
	public int ondorioaEragin(){
		int ondorioa = 0;
		
		if(this.erasoa()){
			ondorioa = this.erasoaIgoJaitsi;
					
		}
		else if(this.karisma()){
				ondorioa = this.karismaIgoJaitsi;
		}
		else if(this.ps()){
			ondorioa = this.psIgoJaitsi;
		}
	
		return ondorioa;
	}
	
	public boolean ps(){
		return this.psIgoJaitsi != 0;
	}
	
	public boolean karisma(){
		return this.karismaIgoJaitsi != 0;
	}
	
	public boolean erasoa(){
		return this.erasoaIgoJaitsi != 0;
	}

	public void imprimatuDesk(){
		System.out.println(this.deskribapena);
	}
}
