package testCase;

import junit.framework.TestCase;
import modelo.Partida;

public class PartidaTest extends TestCase{
	private Partida partida;
	
	private void setupEscenario1() {
		partida =new Partida();
	}
	
	private void setupEscenario2() {
		partida =new Partida();
		partida.setPuntaje(330);
	}
	
	public void testEntroPorteria() {
		setupEscenario1();
		
		int a =790;
		int b =260;
		
		assertTrue(partida.entroPorteria(a, b));
	}
	
	public void testCalcularPuntaje() {
		setupEscenario1();
		
		int a =790;
		int b =260;
		
		partida.calcularPuntaje(a, b);
		
		assertTrue(partida.getPuntaje()==5);
	}
	
	
	public void  calcularNivel() {
		setupEscenario2();

		assertTrue(partida.getNivel()==3);
	}
	
	
}
