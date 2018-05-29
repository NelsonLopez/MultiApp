package interfaz;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import interfaces.Constantes;
import modelo.Icono;
public class PanelAnimacion extends JPanel implements MouseListener, Constantes{

	private ImageIcon cielo;
	private JLabel ima;
	private VentanaPrincipal vent;
	public PanelAnimacion(VentanaPrincipal vent) {
		
		
		setPreferredSize(new Dimension(900, 150));
		cielo = new ImageIcon(Constantes.IMAGENAVES);
		ima = new JLabel();
		this.vent = vent;
		add(ima);
		addMouseListener(this);
		
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		
		g.drawImage(cielo.getImage(),0,0, getWidth(), getHeight(), this);
		
		
		for (int i = 0; i < vent.getaplicacion().getAvatar().darIconos().size(); i++) {
			
		Icono ico = vent.getaplicacion().getUser().darIconos().get(i);
		ImageIcon ima = new ImageIcon(ico.getName());
		g.drawImage(ima.getImage(), ico.getPosX(), ico.getPosY(), this);
			
			
			
		}
		setOpaque(false);
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX()+" "+ e.getY());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
