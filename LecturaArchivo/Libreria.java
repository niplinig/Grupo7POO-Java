package LecturaArchivo;

import LecturaArchivo.Dispositivo;
import java.util.ArrayList;

public class Libreria {
    
    // La libreria tiene la lista de todos los dispositivos disponibles
    public static ArrayList <Dispositivo> listaDispositivos = new ArrayList<>();
    public static ArrayList <String> listaCodigoDispositivos = new ArrayList<>();
    
    // En caso de un dispositivo no estar en la lista es añadido, caso contrario se actualiza
    public static void anadirDispositivo(Dispositivo device) {
        if (device.puedeSerAnadido()) {
            listaDispositivos.add(device);
        }
        else {
            for (Dispositivo dispositivoEnLista: listaDispositivos) {
                if (device.equals(dispositivoEnLista)) {
                    dispositivoEnLista.listaObservaciones.addAll(device.getListaObservaciones());
                            
                            
                    
                    
                    
                }
            }
        }
    }
      
   

}
