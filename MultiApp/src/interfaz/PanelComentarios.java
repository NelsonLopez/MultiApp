package interfaz;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import interfaces.Constantes;
public class PanelComentarios extends JPanel {

	
	private ImageIcon cielo;
	private JLabel ima;
	private VentanaPrincipal vent;
	
	public PanelComentarios() {
		
		setPreferredSize(new Dimension(900, 120));
		cielo = new ImageIcon(Constantes.IMAGECIELO);
		setBackground(Color.CYAN);
		
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.drawImage(cielo.getImage(),0,0, getWidth(), getHeight(), this);
		g2.setColor(new Color(111,17,33));
		g2.fillOval(73, 30, 80, 80);
		g2.setFont(new Font("Tahoma", Font.BOLD, 90));
		g2.drawString("Multi App", 282, 90);
		g2.setColor(Color.RED);
		g2.fillOval(796, 35, 80, 80);
		
}

}
