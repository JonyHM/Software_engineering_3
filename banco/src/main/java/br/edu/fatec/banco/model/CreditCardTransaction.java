package br.edu.fatec.banco.model;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XStreamAlias("br.com.pageseguro.RemessaCartaoCredito")
public class CreditCardTransaction extends CardTransaction {

	@XStreamAlias("parcelas")
	private int parcel;
	
	public CreditCardTransaction(String client, String CPF, String receiptBank, String paymentBank, Date paymentDate,
			Double paymentValue, String cardNumber, String cardOwner, int parcel) {
		
		super(client, CPF, receiptBank, paymentBank, paymentDate, paymentValue, cardNumber, cardOwner);
		this.parcel = parcel;
	}

}
