package modelo;

public class Personaje {
	public final static int lARGO_AMARILLO=75;
	public final static int LARGO_ROJO=78;
	public final static int ANCHO_AMARILLO=113;
	public final static int ANCHO_ROJO=78;


	private int posX;
	private int posY;
	private int direccion;

	public Personaje(int x, int y) {
		this.posX =x;
		this.posY =y;
		direccion =1;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosX(int x) {
		posX =x;
	}
	
	public void setPosY(int y) {
		posY =y;
	}
	
	public int getDireccion() {
		return direccion;
	}
	
	public void moveUp(int posYClick) {
		if(posY>posYClick)
			posY-=8;
	}
	
	public void moveDown(int posYClick) {
		if(posY<posYClick)
			posY+=8;
	}
	
	public void moveRight(int posXClick) {
		if(posX<posXClick)
			posX+=8;
	}
	
	public void moveLeft(int posXClick) {
		if(posX>posXClick)
			posX-=8;
	}
	
	public void moverPersonaje(int posXClick, int posYClick) {
		moveUp(posYClick);
		moveDown(posYClick);
		moveLeft(posXClick);
		moveRight(posXClick);
	}
	
	
	public void moverRival() {
		boolean limSup =posY> 180 && posY<190;
		boolean limInf =posY>300 && posY<310;
		
		if(limSup || limInf) 
			direccion*=-1;		
		
		posY+=direccion*2;
	}
}
