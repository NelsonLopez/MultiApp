package interfaz;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
public class PanelEntretenimiento extends JPanel implements ActionListener{

	
	private JButton botones[];
	private VentanaPrincipal vent;
	public PanelEntretenimiento(VentanaPrincipal vent) {
		setPreferredSize(new Dimension(300, 400));
		setBorder(new TitledBorder("Entretenimiento"));
		setBackground(new Color(153, 217, 234));
		this.vent = vent;
		botones = new JButton[2];
		setLayout(new GridLayout(2, 0));
		
		inicializar();
	}

	
	
	public void inicializar() {
		
		
		botones[0] = new JButton();
		botones[0].setIcon(new ImageIcon("ims/nota.png"));
		botones[0].setToolTipText("Reproductor de Musica");
		botones[1] = new JButton();
		botones[1].setIcon(new ImageIcon("ims/box.png"));
		botones[1].setToolTipText("Juego");
		
		
		for (int i = 0; i < botones.length; i++) {
			
			add(botones[i]);
			botones[i].addActionListener(this);
		}
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == botones[0]) {
			
			vent.mostrarReproductor();
		
		}else if(e.getSource() == botones[1]) {
			
			vent.mostrarJuego();
			
		}
	}
}
