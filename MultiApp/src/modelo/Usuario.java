package modelo;

import java.util.ArrayList;

public class Usuario {

	private ArrayList<Icono> iconos;
	private String[] mensajes;
	protected String nombre;
	public Usuario(String usuario) {
		
		this.nombre = nombre;
		iconos= new ArrayList<Icono>();
		mensajes = new String[5];
		inicializarIconos();
	}

	/**
	 * Este metodo se encarga de inicializar los iconos del programa
	 */
	
	public void inicializarIconos() {
		
		
		iconos.add(new Icono("ims/book.png", 75, 10));
		iconos.add(new Icono("ims/ned2.png", 362, 12));
		iconos.add(new Icono("ims/ot.png", 787, 13));
		iconos.add(new Icono("ims/box.png", 558, 9));
		iconos.add(new Icono("ims/apo.png", 159, 9));
		
		
		mensajes[0] = "Come sanamente!!";
		mensajes[1] = "Sal a correr 2 dias a la Semana";
		mensajes[2] = "Escuchar musica te relaja";
		mensajes[3] = "Con vida util tu vda es mas fácil";
		mensajes[4] = "Ni idea!";
	}
	/**
	 * @return the mensajes
	 */
	public String[] getMensajes() {
		return mensajes;
	}

	public ArrayList<Icono> darIconos(){
	
		return iconos;
		
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	

	

}


