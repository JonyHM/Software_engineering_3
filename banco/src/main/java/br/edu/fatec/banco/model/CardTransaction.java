package br.edu.fatec.banco.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardTransaction extends Transaction {
	
	private String cardNumber;
	private String cardOwner;

	public CardTransaction(String client, String CPF, String receiptBank, String paymentBank, Date paymentDate,
			Double paymentValue, String cardNumber, String cardOwner) {
		
		super(client, CPF, receiptBank, paymentBank, paymentDate, paymentValue);
		this.cardNumber = cardNumber;
		this.cardOwner = cardOwner;
	}
	
}
