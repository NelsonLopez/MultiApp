package testCase;

import junit.framework.TestCase;
import modelo.Ball;
import modelo.Cancion;
import modelo.JuegoHockey;
import modelo.Jugador;
import excepcion.PuntajeNoExisteException;

public class JuegoHockeyTest extends TestCase {
	private JuegoHockey juego;
	
	private void setupEscenario1() {
		juego =new JuegoHockey();
	}
	
	private void setupEscenario2() {
		juego =new JuegoHockey();
		Jugador nuevo =new Jugador("steven");
		nuevo.getPartida().setPuntaje(16);
		
		juego.agregarJugador(nuevo);
	}
	

	public void testGetListaPuntajes() {
		setupEscenario1();
		assertTrue(juego.getListaPuntajes()!=null);
	}
	
	public void testAgregarJugador() {
		setupEscenario1();
		
		int numJugadoresAntes =juego.getNumJugadores();
		Jugador nuevo =new Jugador("nuevo");
		juego.agregarJugador(nuevo);
		int numJugadoresDespues =juego.getNumJugadores();
		
		assertTrue(numJugadoresAntes+1==numJugadoresDespues);
	}
	
	public void testBuscarPorNombre() {
		setupEscenario1();
		
		String nombre= "Jair";
		Jugador buscado =juego.buscarPorNombre(nombre);
		System.out.println(buscado.getNickname());
		
		assertEquals(buscado.getNickname(), nombre);
	}
	
	public void testBuscarJugador() {
		setupEscenario2();
		
		try {
			Jugador buscado =juego.buscarJugador(13);
			fail("El puntaje a buscar si existe");
		} catch (PuntajeNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
