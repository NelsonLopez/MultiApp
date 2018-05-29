package testCase;

import junit.framework.TestCase;
import modelo.Cancion;
import modelo.Reproductor;

public class ReproductorTest extends TestCase {
	
	private Reproductor repro;
	
	private void setupEscenario1() {
		repro = new Reproductor();
	}
	
	public void testAdd() {
		setupEscenario1();
		
		int numAntes= repro.getNumCanciones();
		Cancion nueva =new Cancion("", "", "", "");
		repro.add(nueva);
		
		int numDespues =repro.getNumCanciones();
		
		assertTrue(numAntes+1==numDespues);
	}
	
}
