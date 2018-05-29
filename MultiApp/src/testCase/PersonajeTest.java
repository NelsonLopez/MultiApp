package testCase;

import junit.framework.TestCase;
import modelo.Personaje;

public class PersonajeTest extends TestCase{

	private Personaje personaje;
	
	private void setupEscenario1() {
		personaje =new Personaje(205, 185);
	}
	
	public void  testMoverRival() {
		setupEscenario1();
		
		personaje.moverRival();
		
		assertTrue(personaje.getDireccion()==-1);
	}
}
