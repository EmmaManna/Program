package packproiektua;

import java.util.ArrayList;
import java.util.Iterator;


public class ErasoPosibleak {
	//Atributuak
	private ArrayList<Erasoa> lista;
	private static ErasoPosibleak nireListaErasoak = null;
	
	//Eraikitzailea Singleton patroia
	private ErasoPosibleak() {
		this.lista = new ArrayList<Erasoa>();
	}
	
	//getterrak setterrak
	public static synchronized ErasoPosibleak getErasoPosibleak(){
		if(nireListaErasoak == null){
			nireListaErasoak = new ErasoPosibleak();
		}
		return nireListaErasoak;
	}
	
	//Metodoak
	private Iterator<Erasoa> getIteradorea(){
		return this.lista.iterator();
	}
	
	
	public void gehituErasoa(Erasoa pErasoa){
		Iterator<Erasoa> itr = this.getIteradorea();
		Erasoa eraso = null;
		boolean aurkitua = false;
		
		if(this.lista.size() < 4){
			while(itr.hasNext() && !aurkitua){
				eraso = itr.next();
			
				if(eraso.izenBeraDu(pErasoa)){
					aurkitua = true;
				}
			}
		
			if(!aurkitua){
				this.lista.add(pErasoa);
			}
			else{
				System.out.println("Erasoa bazegoen listan");
			}
		}
		else{
			System.out.println("Lau eraso daude jada");
		}
	}
}
