
package testCase;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import modelo.Aplicacion;

public class AplicacionTest {
	
	private Aplicacion app;
	
	public void setupEscenarioUno() {
		
		app = new Aplicacion();
		
	}

	
	@Test
	
	public void testLeerArchivo() {
		
		setupEscenarioUno();
		try {
			String[] no1 = app.leerArchivoDatos(new File("Files/Registros/Prueba.txt"));
			String[] no2 = app.leerArchivoDatos(new File("Files/Registros/Prueba.txt"));
			
			assertArrayEquals(no1, no2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void testLeerArchivoException() {
		
		setupEscenarioUno();
		try {
			String[] no1 = app.leerArchivoDatos(new File("Files/Registros/Prueb.txt"));
			
			
			fail(" No arroj");
		} catch (IOException e) {
			
		}
		
		
	}
}
