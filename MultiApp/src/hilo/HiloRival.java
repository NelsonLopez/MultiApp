package hilo;

import interfaz.VentanaJuego;
import modelo.JuegoHockey;
import modelo.Jugador;

public class HiloRival extends Thread{

		private VentanaJuego ventana;
		private JuegoHockey  juego;
	
	public HiloRival(VentanaJuego ventana, JuegoHockey juego) {
		this.ventana = ventana;
		this.juego = juego;
	}

	public void run() {
		while(true) {	
			Jugador actual =ventana.getJuego().buscarPorNombre(ventana.getPanelOpciones().getActual());
			juego.getRojo().moverRival();
			int velocidad =actual.getPartida().getVelocidadRival();
			
			try {
				Thread.sleep(velocidad);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ventana.getPanel().repaint();
		}
	}
}
