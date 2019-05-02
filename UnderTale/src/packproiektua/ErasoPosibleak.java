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
	
	
	public void gehituErasoa(Erasoa pErasoa)throws ListanDago{
		Iterator<Erasoa> itr = this.getIteradorea();
		Erasoa eraso = null;
		
		if(!pErasoa.nuluaDa()){
			while(itr.hasNext()){
				eraso = itr.next();
			
				if(eraso.izenBeraDu(pErasoa)){
					throw(new ListanDago());
				}
			}
		this.lista.add(pErasoa);
		}
	}
	
	public void inprimatuErasoak(){
		Iterator<Erasoa> itr = this.getIteradorea();
		int kont = 0;
		Erasoa eraso = null;
		
		while(itr.hasNext()){
			eraso = itr.next();
			System.out.print(kont+"- ");
			eraso.inprimatuIzena();
			kont = kont+1;
		}
	}
	
	public int tamaina(){
		return this.lista.size();
	}
	
	
	public Erasoa aukeratuErasoa(int pZenb){
		Iterator<Erasoa> itr = this.getIteradorea();
		Erasoa eraso = null;
		int kont = 0;
		boolean aurkitua = false;
		
		while(itr.hasNext() && !aurkitua){
			eraso = itr.next();
			
			if(kont == pZenb){
				aurkitua = true;
			}
			kont = kont+1;
		}
		return eraso;
	}
}
