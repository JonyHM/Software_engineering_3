package br.edu.fatec.banco.model;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XStreamAlias("br.com.pageseguro.RemessaBoleto")
public class InvoiceTransaction extends Transaction {

	@XStreamAlias("numeroBoleto")
	private String invoiceNumber;
	
	public InvoiceTransaction(String client, String CPF, String receiptBank, String paymentBank, Date paymentDate,
			Double paymentValue, String invoiceNumber) {
		
		super(client, CPF, receiptBank, paymentBank, paymentDate, paymentValue);		
		this.invoiceNumber = invoiceNumber;
	}

}
