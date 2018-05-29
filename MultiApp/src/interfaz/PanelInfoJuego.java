package interfaz;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import modelo.Jugador;

public class PanelInfoJuego extends JPanel{
	private JTextField txtPuntaje;
	private JLabel labPuntaje;
	private JTextField txtNivel;
	private JLabel labNivel;
	private JTextField txtNick;
	private JLabel labNick;
	
	private VentanaJuego ventana;
	
	public PanelInfoJuego(VentanaJuego ventana) {
		this.ventana =ventana;
		setLayout(new GridLayout(1, 8));
		setPreferredSize(new Dimension(50,100));
		
		txtPuntaje =new JTextField();
		txtNivel =new JTextField();
		txtNick =new JTextField();
		labPuntaje =new JLabel("Puntaje");
		labNivel =new JLabel("       Nivel");
		labNick =new JLabel("Nickname");

		
		TitledBorder border = BorderFactory.createTitledBorder("Informacion");
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		setBackground(Color.LIGHT_GRAY);
		
		add(labNick);
		add(txtNick);
		add(new JLabel(""));
		add(new JLabel(""));
		add(labPuntaje);
		add(txtPuntaje);
		add(labNivel);
		add(txtNivel);
	}

	
	public void refrescarNick(Jugador agregado) {
		txtNick.setText(agregado.getNickname());
		Font fuente =new Font("",Font.PLAIN, 40);
		txtNick.setFont(fuente);
		
	}
	
	public void refrescarPuntaje(Jugador agregado) {
		txtPuntaje.setText(""+agregado.getPuntajeAcum());
		Font fuente =new Font("",Font.PLAIN, 40);
		txtPuntaje.setFont(fuente);
	}
	
	public void refrescarNivel(Jugador agregado) {
		txtNivel.setText(""+agregado.getNivelLlegado());
		Font fuente =new Font("",Font.PLAIN, 40);
		txtNivel.setFont(fuente);
	}
	
	public void actualizarInformacion(Jugador agregado) {
		refrescarPuntaje(agregado);
		refrescarNivel(agregado);
		refrescarNick(agregado);
	}
	
	
}
