package packproiektua;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPertsonaiak {
	//Atributuak
	private ArrayList<Pertsonaiak> lista;
	private static ListaPertsonaiak nireListaPertsonaiak = null;
	
	//Eraikitzailea
	private ListaPertsonaiak() {
		this.lista = new ArrayList<Pertsonaiak>();
	}

	//getterrak eta setterrak
	public static synchronized ListaPertsonaiak getListaPertsonaiak(){
		if(nireListaPertsonaiak == null){
			nireListaPertsonaiak = new ListaPertsonaiak();
		}
		return nireListaPertsonaiak;
	}
	
	private Iterator<Pertsonaiak> getIteradorea(){
		return this.lista.iterator();
	}
	
	//Metodoak
	public void PertsonaiaGehitu(Pertsonaiak pPertsonaiak)throws ListanDago{
		Iterator<Pertsonaiak> itr = this.getIteradorea();
		Pertsonaiak pertsonai = null;
		
		boolean etsaia = false;
		
		if(pPertsonaiak instanceof Etsaiak){
			etsaia = true;
		}
		
		
		while(itr.hasNext()){
			pertsonai = itr.next();
			
			if(pertsonai instanceof Etsaiak && etsaia){
				if(((Etsaiak) pertsonai).izenBeraDu((Etsaiak) pPertsonaiak)){
					throw(new ListanDago());
				}
			}
			else{
				if(pertsonai instanceof Npc && !etsaia){
					if(((Npc)pertsonai).izenBeraDu((Npc)pPertsonaiak)){
						throw(new ListanDago());
					}
				}
			}
		}
		
		this.lista.add(pPertsonaiak);
	}
}
