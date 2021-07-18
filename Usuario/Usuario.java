
package Usuario;

import Notificacion.Notificacion;
import LecturaArchivo.Dispositivo;
import java.util.ArrayList;
public class Usuario {
    private String id;
    private ArrayList <Dispositivo> dispAsociados=new ArrayList<>();
    private ArrayList <Notificacion> nProgramadas=new ArrayList<>();
    
    //Constructor, solo requiere el id para crear un usuario
    
    public Usuario(String id){
        this.id=id;
    }
    //Getters de los atributos de la clase Usuario.
     public String getID(){
        return id;
    }
     public ArrayList <Dispositivo> getListDisp(){
        return dispAsociados;
    }
    public ArrayList <Notificacion> getListNotis(){
        return nProgramadas;
    }
    
    //Métodos para añadir elementos a las listas objetos.
    
    public void vincularDispositivo(Dispositivo d){
        dispAsociados.add(d);
    }
    
    public void añadirNoti(Notificacion n){
        nProgramadas.add(n);
    }
    
}
