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
public class Bovine extends Animal {
	
	private Bovine ready;

	/**
	 * Starts a new Bovine object
	 * @return
	 */
	public Bovine init() {
		this.ready = new Bovine();
		return this;
	}
	
	/**
	 * Sets the breed from the new bovine object	
	 * @param breed
	 * @return
	 */
	public Bovine fromBreed(String breed) {
		this.ready.setBreed(breed);
		return this;
	}
	
	/**
	 * Sets the weight from the new bovine object
	 * @param weight
	 * @return
	 */
	public Bovine weighing(double weight) {
		this.ready.setWeight(weight);
		return this;
	}

	/**
	 * Sets the cost per kg from the new bovine object
	 * @param value
	 * @return
	 */
	public Bovine costingPerKG(double value) {
		this.ready.setKgValue(value);
		return this;
	}
	
	/**
	 * Finishes the new object building process and returns the constructed object
	 * @return
	 */
	public Bovine build() {
		return this.ready;
	}
	
	@Override
	public String toString() {
		return "Animal species: Bovine"
				+ "\nBreed: " + this.breed 
				+ "\nWeight: " + this.weight
				+ "\nCost per Kg: " + this.kgValue;
	}
}
