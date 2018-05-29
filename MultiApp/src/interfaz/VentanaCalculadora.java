package interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaCalculadora extends JDialog {

	private PanelValores pValores;
	private PanelOperaciones pOper;
	private VentanaPrincipal vent;
	public VentanaCalculadora( VentanaPrincipal vent) {
		
		setSize(400, 500);
		setTitle("Calculadora");
		setVisible(true);
		setResizable(false);
		setLayout(new BorderLayout());
		setBackground(new Color(153, 217, 234));
		pValores = new PanelValores();
		pOper = new PanelOperaciones(this);
		this.vent = vent;
		add(pValores, BorderLayout.NORTH);
		add(pOper, BorderLayout.CENTER);
		
		Toolkit screem = Toolkit.getDefaultToolkit();
		Image imag = screem.getImage("ims/cal.png");
		setIconImage(imag);
	}
	
	public void refrescarSuma() {
		
		pValores.setResultado(sumar());
	}
	
	public void refrescarResta() {
		
		pValores.setResultado(restar());
	}
	public void refrescarDivision() {
		
		pValores.setResultado(dividir());
	}
	
	public void refrescarMultiplicacion() {
		
		pValores.setResultado(multiplicar());
	}
	public double sumar() {
		
		double val = vent.getaplicacion().getAvatar().getCalculadora().sumar(pValores.getValor1(), pValores.getValor2());
		return val;
	}
	
	public double restar() {
		
		double val = vent.getaplicacion().getAvatar().getCalculadora().restar(pValores.getValor1(), pValores.getValor2());
		return val;
	}
	
	public double dividir() {
		
		double val = vent.getaplicacion().getAvatar().getCalculadora().dividir(pValores.getValor1(), pValores.getValor2());
		return val;
	}
	
	public double multiplicar() {
		
		double val = vent.getaplicacion().getAvatar().getCalculadora().multiplicar(pValores.getValor1(), pValores.getValor2());
		return val;
	}
}