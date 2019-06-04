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
		boolean ondo = false;
		int zenb = 0;
		
		while (!ondo){
			try{
				System.out.println(pMezua);
		
				String zer = this.sc.nextLine();
				zenb = Integer.parseInt(zer);
		
				if(zenb > pHandiena || zenb < pTxikiena){
					throw (new TeklaOkerra());
				}
				ondo = true;
			}
			catch(NumberFormatException e1){
				System.out.println("Ez duzu zenbaki bat sartu...");
			}
		}
		return zenb;
	}
	
	public String baiEzIrakurri(){
		String erantzuna = " ";
		boolean ondo = false;
		
		while(!ondo){
			try{
				erantzuna = Teklatua.getTeklatua().irakurriString("Aukeratu: Bai   Ez");
				if(!erantzuna.equals("Bai")){
					if(!erantzuna.equals("Ez")){
						throw (new TeklaOkerra());
					}
				}
				ondo = true;
			}
			catch(TeklaOkerra e){
				System.out.println("Bai edo Ez erantzun behar duzu.");
			}
		}
		
		return erantzuna;
	}
	
	public String abIrakurri(){
		String erantzuna = " ";
		boolean ondo = false;
		
		while(!ondo){
			try{
				erantzuna = Teklatua.getTeklatua().irakurriString("Zer egin nahi duzu? a edo b");
				if(!erantzuna.equals("a")){
					if(!erantzuna.equals("b")){
						throw (new TeklaOkerra());
					}
				}
				ondo = true;
			}
			catch(TeklaOkerra e){
				System.out.println("a edo b erantzun behar duzu.");
			}
		}
		
		return erantzuna;
	}
}


