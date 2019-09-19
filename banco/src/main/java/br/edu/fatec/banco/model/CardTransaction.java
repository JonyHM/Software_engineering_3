package br.edu.fatec.banco.model;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XStreamAlias("br.com.pageseguro.RemessaCartaoDebito")
public class CardTransaction extends Transaction {
	
	@XStreamAlias("numeroCartao")
	private String cardNumber;
	
	@XStreamAlias("nomeTitular")
	private String cardOwner;

	public CardTransaction(String client, String CPF, String receiptBank, String paymentBank, Date paymentDate,
			Double paymentValue, String cardNumber, String cardOwner) {
		
		super(client, CPF, receiptBank, paymentBank, paymentDate, paymentValue);
		this.cardNumber = cardNumber;
		this.cardOwner = cardOwner;
	}
	
}
