package interfaz;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import modelo.Ball;
import modelo.Jugador;
import modelo.Personaje;

public class PanelMapa extends JPanel implements MouseListener{
	public final static String FONDO ="ims/imagenes/cancha.png";
	public final static String BALL ="ims/imagenes/ball.png";
	public final static String PLAYER1 ="ims/imagenes/1.png";
	public final static String PLAYER2 ="ims/imagenes/2.png";
	
	private VentanaJuego ventana;
	
	public PanelMapa(VentanaJuego ventana) {
		this.ventana =ventana;
		setPreferredSize(new Dimension(300,1000));
		setFocusable(true);
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		Ball pelota =ventana.getBall();
		Personaje amarillo =ventana.getJuego().getAmarillo();
		Personaje rojo =ventana.getJuego().getRojo();
		
		ImageIcon fondo =new ImageIcon(FONDO);
		ImageIcon ball=new ImageIcon(BALL);
		ImageIcon j1 =new ImageIcon(PLAYER1);
		ImageIcon j2=new ImageIcon(PLAYER2);

		g.drawImage(fondo.getImage(), 0, 0, null);
		g.drawImage(ball.getImage(), pelota.getA(), pelota.getB(), null);
		g.drawImage(j1.getImage(), amarillo.getPosX(), amarillo.getPosY(), null);
		g.drawImage(j2.getImage(), rojo.getPosX(), rojo.getPosY(), null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		ventana.getJuego().getAmarillo().moverPersonaje(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}
	
}
