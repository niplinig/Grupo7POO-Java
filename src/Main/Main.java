package Main;

import Usuario.Usuario;
import Notificacion.NotificacionPropiedadObservable;
import Notificacion.NotificacionDispositivo;
import Notificacion.Notificacion;
import LecturaArchivo.Observacion;
import LecturaArchivo.Libreria;
import LecturaArchivo.LectorArchivo;
import LecturaArchivo.Dispositivo;
import LecturaArchivo.CreadorArchivo;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    /*
    
    Lista que contiene los usuarios que se registren en el sistema
    y donde se verifica si es que existen al momento de iniciar sesión.
    
    */
    public static ArrayList <Usuario> usuariosRegistrados=new ArrayList<>();
    //Objeto scanner qa usarse en todos los métodos relacionados con el main
    public static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        /*
        
        Lee el archivo en la ruta asigna, corre el lector, generando así las listas
        en la clase libreria.
        
        */
        System.out.println("Ingrese la ruta donde se encuentra el archivo .csv: " + '\n');
        String ruta = sc.nextLine();
        
        if (ruta.endsWith(".csv")) {
            
            LectorArchivo miArchivo = new LectorArchivo(ruta);
            miArchivo.LeerArchivo();
            
            /*

            Se trae desde libreria las listas que poseen los dispositivos y sus observaciones,
            y una lista que posee todos los códigos de los dispositivos (importante para realizar 
            validaciones).

            */

            //Sección de la interfaz para el ingreso al sistema
            System.out.println("BIENVENIDO - SISTEMA DE EMULACIÓN DE NOTIFICACIONES");
            Usuario u = Acceso();
            Menu(u, Libreria.listaCodigoDispositivos, Libreria.listaDispositivos);
            
        }
        
        else {
            System.out.println("Ruta incorrecta");
            System.out.println("Por favor agrege la extensión .csv al final del nombre del archivo");
        }  
    }
    
    /*
    
    Acceso es el método que le permite al usuario elegir entre si desea
    registrarse o iniciar sesión al momento que de correr el programa.
    
    */
    public static Usuario Acceso(){
        System.out.println("1-Registro de Usuario");
        System.out.println("2-Inicio Sesión");
        System.out.println("Opcion:");
        String opcion = sc.nextLine();
        Usuario u = null;
        
        switch(opcion){
            case "1":
            Registrarse();
            break;
            case "2":
        /*
        Retorno un usuario U dado que es aquel sobre el cual se va a trabajar,
        para vincular sus dispositivos favoritos y las notificaciones que el quiera generar. 
        */
            u = IniciarSesion();
            break;
        }
        /*
        
        Si el usuario elige la opción de iniciar sesión, y no se encontra dicho usuario
        IniciarSesion retorna null, mientras U no sea un objeto en condiciones, mediante
        recursividad se sigue ejecutando Acceso(), hasta que se registre un usuario e ingrese
        de manera correcta.
        
        */
        while(u == null) {
            u = Acceso();
        }
        return u;
    }
    
    /*
    
    Registrarse crea un objeto de clase U dentro de la lista registrado,
    gracias a esto puede hacer la validación de iniciar sesión.
    
    */
    public static void Registrarse() {
        //Pido el ingreso de un string ID, con el cual crearé un objeto Usuario.
        System.out.println("Cree su id:");
        String id=sc.nextLine();
        usuariosRegistrados.add(new Usuario(id));
        System.out.println("El usuario se ha registrado");
        System.out.println();
    }
    
    public static Usuario IniciarSesion() {
        
        //Se le pide al usuario que inrgrese su ID
        System.out.println("Ingrese su id:");
        String id=sc.nextLine();
        
        /*
        
        Busca si el usuario está registrado, si lo esta retorna el usuario
        para ello se recorren los usuarios registrados y se ccomparan las id, 
        si existe retorna dicho usuario para tratarlo como variable local.
        
        */
        for(Usuario u:usuariosRegistrados) {
            if(u.getID().equals(id)) {
                System.out.println("Ingreso Exitoso");
                System.out.println();
                return u;
            }           
        }
        
        /*
        
        Si en el loop for no se encuentra un usuario existente, se
        muestra un mensaje de error y retorna null.
        
        */
       System.out.println("Usuario no encontrado");
       System.out.println();
        //Retorno un null
        return null;
    }
    
    //Hasta aqui van las funciones de Acceso al sistema
    
    /*
    
    1: Programar Notificaciones
    2: Generar Notificaciones
    3: Desactivar Notificaciones
    Y uno añadido especial mio
    4: Agregar Dispositivos Favotiros (Este método separa el código que debería
    en programar notificaciones para que se menor)
    5: Cerrar Sesión (Acaba el programa) necesario para la condición para loopear este menú
    
    */
    
    public static void Menu(Usuario u, ArrayList <String> ids, ArrayList <Dispositivo> d) {
        /*
        
        El recibir este parámetro hace que todas las acciones
        se redirección hacia el usuario u
        
        */
        String opcion=" ";
        while(!opcion.equals("5")) {
            
            //Presento el menu disponible al usuario despues de iniciar sesión
            System.out.println("1: Programar Notificaciones");
            System.out.println("2: Generar Notificaciones");
            System.out.println("3: Desactivar Notificaciones");
            System.out.println("4: Agregar Dispositivos Favoritos");
            System.out.println("5: Cerrar Programa");
            System.out.println("Opcion: ");

            //El usuario elige su opción
            opcion=sc.nextLine();
            switch(opcion) {
                case "1":
                    programarNoti(u,ids);
                    break;
                case "2":
                    generarNotificaciones(u);
                    break;
                case "3":
                    desactivarNotificaciones(u);
                    break;
                case "4":
                    agregarDispositivos(u,ids,d);
                    break;

            }
                System.out.println();
        }
    }

    /*
    
    Método para agregar un dispositivo a los asociados a un usuario.
    Se pregunta cuantos dispositivos quiere agregar al usuario y se ejecuta
    Se verifica que el id que ingresado sea correcto y posterior se busca el dispositivo
    con ese ID y se agrega a la lista de Usuario
    
    */
    public static void agregarDispositivos(Usuario u, ArrayList <String >idDisp, ArrayList <Dispositivo> d) {
        System.out.println("Cuantos dispositivos desea agregar?: ");
        String cant=sc.nextLine();
        int i =Integer.parseInt(cant);
        while(i!=0){
            System.out.println("Ingrese el ID del dispositivo");
            String id=sc.nextLine();
            if(idDisp.contains(id)) {
                for(Dispositivo dp:d) {
                    if(dp.getCodigo().equals(id)) {
                        u.vincularDispositivo(dp);
                        System.out.println("El dispositivo a sido agregado");
                    }                 
                }
            }
            
            else{
                System.out.println("Dispositivo no encontrado");
            }
            i--;
        }            
    }
    
    /*
    
    Método para desactivar una notificacion que el usuiario ingrese por
    teclado, se verifica si la notificación existe en una lista de 
    notifiaciones para desactivarla.
    
    */
    public static void desactivarNotificaciones(Usuario u) {
        System.out.println("Ingrese el nombre de la notificación a desactivar");
        String nombre=sc.nextLine();
        for(Object n: u.getListNotis()) {
            Notificacion n2=(Notificacion) n;
            if(n2.getNombre().equals(nombre)) {
                n2.desactivarNoti();
            }
            
        }
        System.out.println("Desactivada correctamente");
        
    }
    
    /*
    
    Método para que el usuario pueda programar una notifiacion, se 
    solicita un nombre para la misma y luego se le pregunta qué tipo 
    de notifiacion quiere añadir.
    En caso de ser "Por Dispositivo" se solicita un ID del dispositivo y se crea
    una nueva notificacion con el nombre de notifiacion y el ID. Si es "Por Propiedad
    Observable" se le solicita una propiedad observable, una etiqueta para ser clasificada
    y valores para establecer un rango maximo y minimo. En ambos casos se
    realiza una validacion de ID o propiedad observable respectivamente.
    
    */
    public static void programarNoti(Usuario u, ArrayList <String> listaCodigosDispositivos){
        System.out.println("Ingrese el nombre de la notificacion");
        String nombre=sc.nextLine();
        
        System.out.println("Tipo de notificación");
        System.out.println("1-Por Dispositivo");
        System.out.println("2-Por Propiedad Observable");
        String opcion=sc.nextLine();
        
        switch(opcion) {
            case "1":
                System.out.println("Ingrese el ID del dispositivo: ");
                String id=sc.nextLine();
                Notificacion n1;
                if(listaCodigosDispositivos.contains(id)) {
                    
                    n1=new NotificacionDispositivo(nombre,id);
                    u.añadirNoti(n1);
                    System.out.println("Notificacion Agregada");
                }
                else{
                    System.out.println("Id incorrecto");
                }
                break;
            case "2":
                ArrayList <String> propiedades=new ArrayList<>();
                ArrayList <String> propiedadesBooleanas=new ArrayList<>();
                propiedades.add("co");
                propiedades.add("humidity");
                propiedades.add("lpg");
                propiedades.add("smoke");
                propiedades.add("temp");
                propiedadesBooleanas.add("light");
                propiedadesBooleanas.add("motion");
                System.out.println("Ingrese la propiedad");
                String propiedad=sc.nextLine();
                
                if(propiedades.contains(propiedad)) {
                    System.out.println("Ingrese su etiqueta: ");
                    String etiqueta=sc.nextLine();
                    System.out.println("Ingrese valor máx: ");
                    String max=sc.nextLine();
                    System.out.println("Ingrese valor min: ");
                    String min=sc.nextLine();
                    Notificacion n2=new NotificacionPropiedadObservable(nombre,propiedad,Double.parseDouble(min),Double.parseDouble(max));
                    u.añadirNoti(n2);
                    
                    System.out.println("Notificacion Agregada");

                }
                else if(propiedadesBooleanas.contains(propiedad)) {
                    System.out.println("Ingrese su etiqueta: ");
                    String etiqueta=sc.nextLine();
                    System.out.println("Valor True o False");
                    String valor=sc.nextLine();
                    valor=valor.toLowerCase();
                    if(valor.equals("true")) {
                        
                        Notificacion n=new NotificacionPropiedadObservable(nombre,propiedad,valor);
                        u.añadirNoti(n);
                        System.out.println("Notificacion Agregada");
                        
                    }
                    else if(valor.equals("false")) {
                        Notificacion n=new NotificacionPropiedadObservable(nombre,propiedad,valor);
                        u.añadirNoti(n);
                        System.out.println("Notificacion Agregada");
                    }
                    
                    
                }
                else{
                    System.out.println("Propiedad no válida");
                }           
                break;
        }
    }
    
    /*
    
    Método para generar un archivo con las notificaciones que pertenezcan 
     a un rango establecido de fechas por el usuario.
    
    */
    public static void generarNotificaciones(Usuario u) {
        System.out.println("Ingrese la fecha inicial");
        System.out.println("Dia: ");
        int diaI=sc.nextInt();
        System.out.println("Mes: ");
        int mesI=sc.nextInt();
        System.out.println("Año: ");
        int anioI=sc.nextInt();
        
        LocalDate fechaI=LocalDate.of(anioI,mesI,diaI);
        
        System.out.println("Ingrese la fecha final");
        System.out.println("Dia: ");
        int diaf=sc.nextInt();
        System.out.println("Mes: ");
        int mesf=sc.nextInt();
        System.out.println("Año: ");
        int aniof=sc.nextInt();
        
        LocalDate fechaF=LocalDate.of(aniof,mesf,diaf);
        
        for(Notificacion n: u.getListNotis()) {
            
            if(n instanceof NotificacionDispositivo && n.getStatus()) {
                
                NotificacionDispositivo n2=(NotificacionDispositivo) n;
                Dispositivo d=n2.getDispositivo();
                ArrayList <Observacion> validas=new ArrayList<>();
                
                for(Observacion o: d.listaObservaciones) {
                    if(o.getFecha().isAfter(fechaI) && o.getFecha().isBefore(fechaF)){
                        validas.add(o);
                    }

                }
                
                String texto=d.getCodigo()+'\n';
                for(Observacion o: validas) {
                    texto+=o.toString()+'\n';
                }
                
                System.out.println("Notificacion creada en carpeta Proyecto de NetBeans");
                CreadorArchivo.guardarArchivo(texto, n.getNombre()+".txt");
            }
            
            else if(n instanceof NotificacionPropiedadObservable && n.getStatus()) {
                NotificacionPropiedadObservable n2=(NotificacionPropiedadObservable) n;
                ArrayList<Observacion> datos=n2.establecerRango(u);
                
                String texto="";
                for(Observacion o: datos) {
                    texto+=o.toString()+'\n';
                }
                System.out.println("Notificacion creada en carpeta Proyecto de NetBeans");
                CreadorArchivo.guardarArchivo(texto, n.getNombre()+".txt");
            }
        }
    }
}