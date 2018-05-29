package interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaSalud extends JDialog{

	private VentanaPrincipal vent;
	private PanelValoresSalud salud;
	public VentanaSalud(VentanaPrincipal vent) {
		
		setSize(400, 500);
		setTitle("Mi salud");
		setVisible(true);
		setResizable(false);
		setLayout(new BorderLayout());
		setBackground(new Color(153, 217, 234));
		Toolkit screem = Toolkit.getDefaultToolkit();
		Image imag = screem.getImage("ims/doc.png");
		setIconImage(imag);
		this.vent = vent;
		salud = new PanelValoresSalud(this);
		add(salud, BorderLayout.CENTER);
		
	}
	
	
	public void refrescarDatos() {
		
		double peso = salud.getPeso();
		double statura = salud.getEstatura();
		
		 vent.getaplicacion().getAvatar().getDatosSalud().calcularIMC(peso, statura);
		double imc = vent.getaplicacion().getAvatar().getDatosSalud().getiMC();
		
		String pesoIdeal = vent.getaplicacion().getAvatar().getDatosSalud().darIdeal(statura);
		String estadoIMC= vent.getaplicacion().getAvatar().getDatosSalud().revisarEstado();
		 salud.setIMC(imc, estadoIMC, pesoIdeal);
		
	}
	
}
