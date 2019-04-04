package packproiektua;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaHitzak {
	//Atributuak
	private ArrayList<Hitza> lista;
	
	//Eraikitzailea
	public ListaHitzak() {
		this.lista = new ArrayList<Hitza>();
	}
	
	//getterrak eta setterrak
	private Iterator<Hitza> getIteradorea(){
		return this.lista.iterator();
	}
	
	//Metodoak
	public void gehituHitza(Hitza pHitza){
		Iterator<Hitza> itr = this.getIteradorea();
		Hitza hitz = null;
		boolean aurkitua = false;
		
		if(this.lista.size()<4){
			while(itr.hasNext() && !aurkitua){
				hitz = itr.next();
			
				if(hitz.izenBeraDu(pHitza)){
					aurkitua = true;
				}
			}
		
			if(!aurkitua){
				this.lista.add(pHitza);
			}
			else{
				System.out.println("Hitza bazegoen listan");
			}
		}
		else{
			System.out.println("Lau hitz daude jada");
		}
	}
	
	public Ondorio bilatuOndorio(String pIzena){ //zer egiten du?
		//TODO
	}
	
	public Ondorio zerEsanDu(String pHitz){
		//TODO
		Iterator<Hitza> itr=this.getIteradorea();
		Hitza hitzBerria; Ondorio emaitza=null;
		while (itr.hasNext()){
			hitzBerria=itr.next();
			if(hitzBerria.getIzena()==pHitz){
				emaitza=hitzBerria.getEfektua();
			}
		}
		return emaitza;
	}
}
