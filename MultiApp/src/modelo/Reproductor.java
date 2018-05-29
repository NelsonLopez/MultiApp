package modelo;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Reproductor {
	//corregir estas constantes
	public static final String SONG1 ="ims/musica/1.wav";
	public static final String SONG2 ="ims/musica/2.wav";
	public static final String SONG3 ="ims/musica/3.wav";
	public static final String SONG4 ="ims/musica/4.wav";
	public static final String SONG5 ="ims/musica/5.wav";
	public static final String SONG6 ="ims/musica/6.wav";
	public static final String SONG7 ="ims/musica/7.wav";
	public static final String SONG8 ="ims/musica/8.wav";
	public static final String SONG9 ="ims/musica/9.wav";
	public static final String SONG10 ="ims/musica/10.wav";
	
		private Cancion primera;
		private Cancion ultima;
		private Cancion actual;
		private Clip clip; //Cancion actual en reproduccion
		private boolean estaReproduciendo;
		private int numCanciones;

	public Reproductor() {
		String[][] info =new String[9][3];
		info[0][0] ="Do I Wanna Know";
		info[1][0] ="Blame";
		info[2][0]="How Deep Is your Love";
		info[3][0]="Get Lucky";
		info[4][0]="One More Time";
		info[5][0]="Shape of You";
		info[6][0]="Sugar";
		info[7][0]="Sucker for Pain";
		info[8][0]= "Heathers";
		
		info[0][1] ="Eminem ft. Rihanna";
		info[1][1] ="Calvin Harris";
		info[2][1]="Arctic Monkeys";
		info[3][1]="Twenty One Pilots";
		info[4][1]="Arctic Monkeys";
		info[5][1]="Love again";
		info[6][1]="Martin Garrix";
		info[7][1]="Maroon 5";
		
		info[0][2] ="Pop";
		info[1][2] ="EDM";
		info[2][2]="Rock";
		info[3][2]="Rap";
		info[4][2]="Rock";
		info[5][2]="Pop";
		info[6][2]="EDM";
		info[7][2]="R&B";
		
		for(int i=0; i<9; i++) {
			add(new Cancion("ims/musica/"+(i+2)+".wav", info[i][0], info[i][1], info [i][2]));
		}	
		ultima =new Cancion(SONG10, "Stressed Out", "Twenty One Pilots", "Rap");
		actual =primera;

	}
	
	public boolean getEstado() {
		return estaReproduciendo;
	}
	
	public Cancion getActual() {
		return actual;
	}
	
	public int getNumCanciones() {
		return numCanciones;
	}
	
	public void setActual (Cancion nuevo) {
		actual =nuevo;
	}
	
	
	public void iniciar() {
		File cancion =new File(actual.getRuta());
		try {
			AudioInputStream cancionActual;
				cancionActual = AudioSystem.getAudioInputStream(cancion);
				clip= AudioSystem.getClip();
				clip.open(cancionActual);
				clip.start();
		}catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			((Throwable) e).printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add(Cancion nuevo) {
		if(primera!=null) {
			nuevo.setSiguiente(primera);
			nuevo.setAnterior(ultima);
			primera=nuevo;
		}else {
			primera= nuevo;
		}
		numCanciones++;
	}
	

	public void pausar() {
		if(clip!=null)
			clip.stop();
	}
	
	public void reproSiguiente() {
		if(actual.getSiguiente()==null) {
			actual =primera;
		}else {
			actual =actual.getSiguiente();
		}
		iniciar();
	}
	
	public void reproAnterior() {
		if(actual.getAnterior()==null) {
			actual =ultima;
		}else {
			actual =actual.getAnterior();
		}
		iniciar();
	}
	
	public void reproduciendo() {
		estaReproduciendo= true;
	}
	
	public Cancion buscarCancion(String nombreCancion) {
		Cancion buscada = null;
		Cancion actual =primera;
		boolean encontrada =false;
		
		if(ultima.getNombre().equalsIgnoreCase(nombreCancion)) {
			buscada =ultima;
		}else {
		
			while(actual!=null && !encontrada) {
				if(actual.getNombre().equalsIgnoreCase(nombreCancion)) {
					buscada = actual;
					encontrada =true;
				}
				actual =actual.getSiguiente();
			}
		}
		return buscada;
	}
}