package packproiektua;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaEgoerak {
	//Atributuak
	private ArrayList<Egoera> lista;
	private static ListaEgoerak nireListaEgoerak = null;

	
	//Eraikitzailea
	private ListaEgoerak() {
		// TODO Auto-generated constructor stub
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
	
	public void gehituEgoera(Egoera pEgoera){
		boolean aurkitua = false;
		Iterator<Egoera> itr = this.getIteradorea();
		Egoera ego = null;
		
		while(itr.hasNext() && !aurkitua){
			ego = itr.next();
			
			if(ego.beraDa(pEgoera)){
				aurkitua = true;
			}
		}
		
		if(!aurkitua){
			this.lista.add(pEgoera);
		}
		
	}
	
	public Egoera hurrengoEgoera(int pZenbakia){
		Iterator<Egoera> itr = this.getIteradorea();
		Egoera egoera = null;
		int kont = 0;
		
		if(this.lista.size() < pZenbakia){
				System.out.println("Egoera hori ez dago listan");
			
		}
		else{
			while(pZenbakia <= kont){
				egoera = itr.next();
				kont = kont+1;
			}
		}
	
		
		return egoera;
		
	}

}
