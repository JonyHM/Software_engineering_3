package br.com.fatec.agro.model;

import java.util.List;

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
/**
 * Group of animals, whether bovine or Swine
 * @author Aluno
 *
 */
public class AnimalGroup {

	private List<Animal> animals;
	private double totalPrice;
	
	/**
	 * Adds an animal into the group
	 * @param animal
	 */
	public void addAnimal(Animal animal) {
		this.animals.add(animal);
	}
	
	/**
	 * Removes an animal from the group
	 * @param animal
	 */
	public void removeAnimal(Animal animal) {
		this.animals.remove(animal);
	}
}
