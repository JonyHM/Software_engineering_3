package br.com.fatec.agro.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A bovine animal
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
public class Bovine extends Animal {
	
	private Bovine ready;

	/**
	 * Starts a new Bovine object
	 * @return the own object
	 */
	public Bovine init() {
		this.ready = new Bovine();
		return this;
	}
	
	/**
	 * Sets the breed from the new bovine object	
	 * @param breed
	 * @return the own object
	 */
	public Bovine fromBreed(String breed) {
		this.ready.setBreed(breed);
		return this;
	}
	
	/**
	 * Sets the weight from the new bovine object
	 * @param weight
	 * @return the own object
	 */
	public Bovine weighing(double weight) {
		this.ready.setWeight(weight);
		return this;
	}

	/**
	 * Sets the cost per kg from the new bovine object
	 * @param value
	 * @return the own object
	 */
	public Bovine costing(double value) {
		this.ready.setValue(value);
		return this;
	}
	
	/**
	 * Declares that the base weight unity is kg. Otherwise the base is arroba 
	 * @param isKg
	 * @return the own object
	 */
	public Bovine usingKgWeight(boolean isKg) {
		this.ready.isKg = isKg;
		return this;
	}
	
	/**
	 * Finishes the new object building process and returns the constructed object
	 * @return the Bovine constructed object
	 */
	public Bovine build() {
		return this.ready;
	}
	
	@Override
	public String toString() {
		String weightUnity = this.isKg ? " Kg" : " Arroba";
		
		return "Animal species: Bovine"
				+ "\nBreed: " + this.breed 
				+ "\nWeight: " + String.format("%.2f", this.weight) + weightUnity
				+ "\nCost per" + weightUnity + ": R$ " + String.format("%.2f", this.value);
	}

}
