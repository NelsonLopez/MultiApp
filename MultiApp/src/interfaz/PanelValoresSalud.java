package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import interfaces.Constantes;
public class PanelValoresSalud  extends JPanel implements ActionListener{

	private JLabel[] lbValores;
	private JTextField[] txtValores;
	private VentanaSalud vent;
	public PanelValoresSalud(VentanaSalud vent) {
		
		setLayout(new GridLayout(6, 5));
		setPreferredSize(new Dimension(250, 300));
	
		TitledBorder border = BorderFactory.createTitledBorder( "Valores" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );
		this.vent = vent;
        lbValores = new JLabel[5];
        txtValores = new JTextField[5];
        inicializar();
	}
	
	public void inicializar() {
		
		lbValores[0] = new JLabel("Peso: ");
		lbValores[1] = new JLabel("Estatura : ");
		lbValores[2] = new JLabel("IMC: ");
		lbValores[3] = new JLabel("Estado IMC: ");
		lbValores[4] = new JLabel("Peso ideal: ");
		
		txtValores[0] = new JTextField();
		txtValores[1] = new JTextField();
		txtValores[2] = new JTextField();
		txtValores[2].setEditable(false);
		txtValores[3] = new JTextField();
		txtValores[3].setEditable(false);
		txtValores[4] = new JTextField();
		txtValores[4].setEditable(false);
		for (int i = 0; i < lbValores.length; i++) {
			
			add(lbValores[i]);
			add(txtValores[i]);
		}
		
		JButton calcular = new JButton(Constantes.CALCULAR);
		calcular.addActionListener(this);
		calcular.setActionCommand(Constantes.CALCULAR);
		JLabel ima = new JLabel(new ImageIcon("ims/eat.png"));
		add(calcular);
		add(ima);
	}
	
	
	public double getPeso() {
		double val= 0;
		try {
		 val = Double.parseDouble(txtValores[0].getText());
		}catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(this, "Ingresa Solo caracteres Numéricos,"+"\n"+ "vuelve a ingresar los datos");
		}
		return val;
	}
	public double getEstatura() {
		double val= 0;
		try {
		 val = Double.parseDouble(txtValores[1].getText());
		}catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(this,  "Ingresa Solo caracteres Numéricos,"+"\n"+ "vuelve a ingresar los datos");
		}
		return val;
	
	}
	public void setIMC(double val, String estadoIMc, String pesoIdeal) {
		
		txtValores[2].setText(String.format("%.2f", val));
		txtValores[3].setText(estadoIMc);
		txtValores[4].setText(pesoIdeal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(Constantes.CALCULAR)) {
			
			vent.refrescarDatos();
		}
			
		
	}
}
