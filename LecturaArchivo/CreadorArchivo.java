package LecturaArchivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class CreadorArchivo {
     /*Método para guaradar un archivo, el primer parametro especifica
     el texto a escribirse y el segundo el nombre del archivo, el mismo
     debe contener el tipo de archivo. Ej guardarArchivo("texto","nuevoTexto.txt")
    */
    public static void guardarArchivo(String texto,String nombre) {
        try {
            FileWriter fw = new FileWriter(nombre,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            pw.println(texto);
            pw.flush();
            pw.close();
            
            JOptionPane.showMessageDialog(null,"Archivo guardado");
        }
        catch(Exception E) {
            JOptionPane.showMessageDialog(null,"Archivo no guardado");
            
        }
    }
}
