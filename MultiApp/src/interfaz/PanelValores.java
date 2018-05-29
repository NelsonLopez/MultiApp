package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelValores extends JPanel {
	
	private JLabel[] lbValores;
	private JTextField[] txtValores;
	public PanelValores() {
		
		setLayout(new GridLayout(3, 3));
		setPreferredSize(new Dimension(250, 250));
		
		TitledBorder border = BorderFactory.createTitledBorder( "Valores" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );
		
        lbValores = new JLabel[3];
        txtValores = new JTextField[3];
        
        inicializar();
	}
	
	public void inicializar() {
		
		lbValores[0] = new JLabel("Valor 1: ");
		lbValores[1] = new JLabel("Valor 2: ");
		lbValores[2] = new JLabel("Resultado: ");
		
		txtValores[0] = new JTextField();
		txtValores[1] = new JTextField();
		txtValores[2] = new JTextField();
		txtValores[2].setEditable(false);
		
		for (int i = 0; i < lbValores.length; i++) {
			
			add(lbValores[i]);
			add(txtValores[i]);
		}
	}

	
	public double getValor1() {
		double val= 0;
		try {
		 val = Double.parseDouble(txtValores[0].getText());
		}catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(this,  "Ingresa Solo caracteres Numéricos,"+"\n"+ "vuelve a ingresar los datos");
		}
		return val;
	}
	public double getValor2() {
		
		double val= 0;
		try {
		 val = Double.parseDouble(txtValores[1].getText());
		}catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(this,  "Ingresa Solo caracteres Numéricos,"+"\n"+ "vuelve a ingresar los datos");
		}
		return val;
	}
	
	public void setResultado(double val) {
		
		txtValores[2].setText(String.format("%.2f", val));
	}
}
