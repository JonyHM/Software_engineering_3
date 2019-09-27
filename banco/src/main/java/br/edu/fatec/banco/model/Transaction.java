package br.edu.fatec.banco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Transaction {

	@XmlElement(name = "nome")
	protected String clientName;

	@XmlElement(name = "CPF")
	protected String CPF;

	@XmlElement(name = "bancoRecebimento")
	protected String receiptBank;

	@XmlElement(name = "bancoPagamento")
	protected String paymentBank;

	@XmlElement(name = "data")
	protected String paymentDate;

	@XmlElement(name = "valor")
	protected Double paymentValue;

}
