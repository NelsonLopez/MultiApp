package hilo;

import java.util.ArrayList;
import java.util.List;

import interfaz.VentanaPrincipal;
import modelo.Icono;

public class HiloCabecera extends Thread {

	
	private Icono icono;
	private ArrayList<Icono> iconos;
	private VentanaPrincipal vent;
	
	public HiloCabecera(VentanaPrincipal vent, ArrayList<Icono> iconos) {
		
		this.vent =vent;;
		this.iconos = iconos;
	
	}

	
	
	public void run() {
	
		while(true) {
		for (int i = 0; i < iconos.size(); i++) {
			
		
			iconos.get(i).mover(vent.getAnimacion().getBounds());
			
		}
		
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vent.repaint();
	}
	
	}
	
}
