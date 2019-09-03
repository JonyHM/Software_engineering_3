package br.edu.fatec.model;

import java.util.ArrayList;
import java.util.List;

public class ProdutoComposto extends Produto {
	
	private List<Produto> listaProdutos;

	public ProdutoComposto(List<Produto> list) {
		this.listaProdutos = list;
		this.listaProdutos = new ArrayList<>();
		this.setValorProduto();
	}
	
	public void setValorProduto() {
		this.listaProdutos.forEach(item -> {
			this.valorProduto += item.getValorProduto();
			System.out.println(item.getValorProduto());
		});
	}
	
	@Override
	public void calculaValor() {
		this.valorComDesconto = this.calculador.calcula(this.desconto);			
	}

}
