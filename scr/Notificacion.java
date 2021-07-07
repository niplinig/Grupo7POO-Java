public class Notificacion {
	boolean estado = true;
	String etiqueta;
	String prioridad;

	public Notificacion(boolean estado, String etiqueta, String prioridad) {
		this.estado = estado;
		this.etiqueta = etiqueta;
		this.prioridad = prioridad;
	}

	public void imprimirNotificacion() {
		System.out.println("Notificacion");
		System.out.println("estado: " + this.estado);
		System.out.println("etiqueta: " + this.etiqueta);
		System.out.println("prioridad: " + this.prioridad);
	}

	public void establecerRango(int minimo, int maximo) {
	}

}