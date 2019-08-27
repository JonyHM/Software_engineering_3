package br.edu.fatec.model;


import br.edu.fatec.service.CalculadorPreco;

public class Produto {

	private String nome;
	private double valorProduto;
	private double valorComDesconto;
	private Desconto desconto;
	protected CalculadorPreco calculador;
	
	public Produto(String nome, double valorProduto) {
		this.desconto = new Desconto();
		this.calculador = new CalculadorPreco(this);
		this.nome = nome;
		this.valorProduto = valorProduto;
	}

	public String getNome() {
		return nome;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	public Desconto getDesconto() {
		return desconto;
	}

	public Produto setDesconto(Desconto desconto) {
		this.desconto = desconto;
		return this;
	}

	public double getValorComDesconto() {
		return this.valorComDesconto;
	}
	
	public void calculaValor() {
		this.valorComDesconto = this.calculador.aplicaDesconto();
	}
	
	public void calculaValorPorcentagem() {
		this.valorComDesconto = this.calculador.aplicaDescontoPorcentagem();
	}
}
