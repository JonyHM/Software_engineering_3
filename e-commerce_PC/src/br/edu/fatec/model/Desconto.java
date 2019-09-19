package br.edu.fatec.model;

public class Desconto {

	private int porcentagem;
	private double valorDesconto;
	
	public int getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(int porcentagem) {
		this.porcentagem = porcentagem;
		this.valorDesconto = 0d;
	}

	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
		this.porcentagem = 0;
	}
}
