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

	public Sensor(String ID, float co, float huminity, boolean light, float lpg, boolean motion, float smoke, float temp, String fecha){
    this.ID=ID;
		this.co = co;
		this.huminity = huminity;
		this.light = light;
		this.lpg = lpg;
		this.motion = motion;
		this.smoke = smoke;
		this.temp = co;
  }

}