package br.edu.fatec;

import java.util.Arrays;

import br.edu.fatec.model.Desconto;
import br.edu.fatec.model.Descricao;
import br.edu.fatec.model.Produto;
import br.edu.fatec.model.ProdutoComposto;
import br.edu.fatec.model.ProdutoUnitario;
import br.edu.fatec.service.CalculadorDesconto;

public class App {

	public static void main(String[] args) {
		
		System.out.println("\n");
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println("\n");
		
		// Notebook
		Descricao descricaoNotebook = new Descricao("550P", "Lenovo", "1,092", "45x40", "8Gb RAM, 1 TB HD, i7");
		Produto notebook = new ProdutoUnitario("Notebook", "050026", 3500.0, descricaoNotebook);
		
		CalculadorDesconto calculador = new CalculadorDesconto(notebook);
		
		Desconto descontoNotebook = new Desconto();
		double valorDesconto = 20000;
		
		descontoNotebook.setValorDesconto(valorDesconto);
		String mensagem = "";
		
		System.out.println(notebook.getNome() + notebook.getDescricao());
		System.out.println("\nValor original: " + notebook.getValorProduto());
		
		try {
			notebook.calculaValor(calculador, descontoNotebook);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}

		System.out.println(notebook.getValorComDesconto() > 0 
								? "Valor com desconto: " + notebook.getValorComDesconto()
								: mensagem
						);
		System.out.println("\n");
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println("\n");
		
		// Mouse
		
		Descricao descricaoMouse = new Descricao("75G24", "Logitec", "221", "12x6", "Indicação de LED, níveis de precisão");
		Produto mouse = new ProdutoUnitario("Mouse Gamer", "572468", 254.0, descricaoMouse);
		
		calculador = new CalculadorDesconto(mouse);
		
		Desconto descontoMouse = new Desconto();
		descontoMouse.setPorcentagem(10);
		mensagem = "";
		
		System.out.println(mouse.getNome() + mouse.getDescricao());
		System.out.println("\nValor original: " + mouse.getValorProduto());
		
		try {
			mouse.calculaValor(calculador, descontoMouse);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}

		System.out.println(mouse.getValorComDesconto() > 0 
								? "Valor com desconto: " + mouse.getValorComDesconto()
								: mensagem
						);
		
		
		System.out.println("\n");
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println("\n");
		
		// Kit
		
		Descricao descricaoNote = new Descricao("550P", "Lenovo", "1,092", "45x40", "8Gb RAM, 1 TB HD, i7");
		ProdutoUnitario note = new ProdutoUnitario("Notebook", "050026", 3500.0, descricaoNote);
		
		Descricao descricaoRato = new Descricao("75G24", "Logitec", "221", "12x6", "Indicação de LED, níveis de precisão");
		ProdutoUnitario rato = new ProdutoUnitario("Mouse Gamer", "572468", 254.0, descricaoRato);
		
		Produto kit = new ProdutoComposto(Arrays.asList(note, rato));
		
		calculador = new CalculadorDesconto(kit);
		
		Desconto descontoKit = new Desconto();
		descontoKit.setPorcentagem(10);
		mensagem = "";
		
		System.out.println("Kit Informática");
		System.out.println("\nValor original: " + kit.getValorProduto());
		
		try {
			kit.calculaValor(calculador, descontoKit);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}

		System.out.println(kit.getValorComDesconto() > 0
								? "Valor com desconto: " + kit.getValorComDesconto()
								: mensagem
						);
		
		System.out.println("\n");
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println("\n");
		
	}
}