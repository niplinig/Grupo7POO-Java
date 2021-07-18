package LecturaArchivo;

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
        Co = Co.substring(2, Co.length() - 2);
        Humidity = Humidity.substring(2, Humidity.length() - 2);
        Light = Light.substring(2, Light.length() - 2);
        Lpg = Lpg.substring(2, Lpg.length() - 2);
        Motion = Motion.substring(2, Motion.length() - 2);
        Smoke = Smoke.substring(2, Smoke.length() - 2);
        Temp = Temp.substring(2, Temp.length() - 2);
        
        double CO = Double.parseDouble(Co);
        double HUMIDITY = Double.parseDouble(Humidity);
        boolean LIGHT = Boolean.parseBoolean(Light);
        double LPG = Double.parseDouble(Lpg);
        boolean MOTION = Boolean.parseBoolean(Motion);
        double SMOKE = Double.parseDouble(Smoke);
        double TEMP = Double.parseDouble(Temp);
        
        return new Conjunto(CO, HUMIDITY, LIGHT, LPG, MOTION, SMOKE, TEMP);
    }

    public double getPropiedadDouble(String propiedad) {
        
        double resultado;
        resultado = 0;
        
        switch (propiedad) {
            case "co":
                resultado = co;
                break;
            case "humidity":
                resultado = humidity;
                break;
            case "lpg":
                resultado = lpg;
                break;
            case "smoke":
                resultado = smoke;
                break;
            case "temp":
                resultado = temp;
                break;
        }
        return resultado;
    }

    public boolean getPropiedadBoolean(String propiedad) {
        
        boolean resultado;
        resultado = false;
        
        switch (propiedad) {
            case "light":
                resultado = light;
                break;
            case "motion":
                resultado = motion;
                break;
        }
        return resultado;
    }
}
