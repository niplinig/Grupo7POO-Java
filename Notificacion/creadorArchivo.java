package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class CreadroArchivo {
    public String texto;
    public String nombreArch; // Nombre archvio con ruta. Ej: "notificaciones.txt"
    

    
    public static void guardarArchivo(String texto,String nombreArch){
        try
        {
            FileWriter fw = new FileWriter(nombreArch,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            pw.println(texto);
            pw.flush();
            pw.close();
            
            JOptionPane.showMessageDialog(null,"Archivo guardado");
        }
        catch(Exception E)
        {
            JOptionPane.showMessageDialog(null,"Archivo no guardado");
            
        }
    }
