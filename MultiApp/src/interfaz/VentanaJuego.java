package interfaz;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import hilo.HiloBall;
import hilo.HiloRival;
import modelo.*;

//conectar esto con la ventana principal y que ella haga el enlace con la clase principal del mundo y esta a su vez con juego
public class VentanaJuego extends JDialog{
	private PanelMapa panelMapa;
	
	//modificar
	//private JuegoHockey juego;
	
	private PanelInfoJuego panelInfo;
	private PanelOpcionesJuego panelOpciones;
	private VentanaPrincipal vent;
	public VentanaJuego(VentanaPrincipal vent) {
		//juego =new JuegoHockey();
		//JuegoHockey juego=new JuegoHockey();
		setTitle("HockeyGame");
		setLayout(new BorderLayout());
		setSize(1000, 700);
		setResizable(true);
		this.vent = vent;
		panelMapa =new PanelMapa(this);
		panelInfo= new PanelInfoJuego(this);
		panelOpciones =new PanelOpcionesJuego(this);
		
		add(panelInfo, BorderLayout.NORTH);
		add(panelOpciones, BorderLayout.SOUTH);
		add(panelMapa, BorderLayout.CENTER);
	}
	
	public PanelMapa getPanel() {
		return panelMapa;
	}	
	
	public PanelInfoJuego getPanelInfo() {
		return panelInfo;
	}
	
	public Ball getBall() {
		return vent.getaplicacion().getJuego().getBall();
	}
	
	public JuegoHockey getJuego() {
		return vent.getaplicacion().getJuego();
	}
	
	public PanelOpcionesJuego getPanelOpciones() {
		return panelOpciones;
	}
	
	public void moverBall() {
			HiloBall hiloB= new HiloBall(this, getJuego());
			HiloRival hiloR =new HiloRival(this, getJuego());
			hiloB.start();
			hiloR.start();
		}
	

	

}
