package br.edu.fatec;

import br.edu.fatec.model.Desconto;
import br.edu.fatec.model.Descricao;
import br.edu.fatec.model.Produto;

public class App {

	public static void main(String[] args) {
		
		Descricao descricao = new Descricao("550P", "Lenovo", "1,092", "45x40", "8Gb RAM, 1 TB HD, i7");
		Produto notebook = new Produto("notebook positivo", 1500.0, descricao);
		Desconto desconto = new Desconto();
		desconto.setPorcentagem(10);
		desconto.setValorDesconto(200d);
		
		System.out.println("Valor original: " + notebook.getValorProduto());
		notebook.setDesconto(desconto).calculaValor();

		System.out.println("Valor com desconto: " + notebook.getValorComDesconto());
	}
}
