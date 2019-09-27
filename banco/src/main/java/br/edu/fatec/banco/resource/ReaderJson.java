package br.edu.fatec.banco.resource;

import br.edu.fatec.banco.model.CardTransaction;
import br.edu.fatec.banco.model.CreditCardTransaction;
import br.edu.fatec.banco.model.InvoiceTransaction;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderJson extends Reader {

	private Gson gson = new Gson();

	@Override
	public void read(File file) throws IOException, JsonIOException, JsonSyntaxException {
		JsonObject obj;
		
		JsonReader reader = new JsonReader(new FileReader(file));
		reader.beginArray();
		
		while (reader.hasNext()) {			
			obj = this.gson.fromJson(reader, JsonObject.class);
			
			if(obj.get("numeroBoleto") != null) {
                InvoiceTransaction invoice = InvoiceTransaction.parseFromJsonObject(obj);
                this.list.getList().add(invoice);
			} else if(obj.get("numeroCartao") != null && obj.get("parcelas") != null) {
			    CreditCardTransaction credit = CreditCardTransaction.parseFromJsonObject(obj);
                this.list.getList().add(credit);
			} else {
                CardTransaction debit = CardTransaction.parseFromJsonObject(obj);
				this.list.getList().add(debit);
			}
		}
		reader.close();
	}

}
