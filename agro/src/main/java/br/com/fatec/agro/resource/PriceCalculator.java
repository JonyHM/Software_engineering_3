package br.com.fatec.agro.resource;

import br.com.fatec.agro.model.Animal;
import br.com.fatec.agro.model.AnimalGroup;

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
	 * 
	 * @param animal
	 * @return a double value representing the animal cost
	 */
	public double price(Animal animal) {
		return animal.getValue() * animal.getWeight();
	}
	
	/**
	 * Receives an animal group and return their total cost summed
	 * 
	 * @param group
	 * @return a double value representing the group cost
	 */
	public double price(AnimalGroup group) {
		return group.getAnimals().stream()
			.map(animal -> animal.getValue() * animal.getWeight())
			.reduce(0d, (total, valor) -> total + valor);
	}
	
}
