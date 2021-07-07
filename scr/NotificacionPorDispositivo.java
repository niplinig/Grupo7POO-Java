public class NotificacionPorDispositivo extends Notificacion {

	boolean opcional;

	public NotificacionPorDispositivo(
		boolean estado,
		String etiqueta,
		String prioridad,
		boolean opcional)
		{
		super(estado, etiqueta, prioridad);
		this.opcional = opcional;
	}

	@Override
	public void imprimirNotificacion() {
		System.out.println("Notificacion por dispositivo");
		super.imprimirNotificacion();
		System.out.println("opcional: " + this.opcional);
	}

}