package packproiektua;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaEgoerak {
	//Atributuak
	private ArrayList<Egoera> lista;
	private static ListaEgoerak nireListaEgoerak = null;

	
	//Eraikitzailea
	private ListaEgoerak() {
		this.lista = new ArrayList<Egoera>();
	}
	
	//Singleton patroia
	public static synchronized ListaEgoerak getListaEgoerak(){
		if(nireListaEgoerak == null){
			nireListaEgoerak = new ListaEgoerak();
		}
		return nireListaEgoerak;
	}
	
	private Iterator<Egoera> getIteradorea(){
		return this.lista.iterator();
	}
	
	public void gehituEgoera(Egoera pEgoera) throws ListanDago{
		Iterator<Egoera> itr = this.getIteradorea();
		Egoera ego = null;
		
		while(itr.hasNext()){
			ego = itr.next();
			
			if(ego.beraDa(pEgoera)){
				throw(new ListanDago());
			}
		}
		this.lista.add(pEgoera);
	}
	
	public Egoera hurrengoEgoera(int pZenbakia){
		Iterator<Egoera> itr = this.getIteradorea();
		Egoera egoera = null;
		int kont = 0;
		boolean aurkitua = false;
		
		if(this.lista.size() < pZenbakia-1){
				System.out.println("Egoera hori ez dago listan");
		}
		else{
			while(!aurkitua){
				egoera = itr.next();
			
				if(kont == pZenbakia){
					aurkitua = true;
				}
				kont = kont+1;
			}
		}
		
		return egoera;
		
	}

	public boolean egoeraBereziaDa(Egoera pEgoera){
		boolean da = false;
		
		if(this.lista.indexOf(pEgoera)==23 || this.lista.indexOf(pEgoera)==13){
			da = true;
		}
		return da;
	}
}
