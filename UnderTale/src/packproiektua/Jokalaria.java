package packproiektua;

public class Jokalaria {
	//Atributuak
	private Starter pertsonaia;
	private static Jokalaria nireJokalaria = null;
	
	
	//Eraikitzailea
	private Jokalaria() {
		String izena = Teklatua.getTeklatua().irakurriString("Zein da zure izena?");
		String mota = Teklatua.getTeklatua().irakurriString("Zein motatakoa zara?  Furro,  Influencer,  Informatikoa");

		this.pertsonaia = new Starter(100,20, izena, mota, 0, 0);
	}

	//Singleton
	public static synchronized Jokalaria getJokalaria(){
		if(nireJokalaria == null){
			nireJokalaria = new Jokalaria();
		}
		return nireJokalaria;
	}
	
	//Metodoak
	public void partidaJokatu(){
		//TODO
		
	}
	
	public void partidaHaiseratu(){
		//TODO
	}
	
	public void pertsonaiaSortu(){
		Jokalaria.getJokalaria();
	}
	
	public void aukeratu(){ //Bidean eskuina edo ezkerra aukeratu
		//return String???
		//TODO
	}
	
	public void etsaiekinTopatu(){
		//TODO
	}
	
	public void borrokaPantaila(){
		//TODO
	}
}
