package excepcion;

public class PuntajeNoExisteException extends Exception{
	int puntaje;
	
	public PuntajeNoExisteException(int puntaje) {
		this.puntaje =puntaje;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
}
