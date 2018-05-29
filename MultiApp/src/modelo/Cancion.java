package modelo;

public class Cancion {
	private String ruta;
	private String nombre;
	private String artista;
	private String genero;
	
	private Cancion siguiente;
	private Cancion anterior;
	
	/**
	 * @param ruta
	 * @param nombre
	 * @param artista
	 * @param genero
	 */
	public Cancion(String ruta, String nombre, String artista, String genero) {
		super();
		this.ruta = ruta;
		this.nombre = nombre;
		this.artista = artista;
		this.genero = genero;
	}

	public String getRuta() {
		return ruta;
	}
	
	public void insertarDespues(Cancion nueva) {
		nueva.siguiente =siguiente;
		siguiente =nueva;
	}
	
	public void desconectarSiguiente() {
		siguiente =siguiente.siguiente;
	}
	
	public Cancion  getSiguiente() {
		return siguiente;
	}
	
	public Cancion  getAnterior() {
		return anterior;
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

	/**
	 * @return the artista
	 */
	public String getArtista() {
		return artista;
	}

	/**
	 * @param artista the artista to set
	 */
	public void setArtista(String artista) {
		this.artista = artista;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public void setSiguiente(Cancion nuevo) {
		siguiente =nuevo;
	}
	
	public void setAnterior(Cancion nuevo) {
		anterior =nuevo;
	}
}


