package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import excepcion.NoExisteNombreException;



public class VentanaBlockNotas extends JDialog {
	
	private PanelBloc block;
	private PanelOpcionesBloc opciones;
	private VentanaPrincipal vent;
	public VentanaBlockNotas(VentanaPrincipal vent) {
		
		setTitle("Block de Notas");
		setLayout(new BorderLayout());
		setBounds(45, 45, 500, 500);
		setResizable(false);
		this.vent = vent;
		setBackground(new Color(153, 217, 234));
		block=new PanelBloc();
		opciones =new PanelOpcionesBloc(this);
		Toolkit screem = Toolkit.getDefaultToolkit();
		Image imag = screem.getImage("ims/100.png");
		setIconImage(imag);
		add(block, BorderLayout.CENTER);
		add(opciones, BorderLayout.SOUTH);
	}
	
	
	public PanelBloc getBlock() {
		return block;
	}


	/**
	 * @return the vent
	 */
	public VentanaPrincipal getVent() {
		return vent;
	}
	
	public void cargarNota(String nombre) throws IOException {
		
		
		try {
			String buscado = vent.getaplicacion().getAvatar().getBlockNotas().buscarNotaPorNombre(nombre);
			
			block.setContenido(buscado);
			
		} catch (NoExisteNombreException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
		
	}
}
