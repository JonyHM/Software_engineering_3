package br.edu.fatec.banco.resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.crypto.dsig.XMLObject;

import com.thoughtworks.xstream.XStream;

public class ReaderXML extends Reader {
	
	private XStream xstream = new XStream();

	@Override
	public void read(File file) throws FileNotFoundException, IOException {
		XMLObject obj;
		
		xstream.fromXML(file);
		
	}

}
