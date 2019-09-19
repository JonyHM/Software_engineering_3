package br.edu.fatec.banco.resource;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import br.edu.fatec.banco.model.Transaction;

public abstract class Reader {
	
	protected List<String> fileList = new ArrayList<String>();

	public abstract List<Transaction> convert();
	
	public void read(File file) throws IOException {
		JsonObject obj;
		Gson gson = new Gson();
		
		JsonReader reader = new JsonReader(new FileReader(file));
		reader.beginArray();
		
		while (reader.hasNext()) {			
			obj = gson.fromJson(reader, JsonObject.class);
			System.out.println(obj.get("nome"));
		}
		
		reader.close();
	}
	
	public boolean CPFValidator() {
		return true;
	}
}