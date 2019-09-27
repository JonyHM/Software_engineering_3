package br.edu.fatec.banco.resource;

import br.edu.fatec.banco.model.TransactionList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReaderXML extends Reader {
	

	@Override
	public void read(File file) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(TransactionList.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		this.list = (TransactionList)unmarshaller.unmarshal(file);

		this.list.getList().forEach(item -> {
			if (!CPFValidator.validate(item.getCPF())) {
				System.out.println("CPF " + item.getCPF() + " Inválido");
			}
		});
	}

}
