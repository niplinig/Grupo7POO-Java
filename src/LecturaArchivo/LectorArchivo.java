package LecturaArchivo;

import LecturaArchivo.Dispositivo;
import LecturaArchivo.Conjunto;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectorArchivo {
    
    File miArchivo;
    Scanner miEscaner;
    private final String ruta;
    
    public LectorArchivo(String rutaDelArchivo) {
        miArchivo = new File(rutaDelArchivo);
        this.ruta = rutaDelArchivo;
    }
    
    /*
    Método que recibe un archivo para después leerlo
    Primero lee cada linea del archivo
    Cada linea es separada en dos partes
    Apartir de las partes generamos un codigo para el dispositivo y una observacion
    Y por último generamos un dispositivo con el codigo y la observacion
    */
    public void LeerArchivo() {
        if (ruta.endsWith(".csv")) {
            try {
                miEscaner = new Scanner(miArchivo);
                while (miEscaner.hasNextLine()) {
                    String linea = miEscaner.nextLine();
                    String [] lineaSeparada = separarLinea(linea);
                    String codigo=lineaSeparada[1].substring(2,lineaSeparada[1].length()-2);
                    
                    Conjunto conjunto = Conjunto.convertirTexto(lineaSeparada[2],
                            lineaSeparada[3],
                            lineaSeparada[4],
                            lineaSeparada[5],
                            lineaSeparada[6],
                            lineaSeparada[7],
                            lineaSeparada[8]);
                    
                    Observacion observacion = new Observacion(conjunto, lineaSeparada[9]);
                    Dispositivo.crearDispositivo(codigo, observacion);
                    /*
                        Libreria.listaDispositivos.add(dispositivo);                   
                        Libreria.listaCodigoDispositivos.add(lineaSeparada[1]);
                    */
                        
                }
                miEscaner.close();
            }
            catch (FileNotFoundException exception) {
            }
        }
    }
    
    // Método que recibe una línea del archivo
    // Separa la linea por "," comas
    // Devuelve un arreglo de la partes en las que la linea se separo
    public String [] separarLinea(String lineaASeparar) {
        String [] linea = lineaASeparar.split(",");
        return linea;
    }
}