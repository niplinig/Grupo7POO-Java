package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Observacion {
    
    // Una observacion tiene una propiedad y una fecha
    private Conjunto conjunto;
    private LocalDate fecha;
    
    // Método que recibe un texto que se parece a una fecha
    // Devuelve un objeto fecha a partir del texto recibido
    public static LocalDate convertirFecha(String texto) { 
        String [] textoSeparado = texto.split(" ");
        String fecha = textoSeparado[0];
        String[] fechaSeparada = fecha.split("/");

        String dia = fechaSeparada[0];
        String mes = fechaSeparada[1];
        String anio = fechaSeparada[2];

        int Dia = Integer.parseInt(dia);
        int Mes = Integer.parseInt(mes);
        int Anio = Integer.parseInt(anio);              

        LocalDate resultado = LocalDate.of(Anio, Mes, Dia);
        
        return resultado;
    }
    
    // Constructor recibe un Conjunto de propiedades y una fecha en texto
    // Inicializa el valor del conjunto
    // Utiliza el método convertirFecha() para convertir la fecha en texto a un objeto fecha
    public Observacion(Conjunto conjunto, String fechaTexto) {
        this.conjunto = conjunto;
        this.fecha = Observacion.convertirFecha(fechaTexto);
    }
    
    // Sobreescritura del método toString()
    // Primero convierte el objeto fecha a texto
    // Devuelve la fecha en texto junto con el conjunto de propiedades en texto
    @Override
    public String toString() {
        String fechaEnTexto = fecha.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String Observacion = fechaEnTexto + '\n' +conjunto.toString();
        return Observacion;
    }
    
    public LocalDate getFecha() {
        return this.fecha;
    }
    
    public Conjunto getConjunto() {
        return this.conjunto;
    }
    
}
