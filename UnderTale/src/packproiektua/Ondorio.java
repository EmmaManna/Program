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
	public void ondorioaEragin(int pPS, int pKarisma, int pErasoa){
		//TODO
		pPS=pPS+this.psIgoJaitsi;
		pKarisma=pKarisma+this.karismaIgoJaitsi;
		pErasoa=pErasoa+this.erasoaIgoJaitsi;
	}

}
