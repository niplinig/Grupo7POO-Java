package main;

public class NotificacionDispositivo extends Notificacion{

    Dispositivo dispositivo;
    
    public NotificacionDispositivo(String nombre, String codigoDispositivo) {
        super(nombre);
        int indice = Libreria.listaDispositivos.indexOf(codigoDispositivo);
        this.dispositivo = Libreria.listaDispositivos.get(indice);
    }
    
    public NotificacionDispositivo(String nombre, Dispositivo dispositivo) {
        super(nombre);
        this.dispositivo = dispositivo;
    }
}
