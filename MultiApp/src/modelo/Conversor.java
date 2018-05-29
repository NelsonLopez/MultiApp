package modelo;

public class Conversor {
	
	
	public static final double KELVIN 	= 273.15;
	public static final double FAREN = 32;
	
	public Conversor() {
		
		
	}
	/**
	 * Este metodo concierte una temperatura C° a grados F°
	 * @param temp
	 * @return
	 */
	public double convertirCelsiusFahrenheit( double temp) {
		
		double nuevaTem = ((9/5)* temp) + FAREN;
		
		return nuevaTem;
		
		
	}
	/**
	 * Este metodo concierte una temperatura C° a grados K
	 * @param temp
	 * @return
	 */
	public double convertirCelciusKelvin(double temp) {
		
		double nuevaTem = temp + KELVIN;
		
		return nuevaTem;
		
	}
	/**
	 * Este metodo concierte una temperatura K a grados F°
	 * @param temp
	 * @return
	 */
	
	public double convertirKelvinFahrenheit(double temp) {
		
		double nuevaTem = ((temp - KELVIN)*1.8000 )+ FAREN;
		
		return nuevaTem;
		
	}
	/**
	 * Este metodo concierte una temperatura K a grados C°
	 * @param temp
	 * @return
	 */
	public double convertirKelvinCelsius(double temp) {
		
		double nuevaTem = temp - KELVIN;
		
		return nuevaTem;
	}
	/**
	 * Este metodo concierte una temperatura °F a grados K
	 * @param temp
	 * @return
	 */
	public double convertirFahrenheitKelvin(double temp) {
		double nuevaTem = ((temp - FAREN) / 1.8000) + KELVIN;
		
		return nuevaTem;
	}
	/**
	 * Este metodo concierte una temperatura °F a grados C°
	 * @param temp
	 * @return
	 */
	public double convertirFahrenheitCelsius(double temp) {
		double nuevaTem = (temp - FAREN) * (5/9);
		
		return nuevaTem;
	}
	
}
