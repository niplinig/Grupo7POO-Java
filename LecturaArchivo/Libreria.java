package main;

import java.util.ArrayList;

public class Libreria {
    
    // La libreria tiene la lista de todos los dispositivos disponibles
    public static ArrayList <Dispositivo> listaDispositivos = new ArrayList<>();
    public static ArrayList <String> listaCodigoDispositivos = new ArrayList<>();
    
    /*
    Método que recibe un dispositivo
    Compara el dispositivo recibido con los dispositivos en la cadena de dispositivos
    Verifica si el dispositivo puede ser añadido a la lista
    Si el dispositivo no puede ser añadido significa que ya existe
    Por lo tanto actualiza los datos del dispositivo que se encuentra en lista
    */
    public static void addDevice(Dispositivo nuevoDispositivo) {
        
        if (nuevoDispositivo.puedeSerAnadido()) {
            listaDispositivos.add(nuevoDispositivo);
        }
        else {
            for (Dispositivo dispositivoEnLista : listaDispositivos) {
                if (nuevoDispositivo.equals(dispositivoEnLista)) {
                    dispositivoEnLista.listaObservaciones.addAll(nuevoDispositivo.listaObservaciones);
                }
            }
        }
    }
    
}
