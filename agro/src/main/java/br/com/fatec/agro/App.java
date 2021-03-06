package br.com.fatec.agro;

import br.com.fatec.agro.model.Animal;
import br.com.fatec.agro.model.AnimalGroup;
import br.com.fatec.agro.model.Bovine;
import br.com.fatec.agro.model.Swine;
import br.com.fatec.agro.resource.PriceCalculator;

public class App {
    public static void main( String[] args ) {
    	
    	PriceCalculator priceCalc = PriceCalculator.getInstance();
//    	WeightCalculator weight = WeightCalculator.getInstance(); 
    	
        Animal pork = new Swine().init()
        		.fromBreed("Gaguinho")
        		.weighing(24)
        		.costing(3.74)
        		.usingKgWeight(true)
        		.build();
        
        Animal cow = new Bovine().init()
        		.fromBreed("Bandido")
        		.weighing(3)
        		.costing(174.3)
        		.usingKgWeight(false)
        		.build();
        
        AnimalGroup group = new AnimalGroup();
        group.addAnimal(cow).addAnimal(pork);
        
        System.out.println("\n-----------------------------------\n");
        
        System.out.println(pork);
        System.out.println("Total cost: R$ " + String.format("%.2f", priceCalc.price(pork)));
        
        System.out.println("\n-----------------------------------\n");
        
        System.out.println(cow);
        System.out.println("Total cost: R$ " + String.format("%.2f", priceCalc.price(cow)));
        
        System.out.println("\n-----------------------------------\n");
        
        System.out.println("Animal group:\n");
        group.getAnimals().stream()
    		.map(animal -> "\n" + animal)
        	.forEach(System.out::println);
        System.out.println("\nTotal : R$ " + String.format("%.2f", priceCalc.price(group)));
        
    }
}
