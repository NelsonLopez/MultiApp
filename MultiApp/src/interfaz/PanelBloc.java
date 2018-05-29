package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelBloc extends JPanel{
	private VentanaBlockNotas dialogo;
	private JTextArea hoja;
	
	public PanelBloc() {
		setLayout(new GridLayout(0, 1));
		TitledBorder border =BorderFactory.createTitledBorder("Escriba su nueva nota");
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		setPreferredSize(new Dimension(500,300));
		
		hoja =new JTextArea();
		hoja.setBackground(Color.WHITE);
		
		add(hoja);
	}
	
	public String getContenido() {
		return hoja.getText();
	}
	
	public void setContenido(String nou){
		hoja.setText(nou);
		
	}
}
