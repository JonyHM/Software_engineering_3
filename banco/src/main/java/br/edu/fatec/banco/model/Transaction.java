package br.edu.fatec.banco.model;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Transaction {

	@XStreamAlias("nome")
	protected String client;
	
	@XStreamAlias("CPF")
	protected String CPF;
	
	@XStreamAlias("bancoRecebimento")
	protected String receiptBank;
	
	@XStreamAlias("bancoPagamento")
	protected String paymentBank;
	
	@XStreamAlias("data")
	protected Date paymentDate;
	
	@XStreamAlias("valor")
	protected Double paymentValue;
	
	public Transaction(String client, String CPF, String receiptBank, String paymentBank, Date paymentDate,
			Double paymentValue) {
		this.client = client;
		this.CPF = CPF;
		this.receiptBank = receiptBank;
		this.paymentBank = paymentBank;
		this.paymentDate = paymentDate;
		this.paymentValue = paymentValue;
	}

}
