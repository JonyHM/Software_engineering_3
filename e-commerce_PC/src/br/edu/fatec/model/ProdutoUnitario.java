package br.edu.fatec.model;

import br.edu.fatec.service.CalculadorDesconto;

public class ProdutoUnitario extends Produto {
	
	public ProdutoUnitario(String nome, String codigo, double valorProduto, Descricao descricao) {
		
		this.nome = nome;
		this.codigo = codigo;
		this.valorProduto = valorProduto;
		this.descricao = descricao;
	}
	
	@Override
	public void calculaValor(CalculadorDesconto calculador, Desconto desconto) {
		this.valorComDesconto = calculador.calcula(desconto);
	}
	
}
