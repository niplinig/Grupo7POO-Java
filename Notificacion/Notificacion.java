package main;


public class Notificacion {
    private Boolean estatus = true;
    private String nombre;
    
    public void desactivarNotificacion() {
        estatus = false;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public Notificacion(String nombre) {
        this.nombre = nombre;
    }
}
