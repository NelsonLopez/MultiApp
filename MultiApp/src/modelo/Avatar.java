package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Avatar  extends Usuario {

	//Atributos
	
	
	private double statura; 
	private double peso;
	private int edad; 
	private String genero;
	private String id;
	private String imagen;
	//Relaciones
	
	private Calculadora calculadora; 
	private CalcularNotas calcularNotas;
	private Conversor convertirdor;
	private DatosSalud datosSalud; 
	private BlockNotas blockNotas;
//	private VisorLibros visorLibros;
	private Reproductor reproductor;
	private Avatar izquierda;
	private Avatar derecha;
	
	/**
	 * @param nombre
	 * @param statura
	 * @param peso
	 * @param edad
	 * @param genero
	 */
	public Avatar(String nombre, double statura, double peso, int edad, String genero, String id, String imagen) {
		super(nombre);
	
		this.statura = statura;
		this.peso = peso;
		this.edad = edad;
		this.genero = genero;
		this.calculadora = new Calculadora();
		this.convertirdor = new Conversor();
		this.calcularNotas = new CalcularNotas();
		this.datosSalud = new DatosSalud();
		this.blockNotas = new BlockNotas();
		this.reproductor = new Reproductor();
		this.derecha = null;
		this.izquierda = null;
		this.id = id;
		this.imagen = imagen;
	}
	
	
	/**
	 * @return the blockNotas
	 */
	public BlockNotas getBlockNotas() {
		return blockNotas;
	}


	/**
	 * @return the calcularNotas
	 */
	public CalcularNotas getCalcularNotas() {
		return calcularNotas;
	}

	

	/**
	 * @return the reproductor
	 */
	public Reproductor getReproductor() {
		return reproductor;
	}


	/**
	 * @return the calculadora
	 */
	public Calculadora getCalculadora() {
		return calculadora;
	}


	/**
	 * @return the convertirdor
	 */
	public Conversor getConvertirdor() {
		return convertirdor;
	}


	//Getter and Setter
	/**
	 * @return the statura
	 */
	public double getStatura() {
		return statura;
	}
	/**
	 * @param statura the statura to set
	 */
	public void setStatura(double statura) {
		this.statura = statura;
	}
	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @return the datosSalud
	 */
	public DatosSalud getDatosSalud() {
		return datosSalud;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	
/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}


	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


public void modificarArchivoAvatar(File archivoAvatar, Avatar avatar, String nombre) throws IOException {
		
		String peso = Double.toString(avatar.getPeso());
		String statura = Double.toString(avatar.getStatura());
		String edad = Integer.toString(avatar.getEdad());
		String genero = avatar.getGenero();
		String imagen = avatar.getImagen();
		String id = avatar.getId();
		
		FileReader read = new FileReader(archivoAvatar); // para  que el archivo pueda ser leido. 
		BufferedReader jum = new BufferedReader(read); // para poder leer el archivo
		PrintWriter escribir = new PrintWriter(archivoAvatar); //Para poder escbirir en el archivo 

		String linea =jum.readLine(); // lee cada linea del documento
		boolean mo = false;
		while(!mo) { // lee cada linea del documento hasta que sea null.
						
			if(linea ==null) {
			escribir.println("");
			escribir.println(nombre+ " "+peso+" "+statura+" "+ edad+" "+genero+" "+imagen+" "+id);
//			escribir.println(peso);
//			escribir.println(statura);
//			escribir.println(edad);
//			escribir.println(genero);
//			escribir.println(imagen);
			
			}
			mo = true;
		
			
		}
		
		jum.close();  // Siempre poner close() parta cerrar la acción. 
		read.close();
		escribir.close();
	
}
	public void insertarAvatar(Avatar nueva, String nombre) throws IOException {
	
		
		if(compareTo(nueva) > 0) {
			
			if(izquierda == null) {
				izquierda = nueva;
			File av = new File("Files/Registros/"+nombre+".txt");
			av.createNewFile();
			modificarArchivoAvatar(av, nueva, nombre);
			}else {
				izquierda.insertarAvatar(nueva, nombre);
				File av = new File("Files/Registros/"+nombre+".txt");
				av.createNewFile();
				modificarArchivoAvatar(av, nueva, nombre);
			}
		}else {
			
			if(derecha == null) {
				derecha =  nueva;
			File av = new File("Files/Registros/"+nombre+".txt");
			av.createNewFile();
			modificarArchivoAvatar(av, nueva, nombre);
			}else {
				derecha.insertarAvatar(nueva, nombre);
			File av = new File("Files/Registros/"+nombre+".txt");
			av.createNewFile();
			modificarArchivoAvatar(av, nueva, nombre);
			}
		}
		
		
		
	}
	
	

	public boolean esHoja() {
		
		return izquierda == null && derecha == null;
	}

	//Recursividad;
	public Avatar darMenor() {
		
		return (izquierda == null) ? this: izquierda.darMenor();
	}
	
	public Avatar darMayor() {
		
		return (derecha == null) ? this: derecha.darMayor();
	}
	

	public int compareTo(Avatar av) {
		
		return id.compareToIgnoreCase(av.getId());
	} 

}
