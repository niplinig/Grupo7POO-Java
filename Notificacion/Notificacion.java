package Notificacion;


public class Notificacion {
    //Toda notificacion empieza con un estado true
    protected boolean status=true;
       
    //Método para desactivar la notificación
    public void desactivarNoti(){
        status=false;
    }
    public boolean getStatus(){
        return status;
    }
    
}
