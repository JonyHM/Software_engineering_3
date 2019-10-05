package br.edu.fatec.model;


import br.edu.fatec.service.CalculadorDesconto;

public abstract class Produto {

	protected String nome;
	protected String codigo;
	protected double valorProduto;
	protected double valorComDesconto;
	protected Descricao descricao;
	
	public Descricao getDescricao() {
		return descricao;
	}

	public String getCodigo() {
		return this.codigo;
	}
	
	public void setDescricao(Descricao descricao) {
		this.descricao = descricao;
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
	
	public abstract void calculaValor(CalculadorDesconto calculador, Desconto desconto);

	public double getValorComDesconto() {
		return this.valorComDesconto;
	}
	
}
