package br.edu.fatec.banco;

import br.edu.fatec.banco.resource.Reader;
import br.edu.fatec.banco.resource.ReaderJson;
import br.edu.fatec.banco.resource.ReaderXML;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public class App {
	
    public static void main( String[] args ) throws IOException, JAXBException {

		System.out.println("\n\t\tJson File: \n");
    	File json = new File(System.getProperty("user.dir") + "\\data.json");

    	instantiateReader(json);

		System.out.println("\n\t\tXML File: \n");
		File xml = new File(System.getProperty("user.dir") + "\\data.xml");

		instantiateReader(xml);
    }

    private static void instantiateReader(File file) throws IOException, JAXBException {
		Reader reader;

		if (file.exists() && getFileExtension(file).equals("xml")) {
			reader = new ReaderXML();
			reader.read(file);
		} else if (file.exists() && getFileExtension(file).equals("json")) {
			reader = new ReaderJson();
			reader.read(file);
		} else {
			System.out.println("Arquivo não encontrado!");
		}
	}
    
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
        	return fileName.substring(fileName.lastIndexOf(".")+1);
        }
        else return "";
    }
}
