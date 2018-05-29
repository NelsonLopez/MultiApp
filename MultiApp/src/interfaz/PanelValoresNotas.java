package interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
public class PanelValoresNotas extends JPanel {

	private JLabel[] lbValores;
	private JTextField[] txtValores;
	
	public PanelValoresNotas() {
		
		setLayout(new GridLayout(4, 4));
		setPreferredSize(new Dimension(250, 300));
	
		TitledBorder border = BorderFactory.createTitledBorder( "Valores" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );
		
        lbValores = new JLabel[4];
        txtValores = new JTextField[4];
        inicializar();
        
	}
	
	public void inicializar() {
		
		lbValores[0] = new JLabel("Nota: ");
		lbValores[1] = new JLabel("Porcentaje: ");
		lbValores[2] = new JLabel("Valor : ");
		lbValores[3] = new JLabel("Acumulado: ");
		
		txtValores[0] = new JTextField();
		txtValores[1] = new JTextField();
		txtValores[2] = new JTextField();
		txtValores[2].setEditable(false);
		txtValores[3] = new JTextField();
		txtValores[3].setEditable(false);
		
		for (int i = 0; i < lbValores.length; i++) {
			
			add(lbValores[i]);
			add(txtValores[i]);
		}
	}
	
	public double getNota() {
		double val= 0;
		try {
		 val = Double.parseDouble(txtValores[0].getText());
		}catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(this,  "Ingresa Solo caracteres Numéricos,"+"\n"+ "vuelve a ingresar los datos");
		}
		return val;
	}
	public double getPorcentaje() {
		double val= 0;
		try {
		 val = Double.parseDouble(txtValores[1].getText());
		}catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(this,  "Ingresa Solo caracteres Numéricos,"+"\n"+ "vuelve a ingresar los datos");
			
		}
		return val;
	}
	
	public void setValor(double val) {
		
		txtValores[2].setText(String.format("%.2f", val));
	}
	
	public void setAcumulado(double val) {
		
		txtValores[3].setText(String.format("%.2f", val));
	}
	
	
	public void setRestablecer() {
		txtValores[2].setText("");
		txtValores[1].setText("");
		txtValores[0].setText("");
		
	}
	

}
