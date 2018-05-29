package excepcion;

public class NoExisteNombreException extends Exception {

	private String nombre;
	
	public NoExisteNombreException(String nombre) {
		
		this.nombre = nombre;
	}
	
	
	public String getMessage() {
		
		return "No exite nota con nombre: " + nombre;
	}
}
