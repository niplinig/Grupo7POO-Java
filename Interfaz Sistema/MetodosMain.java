/*Métodos para generar la interfaz del main
*Aun no completado.
*/

public static void Registrarse(){
        Scanner lector=new Scanner(System.in);
        System.out.println("Cree su id:");
        String id=lector.nextLine();        
    }
    public static Usuario IniciarSesion(){
        //Le pido al usuario que inrgrese su ID
        Scanner lector=new Scanner(System.in);
        System.out.println("Ingrese su id:");
        String id=lector.nextLine();
        //Busco si esta registrado si lo esta retorno el usuario
        for(Usuario u:usuariosRegistrados){
            if(u.getID().equals(id)){
                return u;
            }           
        }
        //Si en el loop for no encuentro un usuario existente
        //Pido que se registre
        System.out.println("Usuario no encontrado");
        //Retorno un null
        return null;
    }
    
    public static void programarNoti(Usuario u){
        System.out.println("Desea agregar dispositivos específicos? (S/N)");
        String eleccion=sc.nextLine();
        if(eleccion.equals("S")){
            System.out.println("Ingrese el id del dispositivo");
            String disp=sc.nextLine();
            if()
            u.vincularDispositivo();
            
        }
        
        
    }
    
    public static void Menu(){
        System.out.println("1-Programar Notificaciones");
        System.out.println("2-Generar Notificaciones");
        System.out.println("3-Desactivar Notificaciones");
        
        String opcion=sc.nextLine();
        switch(opcion){
            case "1":
                //LLamar programar Notificaciones
            case "2":
                //Generar Notificaciones
            case "3":
                //Desactivar notificaciones
                            
        }
        
        
    }
    
    /*Este método lo utilizo para entrar al sistema
    Si el inicio de sesión es incorrecto ingreso nulo, y en el main no avanzará
    hasta lograr un Acceso no nulo.
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
        case "2":
        u=IniciarSesion();
        break;               
        }
        return u;
    }
}
