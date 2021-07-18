package main;

import java.util.ArrayList;

public class NotificacionPropiedadObservable extends Notificacion {

    private ArrayList<String> listaEtiquetas = new ArrayList<>();
    private String propiedad;
    
    private boolean propiedadBooleana;
    
    public NotificacionPropiedadObservable(String nombre, String propetie) {
        super(nombre);
        this.propiedad = propiedad;
    }
       
    public NotificacionPropiedadObservable(String nombre, String etiqueta, String propiedad, String valorBoleano) {
        super(nombre);
        this.propiedad = propiedad;
        this.propiedadBooleana = Boolean.parseBoolean(valorBoleano);
    }
    
    public ArrayList<Observacion> establecerRango(Usuario usuario, double minimo, double maximo) {
        
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

                        if (observacion.getConjunto().getPropiedadBoolean(propiedad) == propiedadBooleana) {

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
