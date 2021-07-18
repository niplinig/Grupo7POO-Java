package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class CreadorArchivo {
    
    public static void guardarArchivo(String textoAEscribir,String nombre) {
        try {
            FileWriter fw = new FileWriter(nombre,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            pw.println(textoAEscribir);
            pw.flush();
            pw.close();
            
            JOptionPane.showMessageDialog(null,"Archivo guardado");
        }
        catch(Exception E) {
            JOptionPane.showMessageDialog(null,"Archivo no guardado");
            
        }
    }
}
