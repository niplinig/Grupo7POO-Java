import java.util.ArrayList;

public class Sensor{

	String idDispositivo;
	ArrayList <float> listaCo = new ArrayList<>();
	ArrayList <float> listaHuminity = new ArrayList<>();
	ArrayList <boolean> listaLight = new ArrayList<>();
	ArrayList <float> listaLpg = new ArrayList<>();
	ArrayList <boolean> listaMotion = new ArrayList<>();
	ArrayList <float> listaSmoke = new ArrayList<>();
	ArrayList <float> listaTemp = new ArrayList<>();
	ArrayList <Fecha> listaFechas = new ArrayList<>();

	public Sensor(String idDispositivo, float co, float huminity, boolean light, float lpg, boolean motion, float smoke, float temp, Fecha fecha) {
		this.idDispositivo = idDispositivo;
		listaCo.add(co);
		listaHuminity.add(huminity);
		listaLight.add(light);
		listaLpg.add(lpg);
		listaMotion.add(motion);
		listaSmoke.add(smoke);
		listaTemp.add(temp);
		listaFechas.add(fecha);
	}

}