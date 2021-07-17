package Notificacion;

public class Rango {
    private double min;
    private double max;
    
    public Rango(double min,double max){
        this.min=min;
        this.max=max;
    }
    //Getter para los atributos, útil para el momento de comparar rangos
    public double getMin(){
        return min;
    }
    public double getMax(){
        return max;
    }
    
    
}
