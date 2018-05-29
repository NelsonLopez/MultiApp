package modelo;

import interfaces.Calculable;

public class Calculadora implements Calculable{
	

	public Calculadora() {
		
	}

	//Metodos
	
	
	@Override
	/**
	 * Este metodo suma dos numeros
	 * @param num1
	 * @param num2
	 * @return
	 */
	public double sumar(double num1, double num2) {
	
	double suma = (num1+num2);
		return suma;
		
	}

	@Override
	/**
	 * Este metodo multiplica dos numeros
	 * @param num1
	 * @param num2
	 * @return
	 */
	public double multiplicar(double num1, double num2) {
		
		double valorMultiplicacion = (num1* num2);
		return valorMultiplicacion;
	}
	/**
	 * Este metodo divide dos numeros
	 * @param num1
	 * @param num2
	 * @return
	 */
	
	public double dividir(double num1, double num2) {
		double valorDivision= 0;
		try {
		valorDivision= (num1/num2);
			
			
		}catch(ArithmeticException e) {
			
		}
		return valorDivision;
	}
	/**
	 * Este metodo resta dos numeros
	 * @param num1
	 * @param num2
	 * @return
	 */
	public double restar(double num1, double num2) {
		
		double valorResta = (num1-num2);
			return valorResta;
			
		}
	

}
