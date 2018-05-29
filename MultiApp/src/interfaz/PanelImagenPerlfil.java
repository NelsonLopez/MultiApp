package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelImagenPerlfil  extends JPanel implements ActionListener{

	private VentanaPerfil perfil;
	private JButton but;
	private String rutaImagen;
	private JLabel ima;
	public PanelImagenPerlfil(VentanaPerfil perfil) {
		
		setPreferredSize(new Dimension(500,100));
		
		setLayout(new GridLayout(1, 2));
		this.perfil = perfil;
		rutaImagen = perfil.getVent().getAvatar().getRutaDefecto();
		ima = new JLabel(new ImageIcon(rutaImagen));
		 but = new JButton("Cambiar Imagen");
		but.addActionListener(this);
		add(ima);
		add(but);
	}
	
	
	/**
	 * @param rutaImagen the rutaImagen to set
	 */
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}


	/**
	 * @return the rutaImagen
	 */
	public String getRutaImagen() {
		return rutaImagen;
	}


	public void elegirImagen() {
		
		JFileChooser chu = new JFileChooser();
		chu.setCurrentDirectory(new File("ims/avatars"));
		chu.showOpenDialog(null);
		chu.isVisible();
		
		String rut = chu.getSelectedFile().getAbsolutePath();
		setRutaImagen( rut);
		ima.setIcon(new ImageIcon(rut));
		perfil.getVent().getAvatar().setRutaDefecto(rut);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == but) {
			
			elegirImagen();
		}
		
	}
	
	
}
