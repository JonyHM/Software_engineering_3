package br.edu.fatec.banco.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardTransaction extends CardTransaction {

	private int parcel;
	
	public CreditCardTransaction(String client, String CPF, String receiptBank, String paymentBank, Date paymentDate,
			Double paymentValue, String cardNumber, String cardOwner, int parcel) {
		
		super(client, CPF, receiptBank, paymentBank, paymentDate, paymentValue, cardNumber, cardOwner);
		this.parcel = parcel;
	}

}
