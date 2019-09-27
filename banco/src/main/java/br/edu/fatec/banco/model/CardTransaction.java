package br.edu.fatec.banco.model;

import br.edu.fatec.banco.resource.CPFValidator;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "br.com.pageseguro.RemessaCartaoDebito")
public class CardTransaction extends Transaction {

	@XmlElement(name = "numeroCartao")
	protected String cardNumber;

	@XmlElement(name = "nomeTitular")
	protected String cardOwner;

	public static CardTransaction parseFromJsonObject(JsonObject object) {
		CardTransaction debit = new CardTransaction();

		String CPF = object.get("CPF").toString();

		if (CPFValidator.validate(CPF)) {
			debit.setCPF(CPF);
		} else {
			System.out.println("CPF " + CPF + " Inválido");
			debit.setCPF("00000000000");
		}

		debit.setClientName(object.get("nome").toString());
		debit.setReceiptBank(object.get("bancoRecebimento").toString());
		debit.setPaymentBank(object.get("bancoPagamento").toString());
		debit.setPaymentDate(object.get("data").toString());
		debit.setPaymentValue(Double.parseDouble(object.get("valor").toString()));
		debit.setCardNumber(object.get("numeroCartao").toString());
		debit.setCardOwner(object.get("nomeTitular").toString());

		return debit;
	}
}
