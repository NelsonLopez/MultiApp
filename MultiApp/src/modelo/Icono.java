package modelo;

import java.awt.Rectangle;

public class Icono {


	private String name;


	private int posX; 
	private int posY;
	/**
	 * @param posX
	 * @param posY
	 */
	public Icono( String name,int posx, int posy) {
		super();
		
		
		this.name = name;
		this.posX = posx; 
		this.posY = posy; 

	
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}
	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		
		this.posY = posY;
	}
	/**
	 * Este metodo se encarga del movimiento del icono dado los limites del area.
	 * @param limites
	 */
	
	public void mover(Rectangle limites) {
		
		
		
		posX += 5;
		
		if(posX > limites.getMaxX()) {
			
			posX = 0;
		}

	}

}
