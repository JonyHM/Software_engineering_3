package br.edu.fatec.banco.resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Reader {
	
	protected List<String> fileList = new ArrayList<String>();

	public abstract void read(File file) throws FileNotFoundException, IOException;
	
	public boolean CPFValidator() {
		return true;
	}
}