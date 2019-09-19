package br.edu.fatec.banco;

import java.io.File;
import java.io.IOException;

import br.edu.fatec.banco.resource.JsonReader;
import br.edu.fatec.banco.resource.Reader;

public class App {
	
    public static void main( String[] args ) throws IOException {
    	
    	File file = new File(System.getProperty("user.dir") + "\\data.json");
    	
    	Reader reader = new JsonReader();
    	
    	if (file.exists()) {
    		reader.read(file);
    	} else {
    		System.out.println("Arquivo não encontrado!");
    	}
    }
}
