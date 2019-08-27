package br.edu.fatec.service;

import br.edu.fatec.model.Produto;

public class CalculadorPreco {

	private Produto produto;
	
	public CalculadorPreco(Produto produto) {
		this.produto = produto;
	}
	
	public double aplicaDesconto(int porcentagem) {
		return this.produto.getValorProduto() - (this.produto.getValorProduto() * porcentagem) / 100;
	}
	
	public double aplicaDesconto(double valorDesconto) {
		
		if(this.produto.getValorProduto() > valorDesconto) {
			return this.produto.getValorProduto() - valorDesconto;
		} else {
			throw new ArithmeticException("Valor do desconto superior ao do produto!");
		}
	}
}
