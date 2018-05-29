package hilo;

import interfaz.*;
import modelo.*;

public class HiloBall extends Thread{

		private VentanaJuego ventana;
		private JuegoHockey  juego;
		
	public HiloBall(VentanaJuego ventana, JuegoHockey juego) {
		this.ventana = ventana;
		this.juego = juego;
	}

	public void run() {
		
		while(true) {	
			int x =ventana.getJuego().getAmarillo().getPosX();
			int y =ventana.getJuego().getAmarillo().getPosY();
			int posXRival =ventana.getJuego().getRojo().getPosX();
			int posYRival =ventana.getJuego().getRojo().getPosY();
			
			juego.getBall().mover(x, y, posXRival, posYRival);
			
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			actualizarJuego(juego.getBall().getA(), juego.getBall().getB());
		}
	}
	
	public void actualizarJuego(int x, int y) {
		Jugador actual =ventana.getJuego().buscarPorNombre(ventana.getPanelOpciones().getActual());
		actual.getPartida().calcularPuntaje(x, y);
		actual.getPartida().calcularNivel();
		ventana.getPanelInfo().actualizarInformacion(actual);
		ventana.getPanel().repaint();
	}
}