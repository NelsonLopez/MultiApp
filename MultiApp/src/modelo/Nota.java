package modelo;

public class Nota {
	private String nombre;
	private String contenido;
	private Nota siguiente;
	
	
	public Nota (String nombre, String contenido) {
		this.nombre =nombre;
		this.contenido =contenido;
	}
	
	public void setSiguiente(Nota nuevo) {
		siguiente =nuevo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @return the siguiente
	 */
	public Nota getSiguiente() {
		return siguiente;
	}
	
	
}
