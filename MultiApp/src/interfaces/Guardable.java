package interfaces;

import java.io.IOException;

public interface Guardable {

	public void guardar(String nome, String conte) throws IOException;
	public void cargar(String nombre) throws IOException;
}
