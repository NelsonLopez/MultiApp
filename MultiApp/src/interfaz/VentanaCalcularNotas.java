package interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaCalcularNotas extends JDialog{

	private VentanaPrincipal vent;
	private PanelValoresNotas valores;
	private PanelBotonesNotas botones;
	public VentanaCalcularNotas(VentanaPrincipal vent) {
		
	setVisible(true);
	setBounds(45, 45, 500, 300);
	setLayout(new GridLayout(2, 0));
	setTitle("Calcular Notas");
	setResizable(false);
	this.vent = vent;
	this.valores = new PanelValoresNotas();
	this.botones = new PanelBotonesNotas(this);
	Toolkit screem = Toolkit.getDefaultToolkit();
	Image imag = screem.getImage("ims/65.png");
	setIconImage(imag);
	
	add(valores);
	add(botones);
	
	}
	
	public void refrecarAcumulado() {
		
		valores.setAcumulado(vent.getaplicacion().getAvatar().getCalcularNotas().getAcumulado());
	}
	
	public void calcular() {
		
		double not = valores.getNota();
		double porcen = valores.getPorcentaje();
		double mult = vent.getaplicacion().getAvatar().getCalcularNotas().multiplicar(not, porcen);
		valores.setValor(mult);
	}
	
	public void restablecer() {
		
		vent.getaplicacion().getAvatar().getCalcularNotas().setAcumulado(0);
		valores.setRestablecer();
		refrecarAcumulado();
	}
}
