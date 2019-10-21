package br.edu.fatec.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.fatec.service.CalculadorDesconto;

public class ProdutoComposto extends Produto {
	
	private List<Produto> listaProdutos;

	public ProdutoComposto(List<Produto> list) {
		this.listaProdutos = new ArrayList<>();
		this.listaProdutos = list;
		this.setValorProduto();
	}
	
	public void setValorProduto() {
		this.listaProdutos.forEach(item -> {
			this.valorProduto += item.getValorProduto();
		});
	}
	
	@Override
	public void calculaValor(CalculadorDesconto calculador, Desconto desconto) {
		this.valorComDesconto = calculador.calcula(desconto);			
	}

}
