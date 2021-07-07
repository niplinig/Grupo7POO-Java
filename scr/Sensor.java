import java.util.ArrayList;

public class Sensor{
//Atributos de sensores
//Un sensor puede aparecer mas de una vez, pero son objetos diferentes porque comparten ID pero no los demás atributos
	private String ID;
	private float co;
	private float huminity;
	private boolean light;
	private float lpg;
	private boolean motion;
	private float smoke;
	private float temp;
	private String fecha;

//Constructor de sensores
	public Sensor(String ID, float co, float huminity, boolean light, float lpg, boolean motion, float smoke, float temp, String fecha){
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

public float getCo() {
	return co;
}

public float getHuminity() {
	return huminity;
}

public boolean getLight() {
	return light;
}

public float getlpg() {
	return lpg;
}

public boolean getMotion() {
	return motion;
}

public float getSmoke() {
	return smoke;
}

public float getTemp() {
	return temp;
}

public String getFecha() {
	return fecha;
}

}