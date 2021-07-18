package Notificacion;


import Notificacion.Notificacion;
import LecturaArchivo.Libreria;
import LecturaArchivo.Dispositivo;
import java.util.ArrayList;

public class NotificacionDispositivo extends Notificacion{
    
    private Dispositivo dispositivo;
    private String idDispositivo;
    
    public NotificacionDispositivo(String nombre, String codigoDispositivo) {
        super(nombre);
        this.dispositivo=encontrarDispositivo(codigoDispositivo);
        this.idDispositivo=codigoDispositivo;
        
    }
    
    public NotificacionDispositivo(String nombre, Dispositivo dispositivo) {
        super(nombre);
        this.dispositivo = dispositivo;
    }
    
    public String toString(){
        return this.dispositivo.toString();
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }
    public Dispositivo encontrarDispositivo(String codigo){
        int indice=Libreria.listaCodigoDispositivos.indexOf(codigo);
        
        return Libreria.listaDispositivos.get(indice);
            
    }
    
    
}
