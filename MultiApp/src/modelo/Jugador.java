package modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Jugador extends Usuario {
	
	//hereda solo el atributo nickname
	private String nickname;
	private Partida miPartida;
	private Jugador der;
	private Jugador izq;

	
	public Jugador(String nick) {
		super(nick);
		miPartida =new Partida();
		this.nickname = nick;
	}
	
	public void inorden(Collection  lista) {
		
		if(izq != null)
			izq.inorden(lista);
		
		lista.add(nickname);
		
		if(der != null)
			der.inorden(lista);
		
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public int getPuntajeAcum () {		
		return miPartida.getPuntaje();
	}
	
	public int getNivelLlegado() {
		return miPartida.getNivel();
	}
	
	public Partida getPartida() {
		return miPartida;
	}
	
	public Jugador getDer() {
		return der;
	}
	
	public Jugador getIzq() {
		return izq;
	}
	
	public void setNick(String nuevo) {
		this.nickname =nuevo;
	}

	
	public void add(Jugador nuevo) {
		if(nuevo.getPuntajeAcum()>getPuntajeAcum()) {
			if(izq==null) {
				izq=nuevo;
			}else {
				izq.add(nuevo);
			}
		}else {
			if(der==null) {
				der=nuevo;
			}else {
				der.add(nuevo);
			}
		}
	}
	
	public Jugador buscar(int aBuscar) {
		int puntaje =getPuntajeAcum();
		if(puntaje== aBuscar )
			return this;
		
		else if( puntaje>aBuscar ) 
			return ( izq == null ) ? null : izq.buscar( aBuscar );
			
		else 
			return ( der == null ) ? null : der.buscar( aBuscar );
	
	}
	
	//Metodo recursivo de recorrer arbol inorden
	public void recorrerArbol( ArrayList<Jugador> lista) {
		if(izq!=null) 
			izq.recorrerArbol(lista);

		lista.add(this);

		if(der!=null) 
			der.recorrerArbol(lista);
		
	}
	
	//Metodo recursivo que retorna un String con el contenido a cargar en el archivo plano
	public void infoAGuardar(String info) {
		if(izq!=null) 
			izq.infoAGuardar(info);

		info =nickname+" Puntaje: "+getPuntajeAcum()+" Nivel Alcanzado: "+getNivelLlegado()+"\r";

		if(der!=null) 
			der.infoAGuardar(info);
	}
}
