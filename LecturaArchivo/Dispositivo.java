package main;

import java.util.ArrayList;

public class Dispositivo {
    
    // Un dispositivo cuenta con un código y una Lista de Observaciones
    private String codigo;
    public ArrayList <Observacion> listaObservaciones = new ArrayList<>();
    
    // Consturctor que recibe un código y una lista de observaciones
    // Inicializa los valores del codigo y el de la lista de observaciones
    public Dispositivo(String codigo, Observacion observacion) {
        this.codigo = codigo;
        listaObservaciones.add(observacion);
    }
    
    // Sobreescritura del Método toString()
    // Primero se muestra el codigo del dispositivo
    // Despues se muestra cada una de las observaciones de la lista
    @Override
    public String toString() {
        String Dispositivo = this.codigo;
        for (Observacion observacion: listaObservaciones) {
            Dispositivo = Dispositivo + '\n' + observacion.toString();
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
}
