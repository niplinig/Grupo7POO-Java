package Usuario;

import Notificacion.Notificacion;
import LecturaArchivo.Dispositivo;
import java.util.ArrayList;

public class Usuario {
    // Un usuario tiene un identificador una lista de dispositivos
    // y también cuenta con una lista de notificaciones
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

    //Métodos para añadir dispositivos a las listas de dispositivos asociados del usuario.
    public void vincularDispositivo(Dispositivo d){
        dispAsociados.add(d);
    }

    // Método que añade una Notificacion a la lista de Notificaciones programadas del ususario
    public void añadirNoti(Notificacion n){
        nProgramadas.add(n);
    }
}