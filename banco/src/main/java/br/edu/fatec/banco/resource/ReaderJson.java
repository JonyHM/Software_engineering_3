package br.edu.fatec.banco.resource;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import br.edu.fatec.banco.model.CardTransaction;
import br.edu.fatec.banco.model.CreditCardTransaction;
import br.edu.fatec.banco.model.InvoiceTransaction;
import br.edu.fatec.banco.model.Transaction;

public class ReaderJson extends Reader {

	private Gson gson = new Gson();
	private List<Transaction> transactionList = new ArrayList<Transaction>();
	
	@Override
	public void read(File file) throws IOException, JsonIOException, JsonSyntaxException {
		JsonObject obj;
		
		JsonReader reader = new JsonReader(new FileReader(file));
		reader.beginArray();
		
		while (reader.hasNext()) {			
			obj = this.gson.fromJson(reader, JsonObject.class);
			
			if(obj.get("numeroBoleto") != null) {
				this.transactionList.add(this.gson.fromJson(reader, InvoiceTransaction.class));
			} else if(obj.get("numeroCartao") != null && obj.get("parcelas") != null) {
				this.transactionList.add(this.gson.fromJson(reader, CreditCardTransaction.class));
			} else {
				this.transactionList.add(this.gson.fromJson(reader, CardTransaction.class));
			}
		}
		
		reader.close();
	}

}
