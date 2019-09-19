package br.edu.fatec.banco.resource;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.edu.fatec.banco.model.Transaction;

public class JsonReader extends Reader {

	private Gson gson = new Gson();
	private List<Transaction> transactionList = new ArrayList<Transaction>();
	
	@Override
	public List<Transaction> convert() {

		this.fileList.forEach(file -> {
			 this.transactionList.add(this.gson.fromJson(file, Transaction.class));
		});
		
		return this.transactionList;
	}

}
