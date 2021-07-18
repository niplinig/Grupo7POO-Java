package Notificacion;

import Notificacion.Notificacion;
import LecturaArchivo.Observacion;
import LecturaArchivo.Dispositivo;
import java.util.ArrayList;
import Usuario.Usuario;

public class NotificacionPropiedadObservable extends Notificacion {

    private String Etiquetas;
    private String propiedad;
    private double max;
    private double min;
    
    private boolean propiedadBooleana;
    
    public NotificacionPropiedadObservable(String nombre, String propiedad,double min, double max) {
        super(nombre);
        this.propiedad = propiedad;
        this.max=max;
        this.min=min;
                
    }
    
    // Método que recibe un Usuario.
    // Primero revisa que la lista de dispositivos del Usuario no esté vacia
    // Despues se valida si es una propiedad double o boolean
    // Una vez validad la propiedad se realiza un recorrido de los dispostivos
    // Despues se rrecorre la lista de observaciones del dispostivio
    // Y por último se valida la propiedad que cumpla con los parametros dados
    // Devulve las observaciones que cumplen con la propiedad
    public ArrayList<Observacion> establecerRango(Usuario usuario) {
        
        ArrayList <Observacion> listaResultante = new ArrayList<>();
        
        String propiedaElegida = this.elegirPropiedad();
        
        if (!usuario.getListDisp().isEmpty()) {
            
            if (propiedaElegida.equals("double") ) {
                
                for (Dispositivo dispositivos : usuario.getListDisp()) {
                    
                    for (Observacion observacion: dispositivos.listaObservaciones) {
                        
                        if (this.min > 0 && this.max> 0) {
                            if(this.min < observacion.getConjunto().getPropiedadDouble(propiedad) && observacion.getConjunto().getPropiedadDouble(propiedad) < this.max) {
                                listaResultante.add(observacion);
                            }
                        }
                        
                        else if (this.min> 0 && this.max == 0) {
                            if (this.min < observacion.getConjunto().getPropiedadDouble(propiedad)) {
                                listaResultante.add(observacion);
                            }
                        }
                        
                        else if (this.min == 0 && this.max > 0) {
                            if (observacion.getConjunto().getPropiedadDouble(propiedad) < this.max) {
                                listaResultante.add(observacion);
                            }
                        }
                    }
                }
            }
            
            else if (propiedaElegida.equals("boolean")) {
                
                for (Dispositivo dispositivos : usuario.getListDisp()) {

                    for (Observacion observacion: dispositivos.listaObservaciones) {

                        if (observacion.getConjunto().getPropiedadBoolean(propiedad) == propiedadBooleana) {

                            listaResultante.add(observacion);
                        }
                    }
                }
            }
        }        
        return listaResultante;
    }
    // Método que diferencia entre los tipos de propiedades observables
    // Se los clasifica por su tipo de dato. 
    public String elegirPropiedad() {  
        
        String propiedadElegida;
        
        if (propiedad.equals("co") || propiedad.equals("humidity") || propiedad.equals("lpg") || propiedad.equals("smoke") || propiedad.equals("temp")) {
            return propiedadElegida = "double";
        }
        
        else if (propiedad.equals("light") || propiedad.equals("motion")) {
            return propiedadElegida = "boolean";
        }
        return propiedadElegida = "";
    }
}
