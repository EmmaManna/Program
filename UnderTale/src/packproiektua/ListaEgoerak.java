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
	
	public int tamaina(){
		return this.lista.size();
	}
	
	public Egoera hurrengoEgoera(int pZenbakia){
		Iterator<Egoera> itr = this.getIteradorea();
		Egoera egoera = null;
		int kont = 0;
		boolean aurkitua = false;
		
		while(!aurkitua){
			egoera = itr.next();
			
			if(kont == pZenbakia){
				aurkitua = true;
			}
			kont = kont+1;
			
		}
		
		return egoera;
		
	}

	public boolean egoeraBereziaDa(Egoera pEgoera){
		boolean da = false;
		
		if(this.lista.indexOf(pEgoera)==17 || this.lista.indexOf(pEgoera)==8 || this.lista.indexOf(pEgoera)==5){
			da = true;
		}
		return da;
	}
	
	public boolean gaztelua(Egoera pEgoera){
		boolean gaztelua = false;
		
		if(this.lista.indexOf(pEgoera)==21){
			gaztelua = true;
		}
		
		return gaztelua;
	}
	
	public boolean flowey(Egoera pEgoera){
		boolean flowey = false;
		
		if(this.lista.indexOf(pEgoera)==3){
			flowey = true;
		}
		
		return flowey;
	}
	
	public boolean bifurk(Egoera pEgoera){
		boolean bifurk = false;
		
		if(this.lista.indexOf(pEgoera)==17){
			bifurk = true;
		}
		
		return bifurk;
	}
	
	public void reset(){
		this.lista.clear();
	}
}