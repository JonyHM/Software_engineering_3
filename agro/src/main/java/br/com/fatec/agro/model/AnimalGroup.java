package br.com.fatec.agro.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Group of animals, whether bovine or Swine
 * 
 * @author Jonathas Moraes
 * @author Guilherme Cursino
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AnimalGroup {

	private List<Animal> animals = new ArrayList<Animal>();
	
	/**
	 * Adds an animal into the group
	 * @param animal
	 */
	public AnimalGroup addAnimal(Animal animal) {
		this.animals.add(animal);
		return this;
	}
	
	/**
	 * Removes an animal from the group
	 * @param animal
	 */
	public AnimalGroup removeAnimal(Animal animal) {
		this.animals.remove(animal);
		return this;
	}
}
