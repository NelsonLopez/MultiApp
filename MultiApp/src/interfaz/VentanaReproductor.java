package interfaz;

import modelo.*;
import modelo.Usuario;

import java.awt.*;

import javax.swing.*;

public class VentanaReproductor extends JDialog {
	
	private PanelListaCanciones panelLista;
	private PanelReproduccion panelReproduccion;
	private PanelImagen panelImagen;
	//private App app;
	private VentanaPrincipal app;
	
	//Cuando se vayan a cambiar los JFrame secundarios por dialog se crea la relacion con Principal
		
	public VentanaReproductor(VentanaPrincipal app) {
		this.app=app;
		setTitle("Reproductor de musica");
		setLayout(new BorderLayout());
		setSize(700, 550);
		
		setResizable(true);
		Toolkit screem = Toolkit.getDefaultToolkit();
		Image imag = screem.getImage("ims/nota.png");
		setIconImage(imag);
		panelLista =new PanelListaCanciones(this);
		panelReproduccion =new PanelReproduccion(this);
		panelImagen =new PanelImagen();
		
		add(panelLista, BorderLayout.NORTH);
		add(panelImagen, BorderLayout.WEST);
		add(panelReproduccion, BorderLayout.EAST);
	}


	public VentanaPrincipal getApp() {
		return app;
	}
	
	public PanelReproduccion getPanelRepro() {
		return panelReproduccion;
	}
	
	public Avatar getUsuario() {
		return app.getaplicacion().getAvatar();
	}
	
	public Reproductor getRepro() {
		return app.getaplicacion().getAvatar().getReproductor();
	}
}


