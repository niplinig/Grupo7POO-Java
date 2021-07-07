import java.util.ArrayList;

public class Sensor{
//Atributos de sensores
//Un sensor puede aparecer mas de una vez, pero son objetos diferentes porque comparten ID pero no los demás atributos
	private String ID;
	private double co;
	private double huminity;
	private boolean light;
	private double lpg;
	private boolean motion;
	private double smoke;
	private double temp;
	private String fecha;

//Constructor de sensores
	public Sensor(String ID, double co, double huminity, boolean light, double lpg, boolean motion, double smoke, double temp, String fecha){
    this.ID = ID;
		this.co = co;
		this.huminity = huminity;
		this.light = light;
		this.lpg = lpg;
		this.motion = motion;
		this.smoke = smoke;
		this.temp = temp;
    this.fecha =fecha;
  }

//Agregar un metodo equals que compare los ID

//Getter (no se necesitan Setters)

public String getID() {
	return ID;
}

public double getCo() {
	return co;
}

public double getHuminity() {
	return huminity;
}

public boolean getLight() {
	return light;
}

public double getlpg() {
	return lpg;
}

public boolean getMotion() {
	return motion;
}

public double getSmoke() {
	return smoke;
}

public double getTemp() {
	return temp;
}

public String getFecha() {
	return fecha;
}

}