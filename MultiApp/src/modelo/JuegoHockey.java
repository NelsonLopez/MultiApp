package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import excepcion.PuntajeNoExisteException;
import modelo.Jugador;

public class JuegoHockey {
	//juego tiene jugador y jugador tiene partida y juego tiene ball

	private Jugador raiz;
	private File archivoGamers;
	private int numJugadores;
	
	public JuegoHockey(){
		//prueba
		raiz =new Jugador("Jair");
		numJugadores++;
		
		//Inicialzar jugadores para lista
		Jugador j1 =new Jugador("j1");
		j1.getPartida().setPuntaje(40);
		
		Jugador j2 =new Jugador("j2");
		j2.getPartida().setPuntaje(60);

		Jugador j3 =new Jugador("j3");
		j3.getPartida().setPuntaje(50);

		agregarJugador(j1);
		agregarJugador(j2);
		agregarJugador(j3);

		
		archivoGamers =new File("Files/informacion/infoGamers.txt");
		
		//Deserialzacion
		try {
			ObjectInputStream ois =new ObjectInputStream(new FileInputStream("Files/informacion/infoEstadoJuego.txt"));
			raiz =(Jugador) ois.readObject();
			ois.close();
		}catch(FileNotFoundException e){
			e.getStackTrace();
		}catch(IOException e) {
			e.getStackTrace();
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	
	public Collection darListaSelecciones() {
		
		if(raiz == null)
			return null;
		
		else {
			
			Collection lista = new ArrayList();
			raiz.inorden(lista);
			return lista;
		}
		
	}
	public Jugador getRaiz() {
		return raiz;
	}
	
	public Ball getBall() {
		return raiz.getPartida().getBall();
	}
	
	public Personaje getAmarillo() {
		return raiz.getPartida().getPersonaje()[0];
	}
	
	public Personaje getRojo() {
		return raiz.getPartida().getPersonaje()[1];
	}
	
	public int getNumJugadores() {
		return numJugadores;
	}
	
	//Metodo que devuelve un arrayList de jugadores con los jugadores del arblo binario
	public ArrayList<Jugador> getListaPuntajes(){
		ArrayList<Jugador> lista =new ArrayList<Jugador>();
		
		raiz.recorrerArbol(lista);
		
		return lista;
	}
	
	public ArrayList<Jugador> ordenarPorSeleccion(ArrayList<Jugador> lista) {
		ArrayList<Jugador> ordenado =lista;
		int tamanio =ordenado.size();
		boolean termino =false;
		
		for(int i=0;i< tamanio-1; i++) {
			Jugador menor =ordenado.get(i);
			int cual =i;

			
			for(int j=i+1; j<tamanio && !termino; j++){
				Jugador aux1 =ordenado.get(j);
				if(aux1.getPuntajeAcum()<menor.getPuntajeAcum()) {
					ordenado.set(i, aux1);
					cual=j;
				}
			}
			
			Jugador temp =ordenado.get(i);
			ordenado.set(i, menor);
			ordenado.set(cual, temp);
		}
		return ordenado;
	}
	
	//Serializacion
	public void guardarInfoJuego()  {
		File infoJuego =new File("Files/informacion/infoEstadoJuego.txt");
		
		try {
			ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream(infoJuego));
			os.writeObject(raiz);
			os.close();
			
			System.out.println("Info del juego guardada");
			
		}catch(FileNotFoundException e ) {
			e.getStackTrace();
		}catch(IOException e) {
			e.getStackTrace();
		}
	}
	
	//Escritura de Files plano
	public void guardarInfoGamers() throws FileNotFoundException {
			String contenidoRaiz =""+raiz.getNickname()+" Puntaje: "+raiz.getPuntajeAcum()+" Nivel Alcanzado: "+raiz.getNivelLlegado();
			String contenidoOtros ="";
			
			raiz.infoAGuardar(contenidoOtros);
			String todo =contenidoRaiz+"\r"+contenidoOtros;
			
			
		PrintWriter escritor =new PrintWriter(archivoGamers);
		escritor.println(todo);
		escritor.close();
		System.out.println("Info del jugador guardada");
	}
	
	//lectura de archivo plano
	public String leerInfoGamers() throws IOException {
		String contenido ="";
		String linea ="";

		FileReader reader =new FileReader(archivoGamers);
		BufferedReader lector =new BufferedReader(reader);
		linea =lector.readLine();
		
		while(linea!=null) {
			contenido +=linea+"\n";
			linea =lector.readLine();
		}
		
		lector.close();
		reader.close();

		return contenido;
	}
	
	
	public void agregarJugador(Jugador nuevo) {
		raiz.add(nuevo);
		numJugadores++;
	}
	
	//Metodo buscarIterativo
	public Jugador buscarPorNombre(String nick) {
		Jugador buscado =null;
		
		if(nick!=null) {
			if(nick.equalsIgnoreCase(raiz.getNickname())) {
				buscado =raiz;
			}else {
				ArrayList<Jugador> lista =new ArrayList<Jugador>();
				raiz.recorrerArbol(lista);
				boolean encontrado =false;
			
				for(int i=0; i<lista.size() && !encontrado; i++) {
					if(lista.get(i).getNickname().equalsIgnoreCase(nick)) {
						buscado =lista.get(i);
						encontrado =true;
					}
				}
			}
	}else 
		buscado =raiz;
		
	return buscado;
	}
	
	
	public Jugador buscarJugador(int  puntaje) throws PuntajeNoExisteException{
		Jugador buscado =null;
		if(puntaje==raiz.getPuntajeAcum()) {
			buscado =raiz;
		}else {
			raiz.buscar(puntaje);
		}
		
		if(buscado ==null)
			 throw  new PuntajeNoExisteException(puntaje);
		return buscado;
	}
}
