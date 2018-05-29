package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import excepcion.UsuarioVacioException;
import excepcion.NoExisteNombreException;
import hilo.HiloCabecera;
import modelo.Avatar;
import modelo.Aplicacion;



public class VentanaPrincipal  extends JFrame{

	private PanelAvatar avatar;
	private PanelAnimacion animacion; 
	private HiloCabecera superior;
	private PanelComentarios comentariosAvatar;
	private PanelHerramientas herramientas;
	private PanelEntretenimiento entretenimiento;
	private Aplicacion aplicacion;
	
	public VentanaPrincipal() {
		
		setVisible(true);
		setTitle("Multi App");
		setBounds(0, 0, 1050, 730);
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Toolkit screem = Toolkit.getDefaultToolkit();
		Image imag = screem.getImage("ims/dance.png");
		setIconImage(imag);
		
		
		aplicacion = new Aplicacion();
		animacion = new PanelAnimacion(this);
		comentariosAvatar = new PanelComentarios();
		herramientas = new PanelHerramientas(this);
		entretenimiento = new PanelEntretenimiento(this);
		dialoPrincipal();
		//add(avatar, BorderLayout.CENTER);
		add(animacion, BorderLayout.NORTH);
		add(comentariosAvatar, BorderLayout.SOUTH);
		add(herramientas, BorderLayout.WEST);
		add(entretenimiento, BorderLayout.EAST);
		
		
		
		pack();
		
	}
	
	public void dialoPrincipal() {
		String nombre = "";
		String genero= "";
		String id= "";
		double peso = 0;
		double statura = 0;
		int edad = 0;
		
		int yesOption = JOptionPane.showConfirmDialog(this, "¿Es usuario nuevo?", "Iniciar ", JOptionPane.YES_NO_OPTION);
		
		if(yesOption == JOptionPane.YES_OPTION) {
		try {
		 nombre = JOptionPane.showInputDialog(this, "Ingrese su nombre");
		 genero = JOptionPane.showInputDialog(this, "Ingrese su género");
		
		 peso  = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese su peso "));
		 statura = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese su estatura con formato( #.##)"));
		 edad  = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese su edad"));
		 id  = JOptionPane.showInputDialog(this, "Ingrese su Identificacion");
		 String ima = elegirImagen();
		 aplicacion.setDatosAvatar(nombre, peso, statura, edad, genero, id);
		 aplicacion.agregarAvatarObjeto(nombre, peso, statura, edad, genero, id, ima);
		 if(ima == null) {
				ima = "ims/user.png"; 
			}
		avatar = new PanelAvatar(nombre, ima);
		add(avatar, BorderLayout.CENTER);
		}catch(NumberFormatException e){
			
			JOptionPane.showMessageDialog(this, "Ingre los datos correctos");
		}
		
		}else {
			
			try {
				String rutaFile= elegirArchivo();
				cargar(rutaFile);
			} catch (UsuarioVacioException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	
	public void cargar(String rut) throws UsuarioVacioException {
		
		File re = new File(rut);
		try {
			String[] pr = aplicacion.leerArchivoDatos(re);
			
	
			aplicacion.setDatosAvatar(pr[0], Double.parseDouble(pr[1]),  Double.parseDouble(pr[2]),  Integer.parseInt(pr[3]), pr[4], pr[6]);
			avatar = new PanelAvatar(pr[0], pr[5]);
			add(avatar, BorderLayout.CENTER);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public String elegirArchivo() throws UsuarioVacioException {
		
		JOptionPane.showMessageDialog(this, "Acontinuacion eliga su Nombre");
		
		JFileChooser chu = new JFileChooser();
		chu.setCurrentDirectory(new File("Files/Registros"));
		chu.showOpenDialog(null);
		chu.isVisible();
		
		String rut = chu.getSelectedFile().getAbsolutePath();
		if(rut == null) {
			throw new UsuarioVacioException();
		}
			
		return rut;
		}
		

	
	public String elegirImagen() {
		
		JOptionPane.showMessageDialog(this, "Acontinuacion eliga su imagen");
		JFileChooser chu = new JFileChooser();
		chu.setCurrentDirectory(new File("ims/avatars"));
		chu.showOpenDialog(null);
		chu.isVisible();
		
		String rut = chu.getSelectedFile().getAbsolutePath();
		
		return rut;
	
	}
	/**
	 * @return the aplicacion
	 */
	public Aplicacion getaplicacion() {
		return aplicacion;
	}


	

	/**
	 * @return the animacion
	 */
	public PanelAnimacion getAnimacion() {
		return animacion;
	}


	public VentanaConvertidor mostrarConvertidor() {	
		VentanaConvertidor  dialogo =new VentanaConvertidor(this);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
	return dialogo;
	
	}
	public VentanaCalculadora mostrarCalculadora() {
		
		VentanaCalculadora calcu =  new VentanaCalculadora(this);
		calcu.setLocationRelativeTo(this);
		calcu.setVisible(true);
		return calcu;
	}
	
	public VentanaCalcularNotas mostrarCalcularNotas() {
		
		VentanaCalcularNotas calcu =  new VentanaCalcularNotas(this);
		calcu.setLocationRelativeTo(this);
		calcu.setVisible(true);
		return calcu;
	}
	
	public VentanaSalud mostrarDatosSalud() {
		
		VentanaSalud calcu =  new VentanaSalud(this);
		calcu.setLocationRelativeTo(this);
		calcu.setVisible(true);
		return calcu;
	}
	
	public VentanaPerfil mostrarPerfil() {
		
		VentanaPerfil calcu =  new VentanaPerfil(this);
		calcu.setLocationRelativeTo(this);
		calcu.setVisible(true);
		
		avatar.setRutaDefecto(calcu.getImaPerfil().getRutaImagen());
		return calcu;
	}
	public void mover() {
		
		superior = new HiloCabecera(this, aplicacion.getUser().darIconos());
		superior.start();
	}
	
	public VentanaBlockNotas mostrarBlockBotas() {
		
		VentanaBlockNotas bloc = new VentanaBlockNotas(this);
		bloc.setLocationRelativeTo(this);
		bloc.setVisible(true);
		return bloc;
		
	}
	
	public VentanaReproductor mostrarReproductor() {
		
		VentanaReproductor bloc = new VentanaReproductor(this);
		bloc.setLocationRelativeTo(this);
		bloc.setVisible(true);
		return bloc;
		
	}
	
	public VentanaJuego mostrarJuego() {
		
		VentanaJuego bloc = new VentanaJuego(this);
		bloc.setLocationRelativeTo(this);
		bloc.setVisible(true);
		return bloc;
	}


	
	/**
	 * @return the avatar
	 */
	public PanelAvatar getAvatar() {
		return avatar;
	}

	public void refrescar() {
		
		
		avatar.repaint();
		

	}
	/**
	 * @return the comentariosAvatar
	 */
	public PanelComentarios getComentariosAvatar() {
		return comentariosAvatar;
	}


	public static void main(String[] args) {
		
		VentanaPrincipal vent = new VentanaPrincipal();
		vent.mover();
	}

}
