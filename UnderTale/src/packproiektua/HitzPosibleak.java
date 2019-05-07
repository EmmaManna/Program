package packproiektua;

public class HitzPosibleak {
	//Atributuak
	private ListaHitzak lista;
	private static HitzPosibleak nireListaHitzak = null;
		
	//Eraikitzailea Singleton patroia
	private HitzPosibleak() {
		this.lista = new ListaHitzak();
	}
	
	//getterrak setterrak
	public static synchronized HitzPosibleak getHitzPosibleak(){
		if(nireListaHitzak == null){
			nireListaHitzak = new HitzPosibleak();
		}
		return nireListaHitzak;
	}
	
	//Metodoak
	public void gehituHitza(Hitza pHitza)throws ListanDago{
		this.lista.gehituHitza(pHitza);
	}
	
	public int tamaina(){
		return this.lista.sizea();
	}

}