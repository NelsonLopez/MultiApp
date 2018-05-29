package interfaz;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;


import javax.swing.*;

public class PanelConvertir  extends JPanel implements ActionListener{
	
	private VentanaConvertidor  prin;
	private JButton[] btEscala;
	public PanelConvertir(VentanaConvertidor prin) {
		
		this.prin = prin;
		setLayout(new GridLayout(3, 2));
		btEscala = new JButton[6];
		inicializarBotones();
	
		
	}
	
	public void inicializarBotones () {
		btEscala[0] = new JButton("K a F°");
		btEscala[0].setToolTipText("Click convertir Kelvin a Farenheit");
		btEscala[0].setBackground(Color.CYAN);
		
		btEscala[1] = new JButton(" K a C°");
		btEscala[1].setToolTipText("Click convertir Kelvin a Celcius");
		btEscala[1].setBackground(Color.WHITE);
		
		btEscala[2] = new JButton(" C° a K ");
		btEscala[2].setToolTipText("Click convertir Celcius a Kelvin ");
		btEscala[2].setBackground(Color.WHITE);
		
		btEscala[3] = new JButton("C° a F° ");
		btEscala[3].setToolTipText("Click convertir Celcius a Farenheit ");
		btEscala[3].setBackground(Color.CYAN);
		
		btEscala[4] = new JButton("F° a C° ");
		btEscala[4].setToolTipText("Click convertir Farenheit a Celcius ");
		btEscala[4].setBackground(Color.CYAN);
		
		btEscala[5] = new JButton("F°  a K  ");
		btEscala[5].setToolTipText("Click convertir Farenheit  a Kelvin");
		btEscala[5].setBackground(Color.WHITE);
		for (int i = 0; i < btEscala.length; i++) {
	
			add(btEscala[i]);
			btEscala[i].addActionListener(this);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btEscala[0]) {
			
			prin.refrescarKF();

		}else if(e.getSource() == btEscala[1]) {
			
			prin.refrescarKC();
			
		}else if(e.getSource() == btEscala[2]) {
			
			prin.refrescarCK();
			
		}else if(e.getSource() == btEscala[3]) {
			prin.refrescarKF();
			
		}else if(e.getSource() == btEscala[4]) {
			
			prin.refrescarFC();
			
		}else {
			
			prin.refrescarFK();;
		}
		
	}


}
