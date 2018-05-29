package interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import interfaces.Constantes;
public class PanelBotonesNotas extends JPanel implements ActionListener{
	
	
	public final static String RESTABLECER = "Restablecer";
	public final static String AGREGAR = "Agregar";
	private JButton[] botones;
	private VentanaCalcularNotas vent;
	public PanelBotonesNotas(VentanaCalcularNotas vent) {
		
		setPreferredSize(new Dimension(250, 0));
		TitledBorder border = BorderFactory.createTitledBorder( "Operadores" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );
        this.vent = vent;
        setLayout(new GridLayout(2, 0));
        botones = new JButton[2];
   

        inicializar();
	}

	public void inicializar() {
		
		botones[0] = new JButton(Constantes.CALCULAR);
		botones[0].setToolTipText("Calcular");
		botones[0].addActionListener(this);
		botones[1] = new JButton(RESTABLECER);
		botones[1].setToolTipText("Restablecer");
		botones[1].addActionListener(this);
		
		add(botones[0]);
		add(botones[1]);

	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			
			if(e.getSource() == botones[0]) {
				
				vent.calcular();
				vent.refrecarAcumulado();
				
			}else  {
				
				vent.restablecer();
				
			}
		
	}
}
