package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import modelo.Calculadora;

public class CalcularNotasTest {

	private Calculadora calcu;
	private double val1;
	private double val2;
	
	public void setupEscenarioUno() {
		
		calcu = new Calculadora();
		val1 = 23;
		val2 = 32;
		
	}

	@Test
	public void testMultiplicar() {
		setupEscenarioUno();
		
		double re = calcu.multiplicar(val1, val2);
		double me = calcu.multiplicar(val1, val2);
		assertTrue(re == me );
	}

}
