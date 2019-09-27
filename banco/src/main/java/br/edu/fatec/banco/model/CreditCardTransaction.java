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
@XmlRootElement(name = "br.com.pageseguro.RemessaCartaoCredito")
public class CreditCardTransaction extends CardTransaction {

	@XmlElement(name = "parcelas")
	private int parcel;

	public static CreditCardTransaction parseFromJsonObject(JsonObject object) {
		CreditCardTransaction credit = new CreditCardTransaction();

		String CPF = object.get("CPF").toString();

		if (CPFValidator.validate(CPF)) {
			credit.setCPF(CPF);
		} else {
			System.out.println("CPF " + CPF + " Inválido");
			credit.setCPF("00000000000");
		}

		credit.setClientName(object.get("nome").toString());
		credit.setReceiptBank(object.get("bancoRecebimento").toString());
		credit.setPaymentBank(object.get("bancoPagamento").toString());
		credit.setPaymentDate(object.get("data").toString());
		credit.setPaymentValue(Double.parseDouble(object.get("valor").toString()));
		credit.setCardNumber(object.get("numeroCartao").toString());
		credit.setCardOwner(object.get("nomeTitular").toString());
		credit.setParcel(Integer.parseInt(object.get("parcelas").toString()));

		return credit;
	}

}
