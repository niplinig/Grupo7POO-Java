package Notificacion;

import ManejoArchivos.LectorArchivo;
import Sensores.Fecha;
import Sensores.Sensor;


public class NotificacionPorDispositivo extends Notificacion {
    //ID del dispositivo del cual extraere todas las observaciones
    private String dispositivo;
    /*Rangos de fechas para los cuales obtendre las observaciones del
    *dispositivo
    */
    private Fecha desde;
    private Fecha hasta;
    
    //Constructor de la notificación
    public NotificacionPorDispositivo(String id, Fecha f1, Fecha f2){
        dispositivo=id;
        desde=f1;
        hasta=f2;
        
    }
    
    //Método para la creación del archivo de la notificación
    public void creaciónArchivo(){
        //Recorro todos mis sensores y busco aquellos iguales (Son iguales si comparten id)       
        for(Sensor s:LectorArchivo.listSensores){
            //Compruebo a su vez que la observación de ese dispositivo este entre las fechas que pide el usuario.
            if(s.getID().equals(dispositivo)&& s.getFecha().antesFecha(hasta)&&s.getFecha().despuesFecha(desde)){
               /*Aqui implementar el código de escritura de las propiedades de s
                usando los getters
                */ 
            }            
        }     
        
        
    }
    
}
