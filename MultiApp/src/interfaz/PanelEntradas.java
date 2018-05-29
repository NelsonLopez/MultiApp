package interfaz;

import java.awt.GridLayout;

import javax.swing.*;

public class PanelEntradas extends JPanel{

	
	private JLabel[] lbEntradas; 
	private JTextField[] txtValor;
	public PanelEntradas() {
		
	setLayout(new GridLayout(2, 2));
	
	incializar();
	
	}
	
	public void incializar() {
		lbEntradas = new JLabel[2];
		lbEntradas[0] = new JLabel("Valor a convertir ");
		lbEntradas[1] = new JLabel(new ImageIcon("ims/termo.PNG"));
		txtValor = new JTextField[2];
		txtValor[0] = new JTextField();
		txtValor[1] = new JTextField();
		txtValor[1].setEditable(false);
		add(lbEntradas[0] );
		add(txtValor[0]);
		add(lbEntradas[1] );
		add(txtValor[1]);
	}

	/**
	 * @return the txtValor
	 */
	public double  getValor() {
		
		double val= 0;
		try {
		 val = Double.parseDouble(txtValor[0].getText());
		}catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(this, "Ingresa Solo caracteres Numéricos");
		}
		return val;
	}
	
	public void setTemperatura(double temp) {
		
		txtValor[1].setText(String.format("%.2f", temp));
	}
	
}