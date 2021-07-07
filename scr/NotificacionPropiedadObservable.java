public class NotificacionPropiedadObservable extends Notificacion {
	
	int[] rangoEstablecido = new int[2];

	public NotificacionPropiedadObservable(
		boolean estado,
		String etiqueta,
		String prioridad,
		int minimo,
		int maximo)
		{
		super(estado, etiqueta, prioridad);
		this.rangoEstablecido[0] = minimo;
		this.rangoEstablecido[1] = maximo;
	}

	@Override
	public void establecerRango(int minimo, int maximo) {
		rangoEstablecido[0] = minimo;
		rangoEstablecido[1] = maximo;
		System.out.println("Nuevo rango: " + "[" + this.rangoEstablecido[0] + " ," + this.rangoEstablecido[1] + "]");
	}

	@Override
	public void imprimirNotificacion() {
		System.out.println("Notificacion por propiedad observable");
		super.imprimirNotificacion();
		System.out.println("rangoEstablecido: " + "[" + this.rangoEstablecido[0] + " ," + this.rangoEstablecido[1] + "]");
	}
}