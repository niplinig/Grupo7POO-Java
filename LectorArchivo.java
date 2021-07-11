import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class LectorArchivo {
    
    static ArrayList<Sensor> listSensores = new ArrayList<>();
    
    static ArrayList<String> listDispositivos = new ArrayList<>();
    static ArrayList<String> listCo = new ArrayList<>();
    static ArrayList<String> listHumidity = new ArrayList<>();
    static ArrayList<String> listLight = new ArrayList<>();
    static ArrayList<String> listLpg = new ArrayList<>();
    static ArrayList<String> listMotion = new ArrayList<>();
    static ArrayList<String> listSmoke = new ArrayList<>();
    static ArrayList<String> listTemp = new ArrayList<>();
    static ArrayList<String> listFecha = new ArrayList<>();
    
    public static void LeerArchivo() {

        try {
            File archivo = new File("/home/pop/NetBeansProjects/Main/src/main/Archivo.csv");
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String dispositivo, co, humidity, light, lpg, motion, smoke, temp, fecha;
                String [] resultado = linea.split(",");

                dispositivo = resultado[1];
                co = resultado[2];
                humidity = resultado[3];
                light = resultado[4];
                lpg  = resultado[5];
                motion = resultado[6];
                smoke = resultado[7];
                temp = resultado[8];
                fecha = resultado[9];

                listDispositivos.add(dispositivo);
                listCo.add(co);
                listHumidity.add(humidity);
                listLight.add(light);
                listLpg.add(lpg);
                listMotion.add(motion);
                listSmoke.add(smoke);
                listTemp.add(temp);
                listFecha.add(fecha);
            }

            lector.close();

        }

        catch (FileNotFoundException e) {
            System.out.println("A ocurrido un error.");
            e.printStackTrace();
        }
    }
    
    public static void creandoSensores() {
        
        for (int i = 0; i < listDispositivos.size(); i++) {
            
            String ID = listDispositivos.get(i);
            String CO = listCo.get(i);
            String HUMIDITY = listHumidity.get(i);
            String LIGHT = listLight.get(i);
            String LPG = listLpg.get(i);
            String MOTION = listMotion.get(i);
            String SMOKE = listSmoke.get(i);
            String TEMP = listTemp.get(i);
            String FECHA = listFecha.get(i);
            
            ID = ID.substring(1,ID.length() - 1);
            CO = CO.substring(1,CO.length() - 1);
            HUMIDITY = HUMIDITY.substring(1,HUMIDITY.length() - 1);
            LIGHT = LIGHT.substring(1,LIGHT.length() - 1);
            LPG = LPG.substring(1,LPG.length() - 1);
            MOTION = MOTION.substring(1,MOTION.length() - 1);
            SMOKE = SMOKE.substring(1,SMOKE.length() - 1);
            TEMP = TEMP.substring(1,TEMP.length() - 1);
            FECHA = FECHA.substring(1,FECHA.length() - 1);
            
            double _CO = Double.parseDouble(CO);
            double _HUMIDITY = Double.parseDouble(HUMIDITY);
            boolean _LIGHT = Boolean.parseBoolean(LIGHT);
            double _LPG = Double.parseDouble(LPG);
            boolean _MOTION = Boolean.parseBoolean(MOTION);
            double _SMOKE = Double.parseDouble(SMOKE);
            double _TEMP = Double.parseDouble(TEMP);
            
            listSensores.add(new Sensor(ID, _CO, _HUMIDITY, _LIGHT, _LPG, _MOTION, _SMOKE, _TEMP, FECHA));
        }
    }
}
