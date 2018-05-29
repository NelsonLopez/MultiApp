package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import interfaces.Constantes;
public class PanelOperaciones extends JPanel implements ActionListener {
	
	public final static String SUMAR = "Sumar";
	public final static String RESTAR = "Restar";
	public final static String DIVIDIR = "Dividir";
	public final static String MULTIPLICAR = "Multiplicar";
	private JButton[] botones;
	private VentanaCalculadora vent;
	public PanelOperaciones(VentanaCalculadora vent) {
		
		TitledBorder border = BorderFactory.createTitledBorder( "Operadores" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );
        this.vent = vent;
        setLayout(new GridLayout(2, 2));
        botones = new JButton[4];
   
        setPreferredSize(new Dimension(250, 250));
  
        inicializar();
       
	}

	public void inicializar() {
		
		botones[0] = new JButton(SUMAR);
		botones[0].setToolTipText("Sumar");
		botones[1] = new JButton(RESTAR);
		botones[1].setToolTipText("Restar");
		botones[2] = new JButton(DIVIDIR);
		botones[2].setToolTipText("Dividir");
		botones[3] = new JButton(MULTIPLICAR);
		botones[3].setToolTipText("Multiplicar");
		
		for (int i = 0; i < botones.length; i++) {
			
			add(botones[i]);
			botones[i].addActionListener(this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == botones[0]) {
			vent.refrescarSuma();
			
		}else if(e.getSource() == botones[1]) {
			
			vent.refrescarResta();
		}else if(e.getSource() == botones[2]) {
			vent.refrescarDivision();
		}else {
			
			vent.refrescarMultiplicacion();
		}
		
	}
}
