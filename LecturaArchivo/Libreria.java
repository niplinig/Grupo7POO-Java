package main;

import java.util.ArrayList;

public class Libreria {
    
    // La libreria tiene la lista de todos los dispositivos disponibles
    public static ArrayList <Dispositivo> listaDispositivos = new ArrayList<>();
    
    // Método que valida si un dispositivo existe en la listas de Dispositivos
    // Si existe en la lista de dispositivos devuelve falso
    // En el caso que no exista en la lista devuleve verdadero
    public static boolean sePuedeAnadir(Dispositivo d) {
        if (listaDispositivos.size() > 0 ) {
            for (Dispositivo dispositivo : listaDispositivos) {
                if (dispositivo.getCodigo().equals(d.getCodigo())) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
    
    public static void actualizarDispositivo(Dispositivo d) {
        if (listaDispositivos.size() > 0 ) {
            for (Dispositivo dispositivoEnLista : listaDispositivos) {
                if (dispositivoEnLista.getCodigo().equals(d.getCodigo())) {
                    ArrayList <Observacion> observacionesNuevas = d.listaObservaciones;
                    dispositivoEnLista.listaObservaciones.addAll(observacionesNuevas);
                }
            }
        }
    }
    
    public static void anadirDispositivo(Dispositivo d) {
        if (sePuedeAnadir(d)) {
            listaDispositivos.add(d);
        }
        else if(listaDispositivos.contains(d)) {
            actualizarDispositivo(d);
        }
    }
    
}
