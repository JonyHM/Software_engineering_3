package br.edu.fatec.model;

import br.edu.fatec.service.CalculadorDesconto;

public class ProdutoUnitario extends Produto {
	
	public ProdutoUnitario(String nome, double valorProduto, Descricao descricao) {
		
		this.desconto = new Desconto();
		this.nome = nome;
		this.valorProduto = valorProduto;
		this.descricao = descricao;
		this.calculador = new CalculadorDesconto(this);
	}
}
