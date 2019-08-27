package br.com.fatec.estacionamento.service;

import java.util.Date;

import br.com.fatec.estacionamento.model.veiculo.Veiculo;

public class Conta {
	
	private CalculoValor calculo;
	private Veiculo veiculo;
	private long inicio, fim;
	private double valorTempo;
	
	public Conta(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public void iniciar() {
		this.inicio = new Date().getTime();
	}
	
	public void iniciar(long inicio) {
		this.inicio = inicio;
	}

	public double finalizar() {
		this.fim = new Date().getTime();
		return this.valorConta();
	}
	
	public double finalizar(long fim) {
		this.fim = fim;
		return this.valorConta();
	}
	
	public double valorConta() {
		this.calculo = new ValorMes(this.veiculo);
		this.valorTempo = this.calculo.calcular(this.fim - this.inicio, new ValorDia(this.veiculo)); 
				
		return this.valorTempo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public double getValorTempo() {
		return valorTempo;
	}
	
}
