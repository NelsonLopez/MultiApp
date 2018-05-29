package modelo;

import interfaces.Calculable;

public class CalcularNotas implements Calculable {
	
	
	private double  acumulado;
	
	public CalcularNotas() {
		
		
		acumulado = 0;
		
	}


	@Override
	/**
	 * Este metodo suma dos numeros
	 * @param num1
	 * @param num2
	 * @return
	 */
	public double sumar(double num1, double num2) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	/**
	 * Este metodo multiplica dos numeros
	 * @param num1
	 * @param num2
	 * @return
	 */
	public double multiplicar(double num1, double num2) {

		double mult =(num1 *(num2/100));
		acumulado +=  mult;
		return mult;
	}


	/**
	 * @return the acumulado
	 */
	public double getAcumulado() {
		return acumulado;
	}


	/**
	 * @param acumulado the acumulado to set
	 */
	public void setAcumulado(double acumulado) {
		this.acumulado = acumulado;
	}
	
	
}
