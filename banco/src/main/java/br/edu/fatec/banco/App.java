package br.edu.fatec.banco;

import java.io.File;
import java.io.IOException;

import br.edu.fatec.banco.resource.Reader;
import br.edu.fatec.banco.resource.ReaderXML;

public class App {
	
    public static void main( String[] args ) throws IOException {
    	
    	Reader reader;
    	File file = new File(System.getProperty("user.dir") + "\\data.json");
    	
    	
    	if (file.exists() && getFileExtension(file) == "xml") {
    		reader = new ReaderXML();
    		reader.read(file);
    	} else {
    		System.out.println("Arquivo não encontrado!");
    	}
    }
    
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
