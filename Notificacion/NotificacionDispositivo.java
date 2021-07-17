package main;

import java.time.LocalDate;
import java.util.ArrayList;

public class NotificacionDispositivo extends Notificacion{

    private ArrayList <NotificacionPropiedadObservable> Reglas;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;

    public NotificacionDispositivo(String nombre, LocalDate fechaInicial, LocalDate fechaFinal) {
        super(nombre);
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public ArrayList<Observacion> tomarUnRango(Usuario usuario) {
        
        ArrayList <Observacion> listaResultante = new ArrayList<>();
        
        if (!usuario.getListDisp().isEmpty()) {
            for (Dispositivo dispositivos : usuario.getListDisp()) {
                for (Observacion observacion: dispositivos.listaObservaciones) {
                    if (observacion.getFecha().isAfter(fechaInicial) && observacion.getFecha().isBefore(fechaFinal)) {
                        listaResultante.add(observacion);
                    }
                }
            }
        }        
        return listaResultante;
    }
}
