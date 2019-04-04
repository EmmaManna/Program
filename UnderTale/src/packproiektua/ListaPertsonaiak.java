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
	public void PertsonaiaGehitu(Pertsonaiak pPertsonaiak){
		Iterator<Pertsonaiak> itr = this.getIteradorea();
		boolean aurkitua = false;
		Pertsonaiak pertsonai = null;
		
		boolean etsaia = false;
		
		if(pPertsonaiak instanceof Etsaiak){
			pPertsonaiak = (Etsaiak)pPertsonaiak;
			etsaia = true;
		}
		else{
			if(pPertsonaiak instanceof Npc){
				pPertsonaiak = (Npc) pPertsonaiak;
			}
		}
		
		while(itr.hasNext() && !aurkitua){
			pertsonai = itr.next();
			
			if(pertsonai instanceof Etsaiak && etsaia){
				if(((Etsaiak) pertsonai).izenBeraDu(pPertsonaiak)){
					aurkitua = true;
				}
			}
			else{
				if(pertsonai instanceof Npc && !etsaia){
					pertsonai = (Npc) pertsonai;
					if(pertsonai.izenBeraDu(pPertsonaiak)){
						aurkitua = true;
					}
				}
			}
		}
		
		if(!aurkitua){
			this.lista.add(pPertsonaiak);
		}
		else{
			System.out.println("Etsaia listan dago jada");
		}
		
	}
}
