package br.edu.fatec.banco.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Transaction {

	protected String client;
	protected String CPF;
	protected String receiptBank;
	protected String paymentBank;
	protected Date paymentDate;
	protected Double paymentValue;
	
}
