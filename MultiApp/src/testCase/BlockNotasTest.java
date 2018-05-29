
package testCase;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import excepcion.NoExisteNombreException;
import modelo.BlockNotas;
import modelo.Nota;

public class BlockNotasTest {

	private BlockNotas block;
	public void setupEscenarioUno() {
		
		
		block = new BlockNotas();
		
	}
	
	@Test
	public void testLocalizarUltimaNota() {
		setupEscenarioUno();
		Nota ul = block.localizarUltimoNota();
		Nota lu2 = block.localizarUltimoNota();
		
		assertTrue(ul == lu2);
		
	}
	
	@Test
	public void testLocalizarNotaPorNombre() {
		setupEscenarioUno();
		try {
			String not1 = block.buscarNotaPorNombre("jair");
			String no2 =  block.buscarNotaPorNombre("jair");
			
			assertEquals(not1, no2);
		} catch (NoExisteNombreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testLocalizarNotaPorNombreException() {
		setupEscenarioUno();
		try {
			String not1 = block.buscarNotaPorNombre("Melq");

			fail("Falle");
			
		} catch (NoExisteNombreException e) {
		
		}
		
		
	}
	
	@Test
	public void testleerArchivo() {
		setupEscenarioUno();
		
		try {
			String not = block.leerArchivoNota(new File("Files/Notas/jair.txt"));
			String not1 = block.leerArchivoNota(new File("Files/Notas/jair.txt"));
			
			assertEquals(not, not1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
