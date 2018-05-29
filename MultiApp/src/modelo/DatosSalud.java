package modelo;

public class DatosSalud {

	
	
	private double iMC; 
	
	private String estadoIMC;
	
	private String pesoIdeal;
	
	
	
	
	// Constructor
	
	public DatosSalud() {
		
		iMC =0;
		estadoIMC = "";
		
	}

	
	//Metodos
	/**
	 * Este metodo calcula el iMc de un usuario
	 * @param peso
	 * @param statura
	 */
	public void calcularIMC( double peso, double statura) {
		
		
		iMC = (peso/(statura * statura));
		
		
	}
	
	/**
	 * Este metodo revisa el estado del Imc de un usuario
	 * @return
	 */
	public String revisarEstado() {
		
		if(iMC<18 ) {
			
			estadoIMC = "Peso bajo";	
		}else if(iMC >=18 && iMC <= 24.9 ) {
			
			estadoIMC = "Normal";	
		}else if(iMC >=25   && iMC<= 26.9) {
			
			estadoIMC = "sobrePeso";	
		}else if(iMC >= 27   && iMC<= 29.9) {
			
			estadoIMC = "Obesidad Grado I";	
		}else if(iMC >= 30  && iMC<= 39.9) {
			
			estadoIMC = "Obesidad Grado II";	
		}else {
			
			estadoIMC = "Obesidad Grado II";	
			
		}
		
		return estadoIMC;
	}
	
	
	/**
	 * Este metodo informe cual dberia ser el peso ideal de un usuario
	 * @param estatura
	 * @return
	 */
	
	public String darIdeal(double estatura) {
		
		
		String m  = "";
		
		if(estatura >= 1.45 && estatura <= 1.52) {
			
				m = "Tu peso deberia estar 45-59 kg."; 
		}else if(estatura >= 1.53 && estatura <= 1.60) {
			
				m = "Tu peso deberia estar 47-62 kg.";
		}else	if(estatura >= 1.61 && estatura <= 1.65) {
			
			 m = "Tu peso deberia estar  50-67 kg.";
		}else if(estatura >= 1.65 && estatura < 1.70 ){
			
			m = "Tu peso deberia estar  53-71 kg.";
			
		}else {
			
			m =  " Peso  + 53 kg.";
		}
		
		return m ;
	}
	//Getter and Setter
	
	/**
	 * @return the iMC
	 */
	public double getiMC() {
		return iMC;
	}

	/**
	 * @param iMC the iMC to set
	 */
	public void setiMC(double iMC) {
		this.iMC = iMC;
	}

	/**
	 * @return the estado
	 */
	public String getEstadoIMC() {
		return estadoIMC;
	}

	/**
	 * @param estadoIMC the estadoIMC to set
	 */
	public void setEstadoIMC(String estadoIMC) {
		this.estadoIMC = estadoIMC;
	}

	
	
	
}
