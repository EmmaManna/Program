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
	
	public int irakurriInt(String pMezua, int pTxikiena, int pHandiena) throws TeklaOkerra{
		System.out.println(pMezua);
		int zenb = this.sc.nextInt();
		
		if(zenb > pHandiena || zenb < pTxikiena){
			throw (new TeklaOkerra());
		}
		return zenb;
	}
}


