
package Notificacion;
import LecturaArchivo.Observacion;
import java.util.ArrayList;
import Usuario.Usuario;

public class Notificacion {
    //Nombre para identificar y diferenciar las notificaciones en la lista del Usuario
    protected String nombre;
    //Toda notificacion empieza con un estado true
    protected boolean status=true;
    
    //Constructor de la notificación en su forma básica
    public Notificacion(String n){
        nombre=n;
        
    }
       
    //Método para desactivar la notificación
    public void desactivarNoti(){
        status=false;
    }
    public boolean getStatus(){
        return status;
    }
    public String getNombre(){
        return nombre;
    }
    public ArrayList<Observacion> establecerRango(Usuario u, double min, double max){
        return new ArrayList <Observacion>();
    }
    
    public String toString(){
        return "vacio";
    }
    
}
