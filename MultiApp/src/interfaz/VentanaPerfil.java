package interfaz;

import javax.swing.*;
import java.awt.*;
public class VentanaPerfil extends JDialog{

	private VentanaPrincipal vent;
	private PanelValoresPerfil perfil;
	private PanelImagenPerlfil imaPerfil;
	public VentanaPerfil(VentanaPrincipal vent) {
		
		setVisible(true);
		setBounds(45, 45, 500, 500);
		setLayout(new GridLayout(2, 0));
		setTitle("Mi Perfil");
		setBackground(new Color(153, 217, 234));
		setResizable(false);
		this.vent = vent;
		this.perfil = new PanelValoresPerfil(this);
		this.imaPerfil = new PanelImagenPerlfil(this);
		Toolkit screem = Toolkit.getDefaultToolkit();
		Image imag = screem.getImage("ims/65.png");
		setIconImage(imag);
		refrescarImagenAvtar();
		add(imaPerfil);
		add(perfil);
	}
	
	
	public void refrescarImagenAvtar() {
		
		String rutaDefecto = imaPerfil.getRutaImagen();
		vent.getAvatar().setRutaDefecto(rutaDefecto);
		

	}
	/**
	 * @return the vent
	 */
	public VentanaPrincipal getVent() {
		return vent;
	}


	/**
	 * @return the imaPerfil
	 */
	public PanelImagenPerlfil getImaPerfil() {
		return imaPerfil;
	}
	
	
}
