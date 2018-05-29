package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
public class PanelValoresPerfil extends JPanel  implements ActionListener{

	private JLabel[] lbValores;
	private JTextField[] txtValores;
	private VentanaPerfil perfil;
	private JButton but;
	public PanelValoresPerfil(VentanaPerfil perfil) {
		
		setLayout(new GridLayout(7, 2));
		
		setPreferredSize(new Dimension(250, 400));
	
		TitledBorder border = BorderFactory.createTitledBorder( "Mi Perfil" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );
        this.perfil = perfil;
        lbValores = new JLabel[6];
        txtValores = new JTextField[6];
        inicializar();
	}
	
	public void inicializar() {
		
		lbValores[0] = new JLabel("Nombre : ");
		lbValores[1] = new JLabel("Peso: ");
		lbValores[2] = new JLabel("Estatura: ");
		lbValores[3] = new JLabel("Edad: ");
		lbValores[4] = new JLabel("Genero: ");
		lbValores[5] = new JLabel("Identificacion: ");
		txtValores[0] = new JTextField();
		txtValores[0].setText(perfil.getVent().getaplicacion().getAvatar().getNombre());
		
		txtValores[1] = new JTextField();
		txtValores[1].setText(""+perfil.getVent().getaplicacion().getAvatar().getStatura());
		txtValores[2] = new JTextField(perfil.getVent().getaplicacion().getAvatar().getNombre());
		txtValores[2].setText(""+perfil.getVent().getaplicacion().getAvatar().getPeso());
		txtValores[3] = new JTextField();
		txtValores[3].setText(""+perfil.getVent().getaplicacion().getAvatar().getEdad());
		txtValores[4] = new JTextField();
		txtValores[4].setText(""+perfil.getVent().getaplicacion().getAvatar().getGenero());
		txtValores[5] = new JTextField();
		txtValores[5].setText(""+perfil.getVent().getaplicacion().getAvatar().getId());
	
		for (int i = 0; i < lbValores.length; i++) {
			
			add(lbValores[i]);
			add(txtValores[i]);
			txtValores[i].setEditable(false);
		}
		
		JButton ima = new JButton("Guardar");
		ima.addActionListener(this);
		but = new JButton("Editar Perfil");
		but.addActionListener(this);
		add(ima);
		add(but);
}

	public void deslbloquearPerfil() {
		
		for (int i = 0; i < txtValores.length; i++) {
			
			txtValores[i].setEditable(true);
		}
	}
	
	public void bloquearPerfil() {
		
		for (int i = 0; i < txtValores.length; i++) {
			
			txtValores[i].setEditable(false);
		}
	}
	
	public String[] datosNuevos() {
		
		String[] dat = new String[6];
		
		for (int i = 0; i < txtValores.length; i++) {
			
			dat[i] = txtValores[i].getText();
		}
		
		return dat;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == but) {
			
			deslbloquearPerfil();
			
			
		}else {
			
			perfil.getVent().getaplicacion().setDatosAvatar(datosNuevos()[0], Double.parseDouble(datosNuevos()[1]),  Double.parseDouble(datosNuevos()[2]),  Integer.parseInt(datosNuevos()[3]), datosNuevos()[4], datosNuevos()[5]);
			perfil.getVent().getAvatar().setRutaDefecto(perfil.getImaPerfil().getRutaImagen());
			bloquearPerfil();
			
		}
		
	}
}
