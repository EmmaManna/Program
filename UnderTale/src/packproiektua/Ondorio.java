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
		else{
			if(this.karisma()){
				ondorioa = this.karismaIgoJaitsi;
			}
			else{
				if(this.ps()){
					ondorioa = this.psIgoJaitsi;
				}
			}
		}
		
		return ondorioa;
	}
	
	public boolean ps(){
		boolean ps = false;
		
		if(this.psIgoJaitsi != 0){
			ps = true;
		}
		
		return ps;
	}
	
	public boolean karisma(){
		boolean karisma = false;
		
		if(this.karismaIgoJaitsi != 0){
			karisma = true;
		}
		
		return karisma;
	}
	
	public boolean erasoa(){
		boolean erasoa = false;
		
		if(this.erasoaIgoJaitsi != 0){
			erasoa = true;
		}
		
		return erasoa;
	}

}
