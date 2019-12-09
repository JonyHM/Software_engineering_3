package br.edu.fatec.salao.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.edu.fatec.salao.model.entity.Cliente;

public class ReportResource {

	public static double average(Set<Cliente> clientes) {
		List<Integer> ages = new ArrayList<>();
		for (Cliente cliente : clientes) {
			ages.add(AgeCalcResource.calc(cliente.getDataNascimento()));
		}
		
		int ageNumbers = ages.size();
		int total = 0;
		
		for (Integer age : ages) {
			total += age;
		}
		
		return total / ageNumbers;
	}
}
