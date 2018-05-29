package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Cancion;

public class PanelReproduccion extends JPanel implements ActionListener {
	
	public final static String INICIAR ="Iniciar"; 
	public final static String PAUSAR ="Pausar"; 
	public final static String ANTERIOR ="Anterior"; 
	public final static String SIGUIENTE ="Siguiente"; 
	
	private JLabel labCancion;
	private JLabel labArtista;
	private JLabel labGenero;

	private JButton butIniciar;
	private JButton butPausar;
	private JButton butSiguiente;
	private JButton butAnterior;
	
	private VentanaReproductor ventana;

	public PanelReproduccion(VentanaReproductor ventana) {
		this.ventana =ventana;
		setLayout(new GridLayout(5, 6));
		setPreferredSize(new Dimension(500,200));
	
		labCancion= new JLabel("Nombre:");
		labArtista= new JLabel("Artista: ");
		labGenero= new JLabel("Genero: ");
		
		butIniciar  =new JButton(new ImageIcon("ims/play.png"));
		butPausar  =new JButton(new ImageIcon("ims/pause.png"));
		butSiguiente  =new JButton(new ImageIcon("ims/pasarR.png"));
		butAnterior  =new JButton(new ImageIcon("ims/pasarL.png"));
		
		butIniciar.setActionCommand(INICIAR);
		butPausar.setActionCommand(PAUSAR);
		butSiguiente.setActionCommand(SIGUIENTE);
		butAnterior.setActionCommand(ANTERIOR);
		
		butIniciar.addActionListener(this);
		butPausar.addActionListener(this);
		butAnterior.addActionListener(this);
		butSiguiente.addActionListener(this);

		add(labCancion);
		for(int i=0; i<5; i++) {
			add(new JLabel(""));
		}
		add(labArtista);
		for(int i=0; i<5; i++) {
			add(new JLabel(""));
		}
		add(labGenero);
		for(int i=0; i<5; i++) {
			add(new JLabel(""));
		}
		add(butAnterior);
		add(butPausar);
		add(butIniciar);
		add(butSiguiente);
		for(int i=0; i<7; i++) {
			add(new JLabel(""));
		}
	}

	/**
	 * @return the labCancion
	 */
	public JLabel getLabCancion() {
		return labCancion;
	}

	/**
	 * @param labCancion the labCancion to set
	 */
	public void setLabCancion(JLabel labCancion) {
		this.labCancion = labCancion;
	}

	/**
	 * @return the labArtista
	 */
	public JLabel getLabArtista() {
		return labArtista;
	}

	/**
	 * @param labArtista the labArtista to set
	 */
	public void setLabArtista(JLabel labArtista) {
		this.labArtista = labArtista;
	}

	/**
	 * @return the labGenero
	 */
	public JLabel getLabGenero() {
		return labGenero;
	}

	/**
	 * @param labGenero the labGenero to set
	 */
	public void setLabGenero(JLabel labGenero) {
		this.labGenero = labGenero;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando =e.getActionCommand();
		
		if(comando.equals(INICIAR)) {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
				
				ventana.getRepro().iniciar();
				ventana.getRepro().reproduciendo();
			
		}else if(comando.equals(PAUSAR)) {
			ventana.getRepro().pausar();
		}else if(comando.equals(SIGUIENTE)) {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
				
				ventana.getRepro().reproSiguiente();
				ventana.getRepro().reproduciendo();
			
		}else {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
				
				ventana.getRepro().pausar();
				ventana.getRepro().reproAnterior();
				ventana.getRepro().reproduciendo();
		}
	}
	
	public void actualizarInfo(Cancion actual) {
		labCancion.setText(actual.getNombre());
		labGenero.setText(actual.getGenero());
		labArtista.setText(actual.getArtista());
	}
}
