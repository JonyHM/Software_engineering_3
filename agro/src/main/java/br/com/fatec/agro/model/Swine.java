package br.com.fatec.agro.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
	public Swine costingPerKG(double value) {
		this.ready.setKgValue(value);
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
		return "Animal species: Swine"
				+ "\nBreed: " + this.breed 
				+ "\nWeight: " + this.weight
				+ "\nCost per Kg: " + this.kgValue;
	}
}
