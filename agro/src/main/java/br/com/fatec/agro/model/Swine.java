package br.com.fatec.agro.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A porcine/swine animal 
 * 
 * @author Jonathas Moraes
 * @author Guilherme Cursino
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Swine extends Animal {

	private Swine ready;
	
	/**
	 * Starts a new Swine object
	 * @return the own object
	 */
	public Swine init() {
		this.ready = new Swine();
		return this;
	}
	
	/**
	 * Sets the breed from the new swine object	
	 * @param breed
	 * @return the own object
	 */
	public Swine fromBreed(String breed) {
		this.ready.setBreed(breed);
		return this;
	}
	
	/**
	 * Sets the weight from the new swine object
	 * @param weight
	 * @return the own object
	 */
	public Swine weighing(double weight) {
		this.ready.setWeight(weight);
		return this;
	}
	
	/**
	 * Sets the cost per kg from the new swine object
	 * @param value
	 * @return the own object
	 */
	public Swine costing(double value) {
		this.ready.setValue(value);
		return this;
	}
	
	/**
	 * Declares that the base weight unity is kg. Otherwise the base is arroba 
	 * @param isKg
	 * @return the own object
	 */
	public Swine usingKgWeight(boolean isKg) {
		this.ready.isKg = isKg;
		return this;
	}
	
	/**
	 * Finishes the new object building process 
	 * @return the Swine constructed object
	 */
	public Swine build() {
		return this.ready;
	}
	
	@Override
	public String toString() {
		String weightUnity = this.isKg ? " Kg" : " Arroba";
		
		return "Animal species: Swine"
				+ "\nBreed: " + this.breed 
				+ "\nWeight: " + String.format("%.2f", this.weight) + weightUnity
				+ "\nCost per" + weightUnity + ": R$ " + String.format("%.2f", this.value);
	}
}
