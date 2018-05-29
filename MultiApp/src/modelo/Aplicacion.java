package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Usuario
 *
 */
public class Aplicacion {
	
	//Relaciones
	
	private Usuario avatarRaiz;
	private Usuario jugador;
	private Usuario user;
	private ArrayList<File> listaRegistros;
	private JuegoHockey juego;
	//Constructor
	
	public Aplicacion() {
		
		
		listaRegistros = new ArrayList<>();
		datosRegistro();
		user = new Usuario("");
		avatarRaiz = new Avatar("", 0, 0, 0, "", "", "");
		jugador = new Jugador("");
		juego = new JuegoHockey();
	}
	
	
	/**
	 * @return the jugador
	 */
	public Usuario getJugador() {
		return jugador;
	}


	/**
	 * @return the juego
	 */
	public JuegoHockey getJuego() {
		return juego;
	}


	public Avatar getAvatar() {
		
		return (Avatar) avatarRaiz;
	}

	/**
	 * Este metodo se encarga de cargar los datos de usuarios regristrados.
	 */
	
	public void datosRegistro() {
		
		File carp = new File("Files/Registros");
		File[] dat= archivos(carp);
		
		for (int j = 0; j < dat.length; j++) {
			listaRegistros.add(dat[j]);
		}
		
	}
	/**
	 * Este metodo se encarga de almacenar en un arreglo los archivos con datos de los usuarios.
	 * @param ruta
	 * @return
	 */
	public File[] archivos(File ruta) {
		
		File[] arch = ruta.listFiles();
		
		return arch;
		
	}
	/**
	 * Este metodo se encarga de actualizar los datos del avatar.
	 * @param nombre
	 * @param peso
	 * @param statura
	 * @param edad
	 * @param genero
	 * @param id
	 */

	public void setDatosAvatar(String nombre, double peso, double statura, int edad, String genero, String id) {
		
		avatarRaiz.setNombre(nombre);
		((Avatar) avatarRaiz).setPeso(peso);
		((Avatar) avatarRaiz).setStatura(statura);
		((Avatar) avatarRaiz).setEdad(edad);
		((Avatar) avatarRaiz).setGenero(genero);
		((Avatar) avatarRaiz).setId(id);
		
		
	}
	
	
	/**
	 * @return the user
	 */
	public Usuario getUser() {
		return user;
	}
	/**
	 * Este metodo se encarga de agregar un avatar dado sus atributos
	 * @param nombre
	 * @param peso
	 * @param statura
	 * @param edad
	 * @param genero
	 * @param id
	 * @param imagen
	 */
	public void agregarAvatarObjeto(String nombre, double peso, double statura, int edad, String genero, String id, String imagen) {
		
		Avatar se = new Avatar( nombre, peso,  statura,  edad,  genero, id, imagen);
		
		if (avatarRaiz == null) {
			
				try {
					avatarRaiz = se;
					 File av = new File("Files/Registros/"+nombre+".txt");
					av.createNewFile();
					se.modificarArchivoAvatar(av, se, nombre);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			 
		}else {
			
		try {
			((Avatar) avatarRaiz).insertarAvatar(se, nombre);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}
		
	}
	/**
	 * Este metodo se encarga de leer un archivo con datos de usuarios
	 * @param regGuardado
	 * @return
	 * @throws IOException
	 */
	public String[] leerArchivoDatos(File regGuardado) throws IOException {
		
		FileReader read = new FileReader(regGuardado); // para  que el archivo pueda ser leido. 
		BufferedReader jum = new BufferedReader(read); // para poder leer el archivo
		 
		
		 ;
		 
		String linea= jum.readLine();
		String[] nick = null;

		while(linea != null) { // lee cada linea del documento hasta que sea null.
			 linea= jum.readLine();
			if(linea !=null) {
				nick =  linea.split(" ");
				}
			
		}

		return nick;
	}
	/**
	 * Este metodo se encarga de sobrecargar los usuarios del programa
	 */

	
	public void sobreCargarUsuarios() {
		
		for (int i = 0; i < listaRegistros.size(); i++) {
			
			String[] pr;
			try {
				File m = (File) listaRegistros.get(i);
				pr = leerArchivoDatos(m);
				
				Avatar ava =  new Avatar(pr[0], Double.parseDouble(pr[1]),  Double.parseDouble(pr[2]),  Integer.parseInt(pr[3]), pr[4], pr[6], pr[5]);
			
				//((Avatar) avatarRaiz).insertarAvatar(ava, nombre);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
}