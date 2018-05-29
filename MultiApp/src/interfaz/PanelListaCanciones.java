package interfaz;

import java.awt.*;

import modelo.Cancion;
import modelo.Reproductor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelListaCanciones extends JPanel implements ActionListener{
	
	private static final String SONG1 ="Do I Wanna Know";
	private static final String SONG2 ="Blame";
	private static final String SONG3 ="How Deep Is your Love";
	private static final String SONG4 ="Get Lucky";
	private static final String SONG5 ="One More Time";
	private static final String SONG6 ="Shape of You";
	private static final String SONG7 ="Sugar";
	private static final String SONG8 ="Stressed Out";
	private static final String SONG9 ="Sucker for Pain";
	private static final String SONG10 ="Heathers";

	
	private JButton butSong1;
	private JButton butSong2;
	private JButton butSong3;
	private JButton butSong4;
	private JButton butSong5;
	private JButton butSong6;
	private JButton butSong7;
	private JButton butSong8;
	private JButton butSong9;
	private JButton butSong10;
	
	private VentanaReproductor ventana;
	
	public PanelListaCanciones(VentanaReproductor ventana) {
		this.ventana =ventana;
		setLayout(new GridLayout(5, 2));
		TitledBorder border =BorderFactory.createTitledBorder("Lista de canciones");
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		setPreferredSize(new Dimension(300,300));
		
		butSong1 =new JButton(SONG1);
		butSong2 =new JButton(SONG2);
		butSong3 =new JButton(SONG3);
		butSong4 =new JButton(SONG4);
		butSong5 =new JButton(SONG5);
		butSong6 =new JButton(SONG6);
		butSong7 =new JButton(SONG7);
		butSong8 =new JButton(SONG8);
		butSong9 =new JButton(SONG9);
		butSong10 =new JButton(SONG10);
		
		butSong1.setActionCommand(SONG1);
		butSong2.setActionCommand(SONG2);
		butSong3.setActionCommand(SONG3);
		butSong4.setActionCommand(SONG4);
		butSong5.setActionCommand(SONG5);
		butSong6.setActionCommand(SONG6);
		butSong7.setActionCommand(SONG7);
		butSong8.setActionCommand(SONG8);
		butSong9.setActionCommand(SONG9);
		butSong10.setActionCommand(SONG10);

		butSong1.addActionListener(this);
		butSong2.addActionListener(this);
		butSong3.addActionListener(this);
		butSong4.addActionListener(this);
		butSong5.addActionListener(this);
		butSong6.addActionListener(this);
		butSong7.addActionListener(this);
		butSong8.addActionListener(this);
		butSong9.addActionListener(this);
		butSong10.addActionListener(this);
		
		add(butSong1);
		add(butSong2);
		add(butSong3);
		add(butSong4);
		add(butSong5);
		add(butSong6);
		add(butSong7);
		add(butSong8);
		add(butSong9);
		add(butSong10);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String comando =e.getActionCommand();
		
		if(comando.equals(SONG1)) {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
			
			ventana.getRepro().setActual(ventana.getRepro().buscarCancion(SONG1));
			System.out.println(ventana.getRepro().getActual());
			ventana.getRepro().iniciar();
			ventana.getPanelRepro().actualizarInfo(ventana.getRepro().getActual());
			ventana.getRepro().reproduciendo();
		}else if(comando.equals(SONG2)) {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
			
			ventana.getRepro().setActual(ventana.getRepro().buscarCancion(SONG2));
			ventana.getPanelRepro().actualizarInfo(ventana.getRepro().getActual());

			ventana.getRepro().iniciar();
			ventana.getRepro().reproduciendo();
		}else if(comando.equals(SONG3)) {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
			
			ventana.getRepro().setActual(ventana.getRepro().buscarCancion(SONG3));
			ventana.getPanelRepro().actualizarInfo(ventana.getRepro().getActual());

			ventana.getRepro().iniciar();
			ventana.getRepro().reproduciendo();
		}else if(comando.equals(SONG4)) {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
			
			ventana.getRepro().setActual(ventana.getRepro().buscarCancion(SONG4));
			ventana.getPanelRepro().actualizarInfo(ventana.getRepro().getActual());

			ventana.getRepro().iniciar();
			ventana.getRepro().reproduciendo();
		}else if(comando.equals(SONG5)) {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
			
			ventana.getRepro().setActual(ventana.getRepro().buscarCancion(SONG5));
			ventana.getPanelRepro().actualizarInfo(ventana.getRepro().getActual());

			ventana.getRepro().iniciar();
			ventana.getRepro().reproduciendo();
		}else if(comando.equals(SONG6)) {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
			
			ventana.getRepro().setActual(ventana.getRepro().buscarCancion(SONG6));
			ventana.getRepro().iniciar();
			ventana.getRepro().reproduciendo();
		}else if(comando.equals(SONG7)) {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
			
			ventana.getRepro().setActual(ventana.getRepro().buscarCancion(SONG7));
			ventana.getPanelRepro().actualizarInfo(ventana.getRepro().getActual());

			ventana.getRepro().iniciar();
			ventana.getRepro().reproduciendo();
		}else if(comando.equals(SONG8)) {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
			
			ventana.getRepro().setActual(ventana.getRepro().buscarCancion(SONG8));
			ventana.getPanelRepro().actualizarInfo(ventana.getRepro().getActual());

			ventana.getRepro().iniciar();
			ventana.getRepro().reproduciendo();
		}else if(comando.equals(SONG9)) {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
			
			ventana.getRepro().setActual(ventana.getRepro().buscarCancion(SONG9));
			ventana.getPanelRepro().actualizarInfo(ventana.getRepro().getActual());

			ventana.getRepro().iniciar();
			ventana.getRepro().reproduciendo();
		}else {
			if(ventana.getRepro().getEstado()) 
				ventana.getRepro().pausar();
			
			ventana.getRepro().setActual(ventana.getRepro().buscarCancion(SONG10));
			ventana.getPanelRepro().actualizarInfo(ventana.getRepro().getActual());
			ventana.getRepro().iniciar();
			ventana.getRepro().reproduciendo();
		}
	}


}

