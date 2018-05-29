package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import modelo.Jugador;
import excepcion.PuntajeNoExisteException;

public class PanelOpcionesJuego extends JPanel implements ActionListener{
	
	public final static String GUARDAR ="Guardar"; 
	public final static String INICIAR ="Iniciar"; 
	public final static String CARGAR ="Cargar"; 
	public final static String BUSCAR ="Buscar Jugador";

	
	private VentanaJuego ventana;
	private JButton butGuardar;
	private JButton butIniciar;
	private JButton butCargar;
	private JButton butBuscar;
	private String actual;

	
	public PanelOpcionesJuego(VentanaJuego ventana) {
		this.ventana =ventana;
		
		this.setLayout(new GridLayout(1,2));
		setPreferredSize(new Dimension(0, 80));
		
		butGuardar =new JButton("Guardar");	
		butIniciar =new JButton("Iniciar");	
		butCargar =new JButton("Cargar");	
		butBuscar =new JButton("Buscar Jugador");

		butGuardar.setActionCommand(GUARDAR);
		
		butIniciar.setActionCommand(INICIAR);
		butCargar.setActionCommand(CARGAR);
		butBuscar.setActionCommand(BUSCAR);
		
		TitledBorder border = BorderFactory.createTitledBorder("Opciones");
		border.setTitleColor(Color.BLACK);
		setBorder(border);

		add(butIniciar);
		add(butCargar);
		
		add(butGuardar);
 		
		butIniciar.addActionListener(this);
		butGuardar.addActionListener(this);
		butCargar.addActionListener(this);
		butBuscar.addActionListener(this);
	}
	
	public String getActual() {
		return actual;
	}
	
	public Jugador pedirNick() {
		String nick =JOptionPane.showInputDialog(this, "Ingrese su nickname");
		Jugador nuevo =null;
			if(nick!=null) {
				nuevo =new Jugador(nick);
				ventana.getJuego().agregarJugador(nuevo);
				ventana.getPanelInfo().refrescarNick(nuevo);
				actual =nick;
			}
		return nuevo;
	}
	
	public void mostrarJugadorBuscado() {
		String msj =JOptionPane.showInputDialog(this, "Ingrese el puntaje del jugador a buscar");
			if(msj!=null) {
					try {				
						int puntajeABuscar=Integer.parseInt(msj);
						Jugador buscado =ventana.getJuego().buscarJugador(puntajeABuscar);
						String nick =buscado.getNickname();
						JOptionPane.showMessageDialog(this, "El jugador con este puntaje es "+nick);
					} catch (NumberFormatException | PuntajeNoExisteException e) {
						JOptionPane.showMessageDialog(this, "El puntaje "+msj+ " no corresponde a ningun jugador");
					}
			}
	}
	
	public void actionPerformed(ActionEvent evento) {
		String comando =evento.getActionCommand();
		
		if(comando.equals(GUARDAR)) {
			try {
				ventana.getJuego().guardarInfoGamers();
				ventana.getJuego().guardarInfoJuego();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(comando.equals(INICIAR)) {
			Jugador agregado =pedirNick();
			ventana.getPanelInfo().actualizarInformacion(agregado);
			ventana.moverBall();
			this.setFocusable(false);
		}else if(comando.equals(CARGAR)) {
			File archivoEstadoJuego =new File("archivo/informacion/infoEstadoJuego.txt");

			if(!archivoEstadoJuego.exists()) {
				JOptionPane.showMessageDialog(this, "No se ha guardado ninguna partida");
			}else {
				Jugador raiz =ventana.getJuego().getRaiz();
				ventana.getPanelInfo().actualizarInformacion(raiz);
				ventana.moverBall();
			}
			
		}else if(comando.equals(BUSCAR)) {
			mostrarJugadorBuscado();
		}
	}
}
