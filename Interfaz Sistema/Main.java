package main;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    /*Lista que contiene los usuarios que se registren en el sistema
    y donde verificare si es que estos existen al momento de iniciar sesión
    */
    public static ArrayList <Usuario> usuariosRegistrados=new ArrayList<>();
    //Objeto scanner que usaré en todos mis métodos relacionados al main
    public static Scanner sc=new Scanner(System.in);
    


    public static void main(String[] args) {
        /*Leo mi archivo en la ruta asigna, corro el lector, generando así mis listas
        en la clase libreria
        */
        LectorArchivo miArchivo = new LectorArchivo("C:\\Users\\ggabo\\Documents\\ESPOL\\POO\\Proyecto\\iot_telemetry_data_new.csv");
        miArchivo.LeerArchivo();
        
        /*Traigo desde libreria mis listas que poseen los dispositivos y sus observaciones,
        y una lista que posee todos los códigos de los dispositivos (importante para 
        validaciones)
        */
        ArrayList<Dispositivo> dispositivos=Libreria.listaDispositivos;
        ArrayList<String> codDispositivos=Libreria.listaCodigoDispositivos;
        
        
        Usuario u=Acceso();
                
    }
    
    
    
    /*Acceso es el método que le permite al usuario elegir entre si desea
    registrarse o iniciar sesión al momento que se corre el programa
    */
    public static Usuario Acceso(){
        System.out.println("1-Registro de Usuario");
        System.out.println("2-Inicio Sesión");
        System.out.print("Opcion:");
        String opcion = sc.nextLine();
        Usuario u=null;
        switch(opcion){
        case "1":
        Registrarse();
        break;
        case "2":
        /*Retorno un usuario U dado que es aquel sobre el cual trabajaré,
        para vincular sus dispositivos favoritos a él y las notificaciones que el genere. 
        */
        u=IniciarSesion();
        break;
        }
        /*Si el usuario eligió la opción de iniciar sesión, y no se encontró dicho usuario
        IniciarSesion retorna null, mientras U no sea un objeto en condiciones, mediante
        recursividad sigo ejecutando Acceso(), hasta que se registre un usuario y se ingrese
        de manera correcta.
        */
        while(u==null){
            u=Acceso();
        

        }
        return u;
    }
    
    /*Registrarse crea un objeto de clase U dentro de la lista registrado,
    gracias a esto puede hacer la validación de iniciar sesión
    */
    public static void Registrarse(){
        //Pido el ingreso de un string ID, con el cual crearé un objeto Usuario.
        System.out.println("Cree su id:");
        String id=sc.nextLine();
        usuariosRegistrados.add(new Usuario(id));
        System.out.println("El usuario se ha registrado");
        System.out.println();
    }
    public static Usuario IniciarSesion(){
        //Le pido al usuario que inrgrese su ID
        System.out.println("Ingrese su id:");
        String id=sc.nextLine();
        /*Busco si esta registrado si lo esta retorno el usuario
        para ello recorro mis usuarios registrados y comparo los id, si coincide con alguno
        existe y retorno dicho usuario para tratarlo como variable local.
        */
        for(Usuario u:usuariosRegistrados){
            if(u.getID().equals(id)){
                System.out.println();
                return u;
            }           
        }
      /*Si en el loop for no encuentro un usuario existente
        muestro un mensaje de error y retorno nulo, por lo cual no puedo trabajar con eso
        */
       System.out.println("Usuario no encontrado");
       System.out.println();
        //Retorno un null
        return null;
    }
    
    
       
}
