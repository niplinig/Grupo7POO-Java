package LecturaArchivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreadorArchivo {
    // Método para crear un archivo,
    // Recibe como parámetros el texto a escrivbirse en el documento y el
    // nombre del archivo con su respectivo tipo de texto
    public static void guardarArchivo(String texto,String nombre) {
        try {
            FileWriter fw = new FileWriter(nombre,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(texto);
            pw.flush();
            pw.close();


        }
        catch(IOException E) {
            System.out.println("Archivo no creado");
        }
    }
}
