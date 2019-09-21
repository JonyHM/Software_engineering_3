package br.edu.fatec.banco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "list")
public class TransactionList {

	@XmlElements({
			@XmlElement(name = "br.com.pageseguro.RemessaBoleto", type = InvoiceTransaction.class),
			@XmlElement(name = "br.com.pageseguro.RemessaCartaoDebito", type = CardTransaction.class),
			@XmlElement(name = "br.com.pageseguro.RemessaCartaoCredito", type = CreditCardTransaction.class)
	})
	private List<Transaction> list = new ArrayList<>();
}
