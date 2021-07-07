
import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static ArrayList<Sensor> sensores = new ArrayList<>();
	
  public static void main(String[] args) {
    
		
  }

  public static void añadirDispositivo(Usuario usuario,String ID){
    for(Sensor s:sensores){
      if(s.getID().equals(ID)){
        usuario.añadirDisp(s);
      }
    }
    

  }
}