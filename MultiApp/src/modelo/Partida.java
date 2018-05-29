package modelo;

import java.util.ArrayList;

public class Partida {
	private int puntaje;
	private int nivelActual;
	private int velocidadRival;
	private Jugador inicial;
	private Ball ball;
	private Personaje[] personaje;
	
	public Partida() {
		ball =new Ball(500, 250);
		personaje = new Personaje[2];
		personaje[0] =new Personaje(200, 200);
		personaje[1] =new Personaje(700, 200);
		
		nivelActual=0;
		puntaje=0;
		velocidadRival =50;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public int getNivel() {
		calcularNivel();
		return nivelActual;
	}

	public void setNivelActual(int nivelActual) {
		this.nivelActual = nivelActual;
	}

	public int getVelocidadRival() {
		return velocidadRival;
	}

	public void setVelocidad(int velocidadPeces) {
		this.velocidadRival = velocidadPeces;
	}

	public Jugador getInicial() {
		return inicial;
	}

	public void setInicial(Jugador inicial) {
		this.inicial = inicial;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public Personaje[] getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje[] personaje) {
		this.personaje = personaje;
	}
	
	public boolean entroPorteria(int a, int b) {
		boolean hizoGol =false;
		boolean anchoPorteria =a>785 && a<815;
		boolean largoPorteria =b>255 && b<300;
		
		if(largoPorteria && anchoPorteria) {
			hizoGol =true;
		}
		
	return hizoGol;
	}

	
	public void calcularPuntaje(int x, int y) {
		if(entroPorteria(x, y)) 
			puntaje+=5;
	}
	
	public void calcularNivel() {
		if(puntaje==0) {
			nivelActual =0;
			
		}else if(puntaje>0 && puntaje<=170) {
			nivelActual =1;
		
		}else if(puntaje>170 && puntaje<=320){
			nivelActual=2;
		
		}else if(puntaje>320 && puntaje<=410) {
			nivelActual=3;
		
		}else  {
			nivelActual =4;
		}
	}
	
	public boolean aumentoNivel() {
		boolean aumento=false;
		
		if(puntaje==85 || puntaje==255 ||puntaje==340)
			aumento=true;
  		
		return aumento;
	}
	
	public void actualizarDificultad() {
		if(nivelActual==0) {
			velocidadRival=50;
		}else if(nivelActual==1) {
			velocidadRival=30;
		}else if(nivelActual==2) {
			velocidadRival =20;
		}else if(nivelActual==3) {
			velocidadRival =15;
		}else if(nivelActual==4) {
			velocidadRival =10;
		}
	}
}
