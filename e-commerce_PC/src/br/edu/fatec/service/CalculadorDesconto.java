package br.edu.fatec.service;

import br.edu.fatec.model.Desconto;
import br.edu.fatec.model.Produto;

public class CalculadorDesconto {
	
	private CalculadorPreco calculador;
	
	public CalculadorDesconto(Produto produto) {
		this.calculador = new CalculadorPreco(produto);
	}
	
	public double calculaDesconto(double valorDesconto) {
		return this.calculador.aplicaDesconto(valorDesconto);
	}
	
	public double calculaDesconto(int porcentagem) {
		return this.calculador.aplicaDesconto(porcentagem);
	}
	
	public double calcula(Desconto desconto) {
	
		if(desconto.getValorDesconto() != 0d) {
			return this.calculaDesconto(desconto.getValorDesconto());
		} else {
			return this.calculaDesconto(desconto.getPorcentagem());
		} 
	}
}
