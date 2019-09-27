package br.edu.fatec.banco.model;

import br.edu.fatec.banco.resource.CPFValidator;
import com.google.gson.JsonObject;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "br.com.pageseguro.RemessaBoleto")
public class InvoiceTransaction extends Transaction {

	@XmlElement(name = "numeroBoleto")
	private String invoiceNumber;

	public static InvoiceTransaction parseFromJsonObject(JsonObject object) {
		InvoiceTransaction invoice = new InvoiceTransaction();

		String CPF = object.get("CPF").toString();

		if (CPFValidator.validate(CPF)) {
			invoice.setCPF(CPF);
		} else {
			System.out.println("CPF " + CPF + " Inválido");
			invoice.setCPF("00000000000");
		}

		invoice.setClientName(object.get("nome").toString());
		invoice.setReceiptBank(object.get("bancoRecebimento").toString());
		invoice.setPaymentBank(object.get("bancoPagamento").toString());
		invoice.setPaymentDate(object.get("data").toString());
		invoice.setPaymentValue(Double.parseDouble(object.get("valor").toString()));
		invoice.setInvoiceNumber(object.get("numeroBoleto").toString());

		return invoice;
	}
}
