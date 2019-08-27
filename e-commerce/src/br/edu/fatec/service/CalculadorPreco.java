package br.edu.fatec.service;

import br.edu.fatec.model.Produto;

public class CalculadorPreco {

	private Produto produto;
	
	public CalculadorPreco(Produto produto) {
		this.produto = produto;
	}
	
	public double aplicaDescontoPorcentagem() {
		return this.produto.getValorProduto() - (this.produto.getValorProduto() * this.produto.getDesconto().getPorcentagem()) / 100;
	}
	
	public double aplicaDesconto() {
		
		if(this.produto.getValorProduto() > this.produto.getDesconto().getValorDesconto()) {
			return this.produto.getValorProduto() - this.produto.getDesconto().getValorDesconto();
		} else {
			throw new ArithmeticException("Valor do desconto superior ao do produto!");
		}
	}
}
