package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class LectorArchivo {
    
    static ArrayList<Sensor> listSensores = new ArrayList<>();
    
    public static void LeerArchivo() {

        try {
            File archivo = new File("/home/pop/NetBeansProjects/Main/src/main/Archivo.csv");
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String id, co, humidity, light, lpg, motion, smoke, temp, fecha;
                String [] resultado = linea.split(",");

                id = resultado[1];
                co = resultado[2];
                humidity = resultado[3];
                light = resultado[4];
                lpg  = resultado[5];
                motion = resultado[6];
                smoke = resultado[7];
                temp = resultado[8];
                fecha = resultado[9];
                
                id = id.substring(1, id.length() - 1);
                co = co.substring(1, co.length() - 1);
                humidity = humidity.substring(1, humidity.length() - 1);
                light = light.substring(1, light.length() - 1);
                lpg = lpg.substring(1, lpg.length() - 1);
                motion = motion.substring(1, motion.length() - 1);
                smoke = smoke.substring(1, smoke.length() - 1);
                temp = temp.substring(1, temp.length() - 1);
                fecha = fecha.substring(1, fecha.length() - 1);

                double CO = Double.parseDouble(co);
                double HUMIDITY = Double.parseDouble(humidity);
                boolean LIGHT = Boolean.parseBoolean(light);
                double LPG = Double.parseDouble(lpg);
                boolean MOTION = Boolean.parseBoolean(motion);
                double SMOKE = Double.parseDouble(smoke);
                double TEMP = Double.parseDouble(temp);

                listSensores.add(new Sensor(id, CO, HUMIDITY, LIGHT, LPG, MOTION, SMOKE, TEMP, fecha));
            }

            lector.close();

        }

        catch (FileNotFoundException e) {
            System.out.println("A ocurrido un error.");
            e.printStackTrace();
        }
    }
}
