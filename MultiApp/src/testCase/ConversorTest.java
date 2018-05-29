package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Calculadora;
import modelo.Conversor;

public class ConversorTest {

	private double temp;
	private Conversor conversor;
	public void setupEscenarioUno() {
		
		conversor = new Conversor();
		temp = 32;
		
	}
	@Test
	public void testcConvertirCelsiusFahrenheit() {

		setupEscenarioUno();
		
		double nu1 = conversor.convertirCelsiusFahrenheit(temp);
		
		double nu2 = conversor.convertirCelsiusFahrenheit(temp);
		
		assertTrue(nu1 == nu2);
		
	}
	
	@Test
	public void testconvertirCelciusKelvin() {
		
		setupEscenarioUno();
		
		double nu1 = conversor.convertirCelciusKelvin(temp);
		
		double nu2 = conversor.convertirCelciusKelvin(temp);
		
		assertTrue(nu1 == nu2);
		
	}
	@Test
	public void testconvertirKelvinCelcius() {
		
		setupEscenarioUno();
		
		double nu1 = conversor.convertirKelvinCelsius(temp);
		
		double nu2 = conversor.convertirKelvinCelsius(temp);
		
		assertTrue(nu1 == nu2);
		
	}
	@Test
	public void testconvertirKelvinFarenheit() {
		
		setupEscenarioUno();
		
		double nu1 = conversor.convertirKelvinFahrenheit(temp);
		
		double nu2 = conversor.convertirKelvinFahrenheit(temp);
		
		assertTrue(nu1 == nu2);
		
	}
	
	@Test
	public void testconvertirFarenheitKelvin() {
		
		setupEscenarioUno();
		
		double nu1 = conversor.convertirFahrenheitKelvin(temp);
		
		double nu2 = conversor.convertirFahrenheitKelvin(temp);
		
		assertTrue(nu1 == nu2);
		
	}
	
	
	@Test
	public void testconvertirFarenheitCelcius() {
		
		setupEscenarioUno();
		
		double nu1 = conversor.convertirFahrenheitCelsius(temp);
		
		double nu2 = conversor.convertirFahrenheitCelsius(temp);
		
		assertTrue(nu1 == nu2);
		
	}


}
