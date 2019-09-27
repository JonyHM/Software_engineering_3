package br.edu.fatec.banco.resource;

import br.edu.fatec.banco.model.TransactionList;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

public abstract class Reader {

	protected TransactionList list = new TransactionList();
	
	public abstract void read(File file) throws IOException, JAXBException;

}