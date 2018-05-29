package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import excepcion.NoExisteNombreException;
import interfaces.Guardable;

import java.io.*;

public class BlockNotas implements Guardable {
	private Nota primera;
	private ArrayList<Nota> notas;;
	private ArrayList<File> listanotasFiles; 
	public BlockNotas() {	
	
		notas = new ArrayList<>();
		listanotasFiles = new ArrayList<>();
		
		datos();
		sobreCargarNotas() ;
		
		cargarListaEnlazadaNotas();
	}
	
	/**
	 * Este metodo se encarga de cargar los datos de notas regristrados.
	 */
	
	public void datos() {
		
		File carp = new File("Files/Notas");
		File[] dat= archivos(carp);
		
		for (int j = 0; j < dat.length; j++) {
			listanotasFiles.add(dat[j]);
		}
		
	}
	/**
	 * Este metodo se encarga de almacenar en un arreglo los archivos con notas de los usuarios.
	 * @param ruta
	 * @return
	 */
	public File[] archivos(File ruta) {
		
		File[] arch = ruta.listFiles();
		
		return arch;
		
	}
	/**
	 * Este metodo se encarga de sobrecargar las notas de usuarios del programa
	 */
	
	
public void sobreCargarNotas() {
		
		for (int i = 0; i < listanotasFiles.size(); i++) {
			
			String info;
			try {
				File m = (File) listanotasFiles.get(i);
				info = leerArchivoNota(m);
				Nota player =  new Nota(m.getName(), info);
			
				notas.add(player);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}

	/**
	 * Este metodo retorna la ultima nota de la lista
	 * @return
	 */
	public Nota localizarUltimoNota() {
		
		Nota actual = primera;
		
		if(actual != null) {
			while(actual.getSiguiente() != null ) {
				
				actual = actual.getSiguiente();
				
			}
			
		}
		
		return actual;
	}
	
	/**
	 * Este metodo agrega una nueva nota a lista
	 * @param nombre
	 * @param contenido
	 * @throws IOException
	 */
	public void agregarNota(String nombre, String contenido) throws IOException {
		
		Nota nuevo = new Nota(nombre, contenido);
		
		if(primera == null){
			
			
			primera = nuevo;
			guardar( nombre, contenido);
		}else {
			
			Nota player  = localizarUltimoNota();
			player.setSiguiente(nuevo);
			guardar( nombre, contenido);
		}
		
	}
	/**
	 * Este metodo agrega una nueva nota a lista
	 * @param nuevo
	 */
	public void agregarNotaObjeto(Nota nuevo)  {
		
		if(primera == null){
			
			
			primera = nuevo;
		}else {
			
			Nota player  = localizarUltimoNota();
			player.setSiguiente(nuevo);
		}
		
	}
	/**
	 * este metodo se encarga de spbrecargar la lista de notas
	 */
	public void cargarListaEnlazadaNotas() {
		
		for (int i = 0; i < notas.size(); i++) {
			
				agregarNotaObjeto((Nota)notas.get(i));
			
		}
	}
	

	
	@Override

	public void guardar(String nombre, String contenido) throws IOException {

		
		Nota not =  new Nota(nombre ,contenido);
			
			File datosNota = new File("Files/Notas/"+not.getNombre()+".txt");
			datosNota.createNewFile();
			
			modificarArchivo(datosNota, not);
				
		
	}
	/**
	 * Este metodo se encarga de modificar un archivo nota
	 * @param archivoNota
	 * @param nota
	 * @throws IOException
	 */
	public void modificarArchivo(File archivoNota, Nota nota) throws IOException {
		
		String contenido = nota.getContenido();
		
		FileReader read = new FileReader(archivoNota); // para  que el archivo pueda ser leido. 
		BufferedReader jum = new BufferedReader(read); // para poder leer el archivo
		PrintWriter escribir = new PrintWriter(archivoNota); //Para poder escbirir en el archivo 

		String linea =jum.readLine(); // lee cada linea del documento
		boolean mo = false;
		while(!mo) { // lee cada linea del documento hasta que sea null.
						
			if(linea ==null) {
			escribir.println(contenido ); 
			}
			mo = true;
		
			
		}
		
		jum.close();  // Siempre poner close() parta cerrar la acción. 
		read.close();
		escribir.close();
	
}
	/**
	 * este metodo se encarga de retorna la lista de notas
	 * @return
	 */
	public ArrayList<Nota> getlistaNotas(){
		
		ArrayList<Nota> sele = new ArrayList<Nota>();
		
		for (Nota i = primera; i != null; i = i.getSiguiente()) {
			
			sele.add(i);
			
		}
		return sele;
		
	}

	/**
	 * Este metodo se encarga de buscar una nota dado su nombre
	 * @param nombre
	 * @return
	 * @throws NoExisteNombreException
	 */
	public String buscarNotaPorNombre(String nombre ) throws NoExisteNombreException {
		ordenarPorNombre();
		boolean encontro =false;
		String notaBuscado = "";
		int inicio =0;
		int fin =ordenarPorNombre().size()-1;
		
		while(inicio<=fin && !encontro) {
				int medio =(inicio+fin)/2;
				String  nombreActual =ordenarPorNombre().get(medio).getNombre();
				
				if(nombreActual.equalsIgnoreCase(nombre+".txt") ){
					encontro =true;
					notaBuscado=  ordenarPorNombre().get(medio).getContenido();
				}else if(nombreActual.compareToIgnoreCase(nombre+".tx") > 0) {
					fin=medio-1;
				}else{
					inicio=medio+1;
				}
			}
				
		if(encontro==false) {
			throw new NoExisteNombreException(nombre);
		}
	return notaBuscado;	
	}

/**
 * Este metodo se encarga de retornar una liusta ordenada de notas
 * @return
 */
	
	public ArrayList<Nota> ordenarPorNombre(){
		ArrayList<Nota> ordenado = getlistaNotas();
		
		for(int i=ordenado.size(); i>0; i--) {
			for(int j=0; j<i-1; j++) {
				Nota j1 =ordenado.get(j);
				Nota j2 =ordenado.get(j+1);
				ComparadorNombre comp =new ComparadorNombre(); 

				if(comp.compare(j1, j2)<1) {
					Nota temp =getlistaNotas().get(j);
					getlistaNotas().set(j, getlistaNotas().get(j+1));
					getlistaNotas().set(j+1, temp);
				}
			}
		}
		return ordenado;
	}
	/**
	 * Este metodo se encarga de leer un archivo nota
	 * @param NotaGuardado
	 * @return
	 * @throws IOException
	 */
	public String leerArchivoNota(File NotaGuardado) throws IOException {
		
		FileReader read = new FileReader(NotaGuardado); 
		BufferedReader jum = new BufferedReader(read); 
		String retorno = "";
		String linea= "";
		while(linea != null) { 
			
			linea =jum.readLine();
			retorno += "\n"+	linea;		
			
		}
		
		return retorno;
		}
	
	@Override
	public void cargar(String nombre) throws IOException {
	
		
		
	}


	/**
	 * @return the listanotasFiles
	 */
	public ArrayList<File> getListanotasFiles() {
		return listanotasFiles;
	}


	/**
	 * @return the notas
	 */
	public ArrayList<Nota> getNotas() {
		return notas;
	}
	
	
}
