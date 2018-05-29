package interfaz;

import java.awt.*;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.MouseEvent;
import org.w3c.dom.views.AbstractView;

public class PanelAvatar extends JPanel{

	private String rutaDefecto;
	private String nombre;
	private ImageIcon user;
	public PanelAvatar(String nombre, String ruta) {
		
		setPreferredSize(new Dimension(300,400));
		
		nombre = nombre;
		rutaDefecto = ruta;
		user = new ImageIcon(rutaDefecto);
		setBorder(new TitledBorder(nombre));
		setBackground(new Color(153, 217, 234));

	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(user.getImage(), 0,0,getWidth(), getHeight(), this);
		
		setOpaque(false);
		repaint();
	}

	/**
	 * @return the rutaDefecto
	 */
	public String getRutaDefecto() {
		return rutaDefecto;
	}

	/**
	 * @param rutaDefecto the rutaDefecto to set
	 */
	public void setRutaDefecto(String rutaDefecto) {
		this.rutaDefecto = rutaDefecto;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
