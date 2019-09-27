package br.edu.fatec.service;

import br.edu.fatec.model.Desconto;
import br.edu.fatec.model.Produto;

public class CalculadorDesconto {
	
	private Produto produto;
	
	public CalculadorDesconto(Produto produto) {
		this.produto = produto;
	}
	
	public double calculaDesconto(double valorDesconto) {
		
		if(this.produto.getValorProduto() > valorDesconto) {
			return this.produto.getValorProduto() - valorDesconto;
		} else {
			throw new ArithmeticException("Valor do desconto superior ao do produto!");
		}
	}
	
	public double calculaDesconto(int porcentagem) {
		return this.produto.getValorProduto() - (this.produto.getValorProduto() * porcentagem) / 100;
	}
	
	public double calcula(Desconto desconto) {
	
		if(desconto.getValorDesconto() != 0d) {
			return this.calculaDesconto(desconto.getValorDesconto());
		} else {
			return this.calculaDesconto(desconto.getPorcentagem());
		} 
	}
}
