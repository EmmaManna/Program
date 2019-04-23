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
	public void gehituHitza(Hitza pHitza)throws ListanDago{
		Iterator<Hitza> itr = this.getIteradorea();
		Hitza hitz = null;
		
		if(!pHitza.nuluaDa()){
			while(itr.hasNext()){
				hitz = itr.next();
			
				if(hitz.izenBeraDu(pHitza)){
					throw(new ListanDago());
				}
		}	
		this.lista.add(pHitza);
		}
	}
	
	/*public Ondorio zerEsanDu(String pHitz){
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
	}*/
	
	public void inprimatuHitzak(){
		int kont = 0;
		Iterator<Hitza> itr = this.getIteradorea();
		Hitza hitz = null;
		
		while(itr.hasNext()){
			hitz = itr.next();
			System.out.print(kont+"- ");
			hitz.inprimatuIzena();
			kont = kont+1;
		}
	}
	
	public Hitza bilatuHitza(int pZenb){
		Hitza hitz = null;
		Iterator <Hitza> itr = this.getIteradorea();
		boolean aurkitua = false;
		int kont = 0;
		
		while(itr.hasNext() && !aurkitua){
			hitz = itr.next();
			
			if(kont == pZenb){
				aurkitua = true;
			}
			
			kont = kont+1;
		}
		
		return hitz;
	}
	
	public int tamaina(){
		Iterator<Hitza> itr = this.getIteradorea();
		int kont = 0;
		Hitza hitz = null;
		
		while(itr.hasNext()){
			hitz = itr.next();
		
			if(hitz.getIzena().equals("-")){
				kont = kont+1;
			}
		}
		return this.lista.size()-kont;
	}
	
	public int sizea(){
		return this.lista.size();
	}
}

