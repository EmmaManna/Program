package packproiektua;
import java.util.Random;

public class Dadoa {
    //atributuak
	private int goikoAldea;
    private int aldeKopurua = 10;
    private static Dadoa nireDadoa = null;
    
    //metodo eraikitzaileak
    private Dadoa(){
    	
    }
    
    //getters && setters
   public static synchronized Dadoa getDadoa(){
	   if(nireDadoa == null){
		   nireDadoa = new Dadoa();
	   }
	   return nireDadoa;
   }
   
    
    public void setGoikoAldea(int pGoikoAldea){
    	this.goikoAldea=pGoikoAldea;
    }
    
    public int getGoikoAldea(){
    	return this.goikoAldea;
    }
    
    public int getAldeKopurua(){
    	return this.aldeKopurua;
    }
    
   
    public void bota(){
    	Random zenbakiRandomak=new Random();
    	int egungoBalioa;
    	egungoBalioa=zenbakiRandomak.nextInt(this.getAldeKopurua());
    	this.setGoikoAldea(egungoBalioa);   	
    }   
}

