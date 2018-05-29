package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

public class VentanaConvertidor extends JDialog {

 
	private VentanaPrincipal vent;
	private PanelConvertir escalas; 
	private PanelEntradas entradas;
	public VentanaConvertidor(VentanaPrincipal vent)  {
		
		setVisible(true);
		setBounds(45, 45, 500, 250);
		setTitle("Conversor");
		setResizable(false);
		this.vent = vent;
		setLayout(new GridLayout(0, 2));
		escalas = new PanelConvertir(this);
		entradas = new PanelEntradas();
		add(entradas);
		add(escalas);
		Toolkit screem = Toolkit.getDefaultToolkit();
		Image imag = screem.getImage("ims/convertidor.png");
		setIconImage(imag);
		
		
		
	}
	
	
	
	/**
	 * @return the vent
	 */
	public VentanaPrincipal getVent() {
		return vent;
	}
	
	public void refrescarCF() {
		
		entradas.setTemperatura(convertirCelsiusFahrenheit());
	}
	public void refrescarCK() {
		
		entradas.setTemperatura(convertirCelsiusKelvin());
	}
	
	public void refrescarKF() {
		
		entradas.setTemperatura(convertirkelvinFarenheit());
	}
	
	
	public void refrescarKC() {
		
		entradas.setTemperatura(convertirkelvinCelsius());
	}
	
	public void refrescarFC() {
		
		entradas.setTemperatura(convertirFarenheitCelcius());
	}
	
	public void refrescarFK() {
		
		entradas.setTemperatura(convertirFarenheitkelvin());
	}
	public double convertirCelsiusFahrenheit() {
		
		double temp = entradas.getValor();
		double nuevaTem = vent.getaplicacion().getAvatar().getConvertirdor().convertirCelsiusFahrenheit(temp);
		
		return nuevaTem;
	}
	
	public double convertirCelsiusKelvin() {
		
		double temp = entradas.getValor();
		double nuevaTem = vent.getaplicacion().getAvatar().getConvertirdor().convertirCelciusKelvin(temp);
		
		return nuevaTem;
	}
	
	public double convertirkelvinFarenheit() {
		
		double temp = entradas.getValor();
		double nuevaTem = vent.getaplicacion().getAvatar().getConvertirdor().convertirKelvinFahrenheit(temp);
		
		return nuevaTem;
	}
	
	public double convertirkelvinCelsius() {
		
		double temp = entradas.getValor();
		double nuevaTem = vent.getaplicacion().getAvatar().getConvertirdor().convertirKelvinCelsius(temp);
		
		return nuevaTem;
	}
	
	public double convertirFarenheitkelvin() {
		
		double temp = entradas.getValor();
		double nuevaTem = vent.getaplicacion().getAvatar().getConvertirdor().convertirFahrenheitKelvin(temp);
		
		return nuevaTem;
	}
	public double convertirFarenheitCelcius() {
		
		double temp = entradas.getValor();
		double nuevaTem = vent.getaplicacion().getAvatar().getConvertirdor().convertirFahrenheitCelsius(temp);
		
		return nuevaTem;
	}
	
	
}
