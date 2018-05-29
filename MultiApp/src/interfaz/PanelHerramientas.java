package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelHerramientas extends JPanel implements ActionListener{

	public JButton botones[]; 
	public VentanaPrincipal vent;
	public PanelHerramientas(VentanaPrincipal vent) {
		
		setPreferredSize(new Dimension(300, 400));
		setBorder(new TitledBorder("Herramientas"));
		setBackground(new Color(153, 217, 234));
		this.vent = vent;
		botones = new JButton[6];
		
		setLayout(new GridLayout(3, 2));
		inicializar();
		
	}

	public void inicializar() {
		
		
		botones[0] = new JButton();
		botones[0].setIcon(new ImageIcon("ims/60.png"));
		botones[0].setToolTipText("Conversor");
		botones[1] = new JButton();
		botones[1].setIcon(new ImageIcon("ims/cal.png"));
		botones[1].setToolTipText("Calculadora");
		botones[2] = new JButton();
		botones[2].setIcon(new ImageIcon("ims/doc.png"));
		botones[2].setToolTipText("Mi Salud");
		botones[3] = new JButton();
		botones[3].setIcon(new ImageIcon("ims/100.png"));
		botones[3].setToolTipText("Blok de notas");
		botones[4] = new JButton();
		botones[4].setIcon(new ImageIcon("ims/65.png"));
		botones[4].setToolTipText("Promedio Calificaciones");
		botones[5] = new JButton();
		botones[5].setIcon(new ImageIcon("ims/perfil.png"));
		botones[5].setToolTipText("Mi perfil");
		for (int i = 0; i < botones.length; i++) {
			
			add(botones[i]);
			botones[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == botones[0]) {
			
			vent.mostrarConvertidor();

		}else if(e.getSource() == botones[1]) {
			vent.mostrarCalculadora();
			
		}else if(e.getSource() == botones[2]) {
			
			vent.mostrarDatosSalud();
			
		}else if(e.getSource() == botones[3]) {
			
			vent.mostrarBlockBotas();
			
		}else if(e.getSource() == botones[4]) {
			
			vent.mostrarCalcularNotas();
			
		}else {
			
			vent.mostrarPerfil();
		}
		
			
	}
}
