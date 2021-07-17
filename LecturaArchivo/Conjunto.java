package main;

public class Conjunto {
    
    // Una conjunto de propiedades tiene 7 propiedades en total
    private double co;
    private double humidity;
    private double lpg;
    private double smoke;
    private double temp;
    private boolean light;
    private boolean motion;

    // Constructor recibe valores para las 7 propiedades
    // Actualiza las propiedades observables con los valores recibidos
    public Conjunto(
        double co,
        double humidity,
        boolean light,
        double lpg,
        boolean motion,
        double smoke,
        double temp
            ) {
            this.co = co;
            this.humidity = humidity;
            this.light = light;
            this.lpg = lpg;
            this.motion = motion;
            this.smoke = smoke;
            this.temp = temp;
    }
    
    // Sobreescritura del método toString()
    // Retorna una cadena de texto con el conjunto de propiedades
    @Override
    public String toString() {

        String Conjunto = "co: " + this.co + '\n' + 
                "humidity: " + this.humidity + '\n' +
                "ligt: " + this.light + '\n' +
                "lpg: " + this.lpg + '\n' +
                "motion: " + this.motion + '\n' +
                "smoke: " + this.smoke + '\n' +
                "temp: " + this.temp + '\n';

        return Conjunto;
    }
    
    // Método que recibe las propiedades observables como una cadena de texto.
    // A esta cadena de texto se le subtrae el primer y último caracter.
    // Después se pasa su valor de cadena de texto como un valor decimal o booleano
    // Como resultado devuelve una nueva observacion
    public static Conjunto convertirTexto(
        String Co,
        String Humidity,
        String Light,
        String Lpg,
        String Motion,
        String Smoke,
        String Temp
        ) {
        Co = Co.substring(1, Co.length() - 1);
        Humidity = Humidity.substring(1, Humidity.length() - 1);
        Light = Light.substring(1, Light.length() - 1);
        Lpg = Lpg.substring(1, Lpg.length() - 1);
        Motion = Motion.substring(1, Motion.length() - 1);
        Smoke = Smoke.substring(1, Smoke.length() - 1);
        Temp = Temp.substring(1, Temp.length() - 1);
        
        double CO = Double.parseDouble(Co);
        double HUMIDITY = Double.parseDouble(Humidity);
        boolean LIGHT = Boolean.parseBoolean(Light);
        double LPG = Double.parseDouble(Lpg);
        boolean MOTION = Boolean.parseBoolean(Motion);
        double SMOKE = Double.parseDouble(Smoke);
        double TEMP = Double.parseDouble(Temp);
        
        return new Conjunto(CO, HUMIDITY, LIGHT, LPG, MOTION, SMOKE, TEMP);
    }
}
