package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Conversor;
import modelo.DatosSalud;

public class DatosSaludTest {

	private  DatosSalud salud;
	private  double peso;
	private  double statura;
	
	public void setupEscenarioUno() {
		
		salud = new DatosSalud();
		peso= 53;
		statura = 1.73;
		salud.calcularIMC(peso, statura);
		
	}
	
	@Test
	public void testRevisarEstado() {
	
		setupEscenarioUno();
		
		String es = salud.revisarEstado();
		String me = salud.revisarEstado();
		assertEquals(me, es);	
	}
	
	@Test
	public void testDarIdeal() {
	
		setupEscenarioUno();
		
		String es = salud.darIdeal(statura);
		String me = salud.darIdeal(statura);
		assertEquals(me, es);	
	}
}
