package br.com.fatec.agro.resource;

import br.com.fatec.agro.model.Animal;

/**
 * Class to calculate the price of the given animal
 *   
 * @author Jonathas Moraes
 * @author Guilherme Cursino
 *
 */
public class PriceCalculator {
	
	private static PriceCalculator calculator;
	
	private PriceCalculator() {	}
	
	/**
	 * Get an instance from price calculator.
	 * 
	 * @return the single existing instance from the calculator or instantiates a new object
	 */
	public static PriceCalculator getInstance() {
		return calculator == null 
				? new PriceCalculator() 
				: calculator;
	}

	/**
	 * Receives an animal and return its value based on its weight and value per weight unity
	 * @param animal
	 * @return a double value representing the animal cost
	 */
	public double price(Animal animal) {
		return animal.getValue() * animal.getWeight();
	}

}
