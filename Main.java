
import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static ArrayList<Sensor> sensores = new ArrayList<>();
	
  public static void main(String[] args) {
    
		Sensor prueba = new Sensor("Nuevo Sensor", 0.0, 0.0, true, 0.0, true, 0.0,24,"18/03/2002  15:03");

   System.out.println(prueba); 

  }
}