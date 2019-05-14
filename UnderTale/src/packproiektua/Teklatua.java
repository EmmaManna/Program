package packproiektua;


import java.util.Scanner;

public class Teklatua {
	//Atributuak
	private static Teklatua nireTeklatua = null;
	private Scanner sc;
	
	
	//Eraikitzailea
	private Teklatua() {
		this.sc = new Scanner(System.in);
	}

	//Singleton
	public static synchronized Teklatua getTeklatua(){
		if(nireTeklatua == null){
			nireTeklatua = new Teklatua();
		}
		return nireTeklatua;
	}
	
	public String irakurriString(String pMezua){
		System.out.println(pMezua);
		
		return this.sc.nextLine();
	}
	
	public int irakurriInt(String pMezua, int pTxikiena, int pHandiena) throws TeklaOkerra, NumberFormatException{
		System.out.println(pMezua);
		int zenb = 0;
		String zer = this.sc.nextLine();
		zenb = Integer.parseInt(zer);
		
		
		if(zenb > pHandiena || zenb < pTxikiena){
			throw (new TeklaOkerra());
		}
		return zenb;
	}
	
	public String baiEzIrakurri() throws TeklaOkerra{
		String erantzuna = " ";
		
		erantzuna = Teklatua.getTeklatua().irakurriString("Aukeratu: Bai   Ez");
		if(!erantzuna.equals("Bai")){
			if(!erantzuna.equals("Ez")){
				throw (new TeklaOkerra());
			}
		}
		
		return erantzuna;
	}
	
	public String abIrakurri() throws TeklaOkerra{
		String erantzuna = " ";
		
		erantzuna = Teklatua.getTeklatua().irakurriString("Zer egin nahi duzu? a edo b");
		if(!erantzuna.equals("a")){
			if(!erantzuna.equals("b")){
				throw (new TeklaOkerra());
			}
		}
		
		return erantzuna;
	}
}


