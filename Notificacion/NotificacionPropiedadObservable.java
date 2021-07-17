package main;

import java.util.ArrayList;

public class NotificacionPropiedadObservable extends Notificacion{
    // La etiqueta nos dice el grado de importancia de la notificacion
    private String etiqueta;
    // La propiedad que el usuario selecciona de las multiples observaciones
    private String propiedad;
    // El valor máximo
    private int maximo = 0;
    // El valor mínimo
    private int minimo = 0;
    
    // Constructor completo, inicializa los atributos del rango
    public NotificacionPropiedadObservable(String nombre, int min, String etiqueta, String propetie, int max)  {
        super(nombre);
        this.etiqueta = etiqueta;
        this.propiedad = propetie;
        this.maximo = max;
        this.minimo = min;
    }
    
    // Constructor con el mínimo valor, inicializa solo él mínimo valor
    // Para realizar búsquedas con valores mayores al mínimo
    public NotificacionPropiedadObservable(String nombre, int min, String etiqueta, String propetie) {
        super(nombre);
        this.etiqueta = etiqueta;
        this.propiedad = propetie;
        this.minimo = min;
    }
    
    // Constructor con el máximo valor, inicializa solo el máximo valor
    // Para realizar búsquedas con valores menores al máximo
    public NotificacionPropiedadObservable(String nombre, String etiqueta, String propetie, int max){
        super(nombre);
        this.etiqueta = etiqueta;
        this.propiedad = propetie;
        this.maximo = max;
    }
    
    public ArrayList<Observacion> aplicarNPO(Usuario usuario) {
        ArrayList <Observacion> listaResultante = new ArrayList<>();
        
        String propiedaElegida = this.elegirPropiedad();
        
        if (!usuario.getListDisp().isEmpty()) {
            
            if (propiedaElegida.equals("double") ) {
                
                for (Dispositivo dispositivos : usuario.getListDisp()) {
                    
                    for (Observacion observacion: dispositivos.listaObservaciones) {
                        
                        if (minimo > 0 && maximo > 0) {
                            if(minimo < observacion.getConjunto().getPropiedadDouble(propiedad) && observacion.getConjunto().getPropiedadDouble(propiedad) < maximo) {
                                listaResultante.add(observacion);
                            }
                        }
                        
                        else if (minimo > 0 && maximo == 0) {
                            if (minimo < observacion.getConjunto().getPropiedadDouble(propiedad)) {
                                listaResultante.add(observacion);
                            }
                        }
                        
                        else if (minimo == 0 && maximo > 0) {
                            if (observacion.getConjunto().getPropiedadDouble(propiedad) < maximo) {
                                listaResultante.add(observacion);
                            }
                        }
                    }
                }
            }
            
            else if (propiedaElegida.equals("boolean")) {
                
                for (Dispositivo dispositivos : usuario.getListDisp()) {

                    for (Observacion observacion: dispositivos.listaObservaciones) {

                        if (observacion.getConjunto().getPropiedadBoolean(propiedad) == true) {

                            listaResultante.add(observacion);
                        }
                    }
                }
            }
        }        
        return listaResultante;
    }
    
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
