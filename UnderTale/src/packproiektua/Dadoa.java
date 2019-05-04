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
    
    public String dadoarenLetra(){
    	String letra=" ";
    	Random zenbakiRandomak=new Random();
    	int egungoBalioa;
    	egungoBalioa=zenbakiRandomak.nextInt(this.getAldeKopurua());
    	
    	switch(egungoBalioa){
    	
    	case 0: return letra="g";
    	case 1: return letra="a";
    	case 2: return letra="w";
    	case 3: return letra="e";
    	case 4: return letra="f";
    	case 5: return letra="h";
    	case 6: return letra="b";
    	case 7: return letra="v";
    	case 8: return letra="q";
    	case 9: return letra="z";
    	case 10: return letra="k";
    	}
    	return letra;
    }
}

