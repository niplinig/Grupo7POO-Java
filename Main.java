class Main {
  public static void main(String[] args) {
    
		Notificacion notificacion1 = new Notificacion(true, "etiquta", "prioridad");
		Notificacion notificacion2 = new NotificacionPorDispositivo(true, "etiquta", "prioridad", false);
		Notificacion notificacion3 = new NotificacionPropiedadObservable(true, "etiquta", "prioridad", 50, 69);

		notificacion1.imprimirNotificacion();
		System.out.println("");
		notificacion2.imprimirNotificacion();
		System.out.println("");
		notificacion3.imprimirNotificacion();
		System.out.println("");
		notificacion3.establecerRango(1,2);
  }
}