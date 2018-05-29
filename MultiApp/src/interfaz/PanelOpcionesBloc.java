package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class PanelOpcionesBloc extends JPanel implements ActionListener{
	
	public final static String GUARDAR="Guardar";
	public final static String NUEVA="Nueva Nota";
	public final static String ABRIR="Abrir";
	private JButton butGuardar;
	private JButton butNueva;
	private JButton butAbrir;
	private VentanaBlockNotas dialogo;
	
	
	public PanelOpcionesBloc(VentanaBlockNotas dialogo) {
		this.dialogo =dialogo;
		setLayout(new GridLayout(0, 3));
		TitledBorder border =BorderFactory.createTitledBorder("Opciones");
		border.setTitleColor(Color.BLACK);
		setBorder(border);
		
		butGuardar =new JButton(GUARDAR);
		butGuardar.addActionListener(this);
		butNueva =new JButton(NUEVA);
		butNueva.addActionListener(this);
		butAbrir =new JButton(ABRIR);
		butAbrir.addActionListener(this);
		
		add(butGuardar);
		add(butNueva);
		add(butAbrir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		
		if(comando.equals(GUARDAR)) {
			String nombreArchivo =JOptionPane.showInputDialog(this, "Ingrese el nombre de la nota a guardar");

			String contenido = dialogo.getBlock().getContenido();
			try {
				dialogo.getVent().getaplicacion().getAvatar().getBlockNotas().agregarNota(nombreArchivo, contenido);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource() == butAbrir){
				
			
			String nombreArchivo =JOptionPane.showInputDialog(this, "Ingrese el nombre de la nota ");
			
			try {
				dialogo.cargarNota(nombreArchivo);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}else {
			
			dialogo.getBlock().setContenido("");
		}
		
	}
	
	
}
