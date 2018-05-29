package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Calculadora;


public class CalculadoraTest {

	private Calculadora calcu;
	private double val1;
	private double val2;
	
	public void setupEscenarioUno() {
		
		calcu = new Calculadora();
		val1 = 23;
		val2 = 32;
		
	}
	@Test
	public void testSumar() {
		setupEscenarioUno();
		
		double re = calcu.sumar(val1, val2);
		assertTrue(re == 55);
	}
	
	public void testDividir() {
		setupEscenarioUno();
		
		double re = calcu.dividir(val1, val2);
		double prue = calcu.dividir(val1, val2);
		assertTrue(re == prue);
	}
	
	@Test
	public void testRestar() {
		setupEscenarioUno();
		
		double re = calcu.restar(val1, val2);
		assertTrue(re == -9);
	}
	@Test
	public void testMultiplicar() {
		setupEscenarioUno();
		
		double re = calcu.multiplicar(val1, val2);
		assertTrue(re ==736 );
	}


}
