package modelo;

public class Ball {
	public final static int DORY =1;
	public final static int OTRO =0;

	private int a,b;
	private int direccionX;
	private int direccionY;
	private String imagen;
		
	public Ball( int a, int b) {
		this.a =a;
		this.b =b;
		direccionX=1;
		direccionY=1;
	}
	
	public int getA(){
		return a;
	}
	
	public int getB(){
		return b;
	}
	
	public int getDireccionY() {
		return direccionY;
	}
	
	public void setA(int a) {
		this.a =a;
	}
	
	public void setB(int b) {
		this.b =b;
	}
	
	public String getImagen() {
		return imagen;
	}
	
	public void mover(int posXJugador, int posYJugador, int posXRival, int posYRival) {
		
		boolean limDer= a> 850 && a <900;
		boolean limIzq= a>100 && a<130;
		boolean limInf =b> 380 && b<440;
		boolean limSup =b> 180 && b<200;
		
		boolean choqueHorizontal= a>posXJugador && a<posXJugador+Personaje.ANCHO_AMARILLO;
		boolean choqueVertical= b>posYJugador && b<posYJugador+Personaje.lARGO_AMARILLO;
		boolean choqueHRival =a>=700 && a<720;
		boolean choqueVRival =b>posYRival && b>posYRival+Personaje.LARGO_ROJO;
		boolean choqueJugador =choqueVertical  && choqueHorizontal;
		boolean choqueRival =choqueHRival && choqueVRival;
							
		if(limSup || limInf) 
			direccionY*=-1;		
		
		else if(limDer || limIzq || choqueJugador || choqueRival) {
			direccionX*=-1;
		}
		
		a+=direccionX*2;
		b+=direccionY*2;
	}
}
