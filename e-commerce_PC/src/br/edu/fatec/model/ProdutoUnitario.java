package br.edu.fatec.model;

import br.edu.fatec.service.CalculadorDesconto;

public class ProdutoUnitario extends Produto {
	
	public ProdutoUnitario(String nome, String codigo, double valorProduto, Descricao descricao) {
		
		this.nome = nome;
		this.codigo = codigo;
		this.valorProduto = valorProduto;
		this.descricao = descricao;
		this.desconto = new Desconto();
		this.calculador = new CalculadorDesconto(this);
	}
	
	@Override
	public void calculaValor() {
		this.valorComDesconto = this.calculador.calcula(this.desconto);
	}
	
}
