package Usuario;

import Sensores.Sensor;
import Notificaciones.Notificacion;
import java.util.ArrayList;


public class Usuario {
    //Atributos de la clase Usuario
    private String id;
    //La clase usuario es más de almacenamiento de los datos asociados con un usuario
    private ArrayList<String> dispAsociados=new ArrayList<>(); //Aqui talvez haya que cambiar por que cuando es
    //notificacion por dispositivo asociado solo es para los dispositivos asociados.
    private ArrayList<Notificacion> notificacionesUsuario=new ArrayList<>();
    
    //Constructor (Se utiliza al registrar un usuario)
    public Usuario(String id){
        this.id=id;
    }
    
    //Getter ID Utilizado para el inicio de sesión
    public String getID(){
        return id;
    }
    
    //Métodos para añadir datos a las listas
    public void vincularDispositivo(String id){
        dispAsociados.add(id);
    }
    
    public void añadirNotificacion(Notificacion n){
        notificacionesUsuario.add(n);
    }
    
    public ArrayList getListDisp(){
        return dispAsociados;
    }
    public ArrayList getListNotis(){
        return notificacionesUsuario;
    }
    
}
