package br.com.fatec.agro.resource;


/**
 * Class to convert the weight unity from the animal
 * 
 * @author Jonathas Moraes
 * @author Guilherme Cursino
 *
 */
public class WeightCalculator {
	
	private static WeightCalculator calculator;
	
	private WeightCalculator() {	}
	
	/**
	 * Get an instance from weight calculator.
	 * 
	 * @return the single existing instance from the calculator or instantiates a new object
	 */
	public static WeightCalculator getInstance() {
		return calculator == null 
				? new WeightCalculator() 
				: calculator;
	}

	/**
	 * Converts kg weight to arroba
	 * @param weight value in kg
	 * @return the weight converted to arroba 
	 */
	public double kgToArroba(double weight) {
		return weight / 15d;
	}

	/**
	 * Converts arroba weight to kg
	 * @param weight value in arroba
	 * @return the weight converted to kg
	 */
	public double arrobaToKg(double weight) {		
		return weight * 15d;
	}
}
