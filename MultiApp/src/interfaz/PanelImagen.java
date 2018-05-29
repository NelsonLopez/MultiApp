package interfaz;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.*;

public class PanelImagen extends JPanel{	
	private JLabel imgCancion;
	
	public PanelImagen() {
		FlowLayout layout =new FlowLayout();
		layout.setHgap(70);
		layout.setVgap(20);
		setLayout(layout);
		setPreferredSize(new Dimension(100, 300));

		
		ImageIcon img =new ImageIcon("ims/disco.png");
		imgCancion =new JLabel("");
		imgCancion.setIcon(img);
		add(imgCancion);
	}
}
