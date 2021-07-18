package LecturaArchivo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collector;

public class Dispositivo {
    
    // Un dispositivo cuenta con un código y una Lista de Observaciones.
    private String codigo;
    public ArrayList <Observacion> listaObservaciones = new ArrayList<>();
    
    // Consturctor que recibe un código y una lista de observaciones.
    // Inicializa los valores del codigo y el de la lista de observaciones.
    public Dispositivo(String codigo, Observacion observacion) {
        this.codigo = codigo;
        listaObservaciones.add(observacion);
        Libreria.anadirDispositivo(this);
    }
    
    // Sobreescritura del Método toString()
    // Primero se muestra el codigo del dispositivo.
    // Despues se muestra cada una de las observaciones de la lista.
    @Override
    public String toString() {
        String Dispositivo = this.codigo;
        for (Observacion observacion: listaObservaciones) {
            Dispositivo += '\n' + observacion.toString();
        }
        return Dispositivo;
    }
    
    // Sobrecarga del Método equals()
    // Compara si los dos dispositivos tienen el mismo código
    public boolean equals(Dispositivo d) {
        return this.codigo.equals(d.codigo);
    }
    
    // Método para obtener el código del dispositivo
    public String getCodigo() {
        return this.codigo;
    }
    // Método para crear un nuevo Dispositivo 
    // Recibe un codigo y la observacion 
    // En caso de exitir en la Libreria se busca y se retorna
    // En caso de no existir se genera un nuevo dispositivo
    
    public static Dispositivo crearDispositivo(String codigo, Observacion observacion) {
        if (Libreria.listaCodigoDispositivos.contains(codigo)) {
            int index = Libreria.listaCodigoDispositivos.indexOf(codigo);
            Dispositivo dispositivo = Libreria.listaDispositivos.get(index);
            dispositivo.listaObservaciones.add(observacion);
            return dispositivo;
        }
        else {
            return new Dispositivo(codigo, observacion);
        }
    }

    public ArrayList <LocalDate> getFechas() {
        
        ArrayList <LocalDate> listaFechas = new ArrayList<>();
        
        for (Observacion observacionEnLista: listaObservaciones) {
            listaFechas.add(observacionEnLista.getFecha());
        }
        return listaFechas;
    }
     public boolean puedeSerAnadido() {
        if (Libreria.listaCodigoDispositivos.size() > 0) {
                if (!Libreria.listaCodigoDispositivos.contains(this.getCodigo())) {
                    Libreria.listaCodigoDispositivos.add(this.getCodigo());
                    return true;
                }
                else {
                    return false;
                }  
        }
        else {
            Libreria.listaCodigoDispositivos.add(this.getCodigo());
            return true;
        }
    }

    public ArrayList<Observacion> getListaObservaciones() {
        return listaObservaciones;
    }
     
}

