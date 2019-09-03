package br.edu.fatec.model;


import br.edu.fatec.service.CalculadorDesconto;

public abstract class Produto {

	protected String nome;
	protected String codigo;
	protected double valorProduto;
	protected double valorComDesconto;
	protected Desconto desconto;
	protected Descricao descricao;
	protected CalculadorDesconto calculador;
	
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
	
	public Desconto getDesconto() {
		return desconto;
	}

	public Produto setDesconto(Desconto desconto) {
		this.desconto = desconto;
		return this;
	}
	
	public abstract void calculaValor();

	public double getValorComDesconto() {
		return this.valorComDesconto;
	}
	
}
