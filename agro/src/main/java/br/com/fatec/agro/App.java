package br.com.fatec.agro;

import br.com.fatec.agro.model.Animal;
import br.com.fatec.agro.model.Swine;

public class App {
    public static void main( String[] args ) {
    	
        Animal boi = new Swine().init()
        		.fromBreed("cu")
        		.weighing(150.0)
        		.build();
        
        System.out.println(boi);
    }
}
